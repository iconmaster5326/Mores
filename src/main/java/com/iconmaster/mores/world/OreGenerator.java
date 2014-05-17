package com.iconmaster.mores.world;

import java.util.Random;

import com.iconmaster.mores.registry.OreRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		byte stoneLSB = (byte) (Block.blockRegistry.getIDForObject(Blocks.stone)&255);
		byte stoneMSB = (byte) (Block.blockRegistry.getIDForObject(Blocks.stone)>>8);

		for (ExtendedBlockStorage arr : world.getChunkFromChunkCoords(chunkX, chunkZ).getBlockStorageArray()) {
			if (arr != null) {
				byte[] lsbArray = arr.getBlockLSBArray();
				NibbleArray msbArray = arr.getBlockMSBArray();
				for (int i=0;i<lsbArray.length;i++) {
					byte lsb = lsbArray[i];

					if (msbArray==null) {
						arr.setBlockMSBArray(new NibbleArray(lsbArray.length, 4));
						msbArray = arr.getBlockMSBArray();
					}

					int msb = (i & 1) == 0 ? msbArray.data[i>>1] & 15 : msbArray.data[i>>1] >> 4 & 15;
					
					if (lsb == stoneLSB && msb == stoneMSB) {
						Block randBlock = OreRegistry.blocks.get(random.nextInt(OreRegistry.blocks.size()));
						
						byte oreLSB = (byte) (Block.blockRegistry.getIDForObject(randBlock)&255);
						byte oreMSB = (byte) (Block.blockRegistry.getIDForObject(randBlock)>>8);
						
						lsbArray[i] = oreLSB;

						if (msbArray != null) {
					        if ((i & 1) == 0) {
					            msbArray.data[i>>1] = (byte)(msbArray.data[i>>1] & 240 | oreMSB & 15);
					        } else {
					            msbArray.data[i>>1] = (byte)(msbArray.data[i>>1] & 15 | (oreMSB & 15) << 4);
					        }
						}
						
						if (arr.getMetadataArray() != null) {
					        if ((i & 1) == 0) {
					        	arr.getMetadataArray().data[i>>1] = (byte)(arr.getMetadataArray().data[i>>1] & 240 | 0 & 15);
					        } else {
					        	arr.getMetadataArray().data[i>>1] = (byte)(arr.getMetadataArray().data[i>>1] & 15 | (0 & 15) << 4);
					        }
						}
						
					}
				}
			}
		}
	}

}

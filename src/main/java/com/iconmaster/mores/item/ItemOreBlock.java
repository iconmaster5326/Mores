package com.iconmaster.mores.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.iconmaster.mores.block.BlockOre;
import com.iconmaster.mores.registry.OreData;

public class ItemOreBlock extends ItemBlock {
	public OreData data;

	public ItemOreBlock(Block block) {
		super(block);
		if (block instanceof BlockOre) {
			this.data = ((BlockOre)block).data;
		}
	}

}

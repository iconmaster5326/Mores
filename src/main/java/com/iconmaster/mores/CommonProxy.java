package com.iconmaster.mores;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.iconmaster.mores.block.BlockOre;
import com.iconmaster.mores.item.ItemOreBlock;
import com.iconmaster.mores.item.ItemOreItem;
import com.iconmaster.mores.registry.EnumOreDropType;
import com.iconmaster.mores.registry.EnumOreItemType;
import com.iconmaster.mores.registry.OreData;
import com.iconmaster.mores.registry.OreRegistry;
import com.iconmaster.mores.world.OreGenerator;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy {
	public void registerBlocks() {
		for (OreData entry : OreRegistry.data) {
			Block block = new BlockOre(entry);
			GameRegistry.registerBlock(block, ItemOreBlock.class, "ore"+entry.getName());
			LanguageRegistry.instance().addStringLocalization("ore"+entry.getName()+".name", entry.getName()+" Ore");
			OreRegistry.addBlock(block);
			
			if (entry.getItype() != EnumOreItemType.PREDEFINED) {
				Item item = new ItemOreItem(entry);
				GameRegistry.registerItem(item, "oreItem"+entry.getName());
				LanguageRegistry.instance().addStringLocalization("oreItem"+entry.getName()+".name", entry.getName()+EnumOreItemType.getPrefixName(entry.getItype()));
				entry.setDrop(new ItemStack(item));
				OreRegistry.addItem(item);
				
				GameRegistry.addSmelting(block, new ItemStack(item), 10);
			} else if (entry.getDtype() == EnumOreDropType.BLOCK) {
				GameRegistry.addSmelting(block, entry.getDrop(), 10);
			}
			
		}
	}
	
	public void registerRenderers() {
		
	}
	
	public void registerWorldGen() {
		GameRegistry.registerWorldGenerator(new OreGenerator(), 5326);
	}
}

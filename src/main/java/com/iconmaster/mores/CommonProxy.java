package com.iconmaster.mores;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.iconmaster.mores.block.BlockOre;
import com.iconmaster.mores.item.ItemOreBlock;
import com.iconmaster.mores.item.ItemOreItem;
import com.iconmaster.mores.registry.EnumOreItemType;
import com.iconmaster.mores.registry.OreData;
import com.iconmaster.mores.registry.OreRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy {
	public void registerBlocks() {
		for (OreData entry : OreRegistry.data) {
			Block block = new BlockOre(entry);
			GameRegistry.registerBlock(block, ItemOreBlock.class, "block"+entry.getName());
			LanguageRegistry.instance().addName(block,entry.getName()+" Ore");
			
			if (entry.getItype() != EnumOreItemType.PREDEFINED) {
				Item item = new ItemOreItem(entry);
				GameRegistry.registerItem(item, "item"+entry.getName());
				LanguageRegistry.instance().addName(item,entry.getName()+EnumOreItemType.getName(entry.getItype()));
			}
		}
	}
}

package com.iconmaster.mores.registry;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class OreRegistry {

	public static ArrayList<OreData> data = new ArrayList<OreData>();
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public static void RegisterOre(OreData entry) {
		data.add(entry);
	}
	
	public static void addItem(Item item) {
		items.add(item);
	}
	
	public static void addBlock(Block block) {
		blocks.add(block);
	}
	
}

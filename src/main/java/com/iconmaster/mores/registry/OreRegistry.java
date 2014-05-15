package com.iconmaster.mores.registry;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class OreRegistry {

	public static ArrayList<OreData> data = new ArrayList<>();
	public static ArrayList<Block> blocks = new ArrayList<>();
	public static ArrayList<Item> items = new ArrayList<>();
	
	public static void RegisterOre(OreData entry) {
		data.add(entry);
	}
	
}

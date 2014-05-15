package com.iconmaster.mores.item;

import net.minecraft.item.Item;

import com.iconmaster.mores.Mores;
import com.iconmaster.mores.registry.OreData;

public class ItemOreItem extends Item {
	public OreData data;

	public ItemOreItem(OreData data) {
		this.data = data;
		this.setCreativeTab(Mores.tab);
	}
}

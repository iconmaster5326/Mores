package com.iconmaster.mores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.iconmaster.mores.Mores;
import com.iconmaster.mores.registry.OreData;

public class BlockOre extends Block {
	public OreData data;
	
	public BlockOre(OreData data) {
		super(Material.rock);
		this.data = data;
		this.setCreativeTab(Mores.tab);
	}

}

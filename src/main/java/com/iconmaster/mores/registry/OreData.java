package com.iconmaster.mores.registry;

import net.minecraft.item.ItemStack;

import com.iconmaster.mores.util.OreColor;

public class OreData {
	private String name;
	private OreColor color;
	private EnumOreDropType dtype;
	private EnumOreItemType itype;
	private ItemStack drop;
	
	public OreData(String name,OreColor color, EnumOreItemType itype,EnumOreDropType dtype, ItemStack drop) {
		this.name = name;
		this.color = color;
		this.itype = itype;
		this.dtype = dtype;
		this.drop = drop;
	}
	
	public OreData(String name, EnumOreItemType itype) {
		this(name,null,itype,EnumOreDropType.ITEM,null);
	}

	public OreData(String name, OreColor color, EnumOreItemType itype,EnumOreDropType dtype) {
		this(name,color,itype,dtype,null);
	}
	
	public OreData(String name,OreColor color,EnumOreDropType dtype,ItemStack drop) {
		this(name,color,EnumOreItemType.PREDEFINED,dtype,drop);
	}

	public String getName() {
		return name;
	}

	public OreColor getColor() {
		return color;
	}

	public EnumOreDropType getDtype() {
		return dtype;
	}

	public EnumOreItemType getItype() {
		return itype;
	}

	public ItemStack getDrop() {
		return drop;
	}
	
	public void setDrop(ItemStack item) {
		this.drop = item;
	}
}

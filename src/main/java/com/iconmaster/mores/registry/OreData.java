package com.iconmaster.mores.registry;

import net.minecraft.item.ItemStack;

public class OreData {
	private String name;
	private int color;
	private EnumOreDropType dtype;
	private EnumOreItemType itype;
	private ItemStack drop;
	
	public OreData(String name,int color, EnumOreItemType itype,EnumOreDropType dtype, ItemStack drop) {
		this.name = name;
		this.color = color;
		this.itype = itype;
		this.dtype = dtype;
		this.drop = drop;
	}
	
	public OreData(String name, EnumOreItemType itype) {
		this(name,0,itype,EnumOreDropType.ITEM,null);
	}

	public OreData(String name, int color, EnumOreItemType itype,EnumOreDropType dtype) {
		this(name,color,itype,dtype,null);
	}

	public String getName() {
		return name;
	}

	public int getColor() {
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
}

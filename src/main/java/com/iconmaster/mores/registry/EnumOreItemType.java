package com.iconmaster.mores.registry;

public enum EnumOreItemType {
	INGOT,GEM,PREDEFINED;
	
	public static String getName(EnumOreItemType type) {
		switch (type) {
		case INGOT:
			return " Ingot";
		default:
			return "";
		}
	}
}

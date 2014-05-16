package com.iconmaster.mores.registry;

public enum EnumOreItemType {
	INGOT,GEM,PREDEFINED;
	
	public static String getPrefixName(EnumOreItemType type) {
		switch (type) {
		case INGOT:
			return " Ingot";
		default:
			return "";
		}
	}
	
	public static String getResourceName(EnumOreItemType type) {
		switch (type) {
		case INGOT:
			return "Ingot";
		case GEM:
			return "Gem";
		default:
			return "";
		}
	}
}

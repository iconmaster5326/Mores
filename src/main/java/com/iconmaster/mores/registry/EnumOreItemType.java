package com.iconmaster.mores.registry;

public enum EnumOreItemType {
	INGOT,GEM,DIAMOND,PEARL,DUST,NONE,NULL,PREDEFINED;
	
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
		case DIAMOND:
			return "Diamond";
		case PEARL:
			return "Pearl";
		case DUST:
			return "Dust";
		case NULL:
			return "AnArbitraryStringToBreakTheTextureLoader";
		default:
			return "";
		}
	}
}

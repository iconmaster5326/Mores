package com.iconmaster.mores.util;

public class OreColor {
	private int r;
	private int g;
	private int b;
	
	public OreColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public float getR() {
		return ((float)r)/255F;
	}
	
	public float getG() {
		return ((float)g)/255F;
	}
	
	public float getB() {
		return ((float)b)/255F;
	}
	
	public int composite() {
		return b|g<<8|r<<16;
	}
}

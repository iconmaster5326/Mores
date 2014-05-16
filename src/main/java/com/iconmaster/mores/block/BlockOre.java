package com.iconmaster.mores.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.iconmaster.mores.Mores;
import com.iconmaster.mores.client.render.OreBlockRender;
import com.iconmaster.mores.registry.EnumOreDropType;
import com.iconmaster.mores.registry.OreData;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOre extends Block {
	public OreData data;
	public IIcon oreIcon;
	
	public static int pass = 0;
	
	public BlockOre(OreData data) {
		super(Material.rock);
		this.data = data;
		this.setCreativeTab(Mores.tab);
	}
	
	@Override
	public Item getItemDropped(int arg1, Random arg2, int arg3)
    {
		if (this.data.getDtype() == EnumOreDropType.ITEM) {
			return data.getDrop().getItem();
		} else {
			return super.getItemDropped(arg1, arg2, arg3);
		}
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("mores:oreBack");
        this.oreIcon = reg.registerIcon("mores:oreTop");
    }
	
	@Override
	public String getUnlocalizedName() {
		return "ore"+data.getName();
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType()
    {
        return OreBlockRender.renderId;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side,int ignore) {
		return pass==0? blockIcon : oreIcon;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public boolean canRenderInPass(int pass)
    {
        return pass != 2;
    }
	
	@Override
	public int getRenderBlockPass() {
		return pass;
	}
	
	public void switchPass() {
		pass = pass==0?1:0;
		//System.out.println("PASS IS NOW "+pass);
		//this.setBlockBounds(-.1F*pass, -.1F*pass, -.1F*pass, 1+.1F*pass, 1+.1F*pass, 1+.1F*pass);
	}
	

}

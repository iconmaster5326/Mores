package com.iconmaster.mores.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.iconmaster.mores.Mores;
import com.iconmaster.mores.registry.EnumOreItemType;
import com.iconmaster.mores.registry.OreData;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOreItem extends Item {
	public OreData data;

	public ItemOreItem(OreData data) {
		this.data = data;
		this.setCreativeTab(Mores.tab);
		this.setUnlocalizedName("oreItem"+data.getName());
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return  "oreItem"+data.getName();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
		this.itemIcon = reg.registerIcon("mores:ore"+EnumOreItemType.getResourceName(data.getItype()));
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return data.getColor().composite();
    }
}

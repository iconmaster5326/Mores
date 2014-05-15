package com.iconmaster.mores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.iconmaster.mores.registry.EnumOreDropType;
import com.iconmaster.mores.registry.EnumOreItemType;
import com.iconmaster.mores.registry.OreData;
import com.iconmaster.mores.registry.OreRegistry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Mores.MODID, version = Mores.VERSION)
public class Mores
{
    public static final String MODID = "Mores";
    public static final String VERSION = "MORES";
    
    public static CreativeTabs tab = new CreativeTabs("Mores") {
		@Override
		public Item getTabIconItem() {
			return getIconItemStack().getItem();
		}
		
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Blocks.iron_ore);
		}
		
    };
    
    @SidedProxy(modId="Mores",clientSide="com.iconmaster.mores.client.ClientProxy", serverSide="com.iconmaster.mores.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	LanguageRegistry.instance().addStringLocalization("itemGroup.Mores", "Mores");
    	OreRegistry.RegisterOre(new OreData("Copper",0x444400,EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.registerBlocks();
    }
}

package com.iconmaster.mores;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.iconmaster.mores.registry.EnumOreDropType;
import com.iconmaster.mores.registry.EnumOreItemType;
import com.iconmaster.mores.registry.OreData;
import com.iconmaster.mores.registry.OreRegistry;
import com.iconmaster.mores.util.OreColor;

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
	public static ResourceLocation loc;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//System.out.println("[MORES] "+(Integer.toHexString((new OreColor(1,2,3)).composite())));
    	LanguageRegistry.instance().addStringLocalization("itemGroup.Mores", "Mores");
    	
    	OreRegistry.RegisterOre(new OreData("Copper",new OreColor(191,97,2),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Ruby",new OreColor(255,0,0),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Iron Ore",new OreColor(235,204,133),EnumOreDropType.BLOCK,new ItemStack(Blocks.iron_ore)));
    
    	OreRegistry.addBlock(Blocks.iron_ore);
    	OreRegistry.addBlock(Blocks.gold_ore);
    	OreRegistry.addBlock(Blocks.lapis_ore);
    	OreRegistry.addBlock(Blocks.redstone_ore);
    	OreRegistry.addBlock(Blocks.diamond_ore);
    	OreRegistry.addBlock(Blocks.emerald_ore);
    	OreRegistry.addBlock(Blocks.coal_ore);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	loc = new ResourceLocation("mores","assets/mores");
    	TextureManager tman = Minecraft.getMinecraft().getTextureManager();
    	tman.bindTexture(loc);
    	proxy.registerBlocks();
    	proxy.registerRenderers();
    	proxy.registerWorldGen();
    }
}

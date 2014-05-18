package com.iconmaster.mores;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
    	OreRegistry.RegisterOre(new OreData("Tin",new OreColor(251,230,164),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Zinc",new OreColor(183,213,164),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Aluminum",new OreColor(232,209,243),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Manganese",new OreColor(233,46,228),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Lead",new OreColor(129,142,150),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Silver",new OreColor(231,234,235),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Bismuth",new OreColor(233,207,192),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Nickel",new OreColor(255,255,179),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Titanium",new OreColor(116,137,146),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Chromium",new OreColor(245,188,252),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	
    	OreRegistry.RegisterOre(new OreData("Bronze",new OreColor(240,182,94),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Brass",new OreColor(240,182,94),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Steel",new OreColor(87,100,90),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Electrum",new OreColor(255,255,128),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Invar",new OreColor(230,252,101),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Rust",new OreColor(110,0,0),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Plastic",new OreColor(255,0,128),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Asbestos",new OreColor(56,118,74),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	
    	OreRegistry.RegisterOre(new OreData("Adamantium",new OreColor(34,234,204),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Mithril",new OreColor(220,252,248),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Cobalt",new OreColor(15,22,115),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Promethium",new OreColor(111,38,54),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Cold Iron",new OreColor(97,97,97),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Infused",new OreColor(0,255,0),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Astral Silver",new OreColor(231,234,235),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Unobtanium",new OreColor(44,18,41),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Awesomium",new OreColor(226,123,10),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Rearden",new OreColor(128,255,128),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Oreium",new OreColor(128,128,128),EnumOreItemType.INGOT,EnumOreDropType.BLOCK));
    	
    	OreRegistry.RegisterOre(new OreData("Ruby",new OreColor(255,0,0),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Sapphire",new OreColor(0,0,255),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Perdiot",new OreColor(33,239,105),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Amythyst",new OreColor(233,34,238),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Topaz",new OreColor(28,18,207),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Beryl",new OreColor(11,172,15),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Quartz",new OreColor(240,240,240),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Rose Quartz",new OreColor(253,138,138),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Smoky Quartz",new OreColor(51,44,43),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Forcicium",new OreColor(67,125,43),EnumOreItemType.GEM,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Zircon",new OreColor(220,220,220),EnumOreItemType.GEM,EnumOreDropType.ITEM));
    	
    	OreRegistry.RegisterOre(new OreData("Industrial Diamond",new OreColor(0,255,255),EnumOreItemType.DIAMOND,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Heatstone",new OreColor(255,0,0),EnumOreItemType.DIAMOND,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Apatite",new OreColor(12,136,203),EnumOreItemType.DIAMOND,EnumOreDropType.ITEM));
    	
    	OreRegistry.RegisterOre(new OreData("Radstone",new OreColor(255,0,0),EnumOreItemType.DUST,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Salt",new OreColor(255,255,255),EnumOreItemType.DUST,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Yellowstone",new OreColor(225,225,0),EnumOreItemType.DUST,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Bauxite",new OreColor(225,16,16),EnumOreItemType.DUST,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Dust",new OreColor(128,128,128),EnumOreItemType.DUST,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Sulfur",new OreColor(255,255,64),EnumOreItemType.DUST,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Niter",new OreColor(230,230,230),EnumOreItemType.DUST,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Nikolite",new OreColor(15,134,168),EnumOreItemType.DUST,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Sand",new OreColor(255,255,64),EnumOreItemType.DUST,EnumOreDropType.BLOCK));
    	
    	OreRegistry.RegisterOre(new OreData("Uranium",new OreColor(0,255,0),EnumOreItemType.PEARL ,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Plutonium",new OreColor(149,41,245),EnumOreItemType.PEARL ,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Pearl",new OreColor(252,219,253),EnumOreItemType.PEARL ,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Black Pearl",new OreColor(16,16,16),EnumOreItemType.PEARL ,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Meteorite",new OreColor(85,70,40),EnumOreItemType.PEARL ,EnumOreDropType.ITEM));
    	OreRegistry.RegisterOre(new OreData("Beginner Pearl",new OreColor(45,77,58),EnumOreItemType.PEARL ,EnumOreDropType.ITEM));
    	
    	OreRegistry.RegisterOre(new OreData("Iron Ore",new OreColor(223,190,168),EnumOreDropType.BLOCK,new ItemStack(Blocks.iron_ore)));
    	OreRegistry.RegisterOre(new OreData("Wood",new OreColor(78,49,5),EnumOreDropType.BLOCK,new ItemStack(Blocks.log)));
    	OreRegistry.RegisterOre(new OreData("Obsidian",new OreColor(22,9,32),EnumOreDropType.BLOCK,new ItemStack(Blocks.obsidian)));
    	OreRegistry.RegisterOre(new OreData("Stone",new OreColor(128,128,128),EnumOreDropType.BLOCK,new ItemStack(Blocks.stone)));
    	OreRegistry.RegisterOre(new OreData("Ice",new OreColor(150,252,252),EnumOreDropType.BLOCK,new ItemStack(Blocks.ice)));
    	OreRegistry.RegisterOre(new OreData("Lava",new OreColor(250,205,10),EnumOreDropType.BLOCK,new ItemStack(Blocks.lava)));
    	OreRegistry.RegisterOre(new OreData("Water",new OreColor(0,0,255),EnumOreDropType.BLOCK,new ItemStack(Blocks.water)));
    	OreRegistry.RegisterOre(new OreData("Bedrock",new OreColor(57,57,49),EnumOreDropType.BLOCK,new ItemStack(Blocks.bedrock)));
    	OreRegistry.RegisterOre(new OreData("Command Block",new OreColor(253,221,91),EnumOreDropType.BLOCK,new ItemStack(Blocks.command_block)));
    	OreRegistry.RegisterOre(new OreData("Gravel",new OreColor(180,180,180),EnumOreDropType.BLOCK,new ItemStack(Blocks.gravel)));
    	OreRegistry.RegisterOre(new OreData("Dirt",new OreColor(180,180,180),EnumOreDropType.BLOCK,new ItemStack(Blocks.dirt)));
    	
    	OreRegistry.RegisterOre(new OreData("Chicken",new OreColor(228,228,228),EnumOreDropType.ITEM,new ItemStack(Items.feather)));
    	OreRegistry.RegisterOre(new OreData("Ender",new OreColor(45,77,58),EnumOreDropType.ITEM,new ItemStack(Items.ender_pearl)));
    	OreRegistry.RegisterOre(new OreData("Fossil",new OreColor(255,255,236),EnumOreDropType.ITEM,new ItemStack(Items.bone)));
    	OreRegistry.RegisterOre(new OreData("Nether Quartz",new OreColor(240,240,240),EnumOreDropType.ITEM,new ItemStack(Items.quartz)));
    	OreRegistry.RegisterOre(new OreData("Cake",new OreColor(255,255,255),EnumOreDropType.ITEM,new ItemStack(Items.cake)));
    	OreRegistry.RegisterOre(new OreData("Iron Ingot",new OreColor(200,200,200),EnumOreDropType.ITEM,new ItemStack(Items.iron_ingot)));
    	OreRegistry.RegisterOre(new OreData("Nether Star",new OreColor(32,32,32),EnumOreDropType.ITEM,new ItemStack(Items.nether_star)));
    	
    	OreRegistry.RegisterOre(new OreData("",new OreColor(0,0,0),EnumOreItemType.NONE ,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("Air",new OreColor(255,255,255),EnumOreItemType.NONE ,EnumOreDropType.BLOCK));
    	OreRegistry.RegisterOre(new OreData("item.null.name",new OreColor(0,0,0),EnumOreItemType.NULL ,EnumOreDropType.BLOCK));
    	
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
    	proxy.registerBlocks();
    	proxy.registerRenderers();
    	proxy.registerWorldGen();
    }
}

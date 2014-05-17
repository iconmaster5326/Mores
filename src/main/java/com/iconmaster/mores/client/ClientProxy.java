package com.iconmaster.mores.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

import com.iconmaster.mores.CommonProxy;
import com.iconmaster.mores.client.render.OreBlockRender;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	private ResourceLocation loc;

	@Override
	public void registerRenderers() {
    	loc = new ResourceLocation("mores","assets/mores");
    	TextureManager tman = Minecraft.getMinecraft().getTextureManager();
    	tman.bindTexture(loc);
    	
		OreBlockRender.renderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(OreBlockRender.renderId,new OreBlockRender());
	}
}

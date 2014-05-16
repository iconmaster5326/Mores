package com.iconmaster.mores.client;

import com.iconmaster.mores.CommonProxy;
import com.iconmaster.mores.client.render.OreBlockRender;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		OreBlockRender.renderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(OreBlockRender.renderId,new OreBlockRender());
	}
}

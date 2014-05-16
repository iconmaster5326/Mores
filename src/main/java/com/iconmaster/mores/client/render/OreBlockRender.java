package com.iconmaster.mores.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.iconmaster.mores.block.BlockOre;
import com.iconmaster.mores.util.OreColor;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class OreBlockRender implements ISimpleBlockRenderingHandler {
	public static int renderId = -1;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId,
			RenderBlocks renderer) {

		renderItem(renderer,block,0);
		((BlockOre) block).switchPass();
		renderItem(renderer,block,1);
		((BlockOre) block).switchPass();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		OreColor c = ((BlockOre)block).data.getColor();
		
		renderer.renderStandardBlock(block,x,y,z);
		((BlockOre) block).switchPass();
		//renderer.renderStandardBlockWithColorMultiplier(block,x,y,z,c.getR(),c.getG(),c.getB());
		renderOverlay(renderer, block, x, y, z);
		((BlockOre) block).switchPass();
		
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return renderId;
	}

	public void renderItem(RenderBlocks renderer, Block block,int pass) {
		Tessellator tessellator = Tessellator.instance;
		renderer.setRenderBoundsFromBlock(block);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        
        OreColor c = ((BlockOre)block).data.getColor();
    	
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * c.getR();
        float f8 = f4 * c.getG();
        float f9 = f4 * c.getB();
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;

        f10 = f3 * c.getR();
        f11 = f5 * c.getR();
        f12 = f6 * c.getR();
        f13 = f3 * c.getG();
        f14 = f5 * c.getG();
        f15 = f6 * c.getG();
        f16 = f3 * c.getB();
        f17 = f5 * c.getB();
        f18 = f6 * c.getB();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        if (pass==1) {
        	tessellator.setColorOpaque_F(f10, f13, f16);
        }
        renderer.renderFaceYNeg(block, 0.0D, pass*-.1D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        if (pass==1) {
        	tessellator.setColorOpaque_F(f10, f13, f16);
        }
        renderer.renderFaceYPos(block, 0.0D, pass*.01D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        if (pass==1) {
        	tessellator.setColorOpaque_F(f10, f13, f16);
        }
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, pass*-.01D, renderer.getBlockIconFromSideAndMetadata(block, 2, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        if (pass==1) {
        	tessellator.setColorOpaque_F(f10, f13, f16);
        }
        renderer.renderFaceZPos(block, 0.0D, 0.0D, pass*.01D, renderer.getBlockIconFromSideAndMetadata(block, 3, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        if (pass==1) {
        	tessellator.setColorOpaque_F(f10, f13, f16);
        }
        renderer.renderFaceXNeg(block, pass*-.01D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        if (pass==1) {
        	tessellator.setColorOpaque_F(f10, f13, f16);
        }
        renderer.renderFaceXPos(block, pass*.01D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, 0));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
	
	public void renderOverlay(RenderBlocks renderer, Block block, int x, int y, int z) {
        renderer.enableAO = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        
        OreColor c = ((BlockOre)block).data.getColor();
    	
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * c.getR();
        float f8 = f4 * c.getG();
        float f9 = f4 * c.getB();
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;

        f10 = f3 * c.getR();
        f11 = f5 * c.getR();
        f12 = f6 * c.getR();
        f13 = f3 * c.getG();
        f14 = f5 * c.getG();
        f15 = f6 * c.getG();
        f16 = f3 * c.getB();
        f17 = f5 * c.getB();
        f18 = f6 * c.getB();

        int l = block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z);

        if (renderer.renderAllFaces || block.shouldSideBeRendered(renderer.blockAccess, x, y - 1, z, 0))
        {
            tessellator.setBrightness(renderer.renderMinY > 0.0D ? l : block.getMixedBrightnessForBlock(renderer.blockAccess, x, y - 1, z));
            tessellator.setColorOpaque_F(f10, f13, f16);
            renderFaceYNeg(renderer, (double)x, (double)y, (double)z, renderer.getBlockIcon(block, renderer.blockAccess, x, y, z, 0));
            flag = true;
        }

        if (renderer.renderAllFaces || block.shouldSideBeRendered(renderer.blockAccess, x, y + 1, z, 1))
        {
            tessellator.setBrightness(renderer.renderMaxY < 1.0D ? l : block.getMixedBrightnessForBlock(renderer.blockAccess, x, y + 1, z));
            tessellator.setColorOpaque_F(f7, f8, f9);
            renderFaceYPos(renderer, (double)x, (double)y, (double)z, renderer.getBlockIcon(block, renderer.blockAccess, x, y, z, 1));
            flag = true;
        }

        IIcon iicon;

        if (renderer.renderAllFaces || block.shouldSideBeRendered(renderer.blockAccess, x, y, z - 1, 2))
        {
            tessellator.setBrightness(renderer.renderMinZ > 0.0D ? l : block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z - 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            iicon = renderer.getBlockIcon(block, renderer.blockAccess, x, y, z, 2);
            renderFaceZNeg(renderer, (double)x, (double)y, (double)z, iicon);

            flag = true;
        }

        if (renderer.renderAllFaces || block.shouldSideBeRendered(renderer.blockAccess, x, y, z + 1, 3))
        {
            tessellator.setBrightness(renderer.renderMaxZ < 1.0D ? l : block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z + 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            iicon = renderer.getBlockIcon(block, renderer.blockAccess, x, y, z, 3);
            renderFaceZPos(renderer, (double)x, (double)y, (double)z, iicon);

            flag = true;
        }

        if (renderer.renderAllFaces || block.shouldSideBeRendered(renderer.blockAccess, x - 1, y, z, 4))
        {
            tessellator.setBrightness(renderer.renderMinX > 0.0D ? l : block.getMixedBrightnessForBlock(renderer.blockAccess, x - 1, y, z));
            tessellator.setColorOpaque_F(f12, f15, f18);
            iicon = renderer.getBlockIcon(block, renderer.blockAccess, x, y, z, 4);
            renderFaceXNeg(renderer, (double)x, (double)y, (double)z, iicon);

            flag = true;
        }

        if (renderer.renderAllFaces || block.shouldSideBeRendered(renderer.blockAccess, x + 1, y, z, 5))
        {
            tessellator.setBrightness(renderer.renderMaxX < 1.0D ? l : block.getMixedBrightnessForBlock(renderer.blockAccess, x + 1, y, z));
            tessellator.setColorOpaque_F(f12, f15, f18);
            iicon = renderer.getBlockIcon(block, renderer.blockAccess, x, y, z, 5);
            renderFaceXPos(renderer, (double)x, (double)y, (double)z, iicon);

            flag = true;
        }
	}
	
	public void renderFaceXNeg(RenderBlocks renderer, double x , double y, double z, IIcon texture) {
        Tessellator tessellator = Tessellator.instance;

        if (renderer.hasOverrideBlockTexture())
        {
            texture = renderer.overrideBlockTexture;
        }

        double d3 = (double)texture.getInterpolatedU(renderer.renderMinZ * 16.0D);
        double d4 = (double)texture.getInterpolatedU(renderer.renderMaxZ * 16.0D);
        double d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
        double d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);
        double d7;

        if (renderer.flipTexture)
        {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if (renderer.renderMinZ < 0.0D || renderer.renderMaxZ > 1.0D)
        {
            d3 = (double)texture.getMinU();
            d4 = (double)texture.getMaxU();
        }

        if (renderer.renderMinY < 0.0D || renderer.renderMaxY > 1.0D)
        {
            d5 = (double)texture.getMinV();
            d6 = (double)texture.getMaxV();
        }

        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (renderer.uvRotateNorth == 1)
        {
            d3 = (double)texture.getInterpolatedU(renderer.renderMinY * 16.0D);
            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxZ * 16.0D);
            d4 = (double)texture.getInterpolatedU(renderer.renderMaxY * 16.0D);
            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinZ * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (renderer.uvRotateNorth == 2)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxY * 16.0D);
            d5 = (double)texture.getInterpolatedV(renderer.renderMinZ * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinY * 16.0D);
            d6 = (double)texture.getInterpolatedV(renderer.renderMaxZ * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (renderer.uvRotateNorth == 3)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinZ * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxZ * 16.0D);
            d5 = (double)texture.getInterpolatedV(renderer.renderMaxY * 16.0D);
            d6 = (double)texture.getInterpolatedV(renderer.renderMinY * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = x + renderer.renderMinX  -.01;
        double d12 = y + renderer.renderMinY;
        double d13 = y + renderer.renderMaxY;
        double d14 = z + renderer.renderMinZ;
        double d15 = z + renderer.renderMaxZ;

        if (renderer.renderFromInside)
        {
            d14 = z + renderer.renderMaxZ;
            d15 = z + renderer.renderMinZ;
        }

        if (renderer.enableAO)
        {
            tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
            tessellator.setBrightness(renderer.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d13, d15, d7, d9);
            tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
            tessellator.setBrightness(renderer.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
            tessellator.setBrightness(renderer.brightnessBottomRight);
            tessellator.addVertexWithUV(d11, d12, d14, d8, d10);
            tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
            tessellator.setBrightness(renderer.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d12, d15, d4, d6);
        }
        else
        {
            tessellator.addVertexWithUV(d11, d13, d15, d7, d9);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.addVertexWithUV(d11, d12, d14, d8, d10);
            tessellator.addVertexWithUV(d11, d12, d15, d4, d6);
        }
	}
	
	public void renderFaceXPos(RenderBlocks renderer, double x , double y, double z, IIcon texture) {
        Tessellator tessellator = Tessellator.instance;

        if (renderer.hasOverrideBlockTexture())
        {
            texture = renderer.overrideBlockTexture;
        }

        double d3 = (double)texture.getInterpolatedU(renderer.renderMaxZ * 16.0D);
        double d4 = (double)texture.getInterpolatedU(renderer.renderMinZ * 16.0D);
        double d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
        double d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);
        double d7;

        if (renderer.flipTexture)
        {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if (renderer.renderMinZ < 0.0D || renderer.renderMaxZ > 1.0D)
        {
            d3 = (double)texture.getMinU();
            d4 = (double)texture.getMaxU();
        }

        if (renderer.renderMinY < 0.0D || renderer.renderMaxY > 1.0D)
        {
            d5 = (double)texture.getMinV();
            d6 = (double)texture.getMaxV();
        }

        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (renderer.uvRotateSouth == 2)
        {
            d3 = (double)texture.getInterpolatedU(renderer.renderMinY * 16.0D);
            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinZ * 16.0D);
            d4 = (double)texture.getInterpolatedU(renderer.renderMaxY * 16.0D);
            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxZ * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (renderer.uvRotateSouth == 1)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxY * 16.0D);
            d5 = (double)texture.getInterpolatedV(renderer.renderMaxZ * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinY * 16.0D);
            d6 = (double)texture.getInterpolatedV(renderer.renderMinZ * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (renderer.uvRotateSouth == 3)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinZ * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxZ * 16.0D);
            d5 = (double)texture.getInterpolatedV(renderer.renderMaxY * 16.0D);
            d6 = (double)texture.getInterpolatedV(renderer.renderMinY * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = x + renderer.renderMaxX +.01;
        double d12 = y + renderer.renderMinY;
        double d13 = y + renderer.renderMaxY;
        double d14 = z + renderer.renderMinZ;
        double d15 = z + renderer.renderMaxZ;

        if (renderer.renderFromInside)
        {
            d14 = z + renderer.renderMaxZ;
            d15 = z + renderer.renderMinZ;
        }

        if (renderer.enableAO)
        {
            tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
            tessellator.setBrightness(renderer.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d12, d15, d8, d10);
            tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
            tessellator.setBrightness(renderer.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d12, d14, d4, d6);
            tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
            tessellator.setBrightness(renderer.brightnessBottomRight);
            tessellator.addVertexWithUV(d11, d13, d14, d7, d9);
            tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
            tessellator.setBrightness(renderer.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d5);
        }
        else
        {
            tessellator.addVertexWithUV(d11, d12, d15, d8, d10);
            tessellator.addVertexWithUV(d11, d12, d14, d4, d6);
            tessellator.addVertexWithUV(d11, d13, d14, d7, d9);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d5);
        }
	}
	
	public void renderFaceYNeg(RenderBlocks renderer, double x , double y, double z, IIcon texture) {
	      Tessellator tessellator = Tessellator.instance;

	        if (renderer.hasOverrideBlockTexture())
	        {
	            texture = renderer.overrideBlockTexture;
	        }

	        double d3 = (double)texture.getInterpolatedU(renderer.renderMinX * 16.0D);
	        double d4 = (double)texture.getInterpolatedU(renderer.renderMaxX * 16.0D);
	        double d5 = (double)texture.getInterpolatedV(renderer.renderMinZ * 16.0D);
	        double d6 = (double)texture.getInterpolatedV(renderer.renderMaxZ * 16.0D);

	        if (renderer.renderMinX < 0.0D || renderer.renderMaxX > 1.0D)
	        {
	            d3 = (double)texture.getMinU();
	            d4 = (double)texture.getMaxU();
	        }

	        if (renderer.renderMinZ < 0.0D || renderer.renderMaxZ > 1.0D)
	        {
	            d5 = (double)texture.getMinV();
	            d6 = (double)texture.getMaxV();
	        }

	        double d7 = d4;
	        double d8 = d3;
	        double d9 = d5;
	        double d10 = d6;

	        if (renderer.uvRotateBottom == 2)
	        {
	            d3 = (double)texture.getInterpolatedU(renderer.renderMinZ * 16.0D);
	            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxX * 16.0D);
	            d4 = (double)texture.getInterpolatedU(renderer.renderMaxZ * 16.0D);
	            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinX * 16.0D);
	            d9 = d5;
	            d10 = d6;
	            d7 = d3;
	            d8 = d4;
	            d5 = d6;
	            d6 = d9;
	        }
	        else if (renderer.uvRotateBottom == 1)
	        {
	            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxZ * 16.0D);
	            d5 = (double)texture.getInterpolatedV(renderer.renderMinX * 16.0D);
	            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinZ * 16.0D);
	            d6 = (double)texture.getInterpolatedV(renderer.renderMaxX * 16.0D);
	            d7 = d4;
	            d8 = d3;
	            d3 = d4;
	            d4 = d8;
	            d9 = d6;
	            d10 = d5;
	        }
	        else if (renderer.uvRotateBottom == 3)
	        {
	            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinX * 16.0D);
	            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxX * 16.0D);
	            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinZ * 16.0D);
	            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxZ * 16.0D);
	            d7 = d4;
	            d8 = d3;
	            d9 = d5;
	            d10 = d6;
	        }

	        double d11 = x + renderer.renderMinX;
	        double d12 = x + renderer.renderMaxX;
	        double d13 = y + renderer.renderMinY-.01;
	        double d14 = z + renderer.renderMinZ;
	        double d15 = z + renderer.renderMaxZ;

	        if (renderer.renderFromInside)
	        {
	            d11 = x + renderer.renderMaxX;
	            d12 = x + renderer.renderMinX;
	        }

	        if (renderer.enableAO)
	        {
	            tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
	            tessellator.setBrightness(renderer.brightnessTopLeft);
	            tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
	            tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
	            tessellator.setBrightness(renderer.brightnessBottomLeft);
	            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
	            tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
	            tessellator.setBrightness(renderer.brightnessBottomRight);
	            tessellator.addVertexWithUV(d12, d13, d14, d7, d9);
	            tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
	            tessellator.setBrightness(renderer.brightnessTopRight);
	            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
	        }
	        else
	        {
	            tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
	            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
	            tessellator.addVertexWithUV(d12, d13, d14, d7, d9);
	            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
	        }
	}
	
	public void renderFaceYPos(RenderBlocks renderer, double x , double y, double z, IIcon texture) {
        Tessellator tessellator = Tessellator.instance;

        if (renderer.hasOverrideBlockTexture())
        {
            texture = renderer.overrideBlockTexture;
        }

        double d3 = (double)texture.getInterpolatedU(renderer.renderMinX * 16.0D);
        double d4 = (double)texture.getInterpolatedU(renderer.renderMaxX * 16.0D);
        double d5 = (double)texture.getInterpolatedV(renderer.renderMinZ * 16.0D);
        double d6 = (double)texture.getInterpolatedV(renderer.renderMaxZ * 16.0D);

        if (renderer.renderMinX < 0.0D || renderer.renderMaxX > 1.0D)
        {
            d3 = (double)texture.getMinU();
            d4 = (double)texture.getMaxU();
        }

        if (renderer.renderMinZ < 0.0D || renderer.renderMaxZ > 1.0D)
        {
            d5 = (double)texture.getMinV();
            d6 = (double)texture.getMaxV();
        }

        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (renderer.uvRotateTop == 1)
        {
            d3 = (double)texture.getInterpolatedU(renderer.renderMinZ * 16.0D);
            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxX * 16.0D);
            d4 = (double)texture.getInterpolatedU(renderer.renderMaxZ * 16.0D);
            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinX * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (renderer.uvRotateTop == 2)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxZ * 16.0D);
            d5 = (double)texture.getInterpolatedV(renderer.renderMinX * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinZ * 16.0D);
            d6 = (double)texture.getInterpolatedV(renderer.renderMaxX * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (renderer.uvRotateTop == 3)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinX * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxX * 16.0D);
            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinZ * 16.0D);
            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxZ * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = x + renderer.renderMinX;
        double d12 = x + renderer.renderMaxX;
        double d13 = y + renderer.renderMaxY+.01;
        double d14 = z + renderer.renderMinZ;
        double d15 = z + renderer.renderMaxZ;

        if (renderer.renderFromInside)
        {
            d11 = x + renderer.renderMaxX;
            d12 = x + renderer.renderMinX;
        }

        if (renderer.enableAO)
        {
            tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
            tessellator.setBrightness(renderer.brightnessTopLeft);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
            tessellator.setBrightness(renderer.brightnessBottomLeft);
            tessellator.addVertexWithUV(d12, d13, d14, d7, d9);
            tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
            tessellator.setBrightness(renderer.brightnessBottomRight);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
            tessellator.setBrightness(renderer.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
        }
        else
        {
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.addVertexWithUV(d12, d13, d14, d7, d9);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
        }
	}
	
	public void renderFaceZNeg(RenderBlocks renderer, double x , double y, double z, IIcon texture) {
	       Tessellator tessellator = Tessellator.instance;

	        if (renderer.hasOverrideBlockTexture())
	        {
	            texture = renderer.overrideBlockTexture;
	        }

	        double d3 = (double)texture.getInterpolatedU(renderer.renderMaxX * 16.0D);
	        double d4 = (double)texture.getInterpolatedU(renderer.renderMinX * 16.0D);
	        double d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
	        double d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);
	        double d7;

	        if (renderer.flipTexture)
	        {
	            d7 = d3;
	            d3 = d4;
	            d4 = d7;
	        }

	        if (renderer.renderMinX < 0.0D || renderer.renderMaxX > 1.0D)
	        {
	            d3 = (double)texture.getMinU();
	            d4 = (double)texture.getMaxU();
	        }

	        if (renderer.renderMinY < 0.0D || renderer.renderMaxY > 1.0D)
	        {
	            d5 = (double)texture.getMinV();
	            d6 = (double)texture.getMaxV();
	        }

	        d7 = d4;
	        double d8 = d3;
	        double d9 = d5;
	        double d10 = d6;

	        if (renderer.uvRotateEast == 2)
	        {
	            d3 = (double)texture.getInterpolatedU(renderer.renderMinY * 16.0D);
	            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinX * 16.0D);
	            d4 = (double)texture.getInterpolatedU(renderer.renderMaxY * 16.0D);
	            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxX * 16.0D);
	            d9 = d5;
	            d10 = d6;
	            d7 = d3;
	            d8 = d4;
	            d5 = d6;
	            d6 = d9;
	        }
	        else if (renderer.uvRotateEast == 1)
	        {
	            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxY * 16.0D);
	            d5 = (double)texture.getInterpolatedV(renderer.renderMaxX * 16.0D);
	            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinY * 16.0D);
	            d6 = (double)texture.getInterpolatedV(renderer.renderMinX * 16.0D);
	            d7 = d4;
	            d8 = d3;
	            d3 = d4;
	            d4 = d8;
	            d9 = d6;
	            d10 = d5;
	        }
	        else if (renderer.uvRotateEast == 3)
	        {
	            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinX * 16.0D);
	            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxX * 16.0D);
	            d5 = (double)texture.getInterpolatedV(renderer.renderMaxY * 16.0D);
	            d6 = (double)texture.getInterpolatedV(renderer.renderMinY * 16.0D);
	            d7 = d4;
	            d8 = d3;
	            d9 = d5;
	            d10 = d6;
	        }

	        double d11 = x + renderer.renderMinX;
	        double d12 = x + renderer.renderMaxX;
	        double d13 = y + renderer.renderMinY;
	        double d14 = y + renderer.renderMaxY;
	        double d15 = z + renderer.renderMinZ-.01;

	        if (renderer.renderFromInside)
	        {
	            d11 = x + renderer.renderMaxX;
	            d12 = x + renderer.renderMinX;
	        }

	        if (renderer.enableAO)
	        {
	            tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
	            tessellator.setBrightness(renderer.brightnessTopLeft);
	            tessellator.addVertexWithUV(d11, d14, d15, d7, d9);
	            tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
	            tessellator.setBrightness(renderer.brightnessBottomLeft);
	            tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
	            tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
	            tessellator.setBrightness(renderer.brightnessBottomRight);
	            tessellator.addVertexWithUV(d12, d13, d15, d8, d10);
	            tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
	            tessellator.setBrightness(renderer.brightnessTopRight);
	            tessellator.addVertexWithUV(d11, d13, d15, d4, d6);
	        }
	        else
	        {
	            tessellator.addVertexWithUV(d11, d14, d15, d7, d9);
	            tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
	            tessellator.addVertexWithUV(d12, d13, d15, d8, d10);
	            tessellator.addVertexWithUV(d11, d13, d15, d4, d6);
	        }
	}
	
	public void renderFaceZPos(RenderBlocks renderer, double x , double y, double z, IIcon texture) {
        Tessellator tessellator = Tessellator.instance;

        if (renderer.hasOverrideBlockTexture())
        {
            texture = renderer.overrideBlockTexture;
        }

        double d3 = (double)texture.getInterpolatedU(renderer.renderMinX * 16.0D);
        double d4 = (double)texture.getInterpolatedU(renderer.renderMaxX * 16.0D);
        double d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
        double d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);
        double d7;

        if (renderer.flipTexture)
        {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if (renderer.renderMinX < 0.0D || renderer.renderMaxX > 1.0D)
        {
            d3 = (double)texture.getMinU();
            d4 = (double)texture.getMaxU();
        }

        if (renderer.renderMinY < 0.0D || renderer.renderMaxY > 1.0D)
        {
            d5 = (double)texture.getMinV();
            d6 = (double)texture.getMaxV();
        }

        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (renderer.uvRotateWest == 1)
        {
            d3 = (double)texture.getInterpolatedU(renderer.renderMinY * 16.0D);
            d6 = (double)texture.getInterpolatedV(16.0D - renderer.renderMinX * 16.0D);
            d4 = (double)texture.getInterpolatedU(renderer.renderMaxY * 16.0D);
            d5 = (double)texture.getInterpolatedV(16.0D - renderer.renderMaxX * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (renderer.uvRotateWest == 2)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxY * 16.0D);
            d5 = (double)texture.getInterpolatedV(renderer.renderMinX * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinY * 16.0D);
            d6 = (double)texture.getInterpolatedV(renderer.renderMaxX * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (renderer.uvRotateWest == 3)
        {
            d3 = (double)texture.getInterpolatedU(16.0D - renderer.renderMinX * 16.0D);
            d4 = (double)texture.getInterpolatedU(16.0D - renderer.renderMaxX * 16.0D);
            d5 = (double)texture.getInterpolatedV(renderer.renderMaxY * 16.0D);
            d6 = (double)texture.getInterpolatedV(renderer.renderMinY * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = x + renderer.renderMinX;
        double d12 = x + renderer.renderMaxX;
        double d13 = y + renderer.renderMinY;
        double d14 = y + renderer.renderMaxY;
        double d15 = z + renderer.renderMaxZ+.01;

        if (renderer.renderFromInside)
        {
            d11 = x + renderer.renderMaxX;
            d12 = x + renderer.renderMinX;
        }

        if (renderer.enableAO)
        {
            tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
            tessellator.setBrightness(renderer.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d14, d15, d3, d5);
            tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
            tessellator.setBrightness(renderer.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
            tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
            tessellator.setBrightness(renderer.brightnessBottomRight);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
            tessellator.setBrightness(renderer.brightnessTopRight);
            tessellator.addVertexWithUV(d12, d14, d15, d7, d9);
        }
        else
        {
            tessellator.addVertexWithUV(d11, d14, d15, d3, d5);
            tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.addVertexWithUV(d12, d14, d15, d7, d9);
        }
	}
}

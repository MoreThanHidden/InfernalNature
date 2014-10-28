package com.github.morethanhidden.MolecularGems.renderers;

import org.lwjgl.opengl.GL11;

import com.github.morethanhidden.MolecularGems.MainRegistry;
import com.github.morethanhidden.MolecularGems.Client.ClientProxy;
import com.github.morethanhidden.MolecularGems.blocks.GemOre;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderGemOre  implements ISimpleBlockRenderingHandler {
	public IBlockAccess blockAccess;
	@Override
	public void renderInventoryBlock(Block block, int metadata, int j,
			RenderBlocks renderer) {	
			    Tessellator tessellator=Tessellator.instance;
			    GL11.glTranslatef(-0.5F,-0.5F,-0.5F);
			    tessellator.startDrawingQuads();
			    tessellator.setNormal(0.0F,-1F,0.0F);
			    renderer.renderFaceYNeg(block,0.0D,0.0D,0.0D,Blocks.stone.getBlockTextureFromSide(0));
			    renderer.renderFaceYNeg(block,0.0D,0.0D,0.0D,MainRegistry.gemOre.getBlockTextureFromSide(0));
			    tessellator.draw();
			    tessellator.startDrawingQuads();
			    tessellator.setNormal(0.0F,1.0F,0.0F);
			    renderer.renderFaceYPos(block,0.0D,0.0D,0.0D,Blocks.stone.getBlockTextureFromSide(1));
			    renderer.renderFaceYPos(block,0.0D,0.0D,0.0D,MainRegistry.gemOre.getBlockTextureFromSide(1));
			    tessellator.draw();
			    tessellator.startDrawingQuads();
			    tessellator.setNormal(0.0F,0.0F,-1F);
			    renderer.renderFaceZNeg(block,0.0D,0.0D,0.0D,Blocks.stone.getBlockTextureFromSide(2));
			    renderer.renderFaceZNeg(block,0.0D,0.0D,0.0D,MainRegistry.gemOre.getBlockTextureFromSide(2));
			    tessellator.draw();
			    tessellator.startDrawingQuads();
			    tessellator.setNormal(0.0F,0.0F,1.0F);
			    renderer.renderFaceZPos(block,0.0D,0.0D,0.0D,Blocks.stone.getBlockTextureFromSide(3));
			    renderer.renderFaceZPos(block,0.0D,0.0D,0.0D,MainRegistry.gemOre.getBlockTextureFromSide(3));
			    tessellator.draw();
			    tessellator.startDrawingQuads();
			    tessellator.setNormal(-1F,0.0F,0.0F);
			    renderer.renderFaceXNeg(block,0.0D,0.0D,0.0D,Blocks.stone.getBlockTextureFromSide(4));
			    renderer.renderFaceXNeg(block,0.0D,0.0D,0.0D,MainRegistry.gemOre.getBlockTextureFromSide(4));
			    tessellator.draw();
			    tessellator.startDrawingQuads();
			    tessellator.setNormal(1.0F,0.0F,0.0F);
			    renderer.renderFaceXPos(block,0.0D,0.0D,0.0D,Blocks.stone.getBlockTextureFromSide(5));
			    renderer.renderFaceXPos(block,0.0D,0.0D,0.0D,MainRegistry.gemOre.getBlockTextureFromSide(5));
			    tessellator.draw();
			    GL11.glTranslatef(0.5F,0.5F,0.5F);
			    block.setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
	  }

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		if(ClientProxy.renderPass == 0)
            {
                //we are on the solid block render pass, lets render the solid stone
				renderer.renderStandardBlock(Blocks.stone, x, y, z);
				
				
        }
        else                    
        {
                //we are on the alpha render pass, draw the ice around the diamond
        	Tessellator.instance.setBrightness(240);
		    Tessellator.instance.setColorOpaque(255, 255, 255);

		    // render the overlaying block START
		    renderer.renderFaceYNeg(block, x, y, z, MainRegistry.gemOre.getBlockTextureFromSide(0));
		    renderer.renderFaceYPos(block, x, y, z, MainRegistry.gemOre.getBlockTextureFromSide(1));
		    renderer.renderFaceZNeg(block, x, y, z, MainRegistry.gemOre.getBlockTextureFromSide(2));
		    renderer.renderFaceZPos(block, x, y, z, MainRegistry.gemOre.getBlockTextureFromSide(3));
		    renderer.renderFaceXNeg(block, x, y, z, MainRegistry.gemOre.getBlockTextureFromSide(4));
		    renderer.renderFaceXPos(block, x, y, z, MainRegistry.gemOre.getBlockTextureFromSide(5));
		    // render the overlaying block END

		    Tessellator.instance.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        	
        }
        
        return true;
	}
	

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		 return ClientProxy.GemOreRenderType;
	}
}

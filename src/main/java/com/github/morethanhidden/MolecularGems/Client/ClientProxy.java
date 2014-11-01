package com.github.morethanhidden.MolecularGems.Client;

import com.github.morethanhidden.MolecularGems.MainRegistry;
import com.github.morethanhidden.MolecularGems.common;
import com.github.morethanhidden.MolecularGems.handler.BucketHandler;
import com.github.morethanhidden.MolecularGems.mob.EntityAncientMob;
import com.github.morethanhidden.MolecularGems.renderers.RenderAncientMob;
import com.github.morethanhidden.MolecularGems.renderers.RenderGemOre;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends common {
	
	public static int renderPass;
	public static int GemOreRenderType;
	
	@Override
		public void registerRenderers() {
		
            // Set Liquid Icons
		MainRegistry.liquidElectricOoze.setIcons(MainRegistry.blockElectricOooze.getIcon(0, 0), MainRegistry.blockElectricOooze.getIcon(1, 0));
		
        GemOreRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGemOre());
        
        	// Set Mob Render
        RenderingRegistry.registerEntityRenderingHandler(EntityAncientMob.class, new RenderAncientMob(new ModelBiped(), 0));
		}
	

}

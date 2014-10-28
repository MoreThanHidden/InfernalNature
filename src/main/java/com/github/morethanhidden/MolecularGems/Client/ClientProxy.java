package com.github.morethanhidden.MolecularGems.Client;

import com.github.morethanhidden.MolecularGems.MainRegistry;
import com.github.morethanhidden.MolecularGems.common;
import com.github.morethanhidden.MolecularGems.handler.BucketHandler;
import com.github.morethanhidden.MolecularGems.renderers.RenderGemOre;

import cpw.mods.fml.client.registry.RenderingRegistry;
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
		}
	

}

package morethanhidden.MolecularGems.Client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import morethanhidden.MolecularGems.MainRegistry;
import morethanhidden.MolecularGems.common;
import morethanhidden.MolecularGems.handler.BucketHandler;
import morethanhidden.MolecularGems.mob.EntityAncientMob;
import morethanhidden.MolecularGems.renderers.RenderAncientMob;
import morethanhidden.MolecularGems.renderers.RenderGemOre;
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
		
        GemOreRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGemOre());
        
        	// Set Mob Render
        RenderingRegistry.registerEntityRenderingHandler(EntityAncientMob.class, new RenderAncientMob(new ModelBiped(), 0));

	}
	

}

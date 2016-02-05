package morethanhidden.MolecularGems.Client;

import morethanhidden.MolecularGems.common;
import morethanhidden.MolecularGems.mob.EntityAncientMob;
import morethanhidden.MolecularGems.renderers.RenderAncientMob;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends common {
	
	public static int renderPass;
	public static int GemOreRenderType;
	
	@Override
		public void registerRenderers() {

        // Set Mob Render
        //RenderingRegistry.registerEntityRenderingHandler(EntityAncientMob.class, new RenderAncientMob(, 0));

		//Register Item Models
		ItemModelRegistry.init();


	}
	

}

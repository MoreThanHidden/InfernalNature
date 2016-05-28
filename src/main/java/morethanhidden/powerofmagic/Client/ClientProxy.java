package morethanhidden.powerofmagic.Client;

import morethanhidden.powerofmagic.common;
import morethanhidden.powerofmagic.mob.EntityAncientMob;
import morethanhidden.powerofmagic.renderers.RenderAncientMob;

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

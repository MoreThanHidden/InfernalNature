package morethanhidden.powerofmagic.Client;

import morethanhidden.powerofmagic.common;

public class ClientProxy extends common {
	
	public static int renderPass;
	public static int GemOreRenderType;
	
	@Override
		public void registerRenderers() {

        // Set Mob Render
        //RenderingRegistry.registerEntityRenderingHandler(EntityAncientMob.class, new RenderAncientMob(Minecraft.getMinecraft().getRenderManager(), new ModelZombie(), 2));

		//Register Item Models
		ItemModelRegistry.init();

		//Register Fluids
		FluidModelRegistry.init();


	}
	

}

package morethanhidden.infernalnature.client.renderers;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class RenderAncientMob extends EntityRenderer {

	private static final ResourceLocation mobtextures = new ResourceLocation("infernalnature:textures/entity/ghost.png");
	
	public RenderAncientMob(EntityRendererProvider.Context context) {
		super(context);
		
	}

	@Override
	public ResourceLocation getTextureLocation(Entity entity) {
		return mobtextures;
	}
}

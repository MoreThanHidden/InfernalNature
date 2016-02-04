package morethanhidden.MolecularGems.renderers;

import morethanhidden.MolecularGems.mob.EntityAncientMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderAncientMob extends RenderLiving{

	private static final ResourceLocation mobtextures = new ResourceLocation("moleculargems:textures/entity/ghost.png");
	
	public RenderAncientMob(RenderManager m, ModelBase base, float f) {
		super(m, base, f);
		
	}

	protected ResourceLocation getEntityTexture(EntityAncientMob entity){
		
		return mobtextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityAncientMob)entity);
		
	}
	
}

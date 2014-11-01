package com.github.morethanhidden.MolecularGems.renderers;

import com.github.morethanhidden.MolecularGems.MainRegistry;
import com.github.morethanhidden.MolecularGems.mob.EntityAncientMob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderAncientMob extends RenderLiving{

	private static final ResourceLocation mobtextures = new ResourceLocation("moleculargems:textures/entity/ghost.png");
	
	public RenderAncientMob(ModelBase m, float f) {
		super(m, f);
		
	}

	protected ResourceLocation getEntityTexture(EntityAncientMob entity){
		
		return mobtextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityAncientMob)entity);
		
	}
	
}

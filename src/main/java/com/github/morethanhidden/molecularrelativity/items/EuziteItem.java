package com.github.morethanhidden.molecularrelativity.items;

import com.github.morethanhidden.molecularrelativity.MainRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EuziteItem extends Item {

	public EuziteItem() {
        setMaxStackSize(64);
        setCreativeTab(MainRegistry.tabMolecularRelativity);
        setUnlocalizedName("TwinSubatomicParticles");
        setTextureName("molecularrelativity:TwinSubatomicParticles");
}
	
}



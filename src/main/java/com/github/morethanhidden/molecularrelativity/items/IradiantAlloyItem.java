package com.github.morethanhidden.molecularrelativity.items;

import com.github.morethanhidden.molecularrelativity.MainRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IradiantAlloyItem extends Item {

	public IradiantAlloyItem() {
        setMaxStackSize(64);
        setCreativeTab(MainRegistry.tabMolecularRelativity);
        setUnlocalizedName("IrradiantAlloy");
        setTextureName("molecularrelativity:IrradiantAlloy");
}
	
}



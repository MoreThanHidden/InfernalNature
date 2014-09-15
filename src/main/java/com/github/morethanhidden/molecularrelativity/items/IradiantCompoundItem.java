package com.github.morethanhidden.molecularrelativity.items;

import com.github.morethanhidden.molecularrelativity.MainRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IradiantCompoundItem extends Item {

	public IradiantCompoundItem() {
        setMaxStackSize(64);
        setCreativeTab(MainRegistry.tabMolecularRelativity);
        setUnlocalizedName("IrradiantCompound");
        setTextureName("molecularrelativity:IrradiantCompound");
}
	
}



package com.github.morethanhidden.MolecularGems.items;

import com.github.morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.item.Item;

public class AscendedGem extends Item {

	public AscendedGem() {
		setMaxDamage(MainRegistry.gemeratorEnergyAmt);
        setMaxStackSize(64);
        setCreativeTab(MainRegistry.tabmoleculargems);
        setUnlocalizedName("AscendedGem");
        setTextureName("moleculargems:AscendedGem");
	}
	
	
	
}

package com.github.morethanhidden.molecularrelativity.items;

import com.github.morethanhidden.molecularrelativity.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TelluriumIngot extends Item {

	public TelluriumIngot() {
		maxStackSize = 64;
        setCreativeTab(MainRegistry.tabMolecularRelativity);
        setUnlocalizedName("TelluriumIngot");
        setTextureName("molecularrelativity:TelluriumIngot");
}
}



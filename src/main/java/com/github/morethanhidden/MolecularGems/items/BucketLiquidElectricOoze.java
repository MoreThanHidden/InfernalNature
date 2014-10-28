package com.github.morethanhidden.MolecularGems.items;

import com.github.morethanhidden.MolecularGems.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class BucketLiquidElectricOoze extends ItemBucket {

	public BucketLiquidElectricOoze(Block block) {
		super(block);
	        setCreativeTab(MainRegistry.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidEUz");
	        setContainerItem(Items.bucket);
	        setTextureName("moleculargems:bucket_liquidEUze");
	}

}

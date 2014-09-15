package com.github.morethanhidden.molecularrelativity.items;

import com.github.morethanhidden.molecularrelativity.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class BucketLiquidEUzItem extends ItemBucket {

	public BucketLiquidEUzItem(Block block) {
		super(block);
	        setCreativeTab(MainRegistry.tabMolecularRelativity);
	        setUnlocalizedName("BucketLiquidEUz");
	        setContainerItem(Items.bucket);
	        setTextureName("molecularrelativity:bucket_liquidEUze");
	}

}

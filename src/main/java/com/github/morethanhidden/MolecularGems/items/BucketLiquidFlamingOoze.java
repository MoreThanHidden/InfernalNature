package com.github.morethanhidden.MolecularGems.items;

import com.github.morethanhidden.MolecularGems.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class BucketLiquidFlamingOoze extends ItemBucket {

	public BucketLiquidFlamingOoze(Block block) {
		super(block);
	        setCreativeTab(MainRegistry.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidFlamingOoze");
	        setContainerItem(Items.bucket);
	        setTextureName("moleculargems:bucket_liquidFlamingOoze");
	}

}

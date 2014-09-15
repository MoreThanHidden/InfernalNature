package com.github.morethanhidden.molecularrelativity.blocks;

import java.util.Random;

import com.github.morethanhidden.molecularrelativity.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class TelluriumOre extends Block
{
	public TelluriumOre()
	{
		super(Material.rock);
		setBlockName("TelluriumOre");
		setBlockTextureName("molecularrelativity:" + getUnlocalizedName().substring(5));
		setCreativeTab(MainRegistry.tabMolecularRelativity);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.625F);
	}
	


}
package com.github.morethanhidden.molecularrelativity.blocks;

import java.util.Random;

import com.github.morethanhidden.molecularrelativity.MainRegistry;
import com.github.morethanhidden.molecularrelativity.TileMoleculizer;

import ic2.api.energy.event.EnergyTileUnloadEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class Moleculizer extends BlockContainer
{
	public Moleculizer(){
		super(Material.rock);
		setBlockName("Moleculizer");
		setCreativeTab(MainRegistry.tabMolecularRelativity);
		setStepSound(soundTypePiston);
		setHardness(10.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setBlockTextureName("molecularrelativity:Moleculizer");
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return MainRegistry.telluriumIngot;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		
		if(world.isRemote) return true;
		
		TileMoleculizer te = (TileMoleculizer) world.getTileEntity(x, y, z);
		
		if(te != null){
			if(te.initialized != false){
			if(player.isSneaking()) te.energy = 0.00;
			if(player.isSneaking()) te.euzebufferamount = 0;
			player.addChatComponentMessage(new ChatComponentTranslation("Current Energy: " + te.energy));
			player.addChatComponentMessage(new ChatComponentTranslation("Current LiquidEuze: " + te.euzebufferamount));
					}
			//Add a GUI Here
			}
		
		return true;
		
	} 
	 

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileMoleculizer();
	}
	

}
package com.github.morethanhidden.MolecularGems.blocks;

import java.util.Random;

import com.github.morethanhidden.MolecularGems.MainRegistry;
import com.github.morethanhidden.MolecularGems.TileGemerator;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GemeratorEmpty extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon texture_front;
    private int direction;
    
	public GemeratorEmpty()
	{
		super(Material.rock);
		setBlockName("MolecularGenerator");
		setCreativeTab(MainRegistry.tabmoleculargems);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	

	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		if(world.isRemote) return true;
		if(player.getCurrentEquippedItem() != null) if(player.getCurrentEquippedItem().getItem() == MainRegistry.ascendedGem){
			world.setBlock(x, y, z, MainRegistry.Gemerator, world.getBlockMetadata(x, y, z), 2);
			TileGemerator te = (TileGemerator) world.getTileEntity(x, y, z);
			if (player.getCurrentEquippedItem().isItemDamaged()) te.energy = te.maxEnergy - player.getCurrentEquippedItem().getItemDamage();
			player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
			return true;}
		player.addChatComponentMessage(new ChatComponentTranslation("Insert a Ascended Gem to use"));
		return true;
	} 
	
	
	 /**
     * Called when the block is placed in the world.
     */
	 public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
	    {
	        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
	        }

	        if (l == 1)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
	        }

	        if (l == 2)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
	        }

	        if (l == 3)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
	        }

	    }
	
	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
    	if (par2 == 0 && par1 == 3)
            return this.texture_front;
        return par1 == 1 ? this.blockIcon : (par1 == 0 ? this.blockIcon : (par1 != par2 ? this.blockIcon : this.texture_front));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconreg)
    {
        this.blockIcon = iconreg.registerIcon("moleculargems:Casing");
        this.texture_front = iconreg.registerIcon("moleculargems:GemeratorEmpty");
    }
	
}
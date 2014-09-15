package com.github.morethanhidden.molecularrelativity.blocks;

import java.util.Random;

import com.github.morethanhidden.molecularrelativity.MainRegistry;
import com.github.morethanhidden.molecularrelativity.TileMolecularFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MolecularFurnace extends BlockContainer
{
	
	@SideOnly(Side.CLIENT)
    private IIcon texture_front;
	
	private static boolean isBurning;
	private final boolean isBurning2;
	private final Random random = new Random();
	
	public MolecularFurnace(boolean isActive){
		super(Material.rock);
		setBlockName("MolecularFurnace");
		setCreativeTab(MainRegistry.tabMolecularRelativity);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
		isBurning2 = isActive;
		
	}
	 /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entitylivingbase, ItemStack itemstack)
    {
        int direction = MathHelper.floor_double((double)(entitylivingbase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (direction == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (direction == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (direction == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (direction == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        
        if (itemstack.hasDisplayName()) {
        	((TileMolecularFurnace) world.getTileEntity(x, y, z)).furnaceName(itemstack.getDisplayName());
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
        this.blockIcon = iconreg.registerIcon("molecularrelativity:MoleculizerCasing");
        this.texture_front = iconreg.registerIcon(this.isBurning2 ? "molecularrelativity:MolecularGeneratorActivated" : "molecularrelativity:MolecularGenerator");
    }
    
    
	   /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileMolecularFurnace tilemolecularfurnace = (TileMolecularFurnace)world.getTileEntity(x, y, z);

            if (tilemolecularfurnace != null)
            {
                player.openGui(MainRegistry.instance, 0, world, x, y, z);
            }

            return true;
        }
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
        return MainRegistry.telluriumIngot;
    }
    public Item getItem(int par1, int par2, int par3, int par4){
        return MainRegistry.telluriumIngot;
    }
    
    public static void  updateBlockState(boolean burning, World world, int x, int y, int z){
    	int direction = world.getBlockMetadata(x, y, z);
    	TileEntity tileentity = world.getTileEntity(x, y, z);
    	isBurning = true;
    	
    	if(burning){
    		world.setBlock(x, y, z, MainRegistry.molecularFurnaceActive);
    	}else{
    		world.setBlock(x, y, z, MainRegistry.molecularFurnace);
    	}
    	
    	isBurning = false;
    	world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    	
    	if (tileentity != null){
          	tileentity.validate();world.setTileEntity(x, y, z, tileentity);
        }
    }
    
    public void breakBlock(World world, int x, int y, int z, Block block, int meta){
    	if(!isBurning){
    		TileMolecularFurnace tilemolecularfurnace = (TileMolecularFurnace) world.getTileEntity(x, y, z);
    		if (tilemolecularfurnace != null){
                for (int i = 0; i < tilemolecularfurnace.getSizeInventory(); ++i){
                	ItemStack itemstack = tilemolecularfurnace.getStackInSlot(i);
                	if(itemstack != null){
                    	float f = this.random.nextFloat() * 0.6F + 0.1F;
                    	float f1 = this.random.nextFloat() * 0.6F + 0.1F;
                    	float f2 = this.random.nextFloat() * 0.6F + 0.1F;
                    	
                   	while(itemstack.stackSize > 0){
                   		int j = this.random.nextInt(21) + 10;
                   		
                   		if (j > itemstack.stackSize){
                   			j = itemstack.stackSize;
                   		}
                   		
                   		itemstack.stackSize -= j;
                   		EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
                   	
                   		if(itemstack.hasTagCompound()){
                   		entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                   		}
                   		
                   		float f3 = 0.025F;
                   		entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                   		entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
                   		entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                   		world.spawnEntityInWorld(entityitem);
                   		}
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
    	}
    	super.breakBlock(world, x, y, z, block, meta);
    	
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random){
    	if(this.isBurning2){
    		int direction = world.getBlockMetadata(x, y, z);
    		
    		float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 6.0F / 16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.3F;
    		
    		if(direction == 2){
    			world.spawnParticle("smoke",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    			world.spawnParticle("flame",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    		}else if(direction == 3){
    			world.spawnParticle("smoke",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    			world.spawnParticle("flame",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    		}else if(direction == 4){
    			world.spawnParticle("smoke",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    			world.spawnParticle("flame",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    		}else if(direction == 5){
    			world.spawnParticle("smoke",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    			world.spawnParticle("flame",(double) (xx -xx2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
    		}
    	}
    }
    
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileMolecularFurnace();
	}
	
}
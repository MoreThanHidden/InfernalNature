package morethanhidden.MolecularGems.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morethanhidden.MolecularGems.MainRegistry;
import morethanhidden.MolecularGems.TileMolecularAdaptor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MolecularAdaptor extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon texture_front;
    private IIcon texture_front_e;
    private int direction;
    private ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    private final boolean molecularAdaptorEmpty;
    
	public MolecularAdaptor(boolean adaptorempty)
	{
		super(Material.rock);
		setBlockName("Gemerator");
		setCreativeTab(MainRegistry.tabmoleculargems);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
		this.molecularAdaptorEmpty = adaptorempty;
		
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		
		TileMolecularAdaptor te = (TileMolecularAdaptor) world.getTileEntity(x, y, z);
		if (this.molecularAdaptorEmpty){
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == MainRegistry.molecularBattery){
				
				int energy = 0;
				
				if(player.getCurrentEquippedItem().stackTagCompound != null){
					energy = player.getCurrentEquippedItem().getTagCompound().getInteger("Energy");
					}
				player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
				
				world.setBlock(x, y, z, MainRegistry.molecularAdaptor, world.getBlockMetadata(x, y, z), 2);
				TileMolecularAdaptor te2 = (TileMolecularAdaptor) world.getTileEntity(x, y, z);
				
				te2.energy = energy;
				
				
			return true;}
			if (!world.isRemote) {
			player.addChatComponentMessage(new ChatComponentTranslation("Insert a Ascended Gem to use"));
			}return true;
			
		}else if (player.isSneaking() && !world.isRemote) {
				world.setBlock(x, y, z, MainRegistry.molecularAdaptorEmpty, world.getBlockMetadata(x, y, z), 2);
					ItemStack itemstack = new ItemStack(MainRegistry.molecularBattery,1);
					if(itemstack.stackTagCompound == null) itemstack.setTagCompound(new NBTTagCompound());
					itemstack.stackTagCompound.setInteger("Energy", te.energy);
					world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, itemstack));
			
			}else if (!world.isRemote){ 
					int length = String.valueOf(te.energy).length();
					int lengtheu = String.valueOf(te.energy / 4).length();
					player.addChatComponentMessage(new ChatComponentTranslation(("Stored:")));
					if (length >= 7 && lengtheu >= 7){
						player.addChatComponentMessage(new ChatComponentTranslation(te.energy / 4 / 1000000 + "M EU or " + te.energy / 1000000 + "M RF"));
					}else if (length >= 7 && lengtheu < 7){  
						player.addChatComponentMessage(new ChatComponentTranslation(te.energy / 4 / 1000 + "K EU or " + (double) (te.energy / 10000) / 100 + "M RF"));
					}else if (length < 4){  
						player.addChatComponentMessage(new ChatComponentTranslation(te.energy / 4 + " EU or " + te.energy + " RF"));
					}else if (length < 7){  
						player.addChatComponentMessage(new ChatComponentTranslation(te.energy / 4 / 1000 + "K EU or " + te.energy / 1000 + "K RF"));
					}
			
			}
		
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
            direction = 2;
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
            direction = 5;
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
            direction = 3;
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
            direction = 4;
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
        this.texture_front = iconreg.registerIcon(this.molecularAdaptorEmpty ? "moleculargems:MolecularAdaptorEmpty" : "moleculargems:MolecularAdaptor");
    }
    
    
    @Override
    	@Optional.Method(modid = "CoFHAPI")
    	public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {
    		TileEntity tile = world.getTileEntity(x, y, z);
    		if(tile != null && tile instanceof TileMolecularAdaptor)
    			((TileMolecularAdaptor) tile).onNeighborTileChange(tileX, tileY, tileZ);
    	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileMolecularAdaptor();
	}
	
	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest) {
		
		final TileMolecularAdaptor te = (TileMolecularAdaptor) world.getTileEntity(x, y, z);
		if (!molecularAdaptorEmpty){
		ItemStack itemstack = new ItemStack(MainRegistry.molecularBattery,1);
		if(itemstack.stackTagCompound == null) itemstack.setTagCompound(new NBTTagCompound());
		itemstack.stackTagCompound.setInteger("Energy", te.energy);
		
		ret.add(itemstack);
		}
		return super.removedByPlayer(world, player, x, y, z, willHarvest);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ret.add(new ItemStack (MainRegistry.molecularAdaptorEmpty, 1));
		return ret;
	}
	
    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
	@Override
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
	@Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int p_149736_5_)
    {
		TileMolecularAdaptor te = (TileMolecularAdaptor) world.getTileEntity(x, y, z);
        return te.energy * 16 / (MainRegistry.gemeratorEnergyAmt * 4);
    }
	
}
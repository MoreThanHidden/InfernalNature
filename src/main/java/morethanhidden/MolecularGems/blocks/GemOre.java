package morethanhidden.MolecularGems.blocks;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morethanhidden.MolecularGems.MainRegistry;
import morethanhidden.MolecularGems.Client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GemOre extends Block
{
	public GemOre()
	{
		super(Material.rock);
		setBlockName("GemOre");
		setBlockTextureName("moleculargems:" + getUnlocalizedName().substring(5));
		setCreativeTab(MainRegistry.tabmoleculargems);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) //get drops array
    {	 
    	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    	
		// Gets how much items this block will drop
         int count = 2 + quantityDropped(metadata, fortune, world.rand);
    	
      // Here I make it drop random items
         int luckDraw = 0;
         Item itemDropped = null;
         
         for(int i = 0; i < count; i++)
         {
         	// Gets a number between 0 and 2
         	luckDraw = world.rand.nextInt(3);
         	itemDropped = null;
         	
     
         	// Choose what will be on the list
         	if (luckDraw == 0) { 
         		ret.add(new ItemStack(MainRegistry.cleanGem, 1, 0));
         	}
         	if (luckDraw == 1) { 
         		ret.add(new ItemStack(MainRegistry.cleanGem, 1, 1));
         	}
         	if (luckDraw == 2) { 
         		ret.add(new ItemStack(MainRegistry.cleanGem, 1, 2));
         	}
         	
        }
         
    	return ret;
    }
    
	@Override
    public boolean renderAsNormalBlock()
{
    return false;
}
	
	@Override
    public boolean isOpaqueCube()
{
    return false;
}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getRenderType()
{
    return ClientProxy.GemOreRenderType;
}
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass)
{
    //Set the static var in the client proxy
    ClientProxy.renderPass = pass;
    //the block can render in both passes, so return true always
    return true;
}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
{
            return 1;
}
}
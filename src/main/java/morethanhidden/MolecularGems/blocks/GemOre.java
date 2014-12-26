package morethanhidden.MolecularGems.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morethanhidden.MolecularGems.MainRegistry;
import morethanhidden.MolecularGems.Client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GemOre extends Block{
		public static final String[] blockNames = new String[] {"OreClinohumite", "OreSugilite", "OreJadite"};
			
		private IIcon[] block_icon;
		
		public GemOre () {
			super(Material.rock);
			setBlockName("GemOre");
			setCreativeTab(MainRegistry.tabmoleculargems);
			setHardness(4.0F);
			setHarvestLevel("pickaxe",3);
			
		}

		int blockcount = 3;

		public String getUnlocalizedName(ItemStack par1ItemStack)
		{
		         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, blockcount-1);
		         return super.getUnlocalizedName() + "." + blockNames[i];
		}
		
		@Override
		public void getSubBlocks(Item par1, CreativeTabs creativeTabs, List list)
		{
			         for (int j = 0; j < blockcount; ++j)
			         {
			                 list.add(new ItemStack(this, 1, j));
			         }
		}
		
		@Override
		public void registerBlockIcons(IIconRegister par1IconRegister)
		{
		         this.block_icon = new IIcon[blockNames.length];

		         for (int i = 0; i < blockNames.length; ++i)
		         {
		                 this.block_icon[i] = par1IconRegister.registerIcon("moleculargems:" + blockNames[i]);
		         }
		}
		
		@Override
		@SideOnly(Side.CLIENT)
	    public IIcon getIcon(int par1, int par2)
	    {
			int j = MathHelper.clamp_int(par2, 0, blockcount-1);
	        return this.block_icon[j];
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
         	// Gets a number between 0 and 1
         	luckDraw = world.rand.nextInt(2);
         	itemDropped = null;
         	
     
         	// Choose what will be on the list
         	if (luckDraw == 0) { 
         		ret.add(new ItemStack(MainRegistry.regularGem, 1, metadata));
         	}
         	if (luckDraw == 1) { 
         		ret.add(new ItemStack(MainRegistry.fragmentGem, 1, metadata));
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
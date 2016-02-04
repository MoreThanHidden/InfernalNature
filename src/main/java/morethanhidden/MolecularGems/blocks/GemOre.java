package morethanhidden.MolecularGems.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import morethanhidden.MolecularGems.MolecularGems;
import morethanhidden.MolecularGems.Client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GemOre extends Block{
		
		public GemOre () {
			super(Material.rock);
			setCreativeTab(MolecularGems.tabmoleculargems);
			setHardness(4.0F);
			setHarvestLevel("pickaxe",3);
			
		}
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) //get drops array
    {	 
    	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    	
		// Gets how much items this block will drop
         int count = 2 + quantityDropped(state, fortune, new Random());
    	
      // Here I make it drop random items
         int luckDraw = 0;
         Item itemDropped = null;
         
         for(int i = 0; i < count; i++)
         {
         	// Gets a number between 0 and 1
         	luckDraw = new Random().nextInt(2);
         	itemDropped = null;
         	
     
         	// Choose what will be on the list
         	if (luckDraw == 0) { 
         		ret.add(new ItemStack(MolecularGems.regularGem, 1));
         	}
         	if (luckDraw == 1) { 
         		ret.add(new ItemStack(MolecularGems.fragmentGem, 1));
         	}
         	
        }
         
    	return ret;
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
	

}
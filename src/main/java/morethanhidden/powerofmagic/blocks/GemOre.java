package morethanhidden.powerofmagic.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import morethanhidden.powerofmagic.powerofmagic;
import morethanhidden.powerofmagic.Client.ClientProxy;
import morethanhidden.powerofmagic.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GemOre extends Block{
		
		public GemOre () {
			super(Material.ROCK);
			setCreativeTab(powerofmagic.tabpowerofmagic);
			setHardness(4.0F);
			setHarvestLevel("pickaxe",3);
			setUnlocalizedName("gemOre");
			
		}

    public String getUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }

	@Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) //get drops array
    {	 
    	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

         int count = 1 + quantityDropped(state, fortune, new Random());

         int luckDraw = 0;
         int luckDraw2 = 0;
         Item itemDropped = null;
         
         for(int i = 0; i < count; i++)
         {
         	 // Gets a number between 0 and 3
         	 luckDraw = new Random().nextInt(3);
             luckDraw2 = new Random().nextInt(3);

			 switch (luckDraw) {
				case 0:
         			ret.add(new ItemStack(ItemRegistry.regularGem, 1, 0));
					break;
				case 1:
					ret.add(new ItemStack(ItemRegistry.regularGem, 1, 1));
					break;
				case 2:
					ret.add(new ItemStack(ItemRegistry.regularGem, 1 , 2));
					break;

         	 }switch (luckDraw2) {
                case 0:
                    ret.add(new ItemStack(ItemRegistry.fragmentGem, 1, 0));
                    break;
                case 1:
                    ret.add(new ItemStack(ItemRegistry.fragmentGem, 1, 1));
                    break;
                case 2:
                    ret.add(new ItemStack(ItemRegistry.fragmentGem, 1, 2));
                    break;
            }

        }
         
    	return ret;
    }

	//@Override
    public boolean isOpaqueCube()
{
    return false;
}

	//@Override
    @SideOnly(Side.CLIENT)
    public int getRenderType()
{
    return ClientProxy.GemOreRenderType;
}
	

}
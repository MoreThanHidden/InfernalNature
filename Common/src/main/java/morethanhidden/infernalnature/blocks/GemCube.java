package morethanhidden.infernalnature.blocks;

import morethanhidden.infernalnature.InfernalNature;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class GemCube extends Block{

		public GemCube() {
			super(Material.ROCK);
			setCreativeTab(powerofmagic.tabpowerofmagic);
			setHardness(4.0F);
			setHarvestLevel("pickaxe",3);
			setUnlocalizedName("angled_cube");
            setRegistryName(powerofmagic.MODID + ":angled_cube");
			
		}

    public String getUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

}
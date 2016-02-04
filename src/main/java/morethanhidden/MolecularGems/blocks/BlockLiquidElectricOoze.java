package morethanhidden.MolecularGems.blocks;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockLiquidElectricOoze extends BlockFluidClassic{


        public BlockLiquidElectricOoze(Fluid fluid, Material material) {
                super(fluid, material);
                setCreativeTab(MolecularGems.tabmoleculargems);
                setLightLevel(0.625F);
        }
        
        @Override
        public boolean canDisplace(IBlockAccess world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
                return super.canDisplace(world, pos);
        }
        
        @Override
        public boolean displaceIfPossible(World world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
                return super.displaceIfPossible(world, pos);
        }
        
        @Override
        public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity e) {
        	if (MolecularGems.ShockingLiquid = true){
        	
        	world.spawnEntityInWorld(new EntityLightningBolt(world, pos.getX(),pos.getY(),pos.getZ()));
        	EntityPlayer player = world.getClosestPlayer(pos.getX(),pos.getY(),pos.getZ(), 3);
        	
        	if (player != null){
        	player.addStat(MolecularGems.electrifying, 1);}
        	
        	}
        }
}

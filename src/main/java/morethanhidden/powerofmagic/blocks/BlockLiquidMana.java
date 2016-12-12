package morethanhidden.powerofmagic.blocks;

import morethanhidden.powerofmagic.powerofmagic;
import morethanhidden.powerofmagic.registry.AchievementRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockLiquidMana extends BlockFluidClassic{


        public BlockLiquidMana(Fluid fluid, Material material) {
                super(fluid, material);
                setCreativeTab(powerofmagic.tabpowerofmagic);
                setLightLevel(0.625F);
                setUnlocalizedName("blockliquidmana");
                setRegistryName(powerofmagic.MODID, "blockliquidmana");
        }
        
        @Override
        public boolean canDisplace(IBlockAccess world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().isAssociatedBlock(world.getBlockState(pos).getBlock())) return false;
                return super.canDisplace(world, pos);
        }
        
        @Override
        public boolean displaceIfPossible(World world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().isAssociatedBlock(world.getBlockState(pos).getBlock())) return false;
                return super.displaceIfPossible(world, pos);
        }
        
        @Override
        public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity e) {
        	if (powerofmagic.ShockingLiquid = true){
        	
        	world.spawnEntity(new EntityLightningBolt(world, pos.getX(),pos.getY(),pos.getZ(), true));
        	EntityPlayer player = world.getClosestPlayer(pos.getX(),pos.getY(),pos.getZ(), 3, true);
        	
        	if (player != null){
        	player.addStat(AchievementRegistry.electrifying, 1);}
        	
        	}
        }
}


import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockLiquidFire extends BlockFluidClassic{


        
        private int tickcount = 0;
        
        public BlockLiquidFire(Fluid fluid, Material material) {
                super(fluid, material);
                setUnlocalizedName("blockliquidfire");
        }

        
        
        @Override
        public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
        {
            int quantaRemaining = quantaPerBlock - state.getValue(LEVEL);
            int expQuanta = -101;
            
            //Add 1 to the tick count integer
            
            
            if(tickcount >= 5){
                return;
    		}else{
            tickcount++;
            }
            
            // check adjacent block levels if non-source
            if (quantaRemaining < quantaPerBlock)
            {
                int y2 = pos.getY() - densityDir;

                if (world.getBlockState(new BlockPos(pos.getX(), y2, pos.getZ())) == this ||
                    world.getBlockState(new BlockPos(pos.getX() - 1, y2, pos.getZ())) == this ||
                    world.getBlockState(new BlockPos(pos.getX() + 1, y2, pos.getZ())) == this ||
                    world.getBlockState(new BlockPos(pos.getX(), y2, pos.getZ()-1)) == this ||
                    world.getBlockState(new BlockPos(pos.getX(), y2, pos.getZ()+1)) == this)
                {
                    expQuanta = quantaPerBlock - 1;
                }
                else
                {
                    int maxQuanta = -100;
                    maxQuanta = getLargerQuanta(world, pos.subtract(new Vec3i(1,0,0)), maxQuanta);
                    maxQuanta = getLargerQuanta(world, pos.add(1,0,0), maxQuanta);
                    maxQuanta = getLargerQuanta(world, pos.subtract(new Vec3i(0,0,1)), maxQuanta);
                    maxQuanta = getLargerQuanta(world, pos.add(0,0,1), maxQuanta);

                    expQuanta = maxQuanta - 1;
                }

                // decay calculation
                if (expQuanta != quantaRemaining)
                {
                    quantaRemaining = expQuanta;

                    if (expQuanta <= 0)
                    {
                        tickcount = 0;
                    }
                    else
                    {
                        state = state.withProperty(LEVEL, Integer.valueOf(quantaPerBlock - expQuanta));
                        world.setBlockState(pos, state, 3);
                        world.scheduleUpdate(pos, this, tickRate);
                        world.notifyNeighborsOfStateChange(pos, this);
                    }
                }
            }
            // This is a "source" block, set meta to zero, and send a server only update
            else if (quantaRemaining >= quantaPerBlock)
            {
                state = state.withProperty(LEVEL, Integer.valueOf(0));
                world.setBlockState(pos, state, 2);
            }

            // Flow vertically if possible
            if (canDisplace(world, pos.add(0, densityDir, 0)))
            {
                flowIntoBlock(world, pos.add(0, densityDir, 0), 1);

                return;
            }

            // Flow outward if possible
            int flowMeta = quantaPerBlock - quantaRemaining + 1;
            if (flowMeta >= quantaPerBlock)
            {
            	return;
            }

            if (isSourceBlock(world, pos) || !isFlowingVertically(world, pos))
            {
                if (world.getBlockState(new BlockPos(pos.getX(), pos.getY() - densityDir, pos.getZ())) == this)
                {
                    flowMeta = 1;
                }
                boolean flowTo[] = getOptimalFlowDirections(world, pos);

                if (flowTo[0]) flowIntoBlock(world, pos.subtract(new Vec3i(1,0,0)),     flowMeta);
                if (flowTo[1]) flowIntoBlock(world, pos.add(1,0,0),     flowMeta);
                if (flowTo[2]) flowIntoBlock(world, pos.subtract(new Vec3i(0,0,1)), flowMeta);
                if (flowTo[3]) flowIntoBlock(world, pos.add(0,0,1), flowMeta);

            }
            


        }
                       
        @Override
        public void onBlockAdded(World world, BlockPos pos, IBlockState state)
        {
            world.scheduleBlockUpdate(pos, this, tickRate, 0);
            tickcount = 0;
        }
        
        @Override
        public boolean canDisplace(IBlockAccess world, BlockPos pos) {
                return super.canDisplace(world, pos);
        }
        
        @Override
        public boolean displaceIfPossible(World world, BlockPos pos) {
                return super.displaceIfPossible(world, pos);
        }
        
}

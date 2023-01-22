package morethanhidden.infernalnature.blocks;

import morethanhidden.infernalnature.registry.AchievementRegistry;

public class BlockLiquidMana extends BlockFluidClassic{


        public BlockLiquidMana(Fluid fluid, Material material) {
                super(fluid, material);
                setCreativeTab(infernalnature.tabinfernalnature);
                setLightLevel(0.625F);
                setUnlocalizedName("blockliquidmana");
                setRegistryName(Constants.MOD_ID, "fluid_block#mana");
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
        	if (infernalnature.ShockingLiquid = true){
        	
        	world.spawnEntity(new EntityLightningBolt(world, pos.getX(),pos.getY(),pos.getZ(), true));
        	EntityPlayer player = world.getClosestPlayer(pos.getX(),pos.getY(),pos.getZ(), 3, true);
        	
        	if (player != null){
        	player.addStat(AchievementRegistry.electrifying, 1);}
        	
        	}
        }
}

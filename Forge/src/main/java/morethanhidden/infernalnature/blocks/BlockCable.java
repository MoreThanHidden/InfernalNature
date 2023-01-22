package morethanhidden.infernalnature.blocks;

import morethanhidden.infernalnature.blocks.tiles.TileCable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.energy.IEnergyStorage;

public class BlockCable extends Block {

    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty WEST = BooleanProperty.create("west");

    public BlockCable() {
        super(Properties.of(Material.WEB));
        this.setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(DOWN, false).withProperty(NORTH, false).withProperty(SOUTH, false).withProperty(EAST, false).withProperty(WEST, false));
    }

    public String getUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }

    @Override
    public boolean isOpaqueCube(BlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){
        return state.withProperty(UP, canConnect(worldIn, pos, EnumFacing.UP))
                .withProperty(DOWN, canConnect(worldIn, pos, EnumFacing.DOWN))
                .withProperty(NORTH, canConnect(worldIn, pos, EnumFacing.NORTH))
                .withProperty(SOUTH, canConnect(worldIn, pos, EnumFacing.SOUTH))
                .withProperty(EAST, canConnect(worldIn, pos, EnumFacing.EAST))
                .withProperty(WEST, canConnect(worldIn, pos, EnumFacing.WEST));
    }

    public boolean canConnect(Level world, BlockPos pos, Direction dir){
        boolean connect = false;
        BlockEntity tile = world.getBlockEntity(pos.relative(dir));
        if (tile != null){
            if (tile instanceof IEnergyStorage){
                connect = true;
            }
        }
        return (connect);
    }

    @Override
    public BlockEntity createBlockEntity(Level worldIn) {
        return new TileCable(8192);
    }
}






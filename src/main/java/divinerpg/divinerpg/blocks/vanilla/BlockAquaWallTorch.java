package divinerpg.divinerpg.blocks.vanilla;

import divinerpg.divinerpg.blocks.base.BlockModWallTorch;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class BlockAquaWallTorch extends BlockModWallTorch implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(WATERLOGGED);
    }

    public BlockAquaWallTorch() {
        setDefaultState(getDefaultState().with(WATERLOGGED, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        boolean waterlogged = ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER;
        World world = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();

        for (Direction direction : directions) {
            if (direction.getAxis().isHorizontal()) {
                Direction opposite = direction.getOpposite();
                BlockState blockState = this.getDefaultState().with(FACING, opposite).with(WATERLOGGED, waterlogged);
                if (blockState.canPlaceAt(world, blockPos))
                    return blockState;
            }
        }
        return null;
    }

//    @Override public BlockState updateShape(BlockState state, Direction dir, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
//        if(state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
//        return super.updateShape(state, dir, state1, level, pos, pos1);
//    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();  // .getSource(false) -> .getStill(false)
    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void animateTick(BlockState state, World level, BlockPos pos, Random random) {
//        double d0 = pos.getX() + .5;
//        double d1 = pos.getY() + .7;
//        double d2 = pos.getZ() + .5;
//        double d3 = .22;
//        double d4 = .27;
//        Direction dir1 = state.getValue(FACING).getOpposite();
//        if(state.getValue(WATERLOGGED)) level.addParticle(ParticleTypes.BUBBLE, d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
//        else level.addParticle(ParticleTypes.SMOKE, d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
//        level.addParticle(ParticleRegistry.BLUE_FLAME.get(), d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
//    }
}

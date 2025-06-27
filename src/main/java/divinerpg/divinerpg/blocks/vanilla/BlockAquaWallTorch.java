package divinerpg.divinerpg.blocks.vanilla;

import divinerpg.divinerpg.blocks.base.BlockModWallTorch;
import divinerpg.divinerpg.registries.ParticleRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import javax.annotation.Nullable;

public class BlockAquaWallTorch extends BlockModWallTorch implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public BlockAquaWallTorch() {
        super();
        setDefaultState(getDefaultState().with(WATERLOGGED, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockpos = ctx.getBlockPos();
        FluidState fluidstate = ctx.getWorld().getFluidState(blockpos);
        BlockState blockstate = getDefaultState();
        World world = ctx.getWorld();
        Direction[] adirection = ctx.getPlacementDirections();
        for (Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.with(FACING, direction1).with(WATERLOGGED, fluidstate.isOf(Fluids.WATER));
                if (blockstate.canPlaceAt(world, blockpos)) return blockstate;
            }
        } return null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d0 = pos.getX() + .5;
        double d1 = pos.getY() + .7;
        double d2 = pos.getZ() + .5;
        double d3 = .22;
        double d4 = .27;
        Direction dir1 = state.get(FACING).getOpposite();
        if (state.get(WATERLOGGED)) world.addParticle(ParticleTypes.BUBBLE, d0 + d4 * dir1.getOffsetX(), d1 + d3, d2 + d4 * dir1.getOffsetZ(), 0, 0, 0);
        else world.addParticle(ParticleTypes.SMOKE, d0 + d4 * dir1.getOffsetX(), d1 + d3, d2 + d4 * dir1.getOffsetZ(), 0, 0, 0);
        world.addParticle(ParticleRegistry.BLUE_FLAME, d0 + d4 * dir1.getOffsetX(), d1 + d3, d2 + d4 * dir1.getOffsetZ(), 0, 0, 0);
    }
}
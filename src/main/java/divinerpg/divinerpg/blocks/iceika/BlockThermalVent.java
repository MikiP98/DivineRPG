package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.base.BlockMod;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import javax.annotation.Nullable;

public class BlockThermalVent extends BlockMod implements Waterloggable {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	public static final VoxelShape SHAPE = Block.createCuboidShape(2D, 0D, 2D, 14D, 14D, 14D);

	public BlockThermalVent() {
		super(Settings.copy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.STONE_GRAY).requiresTool());
		setDefaultState(getDefaultState().with(WATERLOGGED, Boolean.TRUE));
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		if (state.get(WATERLOGGED))
			world.addParticle(
					ParticleTypes.CAMPFIRE_COSY_SMOKE,
					pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5,
					0D, 0.1, 0D
			);
		else if (random.nextBoolean())
			world.addParticle(
					ParticleTypes.SMOKE,
					pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5,
					0D, 0.1, 0D
			);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		BlockPos blockpos = pos.down();
		return world.getBlockState(blockpos).isSideSolidFullSquare(world, blockpos, Direction.UP);
	}

	@Override
	@Nullable
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		FluidState fluidstate = ctx.getWorld().getFluidState(ctx.getBlockPos());
		return getDefaultState().with(WATERLOGGED, fluidstate.isIn(FluidTags.WATER) && fluidstate.getLevel() == 8);
	}

	@SuppressWarnings("deprecation")
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState getStateForNeighborUpdate(
			BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
	) {
		if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) return Blocks.AIR.getDefaultState();
		if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
	    return state;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED);
	}

	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
	}
}
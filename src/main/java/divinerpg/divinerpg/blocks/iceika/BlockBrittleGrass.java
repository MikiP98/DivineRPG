package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class BlockBrittleGrass extends PlantBlock implements AlwaysFlammable {
	public static final BooleanProperty HANGING = Properties.HANGING;
	protected static final VoxelShape
			SHAPE = Block.createCuboidShape(2, 0, 2, 14, 12, 14),
			HANGING_SHAPE = Block.createCuboidShape(2, 4, 2, 14, 16, 14);
	
	public BlockBrittleGrass(Settings settings) {
		super(settings.mapColor(MapColor.LICHEN_GREEN).sounds(BlockSoundGroup.MOSS_CARPET).dynamicBounds().offset(AbstractBlock.OffsetType.XZ));
		setDefaultState(getDefaultState().with(HANGING, false));
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(HANGING);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return state.get(HANGING) ? HANGING_SHAPE : SHAPE;
	}
	
	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
		return world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), Direction.UP)
				|| world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos.up(), Direction.DOWN);
	}
	
	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		return world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos.up(), Direction.DOWN)
				? getDefaultState().with(HANGING, true)
				: world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), Direction.UP)
						? getDefaultState()
						: Blocks.AIR.getDefaultState();
	}
	
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return canPlantOnTop(null, world, pos);
	}
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		World world = ctx.getWorld();
		BlockPos pos = ctx.getBlockPos();
		return world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos.up(), Direction.DOWN)
				? getDefaultState().with(HANGING, true)
				: world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), Direction.UP)
						? getDefaultState()
						: Blocks.AIR.getDefaultState();
	}

	@Override
	public int getFlammability() {
		return 100;
	}
	@Override
	public int getFireSpreadSpeed() {
		return 60;
	}
}
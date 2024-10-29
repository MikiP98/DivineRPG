//package divinerpg.divinerpg.blocks.iceika;
//
//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.*;
//import net.minecraft.sound.BlockSoundGroup;
//import net.minecraft.state.property.BooleanProperty;
//import net.minecraft.state.property.Properties;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.shape.VoxelShape;
//
//public class BlockBrittleGrass extends PlantBlock {
//    public static final BooleanProperty HANGING = Properties.HANGING;
//
//    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D), HANGING_SHAPE = Block.box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
//
//    public BlockBrittleGrass() {
//        super(FabricBlockSettings.copy(Blocks.SEAGRASS).mapColor(MapColor.GLOW_LICHEN).sounds(BlockSoundGroup.MOSS_CARPET).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ));
//        registerDefaultState(this.stateDefinition.any().setValue(HANGING, false));
//    }
//
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(HANGING);
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, BlockGetter p_154526_, BlockPos p_154527_, CollisionContext p_154528_) {
//        return state.getValue(HANGING) ? HANGING_SHAPE : SHAPE;
//    }
//
//    @Override
//    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
//        return getter.getBlockState(pos.down()).isFaceSturdy(getter, pos.down(), Direction.UP) || getter.getBlockState(pos.up()).isFaceSturdy(getter, pos.above(), Direction.DOWN);
//    }
//
//    @Override
//    public BlockState updateShape(BlockState state, Direction direction, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
//        return level.getBlockState(pos.up()).isFaceSturdy(level, pos.up(), Direction.DOWN) ? getDefaultState().with(HANGING, true) : level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
//    }
//
//    @Override
//    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
//        return mayPlaceOn(null, level, pos);
//    }
//
//    @Override
//    public BlockState getStateForPlacement(BlockPlaceContext context) {
//        return context.getLevel().getBlockState(context.getClickedPos().above()).isFaceSturdy(context.getLevel(), context.getClickedPos().above(), Direction.DOWN) ? defaultBlockState().setValue(HANGING, true) : context.getLevel().getBlockState(context.getClickedPos().below()).isFaceSturdy(context.getLevel(), context.getClickedPos().below(), Direction.UP) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
//    }
//
//    @Override
//    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 100;
//    }
//
//    @Override
//    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 60;
//    }
//}

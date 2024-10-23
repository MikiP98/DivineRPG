//package divinerpg.divinerpg.blocks.iceika;
//
//import divinerpg.divinerpg.blocks.base.BlockModMoss;
//
//public class BlockBrittleMoss extends BlockModMoss {
//    public BlockBrittleMoss() {
//        super(Block.Properties.copy(Blocks.MOSS_BLOCK).mapColor(MapColor.GLOW_LICHEN));
//    }
//
//    @Override
//    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
//        return level.getBlockState(pos.below()).isAir() || level.getBlockState(pos.above()).isAir();
//    }
//
//    @Override
//    public void place(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
//        if(random.nextBoolean()) pos = pos.relative(Direction.getRandom(random));
//        BlockState s = level.getBlockState(pos);
//        if(s.is(BlockTags.MOSS_REPLACEABLE) || s.is(BlockTags.SNOW)) {
//            if(s.is(BlockRegistry.brittleMoss.get())) ConfiguredFeatureKeys.getConfiguredFeature(level, ConfiguredFeatureKeys.BRITTLE_PLANTS).value().place(level, null, random, pos);
//            else level.setBlock(pos, state, 3);
//        }
//    }
//}

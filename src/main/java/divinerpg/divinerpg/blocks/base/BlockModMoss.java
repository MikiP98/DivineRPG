//package divinerpg.divinerpg.blocks.base;
//
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.MossBlock;
//import net.minecraft.registry.tag.BlockTags;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.math.random.Random;
//
//public class BlockModMoss extends MossBlock {
//    public BlockModMoss(AbstractBlock.Settings properties) {
//        super(properties);
//    }
//
//    @Override
//    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
//        return level.getBlockState(pos.below()).isAir();
//    }
//
//    @Override
//    public void performBonemeal(ServerWorld level, Random random, BlockPos pos, BlockState state) {
//        BlockState myState = this.defaultBlockState();
//        place(level, random, pos.up(), myState);
//        place(level, random, pos.down(), myState);
//        place(level, random, pos.north(), myState);
//        place(level, random, pos.east(), myState);
//        place(level, random, pos.south(), myState);
//        place(level, random, pos.west(), myState);
//    }
//
//    public void place(ServerWorld level, Random random, BlockPos pos, BlockState state) {
//        if(random.nextBoolean()) pos = pos.offset(Direction.random(random));  // .relative
//        if(level.getBlockState(pos).isIn(BlockTags.MOSS_REPLACEABLE)) level.setBlockState(pos, state, 3);
//    }
//}

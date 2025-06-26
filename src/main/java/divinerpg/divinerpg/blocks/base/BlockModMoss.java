package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.BlockState;
import net.minecraft.block.MossBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;

public class BlockModMoss extends MossBlock {
	public BlockModMoss(Settings settings) {
		super(settings);
	}
	
	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
		return world.getBlockState(pos.down()).isAir();
	}
	
	//TODO: to do it the way vanilla does that
	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		BlockState myState = this.getDefaultState();
		place(world, random, pos.up(), myState);
		place(world, random, pos.down(), myState);
		place(world, random, pos.north(), myState);
		place(world, random, pos.east(), myState);
		place(world, random, pos.south(), myState);
		place(world, random, pos.west(), myState);
	}
	
	public void place(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		if (random.nextBoolean())
			pos = pos.offset(Direction.random(random));
		if (world.getBlockState(pos).isIn(BlockTags.MOSS_REPLACEABLE))
			world.setBlockState(pos, state, 3);
	}
}
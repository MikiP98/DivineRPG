package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.registries.BlockRegistry;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BlockBuddingOlivine extends AmethystBlock {
	public BlockBuddingOlivine(Settings settings) {
		super(settings);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(5) == 0) {
			Direction direction = Direction.random(random);
			BlockPos blockpos = pos.offset(direction);
			BlockState blockstate = world.getBlockState(blockpos);
			if (canClusterGrowAtState(blockstate))
				world.setBlockState(
						blockpos,
						BlockRegistry.olivineCluster.getDefaultState()
								.with(AmethystClusterBlock.FACING, direction)
								.with(AmethystClusterBlock.WATERLOGGED, blockstate.getFluidState().isOf(Fluids.WATER))
				);
		}
	}
	
	public static boolean canClusterGrowAtState(BlockState state) {
		return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
		// TODO: I think somewhere during porting I used .getHeight() instead of .getLevel(). Need to find and correct it.
	}
}
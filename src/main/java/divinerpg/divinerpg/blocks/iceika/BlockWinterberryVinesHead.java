package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.arcana.BlockArcaniteVinesHead;
import divinerpg.divinerpg.registries.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWinterberryVinesHead extends BlockArcaniteVinesHead {
	public static final BooleanProperty RIPE = Properties.BLOOM;

	public BlockWinterberryVinesHead(Settings settings) {
		super(settings.luminance((state) -> 1).dynamicBounds());
	}

	// TODO: There is no Fabric equivalent for this method
//	@Override
//	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
//		BlockState aboveState = level.getBlockState(pos.above());
//		if (aboveState.getBlock() == BlockRegistry.winterberryVinesBody.get() && aboveState.getValue(RIPE)) {
//			popResource(level, pos.above(), new ItemStack(ItemRegistry.winterberry.get(), 1));
//		}
//		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
//	}
	// TODO: Using as a replacement for the above method; Make sure this replacement is sufficient
	@SuppressWarnings("deprecation")
	public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
		BlockState aboveState = world.getBlockState(pos.up());
		if (aboveState.getBlock() == BlockRegistry.winterberryVinesBody && aboveState.get(RIPE)) {
			Block.dropStack(world, pos.up(), new ItemStack(ItemRegistry.winterberry, 1));
		}
		super.onStateReplaced(state, world, pos, newState, moved);
	}

	@Override
	protected Block getPlant() {
		return BlockRegistry.winterberryVinesBody;
	}
}

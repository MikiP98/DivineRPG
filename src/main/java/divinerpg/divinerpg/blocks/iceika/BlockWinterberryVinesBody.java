package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import divinerpg.divinerpg.registries.BlockRegistry;
import divinerpg.divinerpg.registries.ItemRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BlockWinterberryVinesBody extends WeepingVinesPlantBlock implements Fertilizable, AlwaysFlammable {
	public static final BooleanProperty RIPE = Properties.BLOOM;

	public BlockWinterberryVinesBody(Settings settings) {
		super(settings.ticksRandomly().luminance((state) -> state.get(RIPE) ? 5 : 1).dynamicBounds());
		setDefaultState(getDefaultState().with(RIPE, false));
	}

	@Override
	protected AbstractPlantStemBlock getStem() {
		return (AbstractPlantStemBlock) BlockRegistry.winterberryVinesHead;
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return !state.get(RIPE);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextFloat() < 0.11F) world.setBlockState(pos, state.with(RIPE, true), 3);
	}

	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		world.setBlockState(pos, state.with(RIPE, true), 2);
	}

	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
		return !state.get(RIPE) || super.isFertilizable(world, pos, state, isClient);
	}

	// TODO: There is no Fabric equivalent for this method
//	@Override
//	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
//		BlockState aboveState = level.getBlockState(pos.up());
//		if (aboveState.getBlock() == BlockRegistry.winterberryVinesBody.get() && aboveState.get(RIPE)) {
//			Block.dropStack(level, pos.up(), new ItemStack(ItemRegistry.winterberry, 1));
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

	@SuppressWarnings("deprecation")
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!player.getStackInHand(hand).isEmpty()) return super.onUse(state, world, pos, player, hand, hit);

		if (state.get(RIPE)) {
			Block.dropStack(world, pos, new ItemStack(ItemRegistry.winterberry, 1));
			world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
			world.setBlockState(pos, state.with(RIPE, false), 2);
			return ActionResult.SUCCESS;
		}
		return ActionResult.PASS;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(RIPE);
	}

	@Override
	public int getFlammability() {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed() {
		return 15;
	}
}

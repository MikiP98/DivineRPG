package divinerpg.divinerpg.blocks.iceika;

//import static net.minecraft.world.level.material.MapColor.CRIMSON_STEM;

import divinerpg.divinerpg.blocks.base.BlockModLeaves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCozybarkLeaves extends BlockModLeaves {
	public static final BooleanProperty SNOWY = Properties.SNOWY;

	public BlockCozybarkLeaves() {
		super(MapColor.DULL_PINK, BlockSoundGroup.CHERRY_LEAVES);
		setDefaultState(getDefaultState().with(DISTANCE, 1).with(PERSISTENT, false).with(WATERLOGGED, false).with(SNOWY, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(DISTANCE, PERSISTENT, WATERLOGGED, SNOWY);
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack stack = player.getStackInHand(hand);
		if (stack.isEmpty()) return super.onUse(state, world, pos, player, hand, hit);

		//TODO: Using water & powder snow buckets doesn't count towards statistics + interactions with buckets is annoyingly different
		if (stack.isOf(Items.BUCKET) && (state.get(SNOWY) || state.get(WATERLOGGED))) {
			if (world.isClient()) {
				if (state.get(SNOWY)) player.playSound(SoundEvents.ITEM_BUCKET_FILL_POWDER_SNOW, 1.0F, 1.0F);
				else player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
			} else {
				if (!player.isCreative()) {
					if (state.get(SNOWY)) player.getInventory().offerOrDrop(new ItemStack(Items.POWDER_SNOW_BUCKET));
					else player.getInventory().offerOrDrop(new ItemStack(Items.WATER_BUCKET));
					stack.decrement(1);
				}
				world.setBlockState(pos, state.with(SNOWY, false).with(WATERLOGGED, false), 3);
			}
			return ActionResult.SUCCESS;
		} else if(stack.isOf(Items.POWDER_SNOW_BUCKET) && !state.get(SNOWY) && !state.get(WATERLOGGED)) {
			if(world.isClient()) player.playSound(SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, 1.0F, 1.0F);
			else {
				if (!player.isCreative()) {
					player.getInventory().offerOrDrop(new ItemStack(Items.BUCKET));
					stack.decrement(1);
				}
				world.setBlockState(pos, state.with(SNOWY, true), 3);
			}
			return ActionResult.SUCCESS;
		} else if(stack.isOf(Items.WATER_BUCKET) && !state.get(WATERLOGGED)) {
			if(world.isClient()) player.playSound(SoundEvents.ITEM_BUCKET_EMPTY, 1.0F, 1.0F);
			else {
				if(!player.isCreative()) {
					player.getInventory().offerOrDrop(new ItemStack(Items.BUCKET));
					stack.decrement(1);
				}
				world.setBlockState(pos, state.with(WATERLOGGED, true), 3);
			}
			return ActionResult.SUCCESS;
		}
		return super.onUse(state, world, pos, player, hand, hit);
	}
}
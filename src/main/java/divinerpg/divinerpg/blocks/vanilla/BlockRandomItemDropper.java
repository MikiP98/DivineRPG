package divinerpg.divinerpg.blocks.vanilla;

import java.util.Set;

import divinerpg.divinerpg.blocks.base.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class BlockRandomItemDropper extends BlockMod {
	public static final DirectionProperty FACING = Properties.FACING;
	public static final BooleanProperty TRIGGERED = Properties.TRIGGERED;

	public BlockRandomItemDropper() {
		super(Settings.copy(Blocks.DROPPER));
		setDefaultState(getDefaultState().with(FACING, Direction.NORTH).with(TRIGGERED, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING, TRIGGERED);
	}

	@Override
	public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
		return getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, BlockMirror mirror) {
		return rotate(state, mirror.getRotation(state.get(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
		if(!world.isClient()) {
			boolean hasSignal = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.up());
			boolean triggered = state.get(TRIGGERED);

			if (triggered && !hasSignal) world.setBlockState(pos, state.with(TRIGGERED, false), 4);
			else if (hasSignal && !triggered) {
				world.setBlockState(pos, state.with(TRIGGERED, true), 4);
				Set<Identifier> keys = Registries.ITEM.getIds();
				Direction dir = state.get(FACING);
				ItemEntity i = new ItemEntity(world, pos.getX() + dir.getOffsetX() + .5, pos.getY() + dir.getOffsetY(), pos.getZ() + dir.getOffsetZ() + .5, new ItemStack(Registries.ITEM.get((Identifier) keys.toArray()[world.random.nextInt(keys.size())])));
				i.addVelocity(dir.getOffsetX() * .5, dir.getOffsetY() * .5, dir.getOffsetZ() * .5);
				world.spawnEntity(i);
				world.playSound(null, pos, SoundEvents.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS);
			}
		}
	}
}
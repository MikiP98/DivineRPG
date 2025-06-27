package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.registries.*;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import org.jetbrains.annotations.NotNull;

public class BlockIcyFire extends AbstractFireBlock {
	public BlockIcyFire(Settings settings) { super(settings.luminance((state) -> 7), 1); }

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (!entity.isAlive()) return;
		if (entity.isOnFire()) entity.extinguishWithSound();
		if (entity.canFreeze() && !entity.isInLava()) {
			entity.setFrozenTicks(entity.getFrozenTicks() + 4);
			if (entity.age % 15 == 0) {
				entity.damage(world.getDamageSources().freeze(), 1);
				if (!entity.isAlive()) world.playSound(null, pos, SoundRegistry.FREEZE, SoundCategory.BLOCKS, .8F, 1.5F);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState getStateForNeighborUpdate(
			BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
	) {
		return isFlammable(world.getBlockState(pos.down())) ? getDefaultState() : Blocks.AIR.getDefaultState();
	}

	@Override
	public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) { return getDefaultState(); }

	@SuppressWarnings("deprecation")
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return isFlammable(world.getBlockState(pos.down()));
	}

	@Override
	protected boolean isFlammable(BlockState state) {
		return state.isIn(BlockTags.SNOW) || state.isIn(BlockTags.ICE);
	}
}
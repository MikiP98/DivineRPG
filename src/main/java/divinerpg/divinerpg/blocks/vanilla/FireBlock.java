package divinerpg.divinerpg.blocks.vanilla;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.NotNull;

// TODO: Rename to ModFireBlock in order to not clash with vanilla FireBlock
public class FireBlock extends AbstractFireBlock {
	public FireBlock() {
		super(Settings.copy(Blocks.FIRE).mapColor(MapColor.BRIGHT_RED), 8);
	}
	public FireBlock(Settings settings) {
		super(settings, 8);
	}
	public FireBlock(float fireDamage) {
		super(Settings.copy(Blocks.FIRE).mapColor(MapColor.BRIGHT_RED), fireDamage);
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		super.onEntityCollision(state, world, pos, entity);
		if (!entity.isAlive()) world.playSound(entity, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.NEUTRAL, .6F, 1.3F);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		super.randomDisplayTick(state, world, pos, random);
		if ((world.getTime() & 0b11) == 0) world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 0D, .04, 0D);
	}

	@Override
	public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
		return getDefaultState();
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState getStateForNeighborUpdate(
			BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
	) {
		BlockPos po = pos.down();
		BlockState st = world.getBlockState(po);
		return !st.isAir() && st.isSideSolidFullSquare(world, po, Direction.UP) ? getDefaultState() : Blocks.AIR.getDefaultState();
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		BlockPos p = pos.down();
		BlockState s = world.getBlockState(p);
		return !s.isAir() && s.isSideSolidFullSquare(world, p, Direction.UP);
	}

	@Override
	protected boolean isFlammable(BlockState state) {
		return !state.isAir();
	}
}
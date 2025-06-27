package divinerpg.divinerpg.blocks.vanilla;

import java.util.Optional;
import divinerpg.divinerpg.blocks.base.BlockMod;
import divinerpg.divinerpg.registries.BlockRegistry;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHellfireSponge extends BlockMod {
	public BlockHellfireSponge() {
		super(Settings.copy(Blocks.SPONGE).mapColor(MapColor.BRIGHT_RED));
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (tryRemoveWater(world, pos.up(), 64)
				| tryRemoveWater(world, pos.down(), 64)
				| tryRemoveWater(world, pos.north(), 64)
				| tryRemoveWater(world, pos.south(), 64)
				| tryRemoveWater(world, pos.east(), 64)
				| tryRemoveWater(world, pos.west(), 64)
		) {
			world.setBlockState(pos, BlockRegistry.coldHellfireSponge.getDefaultState(), 3);
			world.playSoundAtBlockCenter(pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1F, 1F, false);
		}
	}
	
	protected boolean tryRemoveWater(World world, BlockPos pos, int distance) {
		if (distance > 0) {
			distance--;
			boolean b = false;
			BlockState state = world.getBlockState(pos);
			if (state.isOf(Blocks.WATER) || state.isOf(Blocks.BUBBLE_COLUMN) || state.isOf(Blocks.SEAGRASS) || state.isOf(Blocks.TALL_SEAGRASS)) {
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
				b = true;
			} else if (state.isOf(Blocks.KELP) || state.isOf(Blocks.KELP_PLANT)) {
				// TODO: There is no Fabric equivalent for onDestroyedByPlayer
//				state.onDestroyedByPlayer(world, pos, null, true, world.getFluidState(pos));
				// TODO: This is a replacement for the above line; Make sure it works as intended
				world.breakBlock(pos, true, null);
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
				b = true;
			} else {
				Optional<Boolean> o = state.getOrEmpty(Properties.WATERLOGGED);
				if(o.isPresent() && o.get()) {
					world.setBlockState(pos, state.with(Properties.WATERLOGGED, false), 3);
					b = true;
				}
			}
			if (b) {
				world.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, 0.1, 0);
				tryRemoveWater(world, pos.up(), distance);
				tryRemoveWater(world, pos.down(), distance);
				tryRemoveWater(world, pos.north(), distance);
				tryRemoveWater(world, pos.south(), distance);
				tryRemoveWater(world, pos.east(), distance);
				tryRemoveWater(world, pos.west(), distance);
			}
			return b;
		} return false;
	}
}

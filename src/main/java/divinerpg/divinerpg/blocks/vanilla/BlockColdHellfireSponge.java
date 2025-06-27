package divinerpg.divinerpg.blocks.vanilla;

import divinerpg.divinerpg.blocks.base.BlockMod;
import divinerpg.divinerpg.registries.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockColdHellfireSponge extends BlockMod {
	public BlockColdHellfireSponge() {
		super(Settings.copy(Blocks.WET_SPONGE).mapColor(MapColor.RED));
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (world.getDimension().ultrawarm()) {
			world.setBlockState(pos, BlockRegistry.hellfireSponge.getDefaultState(), 3);
			world.playSoundAtBlockCenter(pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1F, 1F, false);
		}
	}
}

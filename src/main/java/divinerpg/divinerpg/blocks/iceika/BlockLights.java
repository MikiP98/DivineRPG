package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockModLadder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.SoundType.WOOD;

public class BlockLights extends BlockModLadder {
    public BlockLights() {super(WOOD);}
    @Override public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {return 15;}
}
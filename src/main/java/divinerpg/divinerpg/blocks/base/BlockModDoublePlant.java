package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.TALL_GRASS;

public class BlockModDoublePlant extends DoublePlantBlock {
    public BlockModDoublePlant(MapColor color, SoundType sound) {super(Properties.ofFullCopy(TALL_GRASS).mapColor(color).sound(sound));}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
}
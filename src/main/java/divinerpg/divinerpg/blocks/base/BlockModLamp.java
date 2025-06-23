package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(MapColor color) {
        super(color, 5, 6, SoundType.LANTERN, NoteBlockInstrument.HARP);
    }
    public BlockModLamp(MapColor color, SoundType sound) {
        super(color, .3F, .3F, sound, NoteBlockInstrument.HAT);
    }
    @Override public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {return 15;}
}
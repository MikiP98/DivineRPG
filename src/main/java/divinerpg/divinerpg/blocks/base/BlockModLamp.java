package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(MapColor color) {
        super(color, 5, 6, BlockSoundGroup.LANTERN, Instrument.HARP, 15);
    }
    public BlockModLamp(MapColor color, BlockSoundGroup sound) {
        super(color, .3F, .3F, sound, Instrument.HAT, 15);
    }
}
package divinerpg.divinerpg.blocks.vethea;

import divinerpg.divinerpg.blocks.base.BlockMod;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(MapColor color) {
        super(Settings.create().mapColor(color).strength(0.3F).sounds(BlockSoundGroup.GLASS).instrument(Instrument.PLING).luminance((state) -> 15));
    }
}

package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(MapColor color) {
        super(FabricBlockSettings.create().mapColor(color).requiresTool().strength(5F, 6F).sounds(BlockSoundGroup.LANTERN).luminance(15));
    }

    public BlockModLamp(MapColor color, BlockSoundGroup sound) {
        super(FabricBlockSettings.create().mapColor(color).strength(0.3F).sounds(sound).instrument(Instrument.HAT).luminance(15));
    }
}

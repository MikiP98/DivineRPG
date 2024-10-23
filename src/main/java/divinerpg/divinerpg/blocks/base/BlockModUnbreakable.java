package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModUnbreakable extends BlockMod {
    public BlockModUnbreakable(Settings properties) {super(properties);}
    public BlockModUnbreakable(MapColor color, boolean isLamp) {
        super(FabricBlockSettings.create().mapColor(color).strength(-1, 3600000).dropsNothing().sounds(BlockSoundGroup.GLASS).instrument(Instrument.HAT).luminance(15));  // lightLevel((p_235464_0_) -> 15)
    }
    public BlockModUnbreakable(MapColor color) {
        super(FabricBlockSettings.create().mapColor(color).strength(-1, 3600000).dropsNothing().sounds(BlockSoundGroup.STONE).instrument(Instrument.BASEDRUM));}
}

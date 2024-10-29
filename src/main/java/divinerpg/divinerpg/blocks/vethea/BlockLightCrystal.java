package divinerpg.divinerpg.blocks.vethea;

import divinerpg.divinerpg.blocks.base.BlockMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(MapColor color) {
        super(FabricBlockSettings.create().mapColor(color).strength(0.3F).sounds(BlockSoundGroup.GLASS).instrument(Instrument.PLING).luminance(15));  // .lightLevel((state) -> 15)
    }
}

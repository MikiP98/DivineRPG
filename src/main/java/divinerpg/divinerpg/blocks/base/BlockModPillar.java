package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModPillar extends PillarBlock {
    public BlockModPillar(MapColor color, float hardness, float resistance, BlockSoundGroup sound) {
        super(FabricBlockSettings.create().mapColor(color).requiresTool().strength(hardness, resistance).sounds(sound));
    }
}

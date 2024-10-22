package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(MapColor color) { super(FabricBlockSettings.create().mapColor(color).strength(.5F).sounds(BlockSoundGroup.ROOTED_DIRT)); }
}

package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;

public class BlockModStem extends PillarBlock {
    public BlockModStem(MapColor color) {
        super(Settings.copy(Blocks.MUSHROOM_STEM).mapColor(color));
    }
}
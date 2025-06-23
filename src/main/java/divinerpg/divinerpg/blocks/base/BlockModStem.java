package divinerpg.blocks.base;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.MUSHROOM_STEM;

public class BlockModStem extends RotatedPillarBlock {
    public BlockModStem(MapColor color) {super(Properties.ofFullCopy(MUSHROOM_STEM).mapColor(color));}
}
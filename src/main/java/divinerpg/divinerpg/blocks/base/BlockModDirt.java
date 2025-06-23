package divinerpg.blocks.base;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.DIRT;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(MapColor color) {super(Properties.ofFullCopy(DIRT).mapColor(color).sound(SoundType.ROOTED_DIRT));}
}
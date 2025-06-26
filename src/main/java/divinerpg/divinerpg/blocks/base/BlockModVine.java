package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.VineBlock;

public class BlockModVine extends VineBlock implements AlwaysFlammable {
    public BlockModVine(MapColor color) { super(Settings.copy(Blocks.VINE).mapColor(color)); }

    @Override public int getFlammability() { return 100; }
    @Override public int getFireSpreadSpeed() { return 15; }
}
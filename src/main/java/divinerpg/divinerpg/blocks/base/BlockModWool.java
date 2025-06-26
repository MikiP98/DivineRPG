package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;

public class BlockModWool extends Block implements AlwaysFlammable {
    public BlockModWool(MapColor color) {
        super(Settings.copy(Blocks.WHITE_WOOL).mapColor(color));
    }

    @Override public int getFlammability() { return 60; }
    @Override public int getFireSpreadSpeed() { return 30; }
}
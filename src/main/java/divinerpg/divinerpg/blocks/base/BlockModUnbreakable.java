package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;

public class BlockModUnbreakable extends BlockMod {
    //Unbreakable stone-like blocks
    public BlockModUnbreakable(MapColor color) { super(color, -1, 3600000); }
    //Unbreakable stone-like blocks with custom properties
    public BlockModUnbreakable(Settings settings) { super(settings.strength(-1, 3600000)); }
    //Unbreakable lantern-like blocks
    public BlockModUnbreakable(MapColor color, int lightLevel) {
        this(Block.Settings.copy(Blocks.SEA_LANTERN).mapColor(color).luminance((state) -> lightLevel));
    }
}
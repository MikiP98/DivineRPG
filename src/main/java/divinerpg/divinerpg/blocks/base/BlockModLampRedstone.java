package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;

public class BlockModLampRedstone extends BlockModPowered {
    public BlockModLampRedstone() {
        super(Settings.copy(Blocks.REDSTONE_LAMP).mapColor(MapColor.GREEN).luminance((state) -> state.get(POWERED) ? 15 : 0));
    }
}
package divinerpg.blocks.base;

import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.REDSTONE_LAMP;

public class BlockModLampRedstone extends BlockModPowered {
    public BlockModLampRedstone() {
        super(Properties.ofFullCopy(REDSTONE_LAMP).mapColor(MapColor.COLOR_GREEN)
                .lightLevel((state) -> state.getValue(POWERED) ? 15 : 0));
    }
}
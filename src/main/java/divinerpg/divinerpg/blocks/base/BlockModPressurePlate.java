package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModPressurePlate extends PressurePlateBlock {
    public BlockModPressurePlate(MapColor color, BlockSetType type) {
        super(ActivationRule.EVERYTHING, Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(color), type);
    }
    public BlockModPressurePlate(Block copy, MapColor color, BlockSetType type) {
        super(ActivationRule.EVERYTHING, Settings.copy(copy).mapColor(color).requiresTool(), type);
    }
    // TODO: Make sure 'ActivationRule.EVERYTHING' is the correct rule for this block.
}
package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;

public class BlockModPressurePlate extends PressurePlateBlock {
    public BlockModPressurePlate(MapColor color, BlockSetType type) {
        super(ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(color), type);
    }
    public BlockModPressurePlate(Block copy, MapColor color, BlockSetType type) {
        super(ActivationRule.EVERYTHING, FabricBlockSettings.copy(copy).mapColor(color).requiresTool(), type);
    }
}

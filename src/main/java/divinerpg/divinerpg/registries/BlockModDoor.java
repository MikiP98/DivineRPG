package divinerpg.divinerpg.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.MapColor;

public class BlockModDoor extends DoorBlock {

    public BlockModDoor(MapColor color, BlockSetType type) {
        super(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(color), type);
    }
    public BlockModDoor(MapColor color) {
        super(FabricBlockSettings.copy(Blocks.IRON_DOOR).mapColor(color), BlockSetType.STONE);
    }
}

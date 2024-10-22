package divinerpg.divinerpg.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.TrapdoorBlock;

public class BlockModTrapdoor extends TrapdoorBlock {
    public BlockModTrapdoor(MapColor color, BlockSetType type) {
        super(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(color), type);
    }
}

package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;

public class BlockModWall extends WallBlock {
    public BlockModWall(Block base) {super(FabricBlockSettings.copy(base));}
}

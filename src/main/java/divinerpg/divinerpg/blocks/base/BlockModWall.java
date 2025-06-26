package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;

public class BlockModWall extends WallBlock {
    public BlockModWall(Block base) { super(Settings.copy(base)); }
}
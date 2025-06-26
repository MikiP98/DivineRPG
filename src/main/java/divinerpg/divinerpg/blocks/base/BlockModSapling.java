package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;

public class BlockModSapling extends SaplingBlock {
    public BlockModSapling(MapColor color, SaplingGenerator tree) {
        super(tree, Settings.copy(Blocks.OAK_SAPLING).mapColor(color));
    }
}
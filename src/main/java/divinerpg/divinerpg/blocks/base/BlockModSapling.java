package divinerpg.blocks.base;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.OAK_SAPLING;

public class BlockModSapling extends SaplingBlock {
    public BlockModSapling(MapColor color, TreeGrower tree) {
        super(tree, Properties.ofFullCopy(OAK_SAPLING).mapColor(color));
    }
}
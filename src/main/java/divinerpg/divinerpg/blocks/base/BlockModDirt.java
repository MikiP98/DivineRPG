package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(MapColor color) {
        super(Block.Settings.copy(Blocks.DIRT).mapColor(color).sounds(BlockSoundGroup.ROOTED_DIRT));
    }
}
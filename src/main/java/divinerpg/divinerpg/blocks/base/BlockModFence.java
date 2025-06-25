package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModFence extends FenceBlock implements AlwaysFlammable {
    public BlockModFence(MapColor color, BlockSoundGroup sound) {
        super(Block.Settings.copy(Blocks.OAK_FENCE).mapColor(color).sounds(sound));
    }

    @Override
    public int getFlammability() { return 20; }
    @Override
    public int getFireSpreadSpeed() { return 5; }
}
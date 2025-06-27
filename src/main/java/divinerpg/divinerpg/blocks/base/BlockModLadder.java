package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder(BlockSoundGroup sound, int luminance) {
        super(Settings.copy(Blocks.LADDER).sounds(sound).luminance((state) -> luminance));
    }
    public BlockModLadder(BlockSoundGroup sound) { super(Settings.copy(Blocks.LADDER).sounds(sound)); }
    public BlockModLadder() { this(BlockSoundGroup.LADDER); }
}
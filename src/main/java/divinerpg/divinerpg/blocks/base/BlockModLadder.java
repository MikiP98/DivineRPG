package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder(SoundType sound) {super(Properties.ofFullCopy(Blocks.LADDER).sound(sound));}
    public BlockModLadder() {this(SoundType.LADDER);}
}
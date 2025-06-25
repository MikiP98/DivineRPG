package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModLeaves extends LeavesBlock implements AlwaysFlammable {
    public BlockModLeaves(MapColor color, BlockSoundGroup sound) {
        super(Settings.copy(Blocks.OAK_LEAVES).mapColor(color).sounds(sound));
    }

    @Override
    public int getFlammability() {return 60;}
    @Override
    public int getFireSpreadSpeed() {return 30;}
}
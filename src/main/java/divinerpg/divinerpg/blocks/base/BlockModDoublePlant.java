package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModDoublePlant extends TallPlantBlock implements AlwaysFlammable {
    public BlockModDoublePlant(MapColor color, BlockSoundGroup sound) {super(Block.Settings.copy(Blocks.TALL_GRASS).mapColor(color).sounds(sound));}

    @Override
    public int getFlammability() {return 100;}
    @Override
    public int getFireSpreadSpeed() {return 60;}
}
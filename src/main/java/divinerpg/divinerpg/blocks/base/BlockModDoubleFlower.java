package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.TallFlowerBlock;

public class BlockModDoubleFlower extends TallFlowerBlock implements AlwaysFlammable {
    public BlockModDoubleFlower(MapColor color) {super(Block.Settings.copy(Blocks.ROSE_BUSH).mapColor(color));}

    @Override
    public int getFlammability() {return 100;}
    @Override
    public int getFireSpreadSpeed() {return 60;}
}
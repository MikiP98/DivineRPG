package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;

public class BlockModButton extends ButtonBlock {
    // TODO: Make sure wooden=true is correct
    public BlockModButton(BlockSetType type) {super(Block.Settings.copy(Blocks.OAK_BUTTON), type, 30, true);}
    public BlockModButton() {super(Block.Settings.copy(Blocks.STONE_BUTTON), BlockSetType.STONE, 20, false);}
}
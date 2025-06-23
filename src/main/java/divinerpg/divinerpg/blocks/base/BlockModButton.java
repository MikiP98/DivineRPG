package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import static net.minecraft.world.level.block.state.properties.BlockSetType.STONE;

public class BlockModButton extends ButtonBlock {
    public BlockModButton(BlockSetType type) {super(type, 30, Properties.ofFullCopy(Blocks.OAK_BUTTON));}
    public BlockModButton() {super(STONE, 20, Properties.ofFullCopy(Blocks.STONE_BUTTON));}
}
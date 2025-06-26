package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.TrapdoorBlock;

public class BlockModTrapdoor extends TrapdoorBlock {
	public BlockModTrapdoor(MapColor color, BlockSetType type) {
		super(Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(color), type);
	}
}
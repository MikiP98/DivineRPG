package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModDoor extends DoorBlock {
	public BlockModDoor(MapColor color, BlockSetType type) {
		super(Block.Settings.copy(Blocks.OAK_DOOR).mapColor(color), type);
	}
	public BlockModDoor(MapColor color) {
		super(Block.Settings.copy(Blocks.IRON_DOOR).mapColor(color), BlockSetType.STONE);
	}
}
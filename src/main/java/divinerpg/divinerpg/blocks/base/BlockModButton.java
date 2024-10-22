package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;

public class BlockModButton extends ButtonBlock {
    public BlockModButton(BlockSetType type) {
        super(FabricBlockSettings.copy(Blocks.OAK_BUTTON), type, 30, true);
    }
}

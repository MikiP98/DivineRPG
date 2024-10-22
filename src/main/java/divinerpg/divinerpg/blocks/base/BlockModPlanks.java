package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModPlanks extends BlockMod {
    public BlockModPlanks(MapColor color, BlockSoundGroup sound) {
        super(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(color).sounds(sound));
        flammability = 20;
        fireSpread = 5;
    }
}

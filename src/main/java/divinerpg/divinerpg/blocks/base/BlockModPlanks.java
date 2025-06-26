package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModPlanks extends BlockMod implements AlwaysFlammable {
    public BlockModPlanks(MapColor color, BlockSoundGroup sound) {
        super(Settings.copy(Blocks.OAK_PLANKS).mapColor(color).sounds(sound));
    }

    @Override
    public int getFlammability() { return 20; }
    @Override
    public int getFireSpreadSpeed() { return 5; }
}
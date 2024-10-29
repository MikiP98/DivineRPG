package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModFence extends FenceBlock {
    public int flammability, fireSpread;

    public BlockModFence(MapColor color, BlockSoundGroup sound) {
        super(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(color).sounds(sound));
        flammability = 20;
        fireSpread = 5;
    }

    // Done in the registry
//    @Override
//    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 20;
//    }
//
//    @Override
//    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 5;
//    }
}

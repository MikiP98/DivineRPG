package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;

public class BlockModGate extends FenceGateBlock {
    public int flammability, fireSpread;

    public BlockModGate(MapColor color, WoodType type) {
        super(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(color), type);
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

package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;

public class BlockModSlab extends SlabBlock {
//    private int flammability, fireSpread;
    public int flammability, fireSpread;

    public BlockModSlab(Block base) {
        super(FabricBlockSettings.copy(base));
        if(base instanceof BlockModPlanks) {
            flammability = 20;
            fireSpread = 5;
        }
    }

    // Done in the registry
//    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return flammability;}
//    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return fireSpread;}
}

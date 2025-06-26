package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;

public class BlockModStairs extends StairsBlock implements AlwaysFlammable {
    private int flammability, fireSpread;

    public BlockModStairs(Block base) {
        super(base.getDefaultState(), Settings.copy(base));
        if(base instanceof BlockModPlanks) {
            flammability = 20;
            fireSpread = 5;
        }
    }

    @Override
    public int getFlammability() { return flammability; }
    @Override
    public int getFireSpreadSpeed() { return fireSpread; }
}
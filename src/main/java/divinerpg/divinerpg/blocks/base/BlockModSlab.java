package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;

public class BlockModSlab extends SlabBlock implements AlwaysFlammable {
    private int flammability, fireSpread;

    public BlockModSlab(Block base) {
        super(Settings.copy(base));
        if (base instanceof BlockModPlanks) {
            flammability = 20;
            fireSpread = 5;
        }
    }

    @Override
    public int getFlammability() { return flammability; }
    @Override
    public int getFireSpreadSpeed() { return fireSpread; }
}
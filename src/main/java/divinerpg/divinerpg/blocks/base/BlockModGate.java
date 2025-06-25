package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.*;

public class BlockModGate extends FenceGateBlock implements AlwaysFlammable {
    public BlockModGate(MapColor color, WoodType type) {super(Block.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(color), type);}

    @Override
    public int getFlammability() { return 20; }
    @Override
    public int getFireSpreadSpeed() { return 5; }
}
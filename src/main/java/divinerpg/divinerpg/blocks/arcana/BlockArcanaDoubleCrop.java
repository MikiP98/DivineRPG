package divinerpg.divinerpg.blocks.arcana;

import divinerpg.divinerpg.blocks.base.BlockModDoubleCrop;
import divinerpg.divinerpg.util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import static divinerpg.divinerpg.registries.BlockRegistry.arcaniteGrass;

public class BlockArcanaDoubleCrop extends BlockModDoubleCrop {
    public BlockArcanaDoubleCrop(ItemConvertible seed) {super(seed);}

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.down());
        return canPlaceFits(world, pos)
                && (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos))
                && ((belowState.getBlock() == arcaniteGrass && Utils.bordersTar(world, pos.getX(), pos.getY() - 1, pos.getZ()))
                || belowState.isOf(this)
                && belowState.get(AGE) == 14);
    }
}
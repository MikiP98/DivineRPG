package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge() {
        super(Block.Settings.copy(Blocks.REDSTONE_LAMP).nonOpaque().luminance((state) -> state.get(POWERED) ? 15 : 0));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return state.get(POWERED) ? super.getOutlineShape(state, view, pos, context) : VoxelShapes.empty();
    }
}
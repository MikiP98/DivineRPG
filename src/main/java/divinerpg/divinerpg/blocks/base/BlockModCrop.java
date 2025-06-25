package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BlockModCrop extends CropBlock {
    private final ItemConvertible seed;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            createCuboidShape(0, 0, 0, 16, 3, 16),
            createCuboidShape(0, 0, 0, 16, 6, 16),
            createCuboidShape(0, 0, 0, 16, 9, 16),
            createCuboidShape(0, 0, 0, 16, 11, 16),
            createCuboidShape(0, 0, 0, 16, 11, 16),
            createCuboidShape(0, 0, 0, 16, 11, 16),
            createCuboidShape(0, 0, 0, 16, 11, 16),
            createCuboidShape(0, 0, 0, 16, 11, 16)
    };

    public BlockModCrop(ItemConvertible seed) {
        super(Block.Settings.copy(Blocks.WHEAT));
        this.seed = seed;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(getAgeProperty())];
    }

    @Override
    protected ItemConvertible getSeedsItem() { return seed; }
}
package divinerpg.divinerpg.blocks.arcana;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import divinerpg.divinerpg.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.WeepingVinesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BlockArcaniteVinesHead extends WeepingVinesBlock implements AlwaysFlammable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public BlockArcaniteVinesHead(Settings settings) {
        super(settings);
    }

    @Override
    protected Block getPlant() {
        return BlockRegistry.arcaniteVinesBody;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return state.isAir();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public int getFlammability() {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed() {
        return 15;
    }
}

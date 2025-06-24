package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

// TODO: Reimplement IShearable logic
public class BlockModGrass extends PlantBlock implements AlwaysFlammable {
    private final boolean canGrowOnSand;

    public BlockModGrass(MapColor color, boolean canGrowOnSand) {
        super(Block.Settings.copy(Blocks.GRASS).mapColor(color).sounds(BlockSoundGroup.CROP).offset(OffsetType.XZ));
        this.canGrowOnSand = canGrowOnSand;
    }
    public BlockModGrass(MapColor color) {this(color, false);}

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return canGrowOnSand ? super.canPlaceAt(state, world, pos) || state.isIn(BlockTags.SAND) : super.canPlaceAt(state, world, pos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return createCuboidShape(2, 0, 2, 14, 13, 14);
    }

    @Override
    public int getFlammability() { return 100; }
    @Override
    public int getFireSpreadSpeed() { return 60; }
}
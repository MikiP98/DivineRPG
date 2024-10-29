package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlockModSapling extends SaplingBlock {
    private final Block grassSupplier;
    private final Block dirtSupplier;

    public BlockModSapling(MapColor color, Block grassSupplier, Block dirtSupplier, SaplingGenerator tree) {
        super(tree, FabricBlockSettings.create().mapColor(color).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        this.grassSupplier = grassSupplier;
        this.dirtSupplier = dirtSupplier;
    }

//    @Override
//    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
//        BlockState soil = worldIn.getBlockState(pos.down());
//        return super.canSurvive(state, worldIn, pos) || soil.getBlock() == grassSupplier || soil.getBlock() == dirtSupplier;
//    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        BlockState soil = world.getBlockState(pos.down());
        return super.canPlantOnTop(floor, world, pos) || soil.getBlock() == grassSupplier || soil.getBlock() == dirtSupplier;
    }
}

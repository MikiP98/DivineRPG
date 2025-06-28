package divinerpg.divinerpg.blocks.arcana;

import divinerpg.divinerpg.blocks.base.BlockMod;
import divinerpg.divinerpg.registries.SoundRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockElevantium extends BlockMod {
    protected static final VoxelShape ELEVANTIUM = VoxelShapes.union(
            createCuboidShape(1, 0, 1, 15, 1, 15),
            createCuboidShape(4.5, 1, 4.5, 11.5, 2, 11.5)
    );

    public BlockElevantium() {
        super(Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LIGHT_BLUE).pistonBehavior(PistonBehavior.DESTROY));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        int signal = world.getReceivedRedstonePower(pos);
        if (signal > 0) {
            entity.addVelocity(0, signal * .25, 0);
            world.playSound(null, pos, SoundRegistry.CONSTRUCTOR_PUNCH, SoundCategory.BLOCKS, .75F, .9F);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return ELEVANTIUM;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(ELEVANTIUM.getBoundingBox().expand(.0625, .125, .0625));
    }

    // TODO: There is no Fabric equivalent for this method.
    //  Find an alternative or ignore it.
//    @Override
//    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
//        return true;
//    }
}
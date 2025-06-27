package divinerpg.divinerpg.blocks.vethea;

import divinerpg.divinerpg.blocks.base.BlockMod;
import divinerpg.divinerpg.registries.DamageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class BlockAcid extends BlockMod {
    public BlockAcid() {
        // TODO: Replace 'BlockSoundGroup.SNOW' with 'BlockSoundGroup.WET_SPONGE' on 1.21+.
        super(Settings.copy(Blocks.SNOW).sounds(BlockSoundGroup.SNOW).blockVision((a, b, c) -> false).noCollision());
        // TODO: Doesn't 'blockVision((a, b, c) -> false)' and `nonOpaque()` do the same thing?
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0, 0, 0, 16, 2, 16);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) world.removeBlock(pos, true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity && entity.isOnGround()) entity.damage(world.getDamageSources().create(DamageRegistry.ACID), 3);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockstate = world.getBlockState(pos.down());
        return blockstate.isIn(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON) || Block.isFaceFullSquare(blockstate.getCollisionShape(world, pos.down()), Direction.UP);
    }
}
package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalFluidTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BlockModDoubleCrop extends SugarCaneBlock {
    private final ItemConvertible seed;

    public BlockModDoubleCrop(int lightLevel, ItemConvertible seed) {
        super(Block.Settings.copy(Blocks.WHEAT).luminance((state) -> lightLevel));
        this.seed = seed;
    }
    public BlockModDoubleCrop(ItemConvertible seed) { this(0, seed); }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(world.isAir(pos.up())) {
            int i = 1;
            while (world.getBlockState(pos.down(i)).isOf(this)) { ++i; }

            if (i < 3) {
                int j = state.get(AGE);
                if (j == 15) {
                    world.setBlockState(pos.up(), getDefaultState());
                    // TODO: Flags 2 or 4?
                    //  Vanilla uses 4, but DivineRPG on NeoForge uses 2.
                    // TODO: Why 14?
                    // TODO: Do I need to replace CommonHooks with something?
                    world.setBlockState(pos, state.with(AGE, 14), 4);
                } else {
                    world.setBlockState(pos, state.with(AGE, j + 1), 4);
                }
                // TODO: There is no Fabric equivalent for CommonHooks.canCropGrow,
                //  though I don't think this is required.
//                if (CommonHooks.canCropGrow(world, pos, state, true)) {
//                    if (j == 15) {
//                        world.setBlockState(pos.up(), getDefaultState());
//                        CommonHooks.fireCropGrowPost(world, pos.up(), getDefaultState());
//                        world.setBlockState(pos, state.with(AGE, 14), 2);
//                    } else world.setBlockState(pos, state.with(AGE, j + 1), 4);
//                }
            }
        }
    }

    protected boolean canPlaceFits(WorldView world, BlockPos pos) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockState blockstate = world.getBlockState(pos.offset(direction));
            if (blockstate.exceedsCube() || world.getFluidState(pos.offset(direction)).isIn(ConventionalFluidTags.LAVA))
                return false;
        }
        return true;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.down());
        return canPlaceFits(world, pos)
                && (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos))
                && (belowState.isIn(BlockTags.DIRT) || belowState.isOf(this)
                && belowState.get(AGE) == 14);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(seed);
    }
}
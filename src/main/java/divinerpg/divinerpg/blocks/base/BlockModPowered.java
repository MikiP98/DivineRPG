package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class BlockModPowered extends BlockMod {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public BlockModPowered(Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    // TODO: Make sure replacing 'onPlaced' with 'getPlacementState' works as intended
//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
//        handleBlockState(state, world, pos);
//    }
    @Override
    public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = super.getPlacementState(ctx);
        return state == null ? getDefaultState() : state.with(POWERED, !ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        handleBlockState(state, world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        handleBlockState(state, world, pos);
    }

    public void handleBlockState(BlockState state, World worldIn, BlockPos pos) {
        if (!worldIn.isClient) {
            if (state.get(POWERED) && !worldIn.isReceivingRedstonePower(pos)) {
                worldIn.setBlockState(pos, getDefaultState(), 2);
            } else if (!state.get(POWERED) && worldIn.isReceivingRedstonePower(pos)) {
                worldIn.setBlockState(pos, getDefaultState().with(POWERED, true), 2);
            }
        }
    }
}

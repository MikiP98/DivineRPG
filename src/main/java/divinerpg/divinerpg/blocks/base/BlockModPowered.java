package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.DebugInfoSender;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BlockModPowered extends BlockMod {
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    public BlockModPowered(Settings properties) {
        super(properties);
        setDefaultState(getDefaultState().with(POWERED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())) {
            return this.getDefaultState().with(POWERED, true);
        } else
            return this.getDefaultState();
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        handleBlockState(state, world, pos);
        DebugInfoSender.sendNeighborUpdate(world, pos);
    }

//    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
//        handleBlockState(state, worldIn, pos);
//    }
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        handleBlockState(state, world, pos);
    }

    public void handleBlockState(BlockState state, World worldIn, BlockPos pos) {
        if (!worldIn.isClient) {
            if (state.get(POWERED) && !worldIn.isReceivingRedstonePower(pos)) {
                worldIn.setBlockState(pos, this.getDefaultState(), 2);
            } else if (!state.get(POWERED) && worldIn.isReceivingRedstonePower(pos)) {
                worldIn.setBlockState(pos, this.getDefaultState().with(POWERED, true), 2);
            }
        }
    }
}

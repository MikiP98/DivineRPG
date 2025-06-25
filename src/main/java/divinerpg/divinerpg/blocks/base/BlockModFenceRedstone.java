package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BlockModFenceRedstone extends FenceBlock {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public BlockModFenceRedstone(MapColor color) {
        super(Block.Settings.create()
                .mapColor(color)
                .dynamicBounds()
                .strength(0.3F)
                .sounds(BlockSoundGroup.GLASS)
                .instrument(Instrument.HAT)
                .luminance(state -> state.get(POWERED) ? 15 : 0)
        );
        setDefaultState(getDefaultState()
                .with(POWERED, Boolean.FALSE)
                .with(NORTH, Boolean.FALSE)
                .with(EAST, Boolean.FALSE)
                .with(SOUTH, Boolean.FALSE)
                .with(WEST, Boolean.FALSE)
                .with(WATERLOGGED, Boolean.FALSE)
        );
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        handleBlockState(state, world, pos);
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

    public void handleBlockState(BlockState state, World world, BlockPos pos) {
        if (!world.isClient) {
            if (state.get(POWERED) && !world.isReceivingRedstonePower(pos)) {
                // TODO: Make sure 2 is the correct flag for updating the block state, as vanilla uses 4 (I think)
                world.setBlockState(pos, state.with(POWERED, false), 2);
            } else if (!state.get(POWERED) && world.isReceivingRedstonePower(pos)) {
                world.setBlockState(pos, state.with(POWERED, Boolean.TRUE), 2);
            }
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED, POWERED);
    }
}

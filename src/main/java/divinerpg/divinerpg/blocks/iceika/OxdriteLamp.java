package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.base.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.tick.TickPriority;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.state.property.Properties.POWER;

public class OxdriteLamp extends BlockMod {
    public OxdriteLamp() {
        // TODO: Change 'sounds' to 'BlockSoundGroup.COPPER_BULB' on 1.21+
        super(Settings.copy(Blocks.GLASS).luminance(state -> state.get(POWER)).sounds(BlockSoundGroup.COPPER).solidBlock((s, b, p) -> false));
        setDefaultState(getDefaultState().with(POWER, 0));
    }

    // TODO: There is no Fabric equivalent for this method, though it doesn't seem necessary to have it
//    @Override
//    public boolean hasDynamicLightEmission(BlockState state) {
//        return true;
//    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if(!world.isClient() && world.getReceivedRedstonePower(pos) != state.get(POWER)) world.scheduleBlockTick(pos, this, 1, TickPriority.LOW);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, state.with(POWER, world.getReceivedRedstonePower(pos)), 3);
    }

    @Override
    public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(POWER, ctx.getWorld().getReceivedRedstonePower(ctx.getBlockPos()));
    }
}

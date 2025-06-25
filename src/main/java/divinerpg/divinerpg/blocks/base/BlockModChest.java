package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class BlockModChest extends ChestBlock {
    public BlockModChest(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier) {
        super(settings, supplier);
    }

    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos).with(CHEST_TYPE, ChestType.SINGLE);
    }

    @Override
    public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getHorizontalPlayerFacing().getOpposite();
        FluidState ifluidstate = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return getDefaultState()
                .with(FACING, direction)
                .with(CHEST_TYPE, ChestType.SINGLE)
                .with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof NamedScreenHandlerFactory && !isChestBlocked(world, pos)) return (NamedScreenHandlerFactory) blockEntity;
        return null;
    }
}

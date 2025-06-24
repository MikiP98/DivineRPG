package divinerpg.divinerpg.blocks.arcana;

import divinerpg.divinerpg.blocks.base.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockAcceleron extends BlockMod {
    protected static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    protected float slipperiness_override = 1.2F;

    public BlockAcceleron() {
        super(Block.Settings.create().mapColor(MapColor.LAPIS_BLUE).requiresTool().strength(5, 6).sounds(BlockSoundGroup.METAL).slipperiness(1.2F));
    }

    public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        this.slipperiness_override = entity != null && entity.isSneaking() ? 0.1F : this.slipperiness;
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public float getSlipperiness() {
        return slipperiness_override;
    }
}
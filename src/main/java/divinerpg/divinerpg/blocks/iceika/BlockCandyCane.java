package divinerpg.divinerpg.blocks.iceika;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;

import org.jetbrains.annotations.NotNull;

public class BlockCandyCane extends HorizontalFacingBlock {
	public BlockCandyCane(Settings settings) {
		super(settings.instrument(Instrument.BASEDRUM).requiresTool().strength(.75F).pistonBehavior(PistonBehavior.PUSH_ONLY));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
	}
}
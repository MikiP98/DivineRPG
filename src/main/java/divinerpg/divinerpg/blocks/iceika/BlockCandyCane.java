package divinerpg.divinerpg.blocks.iceika;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public class BlockCandyCane extends HorizontalFacingBlock {

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockCandyCane(MapColor color) {
        super(FabricBlockSettings.create()
                .mapColor(color)
                .instrument(Instrument.BASEDRUM)
                .requiresTool()
                .strength(.75F)
                .pistonBehavior(PistonBehavior.PUSH_ONLY)
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}

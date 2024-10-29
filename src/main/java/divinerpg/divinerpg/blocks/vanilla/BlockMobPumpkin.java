package divinerpg.divinerpg.blocks.vanilla;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockMobPumpkin extends HorizontalFacingBlock {
    private final SoundEvent sound;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) { builder.add(FACING); }

    public BlockMobPumpkin(SoundEvent sound, MapColor color) {
        super(FabricBlockSettings.create().strength(1).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.WOOD).instrument(Instrument.DIDGERIDOO).mapColor(color));
        this.sound = sound;
        setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        if((player.isSneaking() && !player.getStackInHand(handIn).isEmpty()) || sound == null) return ActionResult.PASS;
        worldIn.playSound(player, pos, sound, SoundCategory.BLOCKS, 3, 1);
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}

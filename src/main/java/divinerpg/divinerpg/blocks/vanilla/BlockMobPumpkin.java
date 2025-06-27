package divinerpg.divinerpg.blocks.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class BlockMobPumpkin extends HorizontalFacingBlock {
    private SoundEvent sound;

    @Deprecated
    public BlockMobPumpkin(Settings settings) { super(settings); }
    public BlockMobPumpkin(SoundEvent sound, MapColor color) {
        super(Settings.create().strength(1).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.WOOD).instrument(Instrument.DIDGERIDOO).mapColor(color));
        this.sound = sound;
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if ((player.isSneaking() && !player.getStackInHand(hand).isEmpty()) || sound == null)
            return ActionResult.PASS;

        Random random = world.getRandom();
        float pitch = (float) (1 + (random.nextFloat() * 0.2f - 0.1)); // Random pitch between 0.9 and 1.1
        if (random.nextInt(24) == 0) {
            pitch = random.nextBoolean() ? random.nextInt(9) + 1 : 1f / (random.nextInt(9) + 1);
        }

        world.playSound(player, pos, sound, SoundCategory.BLOCKS, 3, pitch);
        return ActionResult.SUCCESS;
    }

    @Override
    public @NotNull BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
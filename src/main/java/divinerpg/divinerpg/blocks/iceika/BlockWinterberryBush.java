package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import divinerpg.divinerpg.blocks.base.BlockMod;
import divinerpg.divinerpg.registries.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BlockWinterberryBush extends BlockMod implements Fertilizable, AlwaysFlammable {
    public static final BooleanProperty RIPE = Properties.BLOOM;

    public BlockWinterberryBush() {
        super(Settings.create()
                .mapColor(MapColor.DARK_GREEN)
                .pistonBehavior(PistonBehavior.DESTROY)
                .strength(0.2F)
                .ticksRandomly()
                .noCollision()
                .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                .luminance((state) -> state.get(RIPE) ? 5 : 1)
        );
        setDefaultState(getDefaultState().with(RIPE, false));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return !state.get(RIPE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < 0.11F) world.setBlockState(pos, state.with(RIPE, true), 3);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(RIPE, true), 3);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient){
        return !state.get(RIPE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.getStackInHand(hand).isEmpty()) return super.onUse(state, world, pos, player, hand, hit);

        if (state.get(RIPE)) {
            Block.dropStack(world, pos, new ItemStack(ItemRegistry.winterberry, 1));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(RIPE, false), 2);
            return ActionResult.SUCCESS;
        } return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(RIPE);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public int getFlammability() {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed() {
        return 60;
    }
}

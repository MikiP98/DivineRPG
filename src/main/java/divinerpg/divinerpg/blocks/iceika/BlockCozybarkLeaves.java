package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.base.BlockModLeaves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCozybarkLeaves extends BlockModLeaves {

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE);
        builder.add(PERSISTENT);
        builder.add(WATERLOGGED);
        builder.add(Properties.SNOWY);
    }

    public BlockCozybarkLeaves() {
        super(MapColor.DULL_PINK, BlockSoundGroup.CHERRY_LEAVES);  // CRIMSON_STEM
        setDefaultState(getDefaultState()
                .with(DISTANCE, 1)
                .with(PERSISTENT, false)
                .with(WATERLOGGED, false)
                .with(Properties.SNOWY, false)
        );
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.BUCKET) && (state.get(Properties.SNOWY) || state.get(Properties.WATERLOGGED))) {
            if(level.isClient) {
                if (state.get(Properties.SNOWY)) player.playSound(SoundEvents.ITEM_BUCKET_FILL_POWDER_SNOW, 1, 1);
                else player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1, 1);
            } else {
                if (!player.isCreative()) {
                    stack.decrement(1);
                    if(state.get(Properties.SNOWY)) player.giveItemStack(new ItemStack(Items.POWDER_SNOW_BUCKET));
                    else player.giveItemStack(new ItemStack(Items.WATER_BUCKET));
                }
                level.setBlockState(pos, state.with(Properties.SNOWY, false).with(Properties.WATERLOGGED, false), 3);
            }
            return ActionResult.SUCCESS;

        } else if (stack.isOf(Items.POWDER_SNOW_BUCKET) && !state.get(Properties.SNOWY) && !state.get(Properties.WATERLOGGED)) {
            if (level.isClient) player.playSound(SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, 1, 1);
            else {
                if (!player.isCreative()) {
                    stack.decrement(1);
                    player.giveItemStack(new ItemStack(Items.BUCKET));
                }
                level.setBlockState(pos, state.with(Properties.SNOWY, true), 3);
            }
            return ActionResult.SUCCESS;

        } else if (stack.isOf(Items.WATER_BUCKET) && !state.get(Properties.WATERLOGGED)) {
            if (level.isClient) player.playSound(SoundEvents.ITEM_BUCKET_EMPTY, 1, 1);
            else {
                if (!player.isCreative()) {
                    stack.decrement(1);
                    player.giveItemStack(new ItemStack(Items.BUCKET));
                }
                level.setBlockState(pos, state.with(Properties.WATERLOGGED, true), 3);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}

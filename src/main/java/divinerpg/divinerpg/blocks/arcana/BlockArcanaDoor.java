package divinerpg.divinerpg.blocks.arcana;

//import net.minecraft.core.BlockPos;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.ItemInteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.*;
//import net.minecraft.world.world.Level;
//import net.minecraft.world.world.block.*;
//import net.minecraft.world.world.block.state.BlockState;
//import net.minecraft.world.world.block.state.properties.BlockStateProperties;
//import net.minecraft.world.world.material.MapColor;
//import net.minecraft.world.phys.BlockHitResult;
//
//import static net.minecraft.sounds.SoundSource.BLOCKS;
//import static net.minecraft.world.world.block.state.properties.BlockSetType.IRON;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.minecraft.block.BlockSetType.IRON;

public class BlockArcanaDoor extends DoorBlock {
    protected final Item keyItem;

    public BlockArcanaDoor(MapColor color, Item key) {
        super(Block.Settings.copy(Blocks.BEDROCK).mapColor(color).nonOpaque(), IRON);
        keyItem = key;
    }

    private void updateAdjacentDoors(World world, BlockPos pos, PlayerEntity player, BlockState state) {
        BlockPos[] adjacent = {
                pos.north(),
                pos.east(),
                pos.south(),
                pos.west()
        };
        for(BlockPos adjacentPos : adjacent) {
            BlockState adjacentState = world.getBlockState(adjacentPos);
            if(adjacentState.getBlock() instanceof BlockArcanaDoor) {
                world.setBlockState(adjacentPos, adjacentState.cycle(OPEN));
                world.syncWorldEvent(player, adjacentState.get(OPEN) ? 1005 : 1011, adjacentPos, 0);
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult rayTraceResult) {
        ItemStack itemstack = player.getStackInHand(hand);

        BlockState iblockstate = pos.equals(pos.down()) ? state : world.getBlockState(pos.down());
        if(!iblockstate.isOf(this))
            return ActionResult.FAIL;
        else {
            if (!player.isCreative()) {
                if (iblockstate.get(OPEN).equals(true)) return ActionResult.FAIL;
                if (itemstack.getItem() != this.keyItem) return ActionResult.FAIL;
                itemstack.decrement(1);
            }

            world.setBlockState(pos, state.cycle(OPEN));
            world.syncWorldEvent(player, state.get(OPEN) ? 1005 : 1011, pos, 0);

            if(state.get(OPEN)) world.playSound(player, pos, SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1, .8F);
            else world.playSound(player, pos, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundCategory.BLOCKS, 1, .8F);

            updateAdjacentDoors(world, pos, player, state);
            return ActionResult.SUCCESS;
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos neighborPosition, boolean isPowered) {}
}
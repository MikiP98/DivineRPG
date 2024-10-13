package divinerpg.divinerpg.blocks.arcana;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockArcanaDoor extends DoorBlock {
    private final Item keyItem;

//    public BlockArcanaDoor(Settings settings, BlockSetType blockSetType) {
//        super(settings, blockSetType);
//    }
    public BlockArcanaDoor(MapColor color, Item key) {
        super(Settings.create().mapColor(color).strength(-1.0F, 3600000.0F).nonOpaque().instrument(Instrument.BASEDRUM), BlockSetType.IRON);  // .noOcclusion()
        this.keyItem = key;
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
//        Item key = ForgeRegistries.ITEMS.getValue(keyItem);
        if (!(iblockstate.getBlock() == this)) return ActionResult.FAIL;
//        if(!iblockstate.is(this)) return InteractionResult.FAIL;
        else {
            if(!player.isCreative()) {
//                if(iblockstate.getValue(OPEN).equals(true)) return InteractionResult.FAIL;
                if (iblockstate.get(OPEN)) return ActionResult.FAIL;
                if (itemstack.getItem() != keyItem) return ActionResult.FAIL;
//                itemstack.shrink(1);
                itemstack.decrement(1);
            }
            world.setBlockState(pos, state.cycle(OPEN));
//            world.levelEvent(player, state.get(OPEN) ? 1005 : 1011, pos, 0);
            world.syncWorldEvent(player, state.get(OPEN) ? 1005 : 1011, pos, 0);
            if(state.get(OPEN)) world.playSound(null, pos, SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1F, .8F);
            else world.playSound(null, pos, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundCategory.BLOCKS, 1F, .8F);
            updateAdjacentDoors(world, pos, player, state);
            return ActionResult.SUCCESS;
        }
    }

//    @Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPosition, boolean isPowered) {}
    @Override public void neighborUpdate(BlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos neighborPosition, boolean isPowered) {}
}

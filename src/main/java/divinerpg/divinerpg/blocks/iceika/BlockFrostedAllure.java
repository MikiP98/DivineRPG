package divinerpg.divinerpg.blocks.iceika;

import com.mojang.authlib.properties.Property;
import divinerpg.divinerpg.block_entities.block.FrostedAllureBlockEntity;
import divinerpg.divinerpg.registries.BlockEntityRegistry;
import divinerpg.divinerpg.registries.ItemRegistry;
import divinerpg.divinerpg.util.LocalizeUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockFrostedAllure extends BlockWithEntity {
    public static final IntProperty CATEGORY = IntProperty.of("category", 0, 5);

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) { builder.add(CATEGORY); }

    public BlockFrostedAllure() {
        super(FabricBlockSettings.create().mapColor(MapColor.LIGHT_BLUE).strength(.8F).sounds(BlockSoundGroup.CALCITE).instrument(Instrument.CHIME).ticksRandomly());
        setDefaultState(getDefaultState().with(CATEGORY, 0));
    }

    @Override public BlockRenderType getRenderType(BlockState state) {return BlockRenderType.MODEL;}

    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> type) {
        return level.isClient ? null : checkType(type, BlockEntityRegistry.FROSTED_ALLURE, FrostedAllureBlockEntity::serverTick);
    }

    @Override public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if(hand == Hand.MAIN_HAND && player.getStackInHand(hand).getItem() == ItemRegistry.ice_stone){
            if(state.get(CATEGORY) == 0) {
                level.setBlockState(pos, state.with(CATEGORY, 1), 0);
//                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.monster"), true);
                player.sendMessage(LocalizeUtils.clientMessage("frosted_allure.monster"), true);
                if(!player.isCreative()) player.getStackInHand(hand).decrement(1);
                return ActionResult.SUCCESS;
            } if(state.get(CATEGORY) == 1) {
                level.setBlockState(pos, state.with(CATEGORY, 2), 0);
//                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.creature"), true);
                player.sendMessage(LocalizeUtils.clientMessage("frosted_allure.creature"), true);
                if(!player.isCreative()) player.getStackInHand(hand).decrement(1);
                return ActionResult.SUCCESS;
            } if(state.get(CATEGORY) == 2) {
                level.setBlockState(pos, state.with(CATEGORY, 3), 0);
//                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.ambient"), true);
                player.sendMessage(LocalizeUtils.clientMessage("frosted_allure.ambient"), true);
                if(!player.isCreative()) player.getStackInHand(hand).decrement(1);
                return ActionResult.SUCCESS;
            } if(state.get(CATEGORY) == 3) {
                level.setBlockState(pos, state.with(CATEGORY, 4), 0);
//                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.water"), true);
                player.sendMessage(LocalizeUtils.clientMessage("frosted_allure.water"), true);
                if(!player.isCreative()) player.getStackInHand(hand).decrement(1);
                return ActionResult.SUCCESS;
            } if(state.get(CATEGORY) == 4) {
                level.setBlockState(pos, state.with(CATEGORY, 5), 0);
//                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.misc"), true);
                player.sendMessage(LocalizeUtils.clientMessage("frosted_allure.misc"), true);
                if(!player.isCreative()) player.getStackInHand(hand).decrement(1);
                return ActionResult.SUCCESS;
            } if(state.get(CATEGORY) == 5) {
                level.setBlockState(pos, state.with(CATEGORY, 0), 0);
//                player.displayClientMessage(LocalizeUtils.clientMessage("frosted_allure.all"), true);
                player.sendMessage(LocalizeUtils.clientMessage("frosted_allure.all"), true);
                if(!player.isCreative()) player.getStackInHand(hand).decrement(1);
                return ActionResult.SUCCESS;
            }
        } return ActionResult.FAIL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FrostedAllureBlockEntity(pos, state);
    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.i18n("frosted_allure"));
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//    }
}

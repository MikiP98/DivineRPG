package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.block_entities.block.FrostedAllureBlockEntity;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class BlockFrostedAllure extends BaseEntityBlock {
    public static final MapCodec<BlockFrostedAllure> CODEC = simpleCodec(BlockFrostedAllure::new);
    public static final IntegerProperty CATEGORY = IntegerProperty.create("category", 0, 5);
    @Override public MapCodec<BlockFrostedAllure> codec() {return CODEC;}
    public BlockFrostedAllure(Properties properties) {
        super(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).strength(.8F).sound(SoundType.CALCITE).instrument(NoteBlockInstrument.CHIME).randomTicks());
        registerDefaultState(stateDefinition.any().setValue(CATEGORY, 0));
    }
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new FrostedAllureBlockEntity(pos, state);}
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.FROSTED_ALLURE.get(), FrostedAllureBlockEntity::serverTick);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(CATEGORY);}
    @Override public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();
        if(hand == InteractionHand.MAIN_HAND && item == ItemRegistry.ice_stone.get()){
            int currentCategory = state.getValue(CATEGORY);
            String[] messages = {
                    "frosted_allure.all",
                    "frosted_allure.monster",
                    "frosted_allure.creature",
                    "frosted_allure.ambient",
                    "frosted_allure.water",
                    "frosted_allure.misc"
            };
            int newCategory = (currentCategory + 1) % messages.length;
            level.setBlock(pos, state.setValue(CATEGORY, newCategory), 0);
            player.displayClientMessage(LocalizeUtils.clientMessage(messages[newCategory]), true);
            stack.consume(1, player);
            player.awardStat(Stats.ITEM_USED.get(item));
            return ItemInteractionResult.SUCCESS;
        } return ItemInteractionResult.FAIL;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("frosted_allure"));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}
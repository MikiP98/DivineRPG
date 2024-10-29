package divinerpg.divinerpg.items.base;

import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class ItemShickaxe extends MiningToolItem {
    protected final ToolMaterial tier;

    public ItemShickaxe(Rarity rarity, ToolMaterial tier) {
        // BlockTags.create(new Identifier(MOD_ID, "shickaxe_effective"))
        super(1, -2.4F, tier, BlockTags.ANVIL, new Settings().maxDamage(tier.getDurability()).rarity(rarity));
        this.tier = tier;
    }
    public ItemShickaxe(ToolMaterial tier) {
        // BlockTags.create(new Identifier(MOD_ID, "shickaxe_effective"))
        super(1, -2.4F, tier, BlockTags.ANVIL, new Settings().maxDamage(tier.getDurability()));
        this.tier = tier;
    }

//    private static final Set<ToolAction> TOOL_ACTIONS = Stream.of(AXE_DIG, AXE_SCRAPE, AXE_STRIP, AXE_WAX_OFF, PICKAXE_DIG, SHOVEL_DIG, SHOVEL_FLATTEN, HOE_DIG, HOE_TILL).collect(Collectors.toCollection(Sets::newIdentityHashSet));
//    @Override public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {return TOOL_ACTIONS.contains(toolAction);}

//    @Override public InteractionResult useOn(UseOnContext context) {
//        Level level = context.getLevel();
//        BlockPos blockpos = context.getClickedPos();
//        BlockState state = level.getBlockState(blockpos);
//        InteractionHand hand = context.getHand();
//        Player player = context.getPlayer();
//        BlockState toolModifiedState = state.getToolModifiedState(context, ToolActions.HOE_TILL, false);
//        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, HoeItem.changeIntoState(toolModifiedState));
//        Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(context, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
//        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(state.getToolModifiedState(context, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
//        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(state.getToolModifiedState(context, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
//        ItemStack stack = context.getItemInHand();
//        Optional<BlockState> optional3 = Optional.empty();
//        if(optional.isPresent()) {
//            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1, 1);
//            optional3 = optional;
//        } else if(optional1.isPresent()) {
//            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1, 1);
//            level.levelEvent(player, 3005, blockpos, 0);
//            optional3 = optional1;
//        } else if(optional2.isPresent()) {
//            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1, 1);
//            level.levelEvent(player, 3004, blockpos, 0);
//            optional3 = optional2;
//        } if(optional3.isPresent()) {
//            if(player instanceof ServerPlayer) CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, stack);
//            level.setBlock(blockpos, optional3.get(), 11);
//            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
//            stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
//            return InteractionResult.sidedSuccess(level.isClientSide);
//        } if(pair != null && !player.isShiftKeyDown()) {
//            Predicate<UseOnContext> predicate = pair.getFirst();
//            Consumer<UseOnContext> consumer = pair.getSecond();
//            if(predicate.test(context)) {
//                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1, 1);
//                if(!level.isClientSide) {
//                    consumer.accept(context);
//                    context.getItemInHand().hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
//                } return InteractionResult.sidedSuccess(level.isClientSide);
//            }
//        } BlockState blockstate1 = state.getToolModifiedState(context, net.minecraftforge.common.ToolActions.SHOVEL_FLATTEN, false);
//        BlockState blockstate2 = null;
//        if(context.getClickedFace() != Direction.DOWN) {
//            if(blockstate1 != null && level.isEmptyBlock(blockpos.above()) && player.isShiftKeyDown()) {
//                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1, 1);
//                blockstate2 = blockstate1;
//            } else if(state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
//                if(!level.isClientSide) level.levelEvent(null, 1009, blockpos, 0);
//                CampfireBlock.dowse(context.getPlayer(), level, blockpos, state);
//                blockstate2 = state.setValue(CampfireBlock.LIT, Boolean.FALSE);
//            } if(blockstate2 != null) {
//                if(!level.isClientSide) {
//                    level.setBlock(blockpos, blockstate2, 11);
//                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));
//                    if(player != null) context.getItemInHand().hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
//                } return InteractionResult.sidedSuccess(level.isClientSide);
//            }
//        } return InteractionResult.PASS;
//    }

//    @Override public float getDestroySpeed(ItemStack stack, BlockState state) {
//        if(state.is(BlockTags.MINEABLE_WITH_AXE)) return speed;
//        if(state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return speed;
//        if(state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
//        if(state.is(BlockTags.MINEABLE_WITH_HOE)) return speed;
//        return super.getDestroySpeed(stack, state);
//    }
//    @Override public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
//        if(state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return TierSortingRegistry.isCorrectTierForDrops(tier, state);
//        if(state.is(BlockTags.MINEABLE_WITH_AXE)) return TierSortingRegistry.isCorrectTierForDrops(tier, state);
//        if(state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return TierSortingRegistry.isCorrectTierForDrops(tier, state);
//        if(state.is(BlockTags.MINEABLE_WITH_HOE)) return TierSortingRegistry.isCorrectTierForDrops(tier, state);
//        return false;
//    }

//    @SuppressWarnings("deprecation")
//    @OnlyIn(Dist.CLIENT)
//    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.efficiency((int)speed));
//        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
//        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
//    }
}

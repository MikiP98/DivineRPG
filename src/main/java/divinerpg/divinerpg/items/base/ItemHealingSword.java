package divinerpg.divinerpg.items.base;

import divinerpg.divinerpg.enums.ToolStats;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;

import java.util.List;

public class ItemHealingSword extends ItemModSword {
    public float healAmount;

    public ItemHealingSword(ToolStats material, float heals) {
        super(material);
        healAmount = heals;
        cooldown = 3;
    }

//    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        if(attacker.getHealth() < attacker.getMaxHealth()) {
//            attacker.heal(healAmount);
//            attacker.level().playSound(null, attacker.blockPosition(), SoundRegistry.HEAL.get(), SoundSource.PLAYERS, 1, 1);
//        } return super.hurtEnemy(stack, target, attacker);
//    }
//    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//        if(player.getHealth() < player.getMaxHealth()) {
//            ItemStack stack = player.getItemInHand(hand);
//            if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
//            player.heal(healAmount);
//            if(player.isOnFire() && this == ItemRegistry.frossivence.get()) player.clearFire();
//            player.playSound(SoundRegistry.HEAL.get(), 1, 1);
//            player.awardStat(Stats.ITEM_USED.get(this));
//            player.getCooldowns().addCooldown(this, cooldown);
//            return InteractionResultHolder.success(stack);
//        } return super.use(level, player, hand);
//    }
//    @Override public InteractionResult interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
//        if(!(entity instanceof ServerPlayer) && !(entity instanceof Monster) && entity.getHealth() < entity.getMaxHealth() && !player.getCooldowns().isOnCooldown(this)) {
//            if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
//            entity.heal(healAmount);
//            if(entity.isOnFire() && this == ItemRegistry.frossivence.get()) entity.extinguishFire();
//            entity.playSound(SoundRegistry.HEAL.get(), 1, 1);
//            for(int i = 0; i < 7; ++i) {
//                double d0 = entity.random.nextGaussian() * .02;
//                double d1 = entity.random.nextGaussian() * .02;
//                double d2 = entity.random.nextGaussian() * .02;
//                entity.level().addParticle(ParticleTypes.HEART, entity.getRandomX(1), entity.getRandomY() + .5, entity.getRandomZ(1), d0, d1, d2);
//            } player.awardStat(Stats.ITEM_USED.get(this));
//            player.getCooldowns().addCooldown(this, cooldown);
//            return InteractionResult.SUCCESS;
//        } return super.interactLivingEntity(stack, player, entity, hand);
//    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.healthHeal(healAmount / 2));
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//    }
}

package divinerpg.divinerpg.items.base;

import divinerpg.divinerpg.enums.ToolStats;
import divinerpg.divinerpg.registries.ItemRegistry;
import divinerpg.divinerpg.registries.SoundRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ItemHealingSword extends ItemModSword {
    public float healAmount;

    public ItemHealingSword(ToolStats material, float heals) {
        super(material);
        healAmount = heals;
        cooldown = 3;
    }

    @Override public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.getHealth() < attacker.getMaxHealth()) {
            attacker.heal(healAmount);
            attacker.getWorld().playSound(null, attacker.getBlockPos(), SoundRegistry.HEAL, SoundCategory.PLAYERS, 1, 1);
        } return super.postHit(stack, target, attacker);
    }
//    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        if(attacker.getHealth() < attacker.getMaxHealth()) {
//            attacker.heal(healAmount);
//            attacker.level().playSound(null, attacker.blockPosition(), SoundRegistry.HEAL.get(), SoundSource.PLAYERS, 1, 1);
//        } return super.hurtEnemy(stack, target, attacker);
//    }

    @Override public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getStackInHand(hand);
            if (!player.isCreative()) stack.damage(1, player, (ctx) -> ctx.sendToolBreakStatus(hand));
            player.heal(healAmount);
            player.getWorld().playSound(null, player.getBlockPos(), SoundRegistry.HEAL, SoundCategory.PLAYERS, 1, 1);
//            player.awardStat(Stats.ITEM_USED.get(this));
            player.getItemCooldownManager().set(this, cooldown);
            return TypedActionResult.success(stack);
        } return super.use(level, player, hand);
    }
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

    private static double getRandomXZ(LivingEntity entity, double cord) {
        return (cord + (double) entity.getWidth() * (2.0d * entity.getRandom().nextDouble() - 1.0d));
    }
    private static double getRandomX(LivingEntity entity) {
        return getRandomXZ(entity, entity.getX());
    }
    private static double getRandomZ(LivingEntity entity) {
        return getRandomXZ(entity, entity.getZ());
    }
    private static double getRandomY(LivingEntity entity) {
        return entity.getY() + (double) entity.getHeight() * entity.getRandom().nextDouble();
    }
    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if(!(entity instanceof ServerPlayerEntity) && !(entity instanceof HostileEntity) && entity.getHealth() < entity.getMaxHealth() && !player.getItemCooldownManager().isCoolingDown(this)) {
            if (!player.isCreative()) stack.damage(1, player, (ctx) -> ctx.sendToolBreakStatus(hand));
            entity.heal(healAmount);
            if(entity.isOnFire() && this == ItemRegistry.frossivence) entity.extinguishWithSound();
            entity.playSound(SoundRegistry.HEAL, 1, 1);
            for(int i = 0; i < 7; ++i) {
                double d0 = entity.getRandom().nextGaussian() * .02;
                double d1 = entity.getRandom().nextGaussian() * .02;
                double d2 = entity.getRandom().nextGaussian() * .02;
                entity.getWorld().addParticle(ParticleTypes.HEART, getRandomX(entity), getRandomY(entity) + .5, getRandomZ(entity), d0, d1, d2);
            }
//            player.awardStat(Stats.ITEM_USED.get(this));
            player.getItemCooldownManager().set(this, cooldown);
            return ActionResult.SUCCESS;
        } return super.useOnEntity(stack, player, entity, hand);
    }
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

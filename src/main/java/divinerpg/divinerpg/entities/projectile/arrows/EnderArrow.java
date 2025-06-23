package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.registries.*;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.*;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class EnderArrow extends DivineArrow {
    public EnderArrow(EntityType<? extends DivineArrow> entityType, Level level) {
        super(entityType, level);
    }
    public EnderArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.ENDER_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public EnderArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.ENDER_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemRegistry.ender_arrow.get());
    }
    @Override
    public float getArrowPower() {
        return 4F;
    }
    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(result.getEntity() instanceof LivingEntity e && e.isSensitiveToWater()) {
            Entity entity = result.getEntity();
            float f = (float)getDeltaMovement().length(), d0 = getArrowPower() * powerMultiplier;
            Entity entity1 = getOwner();
            DamageSource damagesource = damageSources().magic();
            if(getWeaponItem() != null && level() instanceof ServerLevel s) d0 = EnchantmentHelper.modifyDamage(s, getWeaponItem(), entity, damagesource, d0);
            int j = Mth.ceil(Mth.clamp((double)f * d0, 0D, Integer.MAX_VALUE)), i = entity.getRemainingFireTicks();
            if(isCritArrow()) j = (int)Math.min(random.nextInt(j / 2 + 2) + (long)j, 2147483647L);
            if(entity1 instanceof LivingEntity livingentity1) livingentity1.setLastHurtMob(entity);
            if(isOnFire()) entity.igniteForSeconds(5F);
            if(entity.hurt(damagesource, (float)j)) {
                if(entity instanceof LivingEntity livingentity) {
                    if(!level().isClientSide) livingentity.setArrowCount(livingentity.getArrowCount() + 1);
                    if(level() instanceof ServerLevel serverlevel1) EnchantmentHelper.doPostAttackEffectsWithItemSource(serverlevel1, livingentity, damagesource, getWeaponItem());
                    doPostHurtEffects(livingentity);
                    if(!level().isClientSide && entity1 instanceof ServerPlayer serverplayer && !entity.isAlive() && shotFromCrossbow()) CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, Arrays.asList(entity));
                } playSound(getHitGroundSoundEvent(), 1F, 1.2F / (random.nextFloat() * .2F + .9F));
                discard();
            } else {
                entity.setRemainingFireTicks(i);
                deflect(ProjectileDeflection.REVERSE, entity, getOwner(), false);
                setDeltaMovement(getDeltaMovement().scale(.2));
                if(!level().isClientSide && getDeltaMovement().lengthSqr() < 1.0E-7) {
                    if(pickup == AbstractArrow.Pickup.ALLOWED) spawnAtLocation(getPickupItem(), .1F);
                    discard();
                }
            }
        } else super.onHitEntity(result);
    }
}
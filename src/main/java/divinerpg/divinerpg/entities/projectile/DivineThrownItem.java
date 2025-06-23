package divinerpg.entities.projectile;

import divinerpg.items.ranged.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class DivineThrownItem extends ThrowableItemProjectile {
    public boolean canPickup = true;
    public DivineThrownItem(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected Item getDefaultItem() {
        return Items.EGG;
    }
    public void drop() {
        ItemStack item = getItem();
        if(canPickup && !item.isEmpty()) spawnAtLocation(getItem(), .1F);
        discard();
    }
    @Override public void tick() {
        super.tick();
        if(tickCount > 200) drop();
    }
    public DamageSource getDamageSource(EntityHitResult result) {
        return damageSources().thrown(this, getOwner());
    }
    protected void doPostHurtEffects(LivingEntity living) {

    }
    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        ItemStack item = getItem();
        float f = (float)getDeltaMovement().length(), d0 = item.isEmpty() || !(item.getItem() instanceof ItemThrowable t) ? 1F : t.damage;
        Entity entity1 = getOwner();
        DamageSource damagesource = getDamageSource(result);
        if(getWeaponItem() != null && level() instanceof ServerLevel s) d0 = EnchantmentHelper.modifyDamage(s, getWeaponItem(), entity, damagesource, d0);
        int j = Mth.ceil(Mth.clamp(f * d0, 0D, Integer.MAX_VALUE)), i = entity.getRemainingFireTicks();
        if(entity1 instanceof LivingEntity livingentity1) livingentity1.setLastHurtMob(entity);
        if(isOnFire()) entity.igniteForSeconds(5F);
        if(entity.hurt(damagesource, j)) {
            if(entity instanceof LivingEntity livingentity) {
                if(level() instanceof ServerLevel serverlevel1) EnchantmentHelper.doPostAttackEffectsWithItemSource(serverlevel1, livingentity, damagesource, getWeaponItem());
                doPostHurtEffects(livingentity);
            } canPickup = false;
            drop();
        } else {
            entity.setRemainingFireTicks(i);
            deflect(ProjectileDeflection.REVERSE, entity, getOwner(), false);
            setDeltaMovement(getDeltaMovement().scale(.2));
            if(!level().isClientSide && getDeltaMovement().lengthSqr() < 1.0E-7) drop();
        }
    }
    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        drop();
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("pickup", canPickup);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        canPickup = compound.getBoolean("pickup");
    }
}
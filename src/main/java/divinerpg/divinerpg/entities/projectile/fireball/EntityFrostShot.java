package divinerpg.entities.projectile.fireball;

import divinerpg.entities.projectile.DivineFireball;
import divinerpg.registries.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;

public class EntityFrostShot extends DivineFireball {
    public EntityFrostShot(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
    }
    public EntityFrostShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EntityRegistry.FROST_SHOT.get(), world, shooter, accelX, accelY, accelZ);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    @Override
    public boolean isOnFire() {
        return false;
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if(result.getType() != HitResult.Type.MISS) {
            if(!level().isClientSide()) {
                level().explode(this, getX(), getY(), getZ(), 1.3F, false, Level.ExplosionInteraction.NONE);
                for(Entity entity : level().getEntities(getOwner(), new AABB(position().add(-3, -3, -3), position().add(3, 3, 3)))) if(entity instanceof  LivingEntity l && l.canFreeze() && !l.hasEffect(MobEffectRegistry.WARMTH)) l.setTicksFrozen(l.getTicksRequiredToFreeze() + 50);
            } discard();
        }
    }
    @Override
    public void tick() {
        if(tickCount > 400) discard();
        super.tick();
        level().addParticle(ParticleRegistry.FROST.get(), xo + (random.nextFloat() * 2F), yo + (random.nextFloat() * 2F), zo + (random.nextFloat() * 2F), 0, 1, 0);
    }
}
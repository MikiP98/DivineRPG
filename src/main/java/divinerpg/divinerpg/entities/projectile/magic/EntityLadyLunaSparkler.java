package divinerpg.entities.projectile.magic;

import divinerpg.registries.DamageRegistry;
import divinerpg.registries.ParticleRegistry;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityLadyLunaSparkler extends DivineParticleProjectile {
    public EntityLadyLunaSparkler(EntityType<? extends DivineParticleProjectile> type, Level world) {
        super(type, world, 12F, ParticleRegistry.APALACHIA_PORTAL);
    }
    @Override
    public DamageSource getDamageSource(EntityHitResult result) {
        return level().damageSources().source(DamageRegistry.SPIKE.getKey());
    }
    @Override public boolean isNoGravity() {return true;}
    @Override
    public void tick() {
        super.tick();
        if (this.getOwner() != null && this.getOwner() instanceof LivingEntity && ((LivingEntity) this.getOwner()).getLastHurtByMob() != null) {
            double tx = ((LivingEntity) this.getOwner()).getLastHurtByMob().xo - this.getOwner().xo;
            double ty = ((LivingEntity) this.getOwner()).getLastHurtByMob().getBoundingBox().minY - this.getOwner().yo;
            double tz = ((LivingEntity) this.getOwner()).getLastHurtByMob().zo - this.getOwner().zo;
            if (!this.level().isClientSide() && this.tickCount > 30) this.shoot(tx, ty, tz, 0.5f, 0);
        }
        if (!this.level().isClientSide() && this.tickCount > 80) this.kill();
    }
}
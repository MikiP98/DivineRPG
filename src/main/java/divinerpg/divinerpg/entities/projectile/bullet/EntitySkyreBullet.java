package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.registries.SoundRegistry;
import divinerpg.registries.DamageRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

public class EntitySkyreBullet extends DivineThrowableProjectile {
    public EntitySkyreBullet(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        setDeltaMovement(level().getRandom().nextGaussian() * 0.05, -0.5, level().getRandom().nextGaussian() * 0.05);
    }
    @Override public boolean isNoGravity() {return true;}
    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        if(entity instanceof Player) {
            entity.hurt(level().damageSources().source(DamageRegistry.SPIKE.getKey()), entity.getHealth() / 2);
            level().playSound((Player) entity, entity.getX(), entity.getY(), entity.getZ(), SoundRegistry.SKYRE_SPARK.get(), SoundSource.HOSTILE, 0, 0);
        } level().explode(this, xo, yo, zo, 4.5F, false, Level.ExplosionInteraction.MOB);
    }
    @Override
    protected void onHit(HitResult result) {
        if(tickCount > 1 && !level().isClientSide()) {
            level().explode(this, xo, yo, zo, 2, false, Level.ExplosionInteraction.MOB);
            discard();
        }
    }
}
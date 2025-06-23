package divinerpg.entities.projectile.magic;

import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class EntityTwilightDemonShot extends DivineParticleProjectile {
    public EntityTwilightDemonShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world, 16F, ParticleRegistry.MORTUM_PORTAL);
    }
    @Override public boolean isNoGravity() {return true;}
    @Override
    public void tick() {
        super.tick();
        if(!level().isClientSide() && tickCount > 20) kill();
    }
    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0), getOwner());
    }
}
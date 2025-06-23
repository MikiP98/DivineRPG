package divinerpg.entities.projectile.magic;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class StarProjectile extends DivineParticleProjectile {
    public StarProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level, float damage, Supplier<SimpleParticleType> particle) {
        super(entityType, level, damage, particle);
        setDeltaMovement(level().getRandom().nextGaussian() * .05, -.5, level().getRandom().nextGaussian() * .05);
    }
}
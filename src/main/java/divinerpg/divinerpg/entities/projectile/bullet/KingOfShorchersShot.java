package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class KingOfShorchersShot extends DivineThrowableProjectile {
    public KingOfShorchersShot(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level);
        baseDamage = 14F;
    }
    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        if(!living.fireImmune()) living.igniteForSeconds(8);
    }
}
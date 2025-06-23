package divinerpg.entities.projectile.bullet;

import divinerpg.registries.EntityRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityFirefly extends EntityHeatSeekingProjectile {

    public EntityFirefly(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityFirefly(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }
    public EntityFirefly(Level world, Player player) {
        super(EntityRegistry.FIREFLY.get(), world);
    }


    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount > 1) {
            if(result.getEntity() instanceof LivingEntity entity) entity.hurt(damageSources().indirectMagic(this, getOwner()), 8);
            if(!level().isClientSide()) discard();
        }
    }
}
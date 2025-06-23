package divinerpg.entities.projectile.magic;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class AttractorBeam extends ThrowableProjectile {
    public AttractorBeam(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public boolean isNoGravity() {
        return true;
    }
    @Override
    public void tick() {
        super.tick();
        level().addParticle(ParticleTypes.DOLPHIN, getX(), getY(), getZ(), 0D, 0D, 0D);
        if(tickCount > 200) discard();
    }
    @Override protected void onHitEntity(EntityHitResult result) {//TODO: make it also hit item entities
        result.getEntity().addDeltaMovement(getDeltaMovement().scale(-0.2F));
        discard();
    }
    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        discard();
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
}
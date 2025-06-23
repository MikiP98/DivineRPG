package divinerpg.entities.projectile.bullet;

import divinerpg.client.particle.options.ParticleColouredOption;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EntitySoulFiendShot extends ThrowableProjectile {
    public EntitySoulFiendShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }
    @Override
    public void onHit(HitResult result) {
        if(tickCount > 1 && !level().isClientSide()) {
            for(int i = 0; i < 3; i++) EntityRegistry.SOUL_SPIDER.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, new BlockPos((int) result.getLocation().x, (int) result.getLocation().y, (int) result.getLocation().z), MobSpawnType.MOB_SUMMONED, true, false);
            discard();
        }
    }
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }
    @Override
    public void tick() {
        super.tick();
        if(level().isClientSide()) for(int cnt = 0; cnt < 8; ++cnt) {
            level().addParticle(new ParticleColouredOption(ParticleRegistry.COLORED.get(), 0), this.xo + (random.nextDouble() - random.nextDouble()) / 4, this.yo + (random.nextDouble() - random.nextDouble()) / 4, this.zo + (random.nextDouble() - random.nextDouble()) / 4, 0.2D, 0.2D, 0.2D);
            level().addParticle(new ParticleColouredOption(ParticleRegistry.COLORED.get(), 255000), this.xo + (random.nextDouble() - random.nextDouble()) / 4, this.yo + (random.nextDouble() - random.nextDouble()) / 4, this.zo + (random.nextDouble() - random.nextDouble()) / 4, 0.2D, 0.2D, 0.2D);
        }
        if(!level().isClientSide() && tickCount > 20) kill();
    }
}

package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.ItemRegistry;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class Tomato extends DivineThrownItem {
    public Tomato(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.tomato.get();
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        drop();
    }
    @Override
    public void drop() {
        playSound(SoundEvents.HONEY_BLOCK_BREAK);
        level().broadcastEntityEvent(this, (byte)3);
        discard();
    }
    public void handleEntityEvent(byte id) {
        if(id == 3) for(int i = 0; i < 8; ++i) level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, getItem()), getX(), getY(), getZ(), (random.nextFloat() - .5) * .08, (random.nextFloat() - .5) * .08, (random.nextFloat() - .5) * .08);
    }
}
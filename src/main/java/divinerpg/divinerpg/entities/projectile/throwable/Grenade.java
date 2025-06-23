package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class Grenade extends DivineThrownItem {
    public Grenade(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
        canPickup = false;
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if(!level().isClientSide()) level().explode(this, getX(), getY(), getZ(), 3, false, Level.ExplosionInteraction.TNT);
    }
    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.grenade.get();
    }
}
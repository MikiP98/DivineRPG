package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class VileStorm extends DivineThrownItem {
    public VileStorm(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        living.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 3), getOwner());
    }
    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.vile_storm.get();
    }
}
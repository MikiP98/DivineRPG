package divinerpg.entities.projectile.throwable;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class SnowFlakeShuriken extends DivineThrownItem {
    public SnowFlakeShuriken(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3), getOwner());
    }
    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.snowflake_shuriken.get();
    }
}

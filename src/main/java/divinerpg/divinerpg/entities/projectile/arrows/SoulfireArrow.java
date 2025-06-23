package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SoulfireArrow extends DivineArrow {
    public SoulfireArrow(EntityType<? extends DivineArrow> entityType, Level level) {
        super(entityType, level);
    }
    public SoulfireArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.SOULFIRE_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public SoulfireArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.SOULFIRE_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemRegistry.soulfire_arrow.get());
    }
    @Override public byte getPierceLevel() {return 0;}
    @Override protected void doPostHurtEffects(LivingEntity entity) {
        if(!level().isClientSide) level().explode(this, xo, yo, zo, 3, false, Level.ExplosionInteraction.TNT);
    }
}
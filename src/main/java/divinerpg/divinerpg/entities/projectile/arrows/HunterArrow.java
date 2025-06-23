package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class HunterArrow extends DivineArrow {
    public HunterArrow(EntityType<? extends DivineArrow> entityType, Level level) {
        super(entityType, level);
        addEffect(new MobEffectInstance(MobEffects.POISON, 40, 3));
    }
    public HunterArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.HUNTER_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
        addEffect(new MobEffectInstance(MobEffects.POISON, 40, 3));
    }
    public HunterArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.HUNTER_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
        addEffect(new MobEffectInstance(MobEffects.POISON, 40, 3));
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemRegistry.hunter_arrow.get());
    }
}
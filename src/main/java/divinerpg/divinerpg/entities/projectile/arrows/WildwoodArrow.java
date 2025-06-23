package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WildwoodArrow extends DivineArrow {
    public WildwoodArrow(EntityType<? extends DivineArrow> entityType, Level level) {
        super(entityType, level);
    }
    public WildwoodArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.WILDWOOD_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public WildwoodArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.WILDWOOD_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemRegistry.wildwood_arrow.get());
    }
    @Override
    public float getArrowPower() {
        return 10F;
    }
}
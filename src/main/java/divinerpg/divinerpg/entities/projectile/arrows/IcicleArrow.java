package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;

public class IcicleArrow extends DivineArrow {
    public IcicleArrow(EntityType<? extends DivineArrow> entityType, Level level) {
        super(entityType, level);
    }
    public IcicleArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.ICICLE_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public IcicleArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(EntityRegistry.ICICLE_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemRegistry.icicle_arrow.get());
    }
    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        if(entity instanceof LivingEntity livingEntity && !(entity instanceof EnderMan) && !(entity instanceof Player p && p.isCreative())) {
            livingEntity.setTicksFrozen(livingEntity.getTicksFrozen() + 80);
            if(livingEntity.isOnFire()) livingEntity.extinguishFire();
        } super.onHitEntity(result);
    }
}
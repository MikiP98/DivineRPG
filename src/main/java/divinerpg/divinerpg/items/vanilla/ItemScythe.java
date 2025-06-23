package divinerpg.items.vanilla;

import divinerpg.entities.projectile.magic.DivineMagicProjectile;
import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemScythe extends ItemRangedWeapon {
    public ItemScythe() {
        super(EntityRegistry.SCYTHE_SHOT::value);
        sound = SoundRegistry.DEEP_LAUGH.get();
        cooldown = 10;
        infinite = true;
    }
    private boolean isJackoman(Player player) {
        return player.getInventory().armor.get(0).is(ItemRegistry.jack_o_man_boots.get())
            && player.getInventory().armor.get(1).is(ItemRegistry.jack_o_man_leggings.get())
            && player.getInventory().armor.get(2).is(ItemRegistry.jack_o_man_chestplate.get())
            && player.getInventory().armor.get(3).is(ItemRegistry.jack_o_man_helmet.get());
    }
    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        Projectile shot = super.createProjectile(level, shooter, weapon, ammo, isCrit);
        if(shot instanceof DivineMagicProjectile d && shooter instanceof Player player && isJackoman(player)) d.baseDamage = 18F;
        return shot;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(LocalizeUtils.magicDam(6));
        super.appendHoverText(stack, context, tooltip, tooltipFlag);
    }
}
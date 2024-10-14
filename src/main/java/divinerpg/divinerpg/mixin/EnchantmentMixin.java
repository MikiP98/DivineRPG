package divinerpg.divinerpg.mixin;

import divinerpg.divinerpg.enums.ToolStats;
import divinerpg.divinerpg.items.base.ItemModSword;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {
    @Shadow protected abstract boolean canAccept(Enchantment other);

    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    private void modifyEnchantmentApplication(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() instanceof ItemModSword) {
            ItemModSword modSwordItem = (ItemModSword) stack.getItem();

            boolean isFireAspect = !canAccept(Enchantments.FIRE_ASPECT);
            if (isFireAspect && modSwordItem.sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) {
                // Prevent FIRE_ASPECT from being applied to FLAME swords
//                System.out.println("EnchantmentMixin: Preventing FIRE_ASPECT from being applied to FLAME swords");
//                System.out.println("EnchantmentMixin: isFireAspect: " + isFireAspect);
//                System.out.println("EnchantmentMixin: modSwordItem.sword.getSwordSpecial(): " + modSwordItem.sword.getSwordSpecial());
                cir.setReturnValue(false);
                cir.cancel();
//                return;
            }
//            System.out.println("EnchantmentMixin: Applying FIRE_ASPECT");
//            System.out.println("EnchantmentMixin: isFireAspect: " + isFireAspect);
//            System.out.println("EnchantmentMixin: modSwordItem.sword.getSwordSpecial(): " + modSwordItem.sword.getSwordSpecial());
        }
    }

//    /**
//     * @author Mikołaj Pokora
//     * @reason Prevent Enchantments from being applied to special swords with FLAME special
//     */
//    @Overwrite
//    public boolean isAcceptableItem(ItemStack stack) {
//        if (stack.getItem() instanceof ItemModSword) {
//            ItemModSword modSwordItem = (ItemModSword) stack.getItem();
//
//            boolean isFireAspect = !canAccept(Enchantments.FIRE_ASPECT);
//            if (isFireAspect && modSwordItem.sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) {
//                // Prevent FIRE_ASPECT from being applied to FLAME swords
//                System.out.println("EnchantmentMixin: Preventing FIRE_ASPECT from being applied to FLAME swords");
//                System.out.println("EnchantmentMixin: isFireAspect: " + isFireAspect);
//                System.out.println("EnchantmentMixin: modSwordItem.sword.getSwordSpecial(): " + modSwordItem.sword.getSwordSpecial());
//                return false;
//            }
//            System.out.println("EnchantmentMixin: Applying FIRE_ASPECT");
//            System.out.println("EnchantmentMixin: isFireAspect: " + isFireAspect);
//            System.out.println("EnchantmentMixin: modSwordItem.sword.getSwordSpecial(): " + modSwordItem.sword.getSwordSpecial());
//        }
//
//        return true;
//    }
}

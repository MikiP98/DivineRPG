package divinerpg.divinerpg.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class RiveEnchant extends Enchantment {
    public RiveEnchant() {
        super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override public int getMaxLevel() { return 3; }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override public int getMinPower(int level) { return 15 * (level + 1); }

    /**
     * Returns the maximum value of enchantability needed on the enchantment level passed.
     */
    @Override public int getMaxPower(int level) { return super.getMaxPower(level) + 50; }
}
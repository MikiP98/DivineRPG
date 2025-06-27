package divinerpg.divinerpg.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class InsulationEnchant extends Enchantment {
	public InsulationEnchant() {
		super(Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
	}

	@Override public boolean isTreasure() { return true; }
}
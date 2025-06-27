package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.enchant.AftershockEnchant;
import divinerpg.divinerpg.enchant.BrainFreezeEnchant;
import divinerpg.divinerpg.enchant.InsulationEnchant;
import divinerpg.divinerpg.enchant.RiveEnchant;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static divinerpg.divinerpg.DivineRPG.getId;

public class EnchantmentRegistry {
	public static final Enchantment
			RIVE = register("rive", new RiveEnchant()),
			AFTERSHOCK = register("aftershock", new AftershockEnchant()),
			BRAIN_FREEZE = register("brain_freeze", new BrainFreezeEnchant()),
			INSULATION = register("insulation", new InsulationEnchant());

	public static Enchantment register(String name, Enchantment enchantment) {
		return Registry.register(Registries.ENCHANTMENT, getId(name), enchantment);
	}
}
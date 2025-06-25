package divinerpg.divinerpg.registries;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static divinerpg.divinerpg.DivineRPG.getId;

public class PotionRegistry {
    public static final Potion
			TEA = register("tea", new Potion(new StatusEffectInstance(MobEffectRegistry.FREEZE_REDUCTION, 1))),
			WARMTH = register("warmth", new Potion(new StatusEffectInstance(MobEffectRegistry.WARMTH, 1800))),
			LONG_WARMTH = register("long_warmth", new Potion(new StatusEffectInstance(MobEffectRegistry.WARMTH, 2500))),
			GROG = register("grog", new Potion(new StatusEffectInstance(StatusEffects.NAUSEA, 250)));

	public static Potion register(String name, Potion potion) {
		return Registry.register(Registries.POTION, getId(name), potion);
	}
}
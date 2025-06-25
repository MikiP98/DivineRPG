package divinerpg.divinerpg.effect.mob.armor.base;

import divinerpg.divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;

public class PoisonProtectionEffect extends ArmorEffect {
	public PoisonProtectionEffect() { super(10991286); }

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity.hasStatusEffect(StatusEffects.POISON)) entity.removeStatusEffect(StatusEffects.POISON);
    }
}
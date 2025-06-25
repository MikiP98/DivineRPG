package divinerpg.divinerpg.effect.mob.armor.base;

import divinerpg.divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.entity.LivingEntity;

public class PreventFallDamageEffect extends ArmorEffect {
	public PreventFallDamageEffect() { super(10991286); }

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		entity.fallDistance = Math.min(entity.fallDistance, 0.1F);
    }
}
package divinerpg.divinerpg.effect.mob;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class WarmthEffect extends StatusEffect {
	public WarmthEffect() { super(StatusEffectCategory.BENEFICIAL, 15899441); }

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity.getFrozenTicks() > 0) entity.setFrozenTicks(0);
	}
}
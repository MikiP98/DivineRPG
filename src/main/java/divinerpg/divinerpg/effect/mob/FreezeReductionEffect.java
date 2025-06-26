package divinerpg.divinerpg.effect.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class FreezeReductionEffect extends InstantStatusEffect {
	public FreezeReductionEffect() { super(StatusEffectCategory.BENEFICIAL, 5813483); }

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

	@Override
	public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
		if (target.getFrozenTicks() > 0) target.setFrozenTicks(target.getFrozenTicks() / 4);
	}
}
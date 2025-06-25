package divinerpg.divinerpg.effect.mob.armor.arcana;

import divinerpg.divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.entity.LivingEntity;

public class VemosHealEffect extends ArmorEffect {
    public VemosHealEffect() { super(10991286); }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.heal(.1F);
    }
}
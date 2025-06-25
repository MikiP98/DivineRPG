package divinerpg.divinerpg.effect.mob.armor.iceika;

import java.util.List;

import divinerpg.divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

public class FrozenSlownessEffect extends ArmorEffect {
    public FrozenSlownessEffect() { super(10991286); }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld() instanceof ServerWorld serverWorld) {
            List<MobEntity> entities = serverWorld.getNonSpectatingEntities(MobEntity.class, new Box(entity.getPos().add(-6, -6, -6), entity.getPos().add(6, 6, 6)));
            entities.forEach(mob -> mob.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 1, true, true, false)));
        }
    }
}
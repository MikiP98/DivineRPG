package divinerpg.divinerpg.effect.mob.armor.vanilla;

import divinerpg.divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class SkelemanFeedEffect extends ArmorEffect {
	public SkelemanFeedEffect() { super(10991286); }

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if(entity instanceof ServerPlayerEntity player && player.getHungerManager().isNotFull())
			player.getHungerManager().add(1, 0);
    }
}
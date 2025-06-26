package divinerpg.divinerpg.effect.mob;

import divinerpg.divinerpg.registries.BlockRegistry;
import divinerpg.divinerpg.registries.MobEffectRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;

public class HeavyAirEffect extends StatusEffect {
	public HeavyAirEffect() { super(StatusEffectCategory.HARMFUL, 10991286); }

	@Override
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		super.onApplied(entity, attributes, amplifier);
		if (entity instanceof ServerPlayerEntity serverPlayerEntity && serverPlayerEntity.interactionManager.getGameMode() == GameMode.SURVIVAL)
			serverPlayerEntity.changeGameMode(GameMode.ADVENTURE);
	}

	@Override
	public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if (entity instanceof ServerPlayerEntity serverPlayerEntity && serverPlayerEntity.interactionManager.getGameMode() == GameMode.ADVENTURE)
			serverPlayerEntity.changeGameMode(GameMode.DEFAULT);
			// TODO: Make sure changing SURVIVAL to DEFAULT works as intended
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration == 10;
		// TODO: Make sure 'duration % 10 == 0' isn't better than current implementation from NeoForge DivineRPG
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if(entity.getWorld().getBlockState(new BlockPos(entity.getBlockX(), (int) (entity.getY() + entity.getEyeHeight(entity.getPose())), entity.getBlockZ())).isOf(BlockRegistry.dungeonAir)) {
			entity.addStatusEffect(new StatusEffectInstance(MobEffectRegistry.HEAVY_AIR, 20, 1, true, false, false));
		} if(entity instanceof ServerPlayerEntity serverPlayerEntity && serverPlayerEntity.interactionManager.getGameMode() == GameMode.ADVENTURE)
			serverPlayerEntity.changeGameMode(GameMode.DEFAULT);
			// TODO: Make sure changing SURVIVAL to DEFAULT works as intended
	}
}
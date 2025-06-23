package divinerpg.effect.mob.armor;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public interface UpdatableArmorEffect {
	void update(ResourceKey<Level> level, LivingEntity entity);
}
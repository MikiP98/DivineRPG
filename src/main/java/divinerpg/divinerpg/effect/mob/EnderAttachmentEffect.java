package divinerpg.divinerpg.effect.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EnderAttachmentEffect extends InstantStatusEffect {
    public EnderAttachmentEffect() { super(StatusEffectCategory.NEUTRAL, 10494192); }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if (source != null && attacker != null && !source.getWorld().isClient())
            teleport(source, attacker);
    }

    public void hitBlock(@Nullable Entity source, @Nullable Entity indirectSource) {
        if (source != null && indirectSource != null && !source.getWorld().isClient())
            teleport(source, indirectSource);
    }

    public static void teleport(@NotNull Entity source, @NotNull Entity indirectSource_attacker) {
        //source.changeDimension(new DimensionTransition((ServerLevel)indirectSource.level(), indirectSource.position(), source.getDeltaMovement(), source.getYRot(), source.getXRot(), false, (entity) -> {entity.playSound(SoundEvents.PLAYER_TELEPORT);}));
        source.moveToWorld((ServerWorld) indirectSource_attacker.getWorld());
        // TODO: Check this, as the fabric alternative seems too simple
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }
}
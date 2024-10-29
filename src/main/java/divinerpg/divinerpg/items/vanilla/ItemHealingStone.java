package divinerpg.divinerpg.items.vanilla;

import divinerpg.divinerpg.items.base.ItemMod;
import divinerpg.divinerpg.registries.SoundRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ItemHealingStone extends ItemMod {
    int healAmount;
    int cooldown;

    public ItemHealingStone() {
        this.healAmount = 20;
        this.cooldown = 50;
    }

    @Override public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getStackInHand(hand);
            if (!player.isCreative()) stack.decrement(1);
            player.heal(healAmount);
            // player.playSound(SoundRegistry.HEAL.get(), 1, 1);
            player.getWorld().playSound(null, player.getBlockPos(), SoundRegistry.HEAL, SoundCategory.PLAYERS, 1, 1);
//            player.awardStat(Stats.ITEM_USED.get(this));
            player.getItemCooldownManager().set(this, cooldown);
            return TypedActionResult.success(stack);
        } return super.use(level, player, hand);
    }

    private static double getRandomXZ(LivingEntity entity, double cord) {
        return (cord + (double) entity.getWidth() * (2.0d * entity.getRandom().nextDouble() - 1.0d));
    }
    private static double getRandomX(LivingEntity entity) {
        return getRandomXZ(entity, entity.getX());
    }
    private static double getRandomZ(LivingEntity entity) {
        return getRandomXZ(entity, entity.getZ());
    }
    private static double getRandomY(LivingEntity entity) {
        return entity.getY() + (double) entity.getHeight() * entity.getRandom().nextDouble();
    }
    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if(!(entity instanceof ServerPlayerEntity) && !(entity instanceof HostileEntity) && entity.getHealth() < entity.getMaxHealth() && !player.getItemCooldownManager().isCoolingDown(this)) {
            if (!player.isCreative()) stack.decrement(1);
            entity.heal(healAmount);
//            entity.playSound(SoundRegistry.HEAL, 1, 1);
            entity.getWorld().playSound(null, player.getBlockPos(), SoundRegistry.HEAL, SoundCategory.PLAYERS, 1, 1);
            for(int i = 0; i < 7; ++i) {
                double d0 = entity.getRandom().nextGaussian() * .02;
                double d1 = entity.getRandom().nextGaussian() * .02;
                double d2 = entity.getRandom().nextGaussian() * .02;
                entity.getWorld().addParticle(ParticleTypes.HEART, getRandomX(entity), getRandomY(entity) + .5, getRandomZ(entity), d0, d1, d2);
            }
            // player.awardStat(Stats.ITEM_USED.get(this));
            player.getItemCooldownManager().set(this, cooldown);
            return ActionResult.SUCCESS;
        }return super.useOnEntity(stack, player, entity, hand);
    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.healthHeal((int)(healAmount / 2)));
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//    }
}

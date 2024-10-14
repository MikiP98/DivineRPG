package divinerpg.divinerpg.items.base;

import divinerpg.divinerpg.components.ArcanaComponent;
import divinerpg.divinerpg.enums.ToolStats;
import divinerpg.divinerpg.registries.DivineComponentRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemModSword extends SwordItem {
    public int arcanaConsumedUse;
    public int arcanaConsumedAttack;
    public int cooldown;
    public ToolStats sword;

    //Have rarity
    public ItemModSword(Rarity rarity, ToolMaterial tier) {
        super(tier, 1, tier.getMiningSpeedMultiplier(), new Settings().rarity(rarity));
        sword = (ToolStats) tier;
    }
    //No rarity
    public ItemModSword(ToolMaterial tier) {
        super(tier, 1, tier.getMiningSpeedMultiplier(), new Settings());
        sword = (ToolStats) tier;
    }
    //Fire-resistant swords
    public ItemModSword(ToolMaterial tier, Settings properties) {
        super(tier, 1, tier.getMiningSpeedMultiplier(), properties);
        sword = (ToolStats) tier;
    }

    public ItemModSword setAttackArcanaConsumption(int amount) {
        arcanaConsumedAttack = amount;
        return this;
    }

    //TODO: to prevent from spam clicking to inflict effects on targets that weren't hurt
    @Override public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW) {
//            if (attacker instanceof PlayerEntity) {
//                PlayerEntity player = (PlayerEntity) attacker;
//                player.sendMessage(Text.of("Slowing target for " + sword.effectSec + " seconds (level " + sword.effectPower + ")"), false);
//            }
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, sword.effectSec * 20, sword.effectPower, false, true), attacker);
        }
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.POISON) {
//            if (attacker instanceof PlayerEntity) {
//                PlayerEntity player = (PlayerEntity) attacker;
//                player.sendMessage(Text.of("Poisoning target for " + sword.effectSec + " seconds (level " + sword.effectPower + ")"), false);
//            }
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, sword.effectSec * 20, sword.effectPower, false, true), attacker);
        }
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) {
//            if (attacker instanceof PlayerEntity) {
//                PlayerEntity player = (PlayerEntity) attacker;
//                player.sendMessage(Text.of("Flaming target for " + sword.effectSec + " seconds"), false);
//            }
            target.setOnFireFor(sword.effectSec);
        }
        return super.postHit(stack, target, attacker);
    }

    public void arcanicAttack(ItemStack stack, PlayerEntity player, Entity entity) {}
    protected TypedActionResult<ItemStack> arcanicUse(World level, PlayerEntity player, Hand hand){
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ArcanaComponent arcana = DivineComponentRegistry.getArcana(player);
        if (arcanaConsumedUse != 0) {
            if (!(arcana.tryUse(arcanaConsumedUse, cooldown))) {
                player.sendMessage(Text.of("Insufficient Arcana or cooldown remaining"), true);
                return super.use(level, player, hand);
            }
            player.sendMessage(Text.of("Arcana used"), true);
            player.getItemCooldownManager().set(this, cooldown);
//            player.awardStat(Stats.ITEM_USED.get(this));
            return arcanicUse(level, player, hand);
        }
        player.sendMessage(Text.of("Arcana not used"), true);
        return super.use(level, player, hand);
    }

    // Done in a mixin `EnchantmentMixin`
//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
//        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME && enchantment == Enchantments.FIRE_ASPECT ||
//                sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW && enchantment == EnchantmentRegistry.BRAIN_FREEZE.get()) return false;
//        else return enchantment.category.canEnchant(stack.getItem());
//    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.ARCANA_DAMAGE) tooltip.add(LocalizeUtils.weakenedWithoutArcana());
//        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) tooltip.add(LocalizeUtils.burn(sword.effectSec));
//        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.LIGHTNING) tooltip.add(LocalizeUtils.lightningShots());
//        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.POISON) tooltip.add(LocalizeUtils.poison(sword.effectSec));
//        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW) tooltip.add(LocalizeUtils.slow(sword.effectSec));
//        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SPEED) tooltip.add(LocalizeUtils.i18n("shadow_saber"));
//        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
//        if(arcanaConsumedAttack > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
//        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
//    }
}

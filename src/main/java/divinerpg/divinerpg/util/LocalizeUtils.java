package divinerpg.divinerpg.util;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;

public class LocalizeUtils {
    private static final String
            Ammo = "ammo",
            ArcanaConsuming = "arcana",
            ArcanaDamage = "damage.arcana",
            ArcanaRegen = "arcana.regen",
            BaseDamage = "damage.base",
            BowFasterPull = "bow_speed.faster",
            BowSlowerPull = "bow_speed.slower",
            BurnMobs = "effect.burns",
            Cool = "cool",
            Efficiency = "tool.efficiency",
            HarvestLevel = "tool.harvest_level",
            HealthHeal = "heals",
            HealthRegen = "health.regen",
            HitEnder = "hit_ender",
            InfiniteAmmo = "ammo.infinite",
            InstantConsumption = "instant_consumption",
            LessDrag = "less_drag",
            LightningShot = "lightning_shot",
            MagicDamage = "damage.magic",
            OnUseDamage = "damage.use",
            Poison = "effect.poisons",
            Pull = "pull",
            Push = "push",
            RangedDamage = "damage.ranged",
            ReturnsToSender = "return",
            ShootingPower = "ranged.power",
            ShotsBlinding = "shots.blind",
            ShotsBouncing = "shots.bounce",
            ShotsBurning = "shots.burn",
            ShotsExplosive = "shots.explosive",
            ShotsHoming = "shots.homing",
            ShotsSky = "shots.sky",
            ShotsSplit = "shots.split",
            SlowMobs = "effect.slows",
            Summoned = "summon",
            SummonedDamage = "summon.damage",
            SummonedDespawn = "summon.despawn",
            SummonedHealth = "summon.health",
            TeleportAttached = "effect.teleport",
            WeakenedWithoutArcana = "weakened_without_arcana";

    // Component -> Text

    /**
     * Indicates what ammunition is required.
     *
     * @param ammo - ammunition
     */
    public static Text ammo(Item ammo) {
        Text ammoName = MutableText.of(new TranslatableTextContent(ammo.getTranslationKey(), null, null));
        return i18n(Formatting.WHITE, Ammo, ammoName);
    }

    /**
     * Indicates how much arcana is being consumed.
     *
     * @param arcana - arcana amount
     */
    public static Text arcanaConsumed(Object arcana) { return i18n(Formatting.AQUA, ArcanaConsuming, arcana); }

    /**
     * Indicates how much damage the arcana deals.
     *
     * @param damage - arcana damage
     */
    public static Text arcanaDam(Object damage) { return i18n(Formatting.DARK_AQUA, ArcanaDamage, damage); }

    /**
     * Indicates how much arcana is restored when used.
     *
     * @param arcana - arcana amount
     */
    public static Text arcanaRegen(int arcana) { return i18n(Formatting.AQUA, ArcanaRegen, arcana); }

    /**
     * Indicates that the projectiles are bouncing.
     */
    public static Text bouncingShots() { return LocalizeUtils.i18n(Formatting.GOLD, ShotsBouncing); }

    /**
     * Indicates how long the entity will burn.
     *
     * @param seconds - burning duration
     */
    public static Text burn(int seconds) { return i18n(Formatting.DARK_RED, BurnMobs, seconds); }

    /**
     * Indicates that the weapon shoots flaming arrows.
     */
    public static Text burningShots() { return i18n(Formatting.RED, ShotsBurning); }

    /**
     * Indicates the efficiency of the tools.
     *
     * @param eff - efficiency
     */
    public static Text efficiency(int eff) { return i18n(Formatting.WHITE, Efficiency, eff); }

    /**
     * Indicates that the projectiles are explosive.
     */
    public static Text explosiveShots() { return LocalizeUtils.i18n(Formatting.GOLD, ShotsExplosive); }

    /**
     * Creates message from server to translate on client.
     *
     * @param string - lang key
     */
    public static Text getClientSideTranslation(String string, final Object... argument) {
        return Text.translatable(string, argument);
    }

    /**
     * Indicates the harvest level of the tools.
     *
     * @param lvl - harvest level
     */
    public static Text harvestLevel(Text lvl) { return i18n(Formatting.WHITE, HarvestLevel, lvl); }

    /**
     * Indicates how much health is restored when used.
     */
    public static Text healthHeal(Object health) { return i18n(Formatting.RED, HealthHeal, health); }

    /**
     * Indicates how much health is restored when used.
     */
    public static Text healthRegen(Object health) { return i18n(Formatting.RED, HealthRegen, health); }

    /**
     * Indicates that the projectiles are homing.
     */
    public static Text homingShots() { return i18n(Formatting.GOLD, ShotsHoming); }

    /**
     * Indicates that no ammo is required.
     */
    public static Text infiniteAmmo() { return i18n(Formatting.BLUE, InfiniteAmmo); }

    /**
     * Indicates that the bowstring pull is faster than usual.
     *
     * @param speed - pull speed
     */
    public static Text bowFasterPull(float speed) { return i18n(Formatting.DARK_GREEN, BowFasterPull, speed); }

    /**
     * Indicates that the bowstring pull is slower than usual.
     *
     * @param speed - pull speed
     */
    public static Text bowSlowerPull(float speed) { return i18n(Formatting.RED, BowSlowerPull, speed); }

    /**
     * Indicates the speed of the shot projectiles.
     */
    public static Text shootingPower(float power) { return i18n(Formatting.DARK_GREEN, ShootingPower, power); }

    /**
     * Indicates the base damage of the shot projectiles.
     */
    public static Text baseDamage(int damage) { return i18n(Formatting.DARK_GREEN, BaseDamage, damage);}

    /**
     * Indicates that the item is consumed instantly.
     */
    public static Text instantConsumption() { return i18n(Formatting.AQUA, InstantConsumption); }

    /**
     * Indicates that the weapon shoots lightning bolts when used.
     */
    public static Text lightningShots() { return i18n(Formatting.YELLOW, LightningShot); }

    /**
     * Indicates how much damage the magic deals.
     *
     * @param damage - magic damage
     */
    public static Text magicDam(Object damage) { return i18n(Formatting.DARK_PURPLE, MagicDamage, damage); }

    /**
     * Indicates how much damage the user takes.
     *
     * @param damage - on use damage
     */
    public static Text onUseDam(Object damage) { return i18n(Formatting.RED, OnUseDamage, damage); }

    /**
     * Indicates how long the poison effect will last.
     *
     * @param seconds - effect duration
     */
    public static Text poison(int seconds) { return i18n(Formatting.DARK_GREEN, Poison, seconds); }

    /**
     * Indicates that the item pulls mobs towards the player.
     */
    public static Text pull() { return i18n(Pull); }

    /**
     * Indicates that the item knocks mobs away.
     */
    public static Text push() { return i18n(Push); }

    /**
     * Indicates how much damage the non-arrow projectiles do.
     *
     * @param damage - damage amount
     */
    public static Text rangedDam(Object damage) { return i18n(Formatting.DARK_GREEN, RangedDamage, damage); }

    /**
     * Indicates that the projectile returns back to the sender.
     */
    public static Text returnsToSender() { return i18n(ReturnsToSender); }

    /**
     * Indicates how long the slowness effect will last.
     *
     * @param seconds - effect duration
     */
    public static Text slow(int seconds) { return i18n(Formatting.DARK_AQUA, SlowMobs, seconds); }

    /**
     * Indicates how long the weapon shoots blinding projectiles.
     *
     * @param seconds - effect duration
     */
    public static Text blind(int seconds) { return i18n(Formatting.BLACK, ShotsBlinding, seconds); }

    /**
     * Indicates whether mobs get cooled.
     */
    public static Text cool() { return i18n(Formatting.AQUA, Cool); }

    /**
     * Indicates that the object experiences less drag
     */
    public static Text lessDrag() { return i18n(Formatting.DARK_GRAY, LessDrag); }

    /**
     * Indicates whether ender creatures can be hit.
     */
    public static Text hitEnder() { return i18n(Formatting.DARK_PURPLE, HitEnder); }

    /**
     * Indicates that the weapon teleports the shooter to where the projectile hit.
     */
    public static Text teleportAttached() { return i18n(Formatting.LIGHT_PURPLE, TeleportAttached); }

    /**
     * Indicates that the projectiles are splitting upon hitting something.
     */
    public static Text splitShots(int count) { return LocalizeUtils.i18n(Formatting.GOLD, ShotsSplit, count); }

    /**
     * Indicates that the item shoots objects from the sky.
     *
     * @param count - amount of objects
     */
    public static Text skyShots(Object count) { return i18n(Formatting.GOLD, ShotsSky, count); }

    /**
     * Specifies the summoned entity.
     *
     * @param entity - summoned entity
     */
    public static Text summoned(EntityType<?> entity) {
        Text name = MutableText.of(new TranslatableTextContent(entity.getTranslationKey(), null, new Object[0]));
        return i18n(Summoned, name);
    }

    /**
     * Specifies the damage of the summoned entity.
     *
     * @param damage - entity's damage
     */
    public static Text summonedDamage(int damage) { return i18n(Formatting.DARK_GREEN, SummonedDamage, damage); }

    /**
     * Specifies that the summoned entity disappears after a while.
     */
    public static Text summonedDespawn() { return i18n(Formatting.BLUE, SummonedDespawn); }

    /**
     * Specifies the health of the summoned entity.
     *
     * @param health - entity's health
     */
    public static Text summonedHealth(int health) { return i18n(Formatting.RED, SummonedHealth, health); }

    /**
     * Indicates that the item is weakened without the arcana.
     */
    public static Text weakenedWithoutArcana() { return i18n(Formatting.RED, WeakenedWithoutArcana); }

    /**
     * Returns translated text.
     * @param color - text color
     * @param text - lang key
     * @param args - string format arguments
     */
    public static Text i18n(Formatting  color, String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableText result = MutableText.of(new TranslatableTextContent(String.format("tooltip.divinerpg.%s", text), null, args));
        return result.formatted(color);
    }
    public static Text i18n(String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableText result = MutableText.of(new TranslatableTextContent(String.format("tooltip.divinerpg.%s", text), null, args));
        return result.formatted(Formatting.GRAY);
    }
    public static Text clientMessage(Formatting color, String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableText result = MutableText.of(new TranslatableTextContent(String.format("message.divinerpg.%s", text), null, args));
        return result.formatted(color);
    }
    public static Text clientMessage(String text, Object... args) {
        if(args == null) {args = new Object[0];}
        MutableText result = MutableText.of(new TranslatableTextContent(String.format("message.divinerpg.%s", text), null, args));
        return result.formatted(Formatting.WHITE);
    }
}
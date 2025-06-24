package divinerpg.divinerpg.util;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodList {
    public static final FoodComponent
        ADVANCED_MUSHROOM_STEW = (new FoodComponent.Builder()).hunger(10).saturationModifier(.6F).build(),
        BACON = (new FoodComponent.Builder()).hunger(1).saturationModifier(.2F).build(),
        BOILED_EGG = (new FoodComponent.Builder()).hunger(4).saturationModifier(.1F).build(),
        CHEESE = (new FoodComponent.Builder()).hunger(4).saturationModifier(.4F).build(),
        CHICKEN_DINNER = (new FoodComponent.Builder()).hunger(20).saturationModifier(.5F).build(),
        DONUT = (new FoodComponent.Builder()).hunger(4).saturationModifier(.5F).build(),
        HOT_PUMPKIN_PIE = (new FoodComponent.Builder()).hunger(9).saturationModifier(.3F).build(),
        TOMATO = (new FoodComponent.Builder()).hunger(4).saturationModifier(.3F).build(),
        WHITE_MUSHROOM = (new FoodComponent.Builder()).hunger(2).saturationModifier(.1F).build(),

    //Iceika
        EGG_NOG = (new FoodComponent.Builder()).hunger(4).saturationModifier(.8F).build(),
        CAULDRON_FLESH = new FoodComponent.Builder().hunger(3).saturationModifier(.3F)
                .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), .8F).build(),
        CHOCOLATE_LOG = (new FoodComponent.Builder()).hunger(5).saturationModifier(.7F).build(),
        FRUIT_CAKE = (new FoodComponent.Builder()).hunger(8).saturationModifier(.3F).build(),
        PEPPERMINTS = (new FoodComponent.Builder()).hunger(1).saturationModifier(.4F).build(),
        RAW_SENG_MEAT = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3F).build(),
        COOKED_SENG_STEAK = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6F).build(),
        SNOW_CONES = (new FoodComponent.Builder()).hunger(3).saturationModifier(.4F).build(),
        WINTERBERRY = (new FoodComponent.Builder()).hunger(3).saturationModifier(.1F).build(),
        RAW_WOLPERTINGER_MEAT = (new FoodComponent.Builder()).hunger(3).saturationModifier(.3F).build(),
        COOKED_WOLPERTINGER_STEAK = (new FoodComponent.Builder()).hunger(6).saturationModifier(.6F).build(),

    //Arcana
        HITCHAK = (new FoodComponent.Builder()).hunger(4).saturationModifier(.4F).build(),
        LAMONA = (new FoodComponent.Builder()).hunger(4).saturationModifier(.4F).build(),
        PINFLY = (new FoodComponent.Builder()).hunger(4).saturationModifier(.3F)
                .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 30, 2), 1).build(),
        VEILO = (new FoodComponent.Builder()).hunger(4).saturationModifier(.3F)
                .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 30, 0), 1).build(),
        WEAK_ARCANA_POTION = (new FoodComponent.Builder()).alwaysEdible().build(),
        STRONG_ARCANA_POTION = (new FoodComponent.Builder()).alwaysEdible().build(),

    //Eden
        RAW_EMPOWERED_MEAT = (new FoodComponent.Builder()).hunger(3).saturationModifier(.4F).build(),
        EMPOWERED_MEAT = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).build(),
        FORBIDDEN_FRUIT = (new FoodComponent.Builder()).hunger(4).saturationModifier(.3F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 3), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 120, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 1), 1).build(),

    //Wildwood
        MAGIC_MEAT = (new FoodComponent.Builder()).hunger(5).saturationModifier(.8F).build(),
        MOONBULB = (new FoodComponent.Builder()).hunger(3).saturationModifier(.5F).build(),

    //Apalachia
        ENRICHED_MAGIC_MEAT = (new FoodComponent.Builder()).hunger(7).saturationModifier(.8F).build(),
        PURPLE_GLOWBONE = (new FoodComponent.Builder()).hunger(3).saturationModifier(.5F).build(),
        PINK_GLOWBONE = (new FoodComponent.Builder()).hunger(3).saturationModifier(.5F).build(),

    //Skythern
        SKY_FLOWER = (new FoodComponent.Builder()).hunger(3).saturationModifier(.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 600, 0), 1).build(),

    //Vethea
        DREAM_CAKE = (new FoodComponent.Builder()).hunger(8).saturationModifier(.8F).build(),
        DREAM_CARROT = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6F).build(),
        DREAM_MELON = (new FoodComponent.Builder()).hunger(6).saturationModifier(.8F).build(),
        DREAM_PIE = (new FoodComponent.Builder()).hunger(8).saturationModifier(.3F).build(),
        DREAM_SWEETS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0).build(),
        DREAM_SOURS = (new FoodComponent.Builder()).hunger(8).saturationModifier(0).build(),
        HONEYCHUNK = (new FoodComponent.Builder()).hunger(1).saturationModifier(.3F).build(),
        HONEYSUCKLE = (new FoodComponent.Builder()).hunger(1).saturationModifier(.3F).build();
}
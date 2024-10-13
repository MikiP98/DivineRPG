package divinerpg.divinerpg.util;

import net.minecraft.item.FoodComponent;

public class FoodList {
    public static final FoodComponent ADVANCED_MUSHROOM_STEW = (new FoodComponent.Builder()).hunger(10).saturationModifier(.6F).build();
    public static final FoodComponent BACON = (new FoodComponent.Builder()).hunger(5).saturationModifier(.2F).build();
    public static final FoodComponent BOILED_EGG = (new FoodComponent.Builder()).hunger(4).saturationModifier(.1F).build();
    public static final FoodComponent CHEESE = (new FoodComponent.Builder()).hunger(4).saturationModifier(.4F).build();
    public static final FoodComponent CHICKEN_DINNER = (new FoodComponent.Builder()).hunger(20).saturationModifier(.5F).build();
    public static final FoodComponent DONUT = (new FoodComponent.Builder()).hunger(4).saturationModifier(.5F).build();
    public static final FoodComponent HOT_PUMPKIN_PIE = (new FoodComponent.Builder()).hunger(9).saturationModifier(.3F).build();
    public static final FoodComponent TOMATO = (new FoodComponent.Builder()).hunger(4).saturationModifier(.3F).build();
    public static final FoodComponent WHITE_MUSHROOM = (new FoodComponent.Builder()).hunger(2).saturationModifier(.1F).build();

    //Iceika
    public static final FoodComponent EGG_NOG = (new FoodComponent.Builder()).hunger(4).saturationModifier(.8F).build();
    public static final FoodComponent CAULDRON_FLESH = (new FoodComponent.Builder()).hunger(3).saturationModifier(.3F).meat().build();
    public static final FoodComponent CHOCOLATE_LOG = (new FoodComponent.Builder()).hunger(5).saturationModifier(.7F).build();
    public static final FoodComponent FRUIT_CAKE = (new FoodComponent.Builder()).hunger(8).saturationModifier(.3F).build();
    public static final FoodComponent PEPPERMINTS = (new FoodComponent.Builder()).hunger(1).saturationModifier(.4F).build();
    public static final FoodComponent RAW_SENG_MEAT = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3F).meat().build();
    public static final FoodComponent COOKED_SENG_STEAK = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6F).meat().build();
    public static final FoodComponent SNOW_CONES = (new FoodComponent.Builder()).hunger(3).saturationModifier(.4F).build();
    public static final FoodComponent WINTERBERRY = (new FoodComponent.Builder()).hunger(3).saturationModifier(.1F).build();
    public static final FoodComponent RAW_WOLPERTINGER_MEAT = (new FoodComponent.Builder()).hunger(3).saturationModifier(.3F).meat().build();
    public static final FoodComponent COOKED_WOLPERTINGER_STEAK = (new FoodComponent.Builder()).hunger(6).saturationModifier(.6F).meat().build();

    //Arcana
    public static final FoodComponent HITCHAK = (new FoodComponent.Builder()).hunger(4).saturationModifier(.4F).build();
    public static final FoodComponent PINFLY = (new FoodComponent.Builder()).hunger(4).saturationModifier(.3F).build();  // .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 2), 1);
    public static final FoodComponent WEAK_ARCANA_POTION = (new FoodComponent.Builder()).alwaysEdible().build();
    public static final FoodComponent STRONG_ARCANA_POTION = (new FoodComponent.Builder()).alwaysEdible().build();

    //Eden
    public static final FoodComponent RAW_EMPOWERED_MEAT = (new FoodComponent.Builder()).hunger(3).saturationModifier(.4F).meat().build();
    public static final FoodComponent EMPOWERED_MEAT = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).meat().build();
    public static final FoodComponent FORBIDDEN_FRUIT = (new FoodComponent.Builder()).hunger(4).saturationModifier(.3F).build();

    //Wildwood
    public static final FoodComponent MAGIC_MEAT = (new FoodComponent.Builder()).hunger(5).saturationModifier(.8F).meat().build();
    public static final FoodComponent MOONBULB = (new FoodComponent.Builder()).hunger(3).saturationModifier(.5F).build();

    //Apalachia
    public static final FoodComponent ENRICHED_MAGIC_MEAT = (new FoodComponent.Builder()).hunger(7).saturationModifier(.8F).meat().build();
    public static final FoodComponent PURPLE_GLOWBONE = (new FoodComponent.Builder()).hunger(3).saturationModifier(.5F).build();
    public static final FoodComponent PINK_GLOWBONE = (new FoodComponent.Builder()).hunger(3).saturationModifier(.5F).build();

    //Skythern
    public static final FoodComponent SKY_FLOWER = (new FoodComponent.Builder()).hunger(3).saturationModifier(.2F).build();  // .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 1)

    //Vethea
    public static final FoodComponent DREAM_CAKE = (new FoodComponent.Builder()).hunger(8).saturationModifier(.8F).build();
    public static final FoodComponent DREAM_CARROT = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6F).build();
    public static final FoodComponent DREAM_MELON = (new FoodComponent.Builder()).hunger(6).saturationModifier(.8F).build();
    public static final FoodComponent DREAM_PIE = (new FoodComponent.Builder()).hunger(8).saturationModifier(.3F).build();
    public static final FoodComponent DREAM_SWEETS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0).build();
    public static final FoodComponent DREAM_SOURS = (new FoodComponent.Builder()).hunger(8).saturationModifier(0).build();
    public static final FoodComponent HONEYCHUNK = (new FoodComponent.Builder()).hunger(1).saturationModifier(.3F).build();
    public static final FoodComponent HONEYSUCKLE = (new FoodComponent.Builder()).hunger(1).saturationModifier(.3F).build();
}

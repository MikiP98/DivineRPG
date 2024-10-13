package divinerpg.divinerpg.enums;

import divinerpg.divinerpg.registries.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ToolStats implements ToolMaterial {
    APALACHIA_BLADE(4, 2540, -2.4F, 25, 22, ItemRegistry.apalachia_gem),
    AQUATON(2, 992, -2.4F, 6.5F, 10, ItemRegistry.aquatic_ingot),
    AQUATOOTH_MAUL(2, 1524, -2.7F, 10.5F, 10, ItemRegistry.liopleurodon_teeth),
    AQUATOOTH_SWORD(2, 1245, -2.4F, 7.5F, 10, ItemRegistry.liopleurodon_teeth),
    AQUA_DAGGER(2, 535, -2, 3.5F, 12, ItemRegistry.aquatic_ingot),
    AQUA_MAUL(2, 1058, -2.7F, 9.2F, 10, ItemRegistry.aquatic_ingot),
    AQUA_TRIDENT(2, 843, -2.4F, 6, 10, ItemRegistry.aquatic_ingot),
    ARCANITE_BLADE(4, 2048, -2.4F, 6, 15, ItemRegistry.arcanium, SwordSpecial.ARCANA_DAMAGE, 8, 0),
    ARCANIUM_SABER(3, -2.4F, 5, SwordSpecial.ARCANA_DAMAGE, 7, 0),
    ARLEMITE_STABBER(3, 1535, -2.4F, 5, 10, ItemRegistry.arlemite_ingot),
    BEDROCK_MAUL(4, -2.7F, 11.5F),
    BEDROCK_SWORD(4, -2.4F, 8),
    BLOODGEM_SWORD(3, -2.4F, 5.2F),
    BOWHEAD_ANCHOR(2, 768, -3, 8, 15, ItemRegistry.whale_fin),
    CORRUPTED_MAUL(4, 2948, -2.7F, 11.1F, 15, ItemRegistry.corrupted_stone),
    CRABCLAW_MAUL(2, 1025, -2.7F, 6.1F, 13, ItemRegistry.crab_claw),
    CRAB_ANCHOR(2, 384, -3, 6, 15, ItemRegistry.crab_claw),
    CYCLOPSIAN_SWORD(2, 300, -2.4F, 4, 14, ItemRegistry.cyclops_eye),
    DEATH_BRINGER(4, 1545, -2.4F, 7.3F, 15, ItemRegistry.corrupted_stone),
    DIVINE_SWORD(4, -2.4F, 13),
    DUAL_CLAW(2, 822, -2.3F, 5.2F, 10, ItemRegistry.crab_claw),
    EDEN_BLADE(4, 2124, -2.4F, 17, 22, ItemRegistry.eden_gem),
    ENDERICE(4, -2.4F, 13, SwordSpecial.SLOW, 1, 3),
    ENDER_SWORD(4, 2556, -2.4F, 12, 10, ItemRegistry.ender_stone),
    FLAMING_FURY(4, 3025, -2.3F, 10, 16, ItemRegistry.molten_stone, SwordSpecial.FLAME, 0, 15),
    FROSSIVENCE(0, 270, -2.4F, -1, 0, ItemRegistry.snowflake, SwordSpecial.HEAL, 0, 0),
    FROSTKING_SWORD(3, 1521, -2.4F, 6.5F, 13, ItemRegistry.snowflake),
    FROST_SWORD(3, 1226, -2.4F, 5.1F, 10, ItemRegistry.ice_stone, SwordSpecial.SLOW, 1, 3),
    FROZEN_MAUL(4, -2.7F, 12.5F, SwordSpecial.SLOW, 1, 3),
    FURY_MAUL(4, 3127, -2.8F, 14, 15, Items.DIAMOND),
    GLACIAL_BLADE(3, 1232, -2.3F, 11, 13, ItemRegistry.snowflake, SwordSpecial.SLOW, 4, 2),
    GLACIER_SWORD(3, 1021, -2.6F, 7, 13, ItemRegistry.snowflake, SwordSpecial.SLOW, 1, 3),
    HALITE_BLADE(4, 3187, -2.4F, 34, 22, ItemRegistry.mortum_gem),
    ICICLE_BANE(3, 1622, -2.5F, 6, 13, ItemRegistry.snowflake, SwordSpecial.SLOW, 1, 3),
    ICICLE_DAGGER(4, 4, -2, 20, 13, Items.AIR),
    ICINE_SWORD(4, -2.4F, 14, SwordSpecial.SLOW, 1, 3),
    INFERNO_SWORD(2, -2.4F, 5.2F, SwordSpecial.FLAME, 0, 12),
    JUNGLE_KNIFE(3, 1292, -2.4F, 5.2F, 10, ItemRegistry.jungle_stone, SwordSpecial.POISON, 1, 3),
    JUNGLE_RAPIER(3, 1425, -2.4F, 6, 12, ItemRegistry.jungle_stone, SwordSpecial.POISON, 1, 4),
    LIOPLEURODON_ANCHOR(2, 960, -3, 9, 15, ItemRegistry.liopleurodon_teeth),
    LIVICIA_SWORD(4, 3223, -2.4F, 15.5F, 16, ItemRegistry.shadow_stone),
    MASSIVENCE(0, 60, -2.4F, -1, 0, ItemRegistry.bloodgem, SwordSpecial.HEAL, 0, 0),
    MOLTEN_SWORD(3, 1297, -2.4F, 5.4F, 10, ItemRegistry.molten_stone, SwordSpecial.FLAME, 0, 5),
    MORTUM_BLADE(4, 2922, -2.4F, 31, 22, ItemRegistry.mortum_gem),
    OCEAN_KNIFE(2, 678, -2.4F, 5.4F, 10, ItemRegistry.aquatic_ingot),
    PALAVENCE(0, 60, -2.4F, -1, 0, ItemRegistry.realmite_ingot, SwordSpecial.HEAL, 0, 0),
    POISON_SABER(3, 1315, -2.4F, 6.5F, 15, ItemRegistry.jungle_stone, SwordSpecial.POISON, 1, 5),
    REALMITE_SWORD(2, 325, -2.4F, 4.5F, 14, ItemRegistry.realmite_ingot),
    RUPEE_RAPIER(3, 1634, -2.4F, 5.5F, 14, ItemRegistry.rupee_ingot),
    SABEAR_SABRE(2, 982, -2.3F, 4.4F, 15, ItemRegistry.sabear_tooth),
    SANDSLASH(4, 100, -2.4F, 16, 15, ItemRegistry.divine_stone),
    SCORCHING_SWORD(4, 1212, -2.4F, 6.2F, 15, ItemRegistry.purple_blaze),
    SHADOW_SABER(3, -2.2F, 10, SwordSpecial.SPEED, 1, 5),
    SHARK_ANCHOR(2, 576, -3, 7, 15, ItemRegistry.shark_fin),
    SHARK_SWORD(2, 627, -2.4F, 5.5F, 10, ItemRegistry.aquatic_ingot),
    SKYTHERN_BLADE(4, 2783, -2.4F, 29, 22, ItemRegistry.skythern_gem),
    SLIME_SWORD(2, 739, -2.6F, 6.5F, 10, Items.DIAMOND),
    SNOWSLASH(4, 150, -2.4F, 17, 15, ItemRegistry.snowflake, SwordSpecial.SLOW, 1, 3),
    SOULFIRE_SWORD(4, 1623, -2.4F, 7, 15, ItemRegistry.soulfire_stone),
    STORM_SWORD(3, -2.4F, 5, SwordSpecial.LIGHTNING, 0, 0),
    TERRAN_DAGGER(3, 425, -2, 3.4F, 12, ItemRegistry.terran_stone),
    TERRAN_KNIFE(3, 1257, -2.4F, 5.1F, 10, ItemRegistry.terran_stone),
    TERRAN_MAUL(3, 1476, -2.7F, 7.4F, 10, ItemRegistry.terran_stone),
    WILDWOOD_BLADE(4, 2342, -2.4F, 21, 22, ItemRegistry.wildwood_gem),

    //Dream Tools
    DREAM_SHOVEL(4, 513, 8, 4, 5, Items.AIR),
    DREAM_PICKAXE(4, 513, 8, 3.5F, 5, Items.AIR),
    DREAM_AXE(4, 513, 8, 8, 5, Items.AIR),

    //Shickaxes
    APALACHIA_SHICKAXE(4, 3540, 25, 12, 22, ItemRegistry.apalachia_chunk),
    ARLEMITE_SHICKAXE(3, 2535, 8, 3.2F, 10, ItemRegistry.arlemite_ingot),
    CORRUPTED_SHICKAXE(4, 3065, 10, 5, 15, ItemRegistry.corrupted_stone),
    DIVINE_SHICKAXE(4, 13, 7),
    EDEN_SHICKAXE(4, 3124, 15, 9, 22, ItemRegistry.eden_chunk),
    HALITE_SHICKAXE(4, 40, 16),
    MORTUM_SHICKAXE(4, 3922, 35, 15, 22, ItemRegistry.mortum_chunk),
    RUPEE_SHICKAXE(3, 2634, 8, 3.5F, 14, ItemRegistry.rupee_ingot),
    SKYTHERN_SHICKAXE(4, 3783, 30, 14, 22, ItemRegistry.skythern_chunk),
    TERRAN_SHICKAXE(3, 2586, 8, 3.3F, 10, ItemRegistry.terran_stone),
    WILDWOOD_SHICKAXE(4, 3342, 20, 11, 22, ItemRegistry.wildwood_chunk),

    //Axes
    APALACHIA_AXE(4, 2540, 25, 29, 22, ItemRegistry.apalachia_gem),
    ARLEMITE_AXE(3, 1535, 8, 8, 10, ItemRegistry.arlemite_ingot),
    BEDROCK_AXE(4, 11, 11),
    CORRUPTED_AXE(4, 2065, 10, 10.3F, 15, ItemRegistry.corrupted_stone),
    DIVINE_AXE(4, 13, 16.5F),
    EDEN_AXE(4, 2124, 15, 21, 22, ItemRegistry.eden_gem),
    MORTUM_AXE(4, 2922, 35, 36, 22, ItemRegistry.mortum_gem),
    REALMITE_AXE(2, 325, 7, 8, 14, ItemRegistry.realmite_ingot),
    RUPEE_AXE(3, 1634, 8, 8.5F, 14, ItemRegistry.rupee_ingot),
    SKYTHERN_AXE(4, 2783, 30, 34, 22, ItemRegistry.skythern_gem),
    TERRAN_AXE(3, 1586, 8, 8.2F, 10, ItemRegistry.terran_stone),
    WILDWOOD_AXE(4, 2342, 20, 25, 22, ItemRegistry.wildwood_gem),

    //Pickaxes
    APALACHIA_PICKAXE(4, 2540, 25, 10, 22, ItemRegistry.apalachia_gem),
    ARLEMITE_PICKAXE(3, 1535, 8, 4, 10, ItemRegistry.arlemite_ingot),
    BEDROCK_PICKAXE(4, 11, 6),
    CORRUPTED_PICKAXE(4, 2065, 10, 5.5F, 15, ItemRegistry.corrupted_stone),
    DIVINE_PICKAXE(4, 13, 7),
    EDEN_PICKAXE(4, 2124, 15, 8, 22, ItemRegistry.eden_gem),
    MORTUM_PICKAXE(4, 2922, 35, 12, 22, ItemRegistry.mortum_gem),
    REALMITE_PICKAXE(2, 325, 7, 3.5F, 14, ItemRegistry.realmite_ingot),
    OXDRITE_PICKAXE(2, 347, 7, 3.5F, 14, ItemRegistry.oxdrite_ingot),
    RUPEE_PICKAXE(3, 1634, 8, 4.5F, 14, ItemRegistry.rupee_ingot),
    SKYTHERN_PICKAXE(4, 2783, 30, 11, 22, ItemRegistry.skythern_gem),
    TERRAN_PICKAXE(3, 1586, 8, 4.1F, 10, ItemRegistry.terran_stone),
    WILDWOOD_PICKAXE(4, 2342, 20, 9, 22, ItemRegistry.wildwood_gem),

    //Shovels
    APALACHIA_SHOVEL(4, 2540, 25, 10.5F, 22, ItemRegistry.apalachia_gem),
    ARLEMITE_SHOVEL(3, 1535, 8, 4.5F, 10, ItemRegistry.arlemite_ingot),
    BEDROCK_SHOVEL(4, 11, 6.5F),
    CORRUPTED_SHOVEL(4, 2065, 10, 6, 15, ItemRegistry.corrupted_stone),
    DIVINE_SHOVEL(4, 13, 7.5F),
    EDEN_SHOVEL(4, 2124, 15, 8.5F, 22, ItemRegistry.eden_gem),
    MORTUM_SHOVEL(4, 2922, 35, 12.5F, 22, ItemRegistry.mortum_gem),
    REALMITE_SHOVEL(2, 325, 7, 4, 14, ItemRegistry.realmite_ingot),
    RUPEE_SHOVEL(3, 1634, 8, 5, 14, ItemRegistry.rupee_ingot),
    SKYTHERN_SHOVEL(4, 2783, 30, 11.5F, 22, ItemRegistry.skythern_gem),
    TERRAN_SHOVEL(3, 1586, 8, 4.7F, 10, ItemRegistry.terran_stone),
    WILDWOOD_SHOVEL(4, 2342, 20, 9.5F, 22, ItemRegistry.wildwood_gem),

    //Hoes
    APALACHIA_HOE(4, 2540, 25, 2, 22, ItemRegistry.apalachia_gem),
    ARLEMITE_HOE(3, 1535, 8, 0, 10, ItemRegistry.arlemite_ingot),
    BEDROCK_HOE(4, 11, .5F),
    CORRUPTED_HOE(4, 2065, 10, .5F, 15, ItemRegistry.corrupted_stone),
    DIVINE_HOE(4, 13, 1),
    EDEN_HOE(4, 2124, 15, 2, 22, ItemRegistry.eden_gem),
    MORTUM_HOE(4, 2922, 35, 2, 22, ItemRegistry.mortum_gem),
    REALMITE_HOE(2, 325, 7, 0, 14, ItemRegistry.realmite_ingot),
    RUPEE_HOE(3, 1634, 8, 0, 14, ItemRegistry.rupee_ingot),
    SKYTHERN_HOE(4, 2783, 30, 2, 22, ItemRegistry.skythern_gem),
    TERRAN_HOE(3, 1586, 8, 0, 10, ItemRegistry.terran_stone),
    WILDWOOD_HOE(4, 2342, 20, 2, 22, ItemRegistry.wildwood_gem),

    //Vethea
    //Hammers
    TEAKER_HAMMER(4, -2.4F, 4),
    AMTHIRMIS_HAMMER(4, -2.4F, 6),
    DARVEN_HAMMER(4, -2.4F, 10),
    CERMILE_HAMMER(4, -2.4F, 13),
    PARDIMAL_HAMMER(4, -2.4F, 17),
    QUADROTIC_HAMMER(4, -2.4F, 22),
    KAROS_HAMMER(4, -2.4F, 26),
    HELIOSIS_HAMMER(4, -2.4F, 31),
    ARKSIANE_HAMMER(4, -2.4F, 37),
    EVERLIGHT(4, -2.4F, 40),
    KAROS_ROCKMAUL(4, -2.4F, 42),

    //Backswords
    TEAKER_BACKSWORD(4, -2.4F, 2),
    AMTHIRMIS_BACKSWORD(4, -2.4F, 4),
    DARVEN_BACKSWORD(4, -2.4F, 7),
    CERMILE_BACKSWORD(4, -2.4F, 11),
    PARDIMAL_BACKSWORD(4, -2.4F, 14),
    QUADROTIC_BACKSWORD(4, -2.4F, 18),
    KAROS_BACKSWORD(4, -2.4F, 20),
    HELIOSIS_BACKSWORD(4, -2.4F, 27),
    ARKSIANE_BACKSWORD(4, -2.4F, 35),

    //Claws
    TEAKER_CLAW(4, -2, 1),
    AMTHIRMIS_CLAW(4, -2, 3),
    DARVEN_CLAW(4, -2, 5),
    CERMILE_CLAW(4, -2, 6),
    PARDIMAL_CLAW(4, -2, 10),
    QUADROTIC_CLAW(4, -2, 12),
    KAROS_CLAW(4, -2, 17),
    HELIOSIS_CLAW(4, -2, 24),
    ARKSIANE_CLAW(4, -2, 33),
    EVERBRIGHT(4, -2, 40);

    private final Ingredient repairMaterial;
    private final SwordSpecial swordSpecial;
    public int effectPower;
    public int effectSec;
    private final float attackDamage;
    private final float efficiency;
    private final int enchantability;
    private final int harvestLevel;
    private final int maxUses;

    //No specials
    ToolStats(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Item repairMaterialIn) {
        harvestLevel = harvestLevelIn;
        maxUses = maxUsesIn;
        efficiency = efficiencyIn;
        attackDamage = attackDamageIn;
        enchantability = enchantabilityIn;
        repairMaterial = Ingredient.ofStacks(repairMaterialIn.getDefaultStack());
        swordSpecial = SwordSpecial.NONE;
    }
    //No specials, unbreakable
    ToolStats(int harvestLevel, float efficiency, float attackDamage) {this(harvestLevel, 0, efficiency, attackDamage, 0, Items.AIR);}
    //Specials, power, seconds
    ToolStats(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Item repairMaterialIn, SwordSpecial special, int power, int seconds) {
        harvestLevel = harvestLevelIn;
        maxUses = maxUsesIn;
        efficiency = efficiencyIn;
        attackDamage = attackDamageIn;
        enchantability = enchantabilityIn;
        repairMaterial = Ingredient.ofStacks(repairMaterialIn.getDefaultStack());  // .of(repairMaterialIn);
        swordSpecial = special;
        effectPower = power;
        effectSec = seconds;
    }
    //Specials, power, seconds, unbreakable
    ToolStats(int harvestLevel, float efficiency, float attackDamage, SwordSpecial special, int power, int seconds) {this(harvestLevel, 0, efficiency, attackDamage, 0, Items.AIR, special, power, seconds);}

    @Override public int getDurability() {return maxUses;}
    @Override public float getMiningSpeedMultiplier() {return efficiency;}
    @Override public float getAttackDamage() {return attackDamage;}
    @Override public int getMiningLevel() {return harvestLevel;}
    @Override public int getEnchantability() {return enchantability;}
    @Override public Ingredient getRepairIngredient() {return repairMaterial;}

    public SwordSpecial getSwordSpecial() {return swordSpecial;}
    public enum SwordSpecial {NONE, FLAME, WITHER, EXPLODE, SLOW, NAUSEA, BLIND, POISON, LIGHTNING, HEAL, SPEED, ARCANA_DAMAGE}
}

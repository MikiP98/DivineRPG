package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.enums.ToolStats;
import divinerpg.divinerpg.items.base.ItemHealingSword;
import divinerpg.divinerpg.items.base.ItemMod;
import divinerpg.divinerpg.items.base.ItemModFood;
import divinerpg.divinerpg.items.base.ItemModSword;
import divinerpg.divinerpg.items.vethea.ItemVethean;
import divinerpg.divinerpg.util.FoodList;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class ItemRegistry {
    private static Item registerItemVethean(String registryId) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryId), new ItemVethean());
    }
    private static <T extends Item> T registerItemVethean(String registryId, T item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryId), item);
    }

    private static Item registerItem(String registryId) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryId), new ItemMod());
    }
    private static <T extends Item> T registerItem(String registryId, T item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryId), item);
    }

    private static Item registerFuelItem(String registryId, int burnTime) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryId), new ItemMod(new Item.Settings()));
        FuelRegistry.INSTANCE.add(item, burnTime);
        return item;
    }
    private static <T extends Item> T registerFuelItem(String registryId, int burnTime, T item) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryId), item);
        FuelRegistry.INSTANCE.add(item, burnTime);
        return item;
    }

    //Misc
    public static Item cyclops_eye;
    public static Item crab_claw;
    public static Item shark_fin;
    public static Item whale_fin;
    public static Item liopleurodon_teeth;
    public static Item aquatic_ingot;
    public static Item realmite_ingot;
    public static Item arlemite_ingot;
    public static Item rupee_ingot;
    public static Item shadow_stone;

    //Stones
    public static Item ice_stone;
    public static Item terran_stone;
    public static Item jungle_stone;
    public static Item molten_stone;
    public static Item corrupted_stone;
    public static Item ender_stone;
    public static Item divine_stone;

    //Nether
    public static Item bloodgem;
    public static Item purple_blaze;
    public static Item soulfire_stone;

    //Iceika
    public static Item sabear_tooth;
    public static Item snowflake;
    public static Item oxdrite_ingot;

    //Arcana
    public static Item ancient_key;
    public static Item degraded_key;
    public static Item sludge_key;
    public static Item soul_key;
    public static Item arcanium;

    //Twilight Dimensions
    public static Item eden_gem;
    public static Item eden_chunk;
    public static Item wildwood_gem;
    public static Item wildwood_chunk;
    public static Item apalachia_gem;
    public static Item apalachia_chunk;
    public static Item skythern_gem;
    public static Item skythern_chunk;
    public static Item mortum_gem;
    public static Item mortum_chunk;

    public static void register() {
        //Misc
        cyclops_eye = registerItem("cyclops_eye_shards");
        registerItem("cyclops_eye");
        crab_claw = registerItem("crab_claw");
        shark_fin = registerItem("shark_fin");
        whale_fin = registerItem("whale_fin");
        liopleurodon_teeth = registerItem("liopleurodon_teeth");
        registerItem("liopleurodon_skull");
        registerItem("aquatic_pellets");
        registerItem("pure_aquatic_pellets");
        aquatic_ingot = registerItem("aquatic_ingot");
        registerItem("kraken_scale");
        registerItem("kraken_skin");
        registerItem("aqua_ball");
        registerItem("aquatic_blaze_rod");
        registerItem("raw_realmite");
        registerItem("raw_arlemite");
        registerItem("raw_rupee");
//        registerItem("healing_stone", ItemHealingStone::new);
        registerItem("red_diamond_chunk");
        registerItem("yellow_diamond_chunk");
        registerItem("green_diamond_chunk");
        registerItem("blue_diamond_chunk");
        registerItem("gray_diamond_chunk");
        registerItem("realmite_nugget");
        registerItem("arlemite_nugget");
        registerItem("rupee_nugget");
        realmite_ingot = registerItem("realmite_ingot");
        arlemite_ingot = registerItem("arlemite_ingot");
        rupee_ingot = registerItem("rupee_ingot");
        registerItem("shadow_bar");
        shadow_stone = registerItem("shadow_stone");
        registerItem("shadow_coins");
        registerItem("bedrock_chunk", new ItemMod(new Item.Settings().fireproof()));

        //Shards
        registerItem("ice_shards");
        registerItem("terran_shards");
        registerItem("jungle_shards");
        registerItem("molten_shards", new ItemMod(new Item.Settings().fireproof()));
        registerItem("corrupted_shards");
        registerItem("ender_shards");
        registerItem("divine_shards");

        //Stones
        ice_stone = registerItem("ice_stone");
        terran_stone = registerItem("terran_stone");
        jungle_stone = registerItem("jungle_stone");
        molten_stone = registerItem("molten_stone", new ItemMod(new Item.Settings().fireproof()));
        corrupted_stone = registerItem("corrupted_stone");
        ender_stone = registerItem("ender_stone");
        divine_stone = registerItem("divine_stone");

        //Nether
        bloodgem = registerItem("bloodgem");
        registerItem("raw_torridite");
        registerItem("torridite_nugget", new ItemMod(new Item.Settings().fireproof()));
        registerItem("torridite_ingot", new ItemMod(new Item.Settings().fireproof()));
        registerItem("torridite_chunk", new ItemMod(new Item.Settings().fireproof()));
        registerItem("hellstone_ingot");
        purple_blaze = registerItem("purple_blaze");
        registerItem("fury_fire");
        soulfire_stone = registerItem("soulfire_stone");

        //Iceika
        registerItem("seng_fur");
        registerItem("sabear_fur");
        sabear_tooth = registerItem("sabear_tooth");
        snowflake = registerItem("snowflake");
        registerFuelItem("anthracite", 3200);
        registerItem("olivine");
        registerItem("raw_oxdrite");
        oxdrite_ingot = registerItem("oxdrite_ingot");

        //End
        registerItem("watching_eye");
        registerItem("legendary_ender_eye");

        //Smithing Templates
//        registerItem("bedrock_upgrade_template", ItemSmithingTemplate::createBedrockUpgrade);
//        registerItem("aquatic_coating_template", ItemSmithingTemplate::createAquaticCoating);
//        registerItem("color_template", ItemSmithingTemplate::createColorTemplate);

        //Some Extra Stuff
//        mysterious_clock = registerItem("mysterious_clock", () -> new ItemBossSpawner("item.overworld_only", Level.OVERWORLD, EntityRegistry.ANCIENT_ENTITY::get));
//        call_of_the_watcher = registerItem("call_of_the_watcher", () -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.THE_WATCHER::get));
//        infernal_flame = registerItem("infernal_flame", () -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.KING_OF_SCORCHERS::get));
//        horde_horn = registerItem("horde_horn", ItemHordeHorn::new);
//        snow_globe = registerItem("snow_globe", ItemSnowGlobe::new);
//        twilight_clock = registerItem("twilight_clock", ItemTwilightClock::new);
//        heat_pack = registerItem("heat_pack", ItemHeatPack::new);
//        glacial_wall_totem = registerItem("glacial_wall_totem", () -> new ItemMod(new Properties().stacksTo(1)));
//        teleportation_crystal = registerItem("teleportation_crystal", ItemTeleportationCrystal::new);
//        teleportation_star = registerItem("teleportation_star", ItemTeleportationStar::new);

        //Arcana
        registerItem("collector_fragments");
//        registerItem("collector", ItemCollector::new);
        ancient_key = registerItem("ancient_key");
        degraded_key = registerItem("degraded_key");
        sludge_key = registerItem("sludge_key");
        soul_key = registerItem("soul_key");
        arcanium = registerItem("piece_of_raw_arcanium");
        registerItem("arcanium");
//        registerItem("wizards_book", ItemWizardsBook::new);
        registerItem("dungeon_tokens");
//        registerItem("aquamarine", ItemAquamarine::new);
        registerItem("firestock");
        registerItem("lamona");
        registerItem("marsine");
        registerItem("veilo");
        registerItem("orb_of_light");
//        registerItem("weak_arcana_potion", () -> new ItemArcanaPotion(FoodList.WEAK_ARCANA_POTION, 100));
//        registerItem("strong_arcana_potion", () -> new ItemArcanaPotion(FoodList.STRONG_ARCANA_POTION, 200));

        //Twilight Dimensions
        registerItem("eden_dust");
        registerItem("eden_sparkles");
        registerItem("eden_soul");
        registerItem("eden_fragments");
        eden_gem = registerItem("eden_gem");
        eden_chunk = registerItem("eden_chunk");
        registerItem("eden_heart");
        registerItem("wildwood_dust");
        registerItem("wildwood_soul");
        registerItem("wildwood_fragments");
        wildwood_gem = registerItem("wildwood_gem");
        wildwood_chunk = registerItem("wildwood_chunk");
        registerItem("wildwood_heart");
        registerItem("apalachia_dust");
        registerItem("apalachia_soul");
        registerItem("apalachia_fragments");
        apalachia_gem = registerItem("apalachia_gem");
        apalachia_chunk = registerItem("apalachia_chunk");
        registerItem("apalachia_heart");
        registerItem("skythern_dust");
        registerItem("skythern_soul");
        registerItem("skythern_fragments");
        skythern_gem = registerItem("skythern_gem");
        skythern_chunk = registerItem("skythern_chunk");
        registerItem("skythern_heart");
        registerItem("mortum_dust");
        registerItem("mortum_soul");
        registerItem("mortum_fragments");
        mortum_gem = registerItem("mortum_gem");
        mortum_chunk = registerItem("mortum_chunk");
        registerItem("mortum_heart");

        //Spawn Crystals
        registerItem("base_spawn_crystal");
//        registerItem("vamacheron_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.VAMACHERON::get));
//        registerItem("karot_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.KAROT::get));
//        registerItem("twilight_demon_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.TWILIGHT_DEMON::get));
//        registerItem("densos_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.DENSOS::get));
//        registerItem("reyvor_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.REYVOR::get));
//        registerItem("soul_fiend_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.SOUL_FIEND::get));

        //Food
        registerItem("bacon", new ItemModFood(FoodList.BACON));
        registerItem("boiled_egg", new ItemModFood(FoodList.BOILED_EGG));
        registerItem("cheese", new ItemModFood(FoodList.CHEESE));
        registerItem("donut", new ItemModFood(FoodList.DONUT));
        registerItem("hot_pumpkin_pie", new ItemModFood(FoodList.HOT_PUMPKIN_PIE));
//        registerItem("tomato", ItemTomato::new);
        registerItem("white_mushroom", new ItemModFood(FoodList.WHITE_MUSHROOM));
//        registerItem("advanced_mushroom_stew", new BowlFoodItem(new Properties().food(FoodList.ADVANCED_MUSHROOM_STEW).stacksTo(1)));
//        registerItem("chicken_dinner", new BowlFoodItem(new Properties().food(FoodList.CHICKEN_DINNER).stacksTo(1)));
        registerItem("robbin_egg");
        registerItem("cauldron_flesh", new ItemModFood(FoodList.CAULDRON_FLESH));
        registerItem("raw_seng_meat", new ItemModFood(FoodList.RAW_SENG_MEAT));
        registerItem("seng_steak", new ItemModFood(FoodList.COOKED_SENG_STEAK));
        registerItem("raw_wolpertinger_meat", new ItemModFood(FoodList.RAW_WOLPERTINGER_MEAT));
        registerItem("wolpertinger_steak", new ItemModFood(FoodList.COOKED_WOLPERTINGER_STEAK));
        registerItem("chocolate_log", new ItemModFood(FoodList.CHOCOLATE_LOG));
//        registerItem("egg_nog", ItemEggNog::new);
        registerItem("fruit_cake", new ItemModFood(FoodList.FRUIT_CAKE));
        registerItem("peppermints", new ItemModFood(FoodList.PEPPERMINTS));
        registerItem("snow_cones", new ItemModFood(FoodList.SNOW_CONES));
//        registerItem("winterberry", ItemWinterberry::new);
        registerItem("hitchak", new ItemModFood(FoodList.HITCHAK));
        registerItem("pinfly", new ItemModFood(FoodList.PINFLY));
        registerItem("raw_empowered_meat", new ItemModFood(FoodList.RAW_EMPOWERED_MEAT));
        registerItem("empowered_meat", new ItemModFood(FoodList.EMPOWERED_MEAT));
        registerItem("magic_meat", new ItemModFood(FoodList.MAGIC_MEAT, true));
        registerItem("enriched_magic_meat", new ItemModFood(FoodList.ENRICHED_MAGIC_MEAT, true));
        registerItem("forbidden_fruit", new ItemModFood(FoodList.FORBIDDEN_FRUIT));
        registerItem("moonbulb", new ItemModFood(FoodList.MOONBULB, true));
        registerItem("purple_glowbone", new ItemModFood(FoodList.PURPLE_GLOWBONE, true));
        registerItem("pink_glowbone", new ItemModFood(FoodList.PINK_GLOWBONE, true));
//        registerItem("sky_flower", ItemSkyFlower::new);
        registerItem("honeysuckle", new ItemModFood(FoodList.HONEYSUCKLE));
        registerItem("honeychunk", new ItemModFood(FoodList.HONEYCHUNK));
        registerItem("dream_carrot", new ItemModFood(FoodList.DREAM_CARROT));
        registerItem("dream_melon", new ItemModFood(FoodList.DREAM_MELON));
        registerItem("dream_pie", new ItemModFood(FoodList.DREAM_PIE));
        registerItem("dream_cake", new ItemModFood(FoodList.DREAM_CAKE));
//        registerItem("dream_sweets", new ItemHealingFood(FoodList.DREAM_SWEETS));
//        registerItem("dream_sours", new ItemHealingFood(FoodList.DREAM_SOURS));

        //Seeds
//        registerItem("tomato_seeds", () -> new ItemNameBlockItem(BlockRegistry.tomatoPlant.get(), new Properties()));
//        registerItem("white_mushroom_seeds", () -> new ItemNameBlockItem(BlockRegistry.whiteMushroomPlant.get(), new Properties()));
//        registerItem("aquamarine_seeds", () -> new ItemNameBlockItem(BlockRegistry.aquamarinePlant.get(), new Properties()));
//        registerItem("eucalyptus_root_seeds", () -> new ItemNameBlockItem(BlockRegistry.eucalyptusPlant.get(), new Properties()));
//        registerItem("firestock_seeds", () -> new ItemNameBlockItem(BlockRegistry.firestockPlant.get(), new Properties()));
//        registerItem("hitchak_seeds", () -> new ItemNameBlockItem(BlockRegistry.hitchakPlant.get(), new Properties()));
//        registerItem("lamona_seeds", () -> new ItemNameBlockItem(BlockRegistry.lamonaPlant.get(), new Properties()));
//        registerItem("marsine_seeds", () -> new ItemNameBlockItem(BlockRegistry.marsinePlant.get(), new Properties()));
//        registerItem("pinfly_seeds", () -> new ItemNameBlockItem(BlockRegistry.pinflyPlant.get(), new Properties()));
//        registerItem("veilo_seeds", () -> new ItemNameBlockItem(BlockRegistry.veiloPlant.get(), new Properties()));
//        registerItem("moonbulb_seeds", () -> new ItemNameBlockItem(BlockRegistry.moonbulbPlant.get(), new Properties()));
//        registerItem("pink_glowbone_seeds", () -> new ItemNameBlockItem(BlockRegistry.pinkGlowbonePlant.get(), new Properties()));
//        registerItem("purple_glowbone_seeds", () -> new ItemNameBlockItem(BlockRegistry.purpleGlowbonePlant.get(), new Properties()));
//        registerItem("sky_plant_seeds", () -> new ItemNameBlockItem(BlockRegistry.skyPlant.get(), new Properties()));

        //Vethea
        registerItemVethean("acid");
        registerItemVethean("rock_chunks");
        registerItemVethean("dirty_pearls");
        registerItemVethean("clean_pearls");
        registerItemVethean("polished_pearls");
        registerItemVethean("shiny_pearls");
        registerItemVethean("teaker_lump");
        registerItemVethean("amthirmis_lump");
        registerItemVethean("darven_lump");
        registerItemVethean("cermile_lump");
        registerItemVethean("pardimal_lump");
        registerItemVethean("quadrotic_lump");
        registerItemVethean("karos_lump");
        registerItemVethean("heliosis_lump");
        registerItemVethean("arksiane_lump");
        registerItemVethean("backsword_template");
        registerItemVethean("hammer_template");
        registerItemVethean("claw_template");
        registerItemVethean("bow_template");
        registerItemVethean("staff_template");
        registerItemVethean("cannon_template");
        registerItemVethean("disk_template");
        registerItemVethean("dissipator_template");
        registerItemVethean("degraded_template");
        registerItemVethean("finished_template");
        registerItemVethean("glistening_template");
        registerItemVethean("demonized_template");
        registerItemVethean("tormented_template");
//        registerItemVethean("dream_flint", ItemDreamFlint::new);
        registerItemVethean("moon_clock", new ItemVethean(new Item.Settings().maxCount(1)));
//        registerItemVethean("miners_amulet", ItemMinersAmulet::new);
        registerItemVethean("band_of_lheiva_hunting", new ItemVethean(new Item.Settings().maxCount(1)));

        //Pets
//        registerItem("snapper_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SNAPPER)),
//        registerItem("ehu_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.EHU)),
//        registerItem("husk_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.HUSK)),
//        registerItem("brown_grizzle_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.BROWN_GRIZZLE)),
//        registerItem("white_grizzle_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.WHITE_GRIZZLE)),
//        registerItem("stone_golem_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.STONE_GOLEM)),
//        registerItem("smelter_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SMELTER)),
//        registerItem("fyracryx_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.FYRACRYX)),
//        registerItem("golem_of_rejuvenation_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.GOLEM_OF_REJUVENATION)),
//        registerItem("paratiku_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.PARATIKU)),
//        registerItem("seimer_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SEIMER)),

        //Tools, Weapons & Armor
        //Swords
        registerItem("cyclopsian_sword", new ItemModSword(ToolStats.CYCLOPSIAN_SWORD));
        registerItem("slime_sword", new ItemModSword(ToolStats.SLIME_SWORD));
        registerItem("glacier_sword", new ItemModSword(ToolStats.GLACIER_SWORD));
        registerItem("crabclaw_maul", new ItemModSword(ToolStats.CRABCLAW_MAUL));
        registerItem("dual_claw", new ItemModSword(ToolStats.DUAL_CLAW));
        registerItem("shark_sword", new ItemModSword(ToolStats.SHARK_SWORD));
        registerItem("aquatooth_sword", new ItemModSword(ToolStats.AQUATOOTH_SWORD));
        registerItem("aquatooth_maul", new ItemModSword(ToolStats.AQUATOOTH_MAUL));
        registerItem("aquatic_dagger", new ItemModSword(ToolStats.AQUA_DAGGER));
        registerItem("ocean_knife", new ItemModSword(ToolStats.OCEAN_KNIFE));
        registerItem("aquatic_trident", new ItemModSword(ToolStats.AQUA_TRIDENT));
        registerItem("aquaton", new ItemModSword(ToolStats.AQUATON));
        registerItem("aquatic_maul", new ItemModSword(ToolStats.AQUA_MAUL));
        registerItem("realmite_sword", new ItemModSword(ToolStats.REALMITE_SWORD));
        registerItem("arlemite_stabber", new ItemModSword(ToolStats.ARLEMITE_STABBER));
        registerItem("rupee_rapier", new ItemModSword(ToolStats.RUPEE_RAPIER));
        registerItem("bedrock_sword", new ItemModSword(ToolStats.BEDROCK_SWORD, new Item.Settings().fireproof()));
        registerItem("bedrock_maul", new ItemModSword(ToolStats.BEDROCK_MAUL, new Item.Settings().fireproof()));
        registerItem("frozen_maul", new ItemModSword(ToolStats.FROZEN_MAUL));
        registerItem("fury_maul", new ItemModSword(ToolStats.FURY_MAUL));
        registerItem("death_bringer", new ItemModSword(ToolStats.DEATH_BRINGER));
        registerItem("corrupted_maul", new ItemModSword(ToolStats.CORRUPTED_MAUL));
        registerItem("terran_dagger", new ItemModSword(ToolStats.TERRAN_DAGGER));
        registerItem("terran_knife", new ItemModSword(ToolStats.TERRAN_KNIFE));
        registerItem("terran_maul", new ItemModSword(ToolStats.TERRAN_MAUL));
        registerItem("jungle_knife", new ItemModSword(ToolStats.JUNGLE_KNIFE));
        registerItem("jungle_rapier", new ItemModSword(ToolStats.JUNGLE_RAPIER));
        registerItem("poison_saber", new ItemModSword(ToolStats.POISON_SABER));
        registerItem("bloodgem_sword", new ItemModSword(ToolStats.BLOODGEM_SWORD));
        registerItem("molten_sword", new ItemModSword(ToolStats.MOLTEN_SWORD, new Item.Settings().fireproof()));
        registerItem("scorching_sword", new ItemModSword(ToolStats.SCORCHING_SWORD));
        registerItem("soulfire_sword", new ItemModSword(ToolStats.SOULFIRE_SWORD));
        registerItem("inferno_sword", new ItemModSword(ToolStats.INFERNO_SWORD, new Item.Settings().fireproof()));
        registerItem("flaming_fury", new ItemModSword(ToolStats.FLAMING_FURY, new Item.Settings().fireproof()));
        registerItem("sabear_sabre", new ItemModSword(ToolStats.SABEAR_SABRE));
        registerItem("frost_sword", new ItemModSword(ToolStats.FROST_SWORD));
        registerItem("frostking_sword", new ItemModSword(ToolStats.FROSTKING_SWORD));
        registerItem("icicle_bane", new ItemModSword(ToolStats.ICICLE_BANE));
        registerItem("glacial_blade", new ItemModSword(ToolStats.GLACIAL_BLADE));
        registerItem("icicle_dagger", new ItemModSword(ToolStats.ICICLE_DAGGER));
//        registerItem("ender_sword", new ItemModSword(RarityList.ENDER, ToolStats.ENDER_SWORD));
//        registerItem("red_ender_sword", new ItemModSword(RarityList.RED, ToolStats.ENDER_SWORD));
        registerItem("yellow_ender_sword", new ItemModSword(Rarity.UNCOMMON, ToolStats.ENDER_SWORD));
//        registerItem("green_ender_sword", new ItemModSword(RarityList.GREEN, ToolStats.ENDER_SWORD));
//        registerItem("blue_ender_sword", new ItemModSword(RarityList.BLUE, ToolStats.ENDER_SWORD));
//        registerItem("black_ender_sword", new ItemModSword(RarityList.DARK_GRAY, ToolStats.ENDER_SWORD));
        registerItem("enderice", new ItemModSword(ToolStats.ENDERICE));
//        registerItem("divine_sword", new ItemModSword(RarityList.DIVINE, ToolStats.DIVINE_SWORD));
//        registerItem("red_divine_sword", new ItemModSword(RarityList.RED, ToolStats.DIVINE_SWORD));
        registerItem("yellow_divine_sword", new ItemModSword(Rarity.UNCOMMON, ToolStats.DIVINE_SWORD));
//        registerItem("green_divine_sword", new ItemModSword(RarityList.GREEN, ToolStats.DIVINE_SWORD));
//        registerItem("blue_divine_sword", new ItemModSword(RarityList.BLUE, ToolStats.DIVINE_SWORD));
//        registerItem("gray_divine_sword", new ItemModSword(RarityList.GRAY, ToolStats.DIVINE_SWORD));
        registerItem("icine_sword", new ItemModSword(ToolStats.ICINE_SWORD));
        registerItem("sandslash", new ItemModSword(ToolStats.SANDSLASH));
        registerItem("snowslash", new ItemModSword(ToolStats.SNOWSLASH));
//        registerItem("storm_sword", ItemStormSword::new);
//        registerItem("shadow_saber", ItemShadowSaber::new);
        registerItem("arcanium_saber", new ItemModSword(ToolStats.ARCANIUM_SABER).setAttackArcanaConsumption(25));
        registerItem("arcanite_blade", new ItemModSword(ToolStats.ARCANITE_BLADE).setAttackArcanaConsumption(30));
        registerItem("livicia_sword", new ItemModSword(ToolStats.LIVICIA_SWORD));
//        registerItem("eden_blade", new ItemModSword(RarityList.EDEN, ToolStats.EDEN_BLADE));
//        registerItem("wildwood_blade", new ItemModSword(RarityList.WILDWOOD, ToolStats.WILDWOOD_BLADE));
//        registerItem("apalachia_blade", new ItemModSword(RarityList.APALACHIA, ToolStats.APALACHIA_BLADE));
//        registerItem("skythern_blade", new ItemModSword(RarityList.SKYTHERN, ToolStats.SKYTHERN_BLADE));
//        registerItem("mortum_blade", new ItemModSword(RarityList.MORTUM, ToolStats.MORTUM_BLADE));
//        registerItem("halite_blade", new ItemModSword(RarityList.HALITE, ToolStats.HALITE_BLADE));

        //Healing
        registerItem("palavence", new ItemHealingSword(ToolStats.PALAVENCE, .5F));
        registerItem("massivence", new ItemHealingSword(ToolStats.MASSIVENCE, 1));
        registerItem("frossivence", new ItemHealingSword(ToolStats.FROSSIVENCE, 1));
    }
}

package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.enums.ArrowType;
import divinerpg.divinerpg.enums.BulletType;
import divinerpg.divinerpg.enums.ToolStats;
import divinerpg.divinerpg.items.base.*;
import divinerpg.divinerpg.items.vanilla.ItemHealingStone;
import divinerpg.divinerpg.items.vanilla.ItemTomato;
import divinerpg.divinerpg.items.vethea.ItemVethean;
import divinerpg.divinerpg.util.FoodList;
import divinerpg.divinerpg.util.RarityList;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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

    //Tools, Weapons & Armor
    //Healing
    public static Item frossivence;

    //Arrows
    public static Item eden_arrow;
    public static Item wildwood_arrow;
    public static Item fury_arrow;

    //Vethean Arrows
    public static Item teaker_arrow;
    public static Item darven_arrow;
    public static Item pardimal_arrow;
    public static Item karos_arrow;
    public static Item ever_arrow;

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
        registerItem("healing_stone", new ItemHealingStone());
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
//        mysterious_clock = registerItem("mysterious_clock", new ItemBossSpawner("item.overworld_only", Level.OVERWORLD, EntityRegistry.ANCIENT_ENTITY::get));
//        call_of_the_watcher = registerItem("call_of_the_watcher", new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.THE_WATCHER::get));
//        infernal_flame = registerItem("infernal_flame", new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.KING_OF_SCORCHERS::get));
//        horde_horn = registerItem("horde_horn", ItemHordeHorn::new);
//        snow_globe = registerItem("snow_globe", ItemSnowGlobe::new);
//        twilight_clock = registerItem("twilight_clock", ItemTwilightClock::new);
//        heat_pack = registerItem("heat_pack", ItemHeatPack::new);
//        glacial_wall_totem = registerItem("glacial_wall_totem", new ItemMod(new Item.Settings().maxCount(1)));
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
//        registerItem("weak_arcana_potion", new ItemArcanaPotion(FoodList.WEAK_ARCANA_POTION, 100));
//        registerItem("strong_arcana_potion", new ItemArcanaPotion(FoodList.STRONG_ARCANA_POTION, 200));

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
//        registerItem("vamacheron_crystal", new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.VAMACHERON::get));
//        registerItem("karot_crystal", new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.KAROT::get));
//        registerItem("twilight_demon_crystal", new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.TWILIGHT_DEMON::get));
//        registerItem("densos_crystal", new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.DENSOS::get));
//        registerItem("reyvor_crystal", new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.REYVOR::get));
//        registerItem("soul_fiend_crystal", new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.SOUL_FIEND::get));

        //Food
        registerItem("bacon", new ItemModFood(FoodList.BACON));
        registerItem("boiled_egg", new ItemModFood(FoodList.BOILED_EGG));
        registerItem("cheese", new ItemModFood(FoodList.CHEESE));
        registerItem("donut", new ItemModFood(FoodList.DONUT));
        registerItem("hot_pumpkin_pie", new ItemModFood(FoodList.HOT_PUMPKIN_PIE));
        registerItem("tomato", new ItemTomato());
        registerItem("white_mushroom", new ItemModFood(FoodList.WHITE_MUSHROOM));
//        registerItem("advanced_mushroom_stew", new BowlFoodItem(new Item.Settings().food(FoodList.ADVANCED_MUSHROOM_STEW).maxCount(1)));
//        registerItem("chicken_dinner", new BowlFoodItem(new Item.Settings().food(FoodList.CHICKEN_DINNER).maxCount(1)));
        registerItem("robbin_egg");
        registerItem("cauldron_flesh", new ItemModFood(FoodList.CAULDRON_FLESH));
        registerItem("raw_seng_meat", new ItemModFood(FoodList.RAW_SENG_MEAT));
        registerItem("seng_steak", new ItemModFood(FoodList.COOKED_SENG_STEAK));
        registerItem("raw_wolpertinger_meat", new ItemModFood(FoodList.RAW_WOLPERTINGER_MEAT));
        registerItem("wolpertinger_steak", new ItemModFood(FoodList.COOKED_WOLPERTINGER_STEAK));
        registerItem("chocolate_log", new ItemModFood(FoodList.CHOCOLATE_LOG));
//        registerItem("egg_nog", new ItemEggNog());
        registerItem("fruit_cake", new ItemModFood(FoodList.FRUIT_CAKE));
        registerItem("peppermints", new ItemModFood(FoodList.PEPPERMINTS));
        registerItem("snow_cones", new ItemModFood(FoodList.SNOW_CONES));
//        registerItem("winterberry", new ItemWinterberry());
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
//        registerItem("tomato_seeds", new ItemNameBlockItem(BlockRegistry.tomatoPlant.get(), new Item.Settings()));
//        registerItem("white_mushroom_seeds", new ItemNameBlockItem(BlockRegistry.whiteMushroomPlant.get(), new Item.Settings()));
//        registerItem("aquamarine_seeds", new ItemNameBlockItem(BlockRegistry.aquamarinePlant.get(), new Item.Settings()));
//        registerItem("eucalyptus_root_seeds", new ItemNameBlockItem(BlockRegistry.eucalyptusPlant.get(), new Item.Settings()));
//        registerItem("firestock_seeds", new ItemNameBlockItem(BlockRegistry.firestockPlant.get(), new Item.Settings()));
//        registerItem("hitchak_seeds", new ItemNameBlockItem(BlockRegistry.hitchakPlant.get(), new Item.Settings()));
//        registerItem("lamona_seeds", new ItemNameBlockItem(BlockRegistry.lamonaPlant.get(), new Item.Settings()));
//        registerItem("marsine_seeds", new ItemNameBlockItem(BlockRegistry.marsinePlant.get(), new Item.Settings()));
//        registerItem("pinfly_seeds", new ItemNameBlockItem(BlockRegistry.pinflyPlant.get(), new Item.Settings()));
//        registerItem("veilo_seeds", new ItemNameBlockItem(BlockRegistry.veiloPlant.get(), new Item.Settings()));
//        registerItem("moonbulb_seeds", new ItemNameBlockItem(BlockRegistry.moonbulbPlant.get(), new Item.Settings()));
//        registerItem("pink_glowbone_seeds", new ItemNameBlockItem(BlockRegistry.pinkGlowbonePlant.get(), new Item.Settings()));
//        registerItem("purple_glowbone_seeds", new ItemNameBlockItem(BlockRegistry.purpleGlowbonePlant.get(), new Item.Settings()));
//        registerItem("sky_plant_seeds", new ItemNameBlockItem(BlockRegistry.skyPlant.get(), new Item.Settings()));

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
//        registerItem("snapper_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.SNAPPER)),
//        registerItem("ehu_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.EHU)),
//        registerItem("husk_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.HUSK)),
//        registerItem("brown_grizzle_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.BROWN_GRIZZLE)),
//        registerItem("white_grizzle_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.WHITE_GRIZZLE)),
//        registerItem("stone_golem_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.STONE_GOLEM)),
//        registerItem("smelter_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.SMELTER)),
//        registerItem("fyracryx_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.FYRACRYX)),
//        registerItem("golem_of_rejuvenation_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.GOLEM_OF_REJUVENATION)),
//        registerItem("paratiku_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.PARATIKU)),
//        registerItem("seimer_spawn_egg", new ItemPetSpawnEgg(EntityRegistry.SEIMER)),

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
        frossivence = registerItem("frossivence", new ItemHealingSword(ToolStats.FROSSIVENCE, 1));

        //Arcana Misc.
//        registerItem("divine_accumulator", ItemDivineAccumulator::new),
//        registerItem("ender_scepter", ItemEnderScepter::new),
//        registerItem("ghostbane", ItemGhostbane::new),
//        registerItem("staff_of_enrichment", ItemStaffEnrichment::new),
//        registerItem("arcanium_attractor", new ItemModRanged(BulletType.ATTRACTOR_SHOT, SoundRegistry.REFLECTOR, null, 0, 0, 20)),
//        registerItem("arcanium_reflector", new ItemModRanged(BulletType.REFLECTOR_SHOT, SoundRegistry.REFLECTOR, null, 0, 0, 20)),

        //Shields
        registerItem("realmite_shield", new DivineShield(realmite_ingot, 426, "realmite_shield"));
        registerItem("arlemite_shield", new DivineShield(arlemite_ingot, 734, "arlemite_shield"));
        registerItem("rupee_shield", new DivineShield(rupee_ingot, 823, "rupee_shield"));
        registerItem("eden_shield", new DivineShield(eden_gem, 978, "eden_shield"));  // RarityList.EDEN,
        registerItem("wildwood_shield", new DivineShield(wildwood_gem, 1125, "wildwood_shield"));  // RarityList.WILDWOOD,
        registerItem("apalachia_shield", new DivineShield(apalachia_gem, 1256, "apalachia_shield"));  // RarityList.APALACHIA,
        registerItem("skythern_shield", new DivineShield(skythern_gem, 1485, "skythern_shield"));  // RarityList.SKYTHERN,
        registerItem("mortum_shield", new DivineShield(mortum_gem, 1627, "mortum_shield"));  // RarityList.MORTUM,
        registerItem("halite_shield", new DivineShield(Items.AIR, 0, "halite_shield"));  // RarityList.HALITE,

        //Serenades
//        serenade_striker = registerItem("serenade_striker", ItemSerenadeStriker::new);
//        serenade_of_ice = registerItem("serenade_of_ice", new ItemModRanged(BulletType.SERENADE_OF_ICE_SHOT, SoundRegistry.SERENADE.get(), 100, 0));
//        serenade_of_death = registerItem("serenade_of_death", new ItemModRanged(BulletType.SERENADE_OF_DEATH_SHOT, SoundRegistry.SERENADE.get(), 857, 0));
//        serenade_of_health = registerItem("serenade_of_health", ItemSerenadeOfHealth::new);
//        serenade_of_infusion = registerItem("serenade_of_infusion", ItemSerenadeOfInfusion::new);

        //Arrows
        eden_arrow = registerItem("eden_arrow");
        wildwood_arrow = registerItem("wildwood_arrow");
        fury_arrow = registerItem("fury_arrow");

        //Vethean Arrows
        teaker_arrow = registerItemVethean("teaker_arrow");
        darven_arrow = registerItemVethean("darven_arrow");
        pardimal_arrow = registerItemVethean("pardimal_arrow");
        karos_arrow = registerItemVethean("karos_arrow");
        ever_arrow = registerItemVethean("ever_arrow");

        //Bows
//        hunter_bow = registerItem("hunter_bow", new ItemModBow(ArrowType.HUNTER_ARROW, 1125));
//        shadow_bow = registerItem("shadow_bow", new ItemModBow(ArrowType.SHADOW_ARROW, 1225, 36000));
//        icicle_bow = registerItem("icicle_bow", new ItemModBow(ArrowType.ICICLE_ARROW, 1456, 24000));
//        inferno_bow = registerItem("inferno_bow", new ItemModBow(ArrowType.INFERNO_ARROW, ItemModBow.DEFAULT_MAX_USE_DURATION, new Item.Settings().durability(0).fireResistant()));
//        soulfire_bow = registerItem("soulfire_bow", new ItemModBow(ArrowType.SOULFIRE_ARROW, 0));
//        snowstorm_bow = registerItem("snowstorm_bow", new ItemModBow(ArrowType.SNOWSTORM_ARROW, 0));
//        ender_bow = registerItem("ender_bow", new ItemModBow(RarityList.ENDER, ArrowType.ENDER_ARROW, 0));
//        eden_bow = registerItem("eden_bow", new ItemModBow(RarityList.EDEN, ArrowType.EDEN_ARROW, 1517));
//        wildwood_bow = registerItem("wildwood_bow", new ItemModBow(RarityList.WILDWOOD, ArrowType.LESSER_WILDWOOD_ARROW, 1624, 36000));
//        apalachia_bow = registerItem("apalachia_bow", new ItemModBow(RarityList.APALACHIA, ArrowType.GREATER_WILDWOOD_ARROW, 1778));
//        skythern_bow = registerItem("skythern_bow", new ItemModBow(RarityList.SKYTHERN, ArrowType.GREATER_WILDWOOD_ARROW, 1879, 36000));
//        mortum_bow = registerItem("mortum_bow", new ItemModBow(RarityList.MORTUM, ArrowType.FURY_ARROW, 1990));
//        halite_bow = registerItem("halite_bow", new ItemModBow(RarityList.HALITE, ArrowType.FURY_ARROW, 2114, 36000));
//        twilight_bow = registerItem("twilight_bow", new ItemModBow(ArrowType.FURY_ARROW, 2376, 14400));

        //Anchors
//        crab_anchor = registerItem("crab_anchor", new ItemAnchor(ToolStats.CRAB_ANCHOR, BulletType.CRAB_ANCHOR_SHOT));
//        shark_anchor = registerItem("shark_anchor", new ItemAnchor(ToolStats.SHARK_ANCHOR, BulletType.SHARK_ANCHOR_SHOT));
//        bowhead_anchor = registerItem("bowhead_anchor", new ItemAnchor(ToolStats.BOWHEAD_ANCHOR, BulletType.BOWHEAD_ANCHOR_SHOT));
//        liopleurodon_anchor = registerItem("liopleurodon_anchor", new ItemAnchor(ToolStats.LIOPLEURODON_ANCHOR, BulletType.LIOPLEURODON_ANCHOR_SHOT));

        //Harps
//        sound_of_music = registerItem("sound_of_music", new ItemModRanged(BulletType.SOUND_OF_MUSIC_SHOT, SoundRegistry.SOUND_OF_MUSIC, 666, 20));
//        sound_of_carols = registerItem("sound_of_carols", new ItemModRanged(BulletType.SOUND_OF_CAROLS_SHOT, SoundRegistry.SOUND_OF_CAROLS, 1025, 20));
//        sound_of_whales = registerItem("sound_of_whales", new ItemModRanged(BulletType.SOUND_OF_WHALES_SHOT, SoundRegistry.WHALE, 1592, 20));

        //Shurikens
//        shuriken = registerItem("shuriken", new ItemModThrowable(BulletType.SHURIKEN_SHOT));
//        snowflake_shuriken = registerItem("snowflake_shuriken", new ItemModThrowable(BulletType.SNOWFLAKE_SHURIKEN_SHOT));
//        vile_storm = registerItem("vile_storm", new ItemModThrowable(BulletType.VILE_STORM_SHOT));

        //Slicers
//        eden_slicer = registerItem("eden_slicer", new ItemModThrowable(RarityList.EDEN, BulletType.EDEN_SLICER_SHOT));
//        wildwood_slicer = registerItem("wildwood_slicer", new ItemModThrowable(RarityList.WILDWOOD, BulletType.WILDWOOD_SLICER_SHOT));
//        apalachia_slicer = registerItem("apalachia_slicer", new ItemModThrowable(RarityList.APALACHIA, BulletType.APALACHIA_SLICER_SHOT));
//        skythern_slicer = registerItem("skythern_slicer", new ItemModThrowable(RarityList.SKYTHERN, BulletType.SKYTHERN_SLICER_SHOT));
//        mortum_slicer = registerItem("mortum_slicer", new ItemModThrowable(RarityList.MORTUM, BulletType.MORTUM_SLICER_SHOT));
//        halite_slicer = registerItem("halite_slicer", new ItemModThrowable(RarityList.HALITE, BulletType.HALITE_SLICER_SHOT));

        //Extra
//        scythe = registerItem("scythe", ItemScythe::new);
//        cyclopsian_staff = registerItem("cyclopsian_staff", new ItemModRanged(BulletType.CYCLOPSIAN_STAFF_SHOT, SoundRegistry.STAFF.get(), 126, 0));
//        maelstrom = registerItem("maelstrom", new ItemModRanged(BulletType.MAELSTROM_SHOT, SoundRegistry.GHAST_CANNON.get(), 100, 20));
//        captains_sparkler = registerItem("captains_sparkler", new ItemModRanged(BulletType.CAPTAINS_SPARKLER_SHOT, SoundRegistry.SPARKLER.get(), null, 1235, 15, 7));
//        grenade = registerItem("grenade", new ItemModThrowable(BulletType.GRENADE));
//        la_vekor = registerItem("la_vekor", new ItemModRanged(BulletType.GRENADE, SoundRegistry.LA_VEKOR.get(), ItemRegistry.grenade.get(), 1225, 10, 15));
//        firefly = registerItem("firefly", ItemFirefly::new);
//        meriks_missile = registerItem("meriks_missile", ItemMeriksMissile::new);
//        generals_staff = registerItem("generals_staff", new ItemModRanged(BulletType.GENERALS_STAFF_SHOT, SoundRegistry.STARLIGHT.get(), null, 1212, 50, 20));
//        starlight = registerItem("starlight", new ItemStaffSkyDrop(BulletType.STAR, 5, 1, 10, 1010));
//        staff_of_starlight = registerItem("staff_of_starlight", new ItemStaffSkyDrop(BulletType.STAR, 25, 8, 40, 1176));
//        meteor_mash = registerItem("meteor_mash", new ItemStaffSkyDrop(BulletType.METEOR, 35, 1, 30, 1218));

        //Phasers
//        eden_phaser = registerItem("eden_phaser", new ItemTwilightPhaser(RarityList.EDEN, BulletType.EDEN_PHASER_SHOT, 1517));
//        wildwood_phaser = registerItem("wildwood_phaser", new ItemTwilightPhaser(RarityList.WILDWOOD, BulletType.WILDWOOD_PHASER_SHOT, 1624));
//        apalachia_phaser = registerItem("apalachia_phaser", new ItemTwilightPhaser(RarityList.APALACHIA, BulletType.APALACHIA_PHASER_SHOT, 1778));
//        skythern_phaser = registerItem("skythern_phaser", new ItemTwilightPhaser(RarityList.SKYTHERN, BulletType.SKYTHERN_PHASER_SHOT, 1879));
//        mortum_phaser = registerItem("mortum_phaser", new ItemTwilightPhaser(RarityList.MORTUM, BulletType.MORTUM_PHASER_SHOT, 1990));
//        halite_phaser = registerItem("halite_phaser", new ItemTwilightPhaser(RarityList.HALITE, BulletType.HALITE_PHASER_SHOT, 2114));

        //Cannons
//        crabclaw_cannon = registerItem("crabclaw_cannon", new ItemModRanged(BulletType.CRABCLAW_CANNON_SHOT, SoundRegistry.GHAST_CANNON.get(), Blocks.CACTUS.asItem(), 246, 20));
//        frostclaw_cannon = registerItem("frostclaw_cannon", new ItemModRanged(BulletType.FROSTCLAW_CANNON_SHOT, SoundRegistry.FROSTCLAW_CANNON.get(), Blocks.CACTUS.asItem(), 612, 0));
//        bowhead_cannon = registerItem("bowhead_cannon", new ItemModRanged(BulletType.BOWHEAD_CANNON_SHOT, SoundRegistry.GHAST_CANNON.get(), Blocks.CACTUS.asItem(), 592, 20));
//        frost_cannon = registerItem("frost_cannon", new ItemModRanged(BulletType.FROST_CANNON_SHOT, SoundRegistry.FROST_CANNON.get(), Items.SNOWBALL, 1126, 0));
//        fractite_cannon = registerItem("fractite_cannon", new ItemModRanged(BulletType.FRACTITE_CANNON_SHOT, SoundRegistry.FRACTITE_CANNON.get(), ice_shards.get(), 1442, 0));
//        ghast_cannon = registerItem("ghast_cannon", new ItemModRanged(BulletType.GHAST_CANNON_SHOT, SoundRegistry.GHAST_CANNON.get(), 726, 20));
//        golden_fury = registerItem("golden_fury", new ItemModRanged(BulletType.GOLDEN_FURY_SHOT, SoundRegistry.BLITZ.get(), Items.GOLD_NUGGET, 2417, 0));

        //Blitz
//        eden_blitz = registerItem("eden_blitz", new ItemTwilightBlitz(RarityList.EDEN, BulletType.EDEN_BLITZ_SHOT, eden_dust.get(), 1517));
//        wildwood_blitz = registerItem("wildwood_blitz", new ItemTwilightBlitz(RarityList.WILDWOOD, BulletType.WILDWOOD_BLITZ_SHOT, wildwood_dust.get(), 1624));
//        apalachia_blitz = registerItem("apalachia_blitz", new ItemTwilightBlitz(RarityList.APALACHIA, BulletType.APALACHIA_BLITZ_SHOT, apalachia_dust.get(), 1778));
//        skythern_blitz = registerItem("skythern_blitz", new ItemTwilightBlitz(RarityList.SKYTHERN, BulletType.SKYTHERN_BLITZ_SHOT, skythern_dust.get(), 1879));
//        mortum_blitz = registerItem("mortum_blitz", new ItemTwilightBlitz(RarityList.MORTUM, BulletType.MORTUM_BLITZ_SHOT, mortum_dust.get(), 1990));
//        halite_blitz = registerItem("halite_blitz", new ItemTwilightBlitz(RarityList.HALITE, BulletType.HALITE_BLITZ_SHOT, mortum_dust.get(), 2114));

        //Shotguns
        Item corrupted_bullet = registerItem("corrupted_bullet");
//        corrupted_cannon = registerItem("corrupted_cannon", new ItemModShotgun(BulletType.CORRUPTED_BULLET, SoundRegistry.GHAST_CANNON, 1672, 15, corrupted_bullet, 0, 4));
//        arcanite_blaster = registerItem("arcanite_blaster", new ItemModShotgun(BulletType.ARCANITE_BLASTER, SoundRegistry.GHAST_CANNON, 1127, 30, null, 20, 30));


        //Tool Sets
        registerItem("realmite_shovel", new ItemModShovel(ToolStats.REALMITE_SHOVEL));
        registerItem("realmite_pickaxe", new ItemModPickaxe(ToolStats.REALMITE_PICKAXE));
        registerItem("realmite_axe", new ItemModAxe(ToolStats.REALMITE_AXE, -3.1F));
        registerItem("realmite_hoe", new ItemModHoe(ToolStats.REALMITE_HOE, -1));

        registerItem("oxdrite_pickaxe", new ItemModPickaxe(ToolStats.OXDRITE_PICKAXE));

        registerItem("arlemite_shovel", new ItemModShovel(ToolStats.ARLEMITE_SHOVEL));
        registerItem("arlemite_pickaxe", new ItemModPickaxe(ToolStats.ARLEMITE_PICKAXE));
        registerItem("arlemite_axe", new ItemModAxe(ToolStats.ARLEMITE_AXE, -3));
        registerItem("arlemite_hoe", new ItemModHoe(ToolStats.ARLEMITE_HOE, 0));
//        registerItem("arlemite_shickaxe", new ItemShickaxe(ToolStats.ARLEMITE_SHICKAXE));

        registerItem("terran_shovel", new ItemModShovel(ToolStats.TERRAN_SHOVEL));
        registerItem("terran_pickaxe", new ItemModPickaxe(ToolStats.TERRAN_PICKAXE));
        registerItem("terran_axe", new ItemModAxe(ToolStats.TERRAN_AXE, -3));
        registerItem("terran_hoe", new ItemModHoe(ToolStats.TERRAN_HOE, 0));
//        registerItem("terran_shickaxe", new ItemShickaxe(ToolStats.TERRAN_SHICKAXE));

        registerItem("rupee_shovel", new ItemModShovel(ToolStats.RUPEE_SHOVEL));
        registerItem("rupee_pickaxe", new ItemModPickaxe(ToolStats.RUPEE_PICKAXE));
        registerItem("rupee_axe", new ItemModAxe(ToolStats.RUPEE_AXE, -3));
        registerItem("rupee_hoe", new ItemModHoe(ToolStats.RUPEE_HOE, 0));
//        registerItem("rupee_shickaxe", new ItemShickaxe(ToolStats.RUPEE_SHICKAXE));

        registerItem("corrupted_shovel", new ItemModShovel(ToolStats.CORRUPTED_SHOVEL));
        registerItem("corrupted_pickaxe", new ItemModPickaxe(ToolStats.CORRUPTED_PICKAXE));
        registerItem("corrupted_axe", new ItemModAxe(ToolStats.CORRUPTED_AXE, -2.9F));
        registerItem("corrupted_hoe", new ItemModHoe(ToolStats.CORRUPTED_HOE, 0));
//        registerItem("corrupted_shickaxe", new ItemShickaxe(ToolStats.CORRUPTED_SHICKAXE));

        registerItem("bedrock_shovel", new ItemModShovel(ToolStats.BEDROCK_SHOVEL, new Item.Settings().fireproof()));
        registerItem("bedrock_pickaxe", new ItemModPickaxe(ToolStats.BEDROCK_PICKAXE, new Item.Settings().fireproof()));
        registerItem("bedrock_axe", new ItemModAxe(ToolStats.BEDROCK_AXE, new Item.Settings().fireproof()));
        registerItem("bedrock_hoe", new ItemModHoe(ToolStats.BEDROCK_HOE, new Item.Settings().fireproof()));

        registerItem("divine_shovel", new ItemModShovel(ToolStats.DIVINE_SHOVEL)); // , RarityList.DIVINE
        registerItem("divine_pickaxe", new ItemModPickaxe(ToolStats.DIVINE_PICKAXE));  // , RarityList.DIVINE
        registerItem("divine_axe", new ItemModAxe(ToolStats.DIVINE_AXE, -2.9F));  // , RarityList.DIVINE
        registerItem("divine_hoe", new ItemModHoe(ToolStats.DIVINE_HOE));  // , RarityList.DIVINE
//        registerItem("divine_shickaxe", new ItemShickaxe(RarityList.DIVINE, ToolStats.DIVINE_SHICKAXE));

        registerItem("eden_shovel", new ItemModShovel(ToolStats.EDEN_SHOVEL));  // , RarityList.EDEN
        registerItem("eden_pickaxe", new ItemModPickaxe(ToolStats.EDEN_PICKAXE));  // , RarityList.EDEN
        registerItem("eden_axe", new ItemModAxe(ToolStats.EDEN_AXE, -2.8F));  // , RarityList.EDEN
        registerItem("eden_hoe", new ItemModHoe(ToolStats.EDEN_HOE));  // , RarityList.EDEN
//        registerItem("eden_shickaxe", new ItemShickaxe(RarityList.EDEN, ToolStats.EDEN_SHICKAXE));

        registerItem("wildwood_shovel", new ItemModShovel(ToolStats.WILDWOOD_SHOVEL));  // , RarityList.WILDWOOD
        registerItem("wildwood_pickaxe", new ItemModPickaxe(ToolStats.WILDWOOD_PICKAXE));  // , RarityList.WILDWOOD
        registerItem("wildwood_axe", new ItemModAxe(ToolStats.WILDWOOD_AXE, -2.8F));  // , RarityList.WILDWOOD
        registerItem("wildwood_hoe", new ItemModHoe(ToolStats.WILDWOOD_HOE));  // , RarityList.WILDWOOD
//        registerItem("wildwood_shickaxe", new ItemShickaxe(RarityList.WILDWOOD, ToolStats.WILDWOOD_SHICKAXE));

        registerItem("apalachia_shovel", new ItemModShovel(ToolStats.APALACHIA_SHOVEL));  // , RarityList.APALACHIA
        registerItem("apalachia_pickaxe", new ItemModPickaxe(ToolStats.APALACHIA_PICKAXE));  // , RarityList.APALACHIA
        registerItem("apalachia_axe", new ItemModAxe(ToolStats.APALACHIA_AXE, -2.8F));  // , RarityList.APALACHIA
        registerItem("apalachia_hoe", new ItemModHoe(ToolStats.APALACHIA_HOE));  // , RarityList.APALACHIA
//        registerItem("apalachia_shickaxe", new ItemShickaxe(RarityList.APALACHIA, ToolStats.APALACHIA_SHICKAXE));

        registerItem("skythern_shovel", new ItemModShovel(ToolStats.SKYTHERN_SHOVEL));  // , RarityList.SKYTHERN
        registerItem("skythern_pickaxe", new ItemModPickaxe(ToolStats.SKYTHERN_PICKAXE));  // , RarityList.SKYTHERN
        registerItem("skythern_axe", new ItemModAxe(ToolStats.SKYTHERN_AXE, -2.8F));  // , RarityList.SKYTHERN
        registerItem("skythern_hoe", new ItemModHoe(ToolStats.SKYTHERN_HOE));  // , RarityList.SKYTHERN
//        registerItem("skythern_shickaxe", new ItemShickaxe(RarityList.SKYTHERN, ToolStats.SKYTHERN_SHICKAXE));

        registerItem("mortum_shovel", new ItemModShovel(ToolStats.MORTUM_SHOVEL));  // , RarityList.MORTUM
        registerItem("mortum_pickaxe", new ItemModPickaxe(ToolStats.MORTUM_PICKAXE));  // , RarityList.MORTUM
        registerItem("mortum_axe", new ItemModAxe(ToolStats.MORTUM_AXE, -2.8F));  // , RarityList.MORTUM
        registerItem("mortum_hoe", new ItemModHoe(ToolStats.MORTUM_HOE));  // , RarityList.MORTUM
//        registerItem("mortum_shickaxe", new ItemShickaxe(RarityList.MORTUM, ToolStats.MORTUM_SHICKAXE));

//        registerItem("halite_shickaxe", new ItemShickaxe(RarityList.HALITE, ToolStats.HALITE_SHICKAXE));

        registerItemVethean("dream_shovel", new ItemModShovel(ToolStats.DREAM_SHOVEL));
        registerItemVethean("dream_pickaxe", new ItemModPickaxe(ToolStats.DREAM_PICKAXE));
        registerItemVethean("dream_axe", new ItemModAxe(ToolStats.DREAM_AXE, -3.1F));

        //Buckets
//        gem_fin_bucket = registerItem("gem_fin_bucket", new MobBucketItem(EntityRegistry.GEM_FIN, Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Settings()).maxCount(1)));
//        cauldron_fish_bucket = registerItem("cauldron_fish_bucket", new MobBucketItem(EntityRegistry.CAULDRON_FISH, Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1)));
//        smoldering_tar_bucket = registerItem("smoldering_tar_bucket", new BucketItem(FluidRegistry.SMOLDERING_TAR_FLUID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

        //Vethean Swords
        registerItemVethean("teaker_backsword", new ItemModSword(ToolStats.TEAKER_BACKSWORD));
        registerItemVethean("amthirmis_backsword", new ItemModSword(ToolStats.AMTHIRMIS_BACKSWORD));
        registerItemVethean("darven_backsword", new ItemModSword(ToolStats.DARVEN_BACKSWORD));
        registerItemVethean("cermile_backsword", new ItemModSword(ToolStats.CERMILE_BACKSWORD));
        registerItemVethean("pardimal_backsword", new ItemModSword(ToolStats.PARDIMAL_BACKSWORD));
        registerItemVethean("quadrotic_backsword", new ItemModSword(ToolStats.QUADROTIC_BACKSWORD));
        registerItemVethean("karos_backsword", new ItemModSword(ToolStats.KAROS_BACKSWORD));
        registerItemVethean("heliosis_backsword", new ItemModSword(ToolStats.HELIOSIS_BACKSWORD));
        registerItemVethean("arksiane_backsword", new ItemModSword(ToolStats.ARKSIANE_BACKSWORD));

        //Hammers
        registerItemVethean("teaker_hammer", new ItemModSword(ToolStats.TEAKER_HAMMER));
        registerItemVethean("amthirmis_hammer", new ItemModSword(ToolStats.AMTHIRMIS_HAMMER));
        registerItemVethean("darven_hammer", new ItemModSword(ToolStats.DARVEN_HAMMER));
        registerItemVethean("cermile_hammer", new ItemModSword(ToolStats.CERMILE_HAMMER));
        registerItemVethean("pardimal_hammer", new ItemModSword(ToolStats.PARDIMAL_HAMMER));
        registerItemVethean("quadrotic_hammer", new ItemModSword(ToolStats.QUADROTIC_HAMMER));
        registerItemVethean("karos_hammer", new ItemModSword(ToolStats.KAROS_HAMMER));
        registerItemVethean("heliosis_hammer", new ItemModSword(ToolStats.HELIOSIS_HAMMER));
        registerItemVethean("arksiane_hammer", new ItemModSword(ToolStats.ARKSIANE_HAMMER));
        registerItemVethean("everlight", new ItemModSword(ToolStats.EVERLIGHT));
        registerItemVethean("karos_rockmaul", new ItemModSword(ToolStats.KAROS_ROCKMAUL));

        //Claws
        registerItemVethean("teaker_claw", new ItemModSword(ToolStats.TEAKER_CLAW));
        registerItemVethean("amthirmis_claw", new ItemModSword(ToolStats.AMTHIRMIS_CLAW));
        registerItemVethean("darven_claw", new ItemModSword(ToolStats.DARVEN_CLAW));
        registerItemVethean("cermile_claw", new ItemModSword(ToolStats.CERMILE_CLAW));
        registerItemVethean("pardimal_claw", new ItemModSword(ToolStats.PARDIMAL_CLAW));
        registerItemVethean("quadrotic_claw", new ItemModSword(ToolStats.QUADROTIC_CLAW));
        registerItemVethean("karos_claw", new ItemModSword(ToolStats.KAROS_CLAW));
        registerItemVethean("heliosis_claw", new ItemModSword(ToolStats.HELIOSIS_CLAW));
        registerItemVethean("arksiane_claw", new ItemModSword(ToolStats.ARKSIANE_CLAW));
        registerItemVethean("everbright", new ItemModSword(ToolStats.EVERBRIGHT));

        //Vethean Bows
        registerItemVethean("teaker_bow", new ItemModBow(ArrowType.TEAKER_ARROW, 0));
        registerItemVethean("amthirmis_bow", new ItemModBow(ArrowType.AMTHIRMIS_ARROW, 0));
        registerItemVethean("darven_bow", new ItemModBow(ArrowType.DARVEN_ARROW, 0));
        registerItemVethean("cermile_bow", new ItemModBow(ArrowType.CERMILE_ARROW, 0));
        registerItemVethean("pardimal_bow", new ItemModBow(ArrowType.PARDIMAL_ARROW, 0));
        registerItemVethean("quadrotic_bow", new ItemModBow(ArrowType.QUADROTIC_ARROW, 0));
        registerItemVethean("karos_bow", new ItemModBow(ArrowType.KAROS_ARROW, 0));
        registerItemVethean("heliosis_bow", new ItemModBow(ArrowType.HELIOSIS_ARROW, 0));
        registerItemVethean("arksiane_bow", new ItemModBow(ArrowType.ARKSIANE_ARROW, 0));
        registerItemVethean("everfright", new ItemModBow(ArrowType.EVERFRIGHT, 0));

        //Vethean Staffs
//        registerItemVethean("teaker_staff", new ItemStaff(BulletType.TEAKER_STAFF_SHOT, 10, 0));
//        registerItemVethean("amthirmis_staff", new ItemStaff(BulletType.AMTHIRMIS_STAFF_SHOT, 10, 0));
//        registerItemVethean("darven_staff", new ItemStaff(BulletType.DARVEN_STAFF_SHOT, 10, 0));
//        registerItemVethean("cermile_staff", new ItemStaff(BulletType.CERMILE_STAFF_SHOT, 10, 0));
//        registerItemVethean("pardimal_staff", new ItemStaff(BulletType.PARDIMAL_STAFF_SHOT, 10, 0));
//        registerItemVethean("quadrotic_staff", new ItemStaff(BulletType.QUADROTIC_STAFF_SHOT, 10, 0));
//        registerItemVethean("karos_staff", new ItemStaff(BulletType.KAROS_STAFF_SHOT, 10, 0));
//        registerItemVethean("heliosis_staff", new ItemStaff(BulletType.HELIOSIS_STAFF_SHOT, 10, 0));
//        registerItemVethean("arksiane_staff", new ItemStaff(BulletType.ARKSIANE_STAFF_SHOT, 10, 0));
//        registerItemVethean("evernight", new ItemStaff(BulletType.EVERNIGHT_SHOT, 80, 20));

        //Vethean Cannons
//        registerItemVethean("teaker_cannon", new ItemVetheanCannon(BulletType.TEAKER_CANNON_SHOT));
//        registerItemVethean("amthirmis_cannon", new ItemVetheanCannon(BulletType.AMTHIRMIS_CANNON_SHOT));
//        registerItemVethean("darven_cannon", new ItemVetheanCannon(BulletType.DARVEN_CANNON_SHOT));
//        registerItemVethean("cermile_cannon", new ItemVetheanCannon(BulletType.CERMILE_CANNON_SHOT));
//        registerItemVethean("pardimal_cannon", new ItemVetheanCannon(BulletType.PARDIMAL_CANNON_SHOT));
//        registerItemVethean("quadrotic_cannon", new ItemVetheanCannon(BulletType.QUADROTIC_CANNON_SHOT));
//        registerItemVethean("karos_cannon", new ItemVetheanCannon(BulletType.KAROS_CANNON_SHOT));
//        registerItemVethean("heliosis_cannon", new ItemVetheanCannon(BulletType.HELIOSIS_CANNON_SHOT));
//        registerItemVethean("arksiane_cannon", new ItemVetheanCannon(BulletType.ARKSIANE_CANNON_SHOT));
//        registerItemVethean("eversight", new ItemVetheanCannon(BulletType.EVERSIGHT_SHOT));

        //Vethean Disks
//        registerItemVethean("teaker_disk", new ItemVetheanDisk(BulletType.TEAKER_DISK));
//        registerItemVethean("amthirmis_disk", new ItemVetheanDisk(BulletType.AMTHIRMIS_DISK));
//        registerItemVethean("darven_disk", new ItemVetheanDisk(BulletType.DARVEN_DISK));
//        registerItemVethean("cermile_disk", new ItemVetheanDisk(BulletType.CERMILE_DISK));
//        registerItemVethean("pardimal_disk", new ItemVetheanDisk(BulletType.PARDIMAL_DISK));
//        registerItemVethean("quadrotic_disk", new ItemVetheanDisk(BulletType.QUADROTIC_DISK));
//        registerItemVethean("karos_disk", new ItemVetheanDisk(BulletType.KAROS_DISK));
//        registerItemVethean("heliosis_disk", new ItemVetheanDisk(BulletType.HELIOSIS_DISK));
//        registerItemVethean("arksiane_disk", new ItemVetheanDisk(BulletType.ARKSIANE_DISK));

        //Vethean Dissipators
//        registerItemVethean("teaker_dissipator", new ItemVetheanDissipator(BulletType.TEAKER_DISSIPATOR));
//        registerItemVethean("amthirmis_dissipator", new ItemVetheanDissipator(BulletType.AMTHIRMIS_DISSIPATOR));
//        registerItemVethean("darven_dissipator", new ItemVetheanDissipator(BulletType.DARVEN_DISSIPATOR));
//        registerItemVethean("cermile_dissipator", new ItemVetheanDissipator(BulletType.CERMILE_DISSIPATOR));
//        registerItemVethean("pardimal_dissipator", new ItemVetheanDissipator(BulletType.PARDIMAL_DISSIPATOR));
//        registerItemVethean("quadrotic_dissipator", new ItemVetheanDissipator(BulletType.QUADROTIC_DISSIPATOR));
//        registerItemVethean("karos_dissipator", new ItemVetheanDissipator(BulletType.KAROS_DISSIPATOR));
//        registerItemVethean("heliosis_dissipator", new ItemVetheanDissipator(BulletType.HELIOSIS_DISSIPATOR));
//        registerItemVethean("arksiane_dissipator", new ItemVetheanDissipator(BulletType.ARKSIANE_DISSIPATOR));

        //Armor Pouches
//        registerItem("armor_pouch", new ItemArmorPouch(Rarity.COMMON));
//        registerItem("red_armor_pouch", new ItemArmorPouch(RarityList.RED));
//        registerItem("yellow_armor_pouch", new ItemArmorPouch(Rarity.UNCOMMON));
//        registerItem("green_armor_pouch", new ItemArmorPouch(RarityList.GREEN));
//        registerItem("blue_armor_pouch", new ItemArmorPouch(RarityList.BLUE));
//        registerItem("gray_armor_pouch", new ItemArmorPouch(RarityList.GRAY));

        //Blocks
//        registerItemVethean("nightmare_bed", ItemNightmareBed::new),
//        registerItem("aqua_torch", new StandingAndWallBlockItem(BlockRegistry.aquaTorch.get(), BlockRegistry.aquaWallTorch.get(), new Properties(), Direction.DOWN));
//        registerItem("skeleton_torch", new StandingAndWallBlockItem(BlockRegistry.skeletonTorch.get(), BlockRegistry.skeletonWallTorch.get(), new Properties(), Direction.DOWN));
//        registerItem("arcanium_torch", new StandingAndWallBlockItem(BlockRegistry.arcaniumTorch.get(), BlockRegistry.arcaniumWallTorch.get(), new Properties(), Direction.DOWN));
//        registerItem("eden_torch", new StandingAndWallBlockItem(BlockRegistry.edenTorch.get(), BlockRegistry.edenWallTorch.get(), new Properties(), Direction.DOWN));


        //Armour
//        realmite_helmet = registerItem("realmite_helmet", new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.HELMET)),
//        realmite_chestplate = registerItem("realmite_chestplate", new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.CHESTPLATE)),
//        realmite_leggings = registerItem("realmite_leggings", new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.LEGGINGS)),
//        realmite_boots = registerItem("realmite_boots", new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.BOOTS)),
//
//        seng_fur_helmet = registerItem("seng_fur_helmet", new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.HELMET, ArmorInfo.sengFurInfo, SENG_FUR.get(), WARMTH.get())),
//        seng_fur_chestplate = registerItem("seng_fur_chestplate", new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.CHESTPLATE, ArmorInfo.sengFurInfo)),
//        seng_fur_leggings = registerItem("seng_fur_leggings", new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.LEGGINGS, ArmorInfo.sengFurInfo)),
//        seng_fur_boots = registerItem("seng_fur_boots", new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.BOOTS, ArmorInfo.sengFurInfo)),
//
//        santa_helmet = registerItem("santa_helmet", new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.HELMET, ArmorInfo.sengFurInfo, SENG_FUR.get(), WARMTH.get())),
//        santa_chestplate = registerItem("santa_chestplate", new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.CHESTPLATE, ArmorInfo.sengFurInfo)),
//        santa_leggings = registerItem("santa_leggings", new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.LEGGINGS, ArmorInfo.sengFurInfo)),
//        santa_boots = registerItem("santa_boots", new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.BOOTS, ArmorInfo.sengFurInfo)),
//
//        aquastrive_helmet = registerItem("aquastrive_helmet", new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.HELMET, ArmorInfo.aquastriveInfo, MobEffects.WATER_BREATHING)),
//        aquastrive_chestplate = registerItem("aquastrive_chestplate", new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.CHESTPLATE, ArmorInfo.aquastriveInfo)),
//        aquastrive_leggings = registerItem("aquastrive_leggings", new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.LEGGINGS, ArmorInfo.aquastriveInfo)),
//        aquastrive_boots = registerItem("aquastrive_boots", new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.BOOTS, ArmorInfo.aquastriveInfo)),
//
//        kraken_helmet = registerItem("kraken_helmet", new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.HELMET, ArmorInfo.krakenInfo, MobEffects.DOLPHINS_GRACE, MobEffects.CONDUIT_POWER)),
//        kraken_chestplate = registerItem("kraken_chestplate", new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.CHESTPLATE, ArmorInfo.krakenInfo)),
//        kraken_leggings = registerItem("kraken_leggings", new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.LEGGINGS, ArmorInfo.krakenInfo)),
//        kraken_boots = registerItem("kraken_boots", new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.BOOTS, ArmorInfo.krakenInfo)),
//
//        jack_o_man_helmet = registerItem("jack_o_man_helmet", new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.HELMET, ArmorInfo.jackomanInfo)),
//        jack_o_man_chestplate = registerItem("jack_o_man_chestplate", new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.CHESTPLATE, ArmorInfo.jackomanInfo)),
//        jack_o_man_leggings = registerItem("jack_o_man_leggings", new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.LEGGINGS, ArmorInfo.jackomanInfo)),
//        jack_o_man_boots = registerItem("jack_o_man_boots", new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.BOOTS, ArmorInfo.jackomanInfo)),
//
//        skeleman_helmet = registerItem("skeleman_helmet", new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.HELMET, ArmorInfo.skelemanInfo, SKELEMAN_FEED.get())),
//        skeleman_chestplate = registerItem("skeleman_chestplate", new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.CHESTPLATE, ArmorInfo.skelemanInfo)),
//        skeleman_leggings = registerItem("skeleman_leggings", new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.LEGGINGS, ArmorInfo.skelemanInfo)),
//        skeleman_boots = registerItem("skeleman_boots", new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.BOOTS, ArmorInfo.skelemanInfo)),
//
//        wither_reaper_helmet = registerItem("wither_reaper_helmet", new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.HELMET, ArmorInfo.witherReaperInfo, WITHER_PROTECTION.get())),
//        wither_reaper_chestplate = registerItem("wither_reaper_chestplate", new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.CHESTPLATE, ArmorInfo.witherReaperInfo)),
//        wither_reaper_leggings = registerItem("wither_reaper_leggings", new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.LEGGINGS, ArmorInfo.witherReaperInfo)),
//        wither_reaper_boots = registerItem("wither_reaper_boots", new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.BOOTS, ArmorInfo.witherReaperInfo)),
//
//        arlemite_helmet = registerItem("arlemite_helmet", new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.HELMET, ArmorInfo.arlemiteInfo, PROJECTILE_PROTECTION.get())),
//        arlemite_chestplate = registerItem("arlemite_chestplate", new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.arlemiteInfo)),
//        arlemite_leggings = registerItem("arlemite_leggings", new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.LEGGINGS, ArmorInfo.arlemiteInfo)),
//        arlemite_boots = registerItem("arlemite_boots", new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.BOOTS, ArmorInfo.arlemiteInfo)),
//
//        frozen_helmet = registerItem("frozen_helmet", new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.HELMET, ArmorInfo.frozenInfo, FROZEN_SLOWNESS.get())),
//        frozen_chestplate = registerItem("frozen_chestplate", new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.CHESTPLATE, ArmorInfo.frozenInfo)),
//        frozen_leggings = registerItem("frozen_leggings", new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.LEGGINGS, ArmorInfo.frozenInfo)),
//        frozen_boots = registerItem("frozen_boots", new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.BOOTS, ArmorInfo.frozenInfo)),
//
//        jungle_helmet = registerItem("jungle_helmet", new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.HELMET, ArmorInfo.jungleInfo, POISON_PROTECTION.get())),
//        jungle_chestplate = registerItem("jungle_chestplate", new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.CHESTPLATE, ArmorInfo.jungleInfo)),
//        jungle_leggings = registerItem("jungle_leggings", new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.LEGGINGS, ArmorInfo.jungleInfo)),
//        jungle_boots = registerItem("jungle_boots", new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.BOOTS, ArmorInfo.jungleInfo)),
//
//        inferno_helmet = registerItem("inferno_helmet", new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.HELMET, ArmorInfo.fireInfo, new Properties().fireResistant(), MobEffects.FIRE_RESISTANCE)),
//        inferno_chestplate = registerItem("inferno_chestplate", new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.CHESTPLATE, ArmorInfo.fireInfo, new Properties().fireResistant())),
//        inferno_leggings = registerItem("inferno_leggings", new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.LEGGINGS, ArmorInfo.fireInfo, new Properties().fireResistant())),
//        inferno_boots = registerItem("inferno_boots", new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.BOOTS, ArmorInfo.fireInfo, new Properties().fireResistant())),
//
//        torridite_helmet = registerItem("torridite_helmet", new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.HELMET, ArmorInfo.fireInfo, new Properties().fireResistant(), MobEffects.FIRE_RESISTANCE)),
//        torridite_chestplate = registerItem("torridite_chestplate", new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.fireInfo, new Properties().fireResistant())),
//        torridite_leggings = registerItem("torridite_leggings", new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.LEGGINGS, ArmorInfo.fireInfo, new Properties().fireResistant())),
//        torridite_boots = registerItem("torridite_boots", new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.BOOTS, ArmorInfo.fireInfo, new Properties().fireResistant())),
//
//        terran_helmet = registerItem("terran_helmet", new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.HELMET, ArmorInfo.terranInfo, new int[]{2}, MobEffects.DIG_SPEED)),
//        terran_chestplate = registerItem("terran_chestplate", new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.CHESTPLATE, ArmorInfo.terranInfo)),
//        terran_leggings = registerItem("terran_leggings", new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.LEGGINGS, ArmorInfo.terranInfo)),
//        terran_boots = registerItem("terran_boots", new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.BOOTS, ArmorInfo.terranInfo)),
//
//        angelic_helmet = registerItem("angelic_helmet", new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.HELMET, ArmorInfo.angelicInfo, PREVENT_FALL_DAMAGE.get(), ANGELIC_FLIGHT.get())),
//        angelic_chestplate = registerItem("angelic_chestplate", new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.CHESTPLATE, ArmorInfo.angelicInfo)),
//        angelic_leggings = registerItem("angelic_leggings", new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.LEGGINGS, ArmorInfo.angelicInfo)),
//        angelic_boots = registerItem("angelic_boots", new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.BOOTS, ArmorInfo.angelicInfo)),
//
//        shadow_helmet = registerItem("shadow_helmet", new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.HELMET, ArmorInfo.shadowInfo, STEP_ASSIST.get())),
//        shadow_chestplate = registerItem("shadow_chestplate", new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.CHESTPLATE, ArmorInfo.shadowInfo, new int[]{3}, MobEffects.MOVEMENT_SPEED)),
//        shadow_leggings = registerItem("shadow_leggings", new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.LEGGINGS, ArmorInfo.shadowInfo)),
//        shadow_boots = registerItem("shadow_boots", new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.BOOTS, ArmorInfo.shadowInfo)),
//
//        rupee_helmet = registerItem("rupee_helmet", new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
//        rupee_chestplate = registerItem("rupee_chestplate", new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
//        rupee_leggings = registerItem("rupee_leggings", new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
//        rupee_boots = registerItem("rupee_boots", new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),
//
//        red_rupee_helmet = registerItem("red_rupee_helmet", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
//        red_rupee_chestplate = registerItem("red_rupee_chestplate", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
//        red_rupee_leggings = registerItem("red_rupee_leggings", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
//        red_rupee_boots = registerItem("red_rupee_boots", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),
//
//        yellow_rupee_helmet = registerItem("yellow_rupee_helmet", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
//        yellow_rupee_chestplate = registerItem("yellow_rupee_chestplate", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
//        yellow_rupee_leggings = registerItem("yellow_rupee_leggings", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
//        yellow_rupee_boots = registerItem("yellow_rupee_boots", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),
//
//        green_rupee_helmet = registerItem("green_rupee_helmet", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
//        green_rupee_chestplate = registerItem("green_rupee_chestplate", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
//        green_rupee_leggings = registerItem("green_rupee_leggings", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
//        green_rupee_boots = registerItem("green_rupee_boots", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),
//
//        blue_rupee_helmet = registerItem("blue_rupee_helmet", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
//        blue_rupee_chestplate = registerItem("blue_rupee_chestplate", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
//        blue_rupee_leggings = registerItem("blue_rupee_leggings", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
//        blue_rupee_boots = registerItem("blue_rupee_boots", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),
//
//        gray_rupee_helmet = registerItem("gray_rupee_helmet", new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
//        gray_rupee_chestplate = registerItem("gray_rupee_chestplate", new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
//        gray_rupee_leggings = registerItem("gray_rupee_leggings", new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
//        gray_rupee_boots = registerItem("gray_rupee_boots", new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),
//
//        elite_realmite_helmet = registerItem("elite_realmite_helmet", new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.HELMET, ArmorInfo.eliteRealmiteInfo, PREVENT_FALL_DAMAGE.get())),
//        elite_realmite_chestplate = registerItem("elite_realmite_chestplate", new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.eliteRealmiteInfo)),
//        elite_realmite_leggings = registerItem("elite_realmite_leggings", new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.LEGGINGS, ArmorInfo.eliteRealmiteInfo)),
//        elite_realmite_boots = registerItem("elite_realmite_boots", new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.BOOTS, ArmorInfo.eliteRealmiteInfo)),
//
//        corrupted_helmet = registerItem("corrupted_helmet", new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.HELMET, ArmorInfo.corruptedInfo, CORRUPTED_STRENGTH.get())),
//        corrupted_chestplate = registerItem("corrupted_chestplate", new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.CHESTPLATE, ArmorInfo.corruptedInfo)),
//        corrupted_leggings = registerItem("corrupted_leggings", new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.LEGGINGS, ArmorInfo.corruptedInfo)),
//        corrupted_boots = registerItem("corrupted_boots", new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.BOOTS, ArmorInfo.corruptedInfo)),
//
//        bedrock_helmet = registerItem("bedrock_helmet", new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.HELMET, ArmorInfo.bedrockInfo, new Properties().fireResistant(), MobEffects.FIRE_RESISTANCE, EXPLOSION_PROTECTION.get())),
//        bedrock_chestplate = registerItem("bedrock_chestplate", new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.CHESTPLATE, ArmorInfo.bedrockInfo, new Properties().fireResistant())),
//        bedrock_leggings = registerItem("bedrock_leggings", new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.LEGGINGS, ArmorInfo.bedrockInfo, new Properties().fireResistant())),
//        bedrock_boots = registerItem("bedrock_boots", new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.BOOTS, ArmorInfo.bedrockInfo, new Properties().fireResistant())),
//
//        korma_helmet = registerItem("korma_helmet", new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.HELMET, ArmorInfo.kormInfo, KORMA_ARCANA.get())),
//        korma_chestplate = registerItem("korma_chestplate", new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.CHESTPLATE, ArmorInfo.kormInfo)),
//        korma_leggings = registerItem("korma_leggings", new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.LEGGINGS, ArmorInfo.kormInfo)),
//        korma_boots = registerItem("korma_boots", new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.BOOTS, ArmorInfo.kormInfo)),
//
//        vemos_helmet = registerItem("vemos_helmet", new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.HELMET, ArmorInfo.vemInfo, VEMOS_HEAL.get())),
//        vemos_chestplate = registerItem("vemos_chestplate", new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.CHESTPLATE, ArmorInfo.vemInfo)),
//        vemos_leggings = registerItem("vemos_leggings", new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.LEGGINGS, ArmorInfo.vemInfo)),
//        vemos_boots = registerItem("vemos_boots", new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.BOOTS, ArmorInfo.vemInfo)),
//
//        ender_helmet = registerItem("ender_helmet", new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
//        ender_chestplate = registerItem("ender_chestplate", new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
//        ender_leggings = registerItem("ender_leggings", new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
//        ender_boots = registerItem("ender_boots", new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),
//
//        red_ender_helmet = registerItem("red_ender_helmet", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
//        red_ender_chestplate = registerItem("red_ender_chestplate", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
//        red_ender_leggings = registerItem("red_ender_leggings", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
//        red_ender_boots = registerItem("red_ender_boots", new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),
//
//        yellow_ender_helmet = registerItem("yellow_ender_helmet", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
//        yellow_ender_chestplate = registerItem("yellow_ender_chestplate", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
//        yellow_ender_leggings = registerItem("yellow_ender_leggings", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
//        yellow_ender_boots = registerItem("yellow_ender_boots", new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),
//
//        green_ender_helmet = registerItem("green_ender_helmet", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
//        green_ender_chestplate = registerItem("green_ender_chestplate", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
//        green_ender_leggings = registerItem("green_ender_leggings", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
//        green_ender_boots = registerItem("green_ender_boots", new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),
//
//        blue_ender_helmet = registerItem("blue_ender_helmet", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
//        blue_ender_chestplate = registerItem("blue_ender_chestplate", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
//        blue_ender_leggings = registerItem("blue_ender_leggings", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
//        blue_ender_boots = registerItem("blue_ender_boots", new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),
//
//        gray_ender_helmet = registerItem("gray_ender_helmet", new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
//        gray_ender_chestplate = registerItem("gray_ender_chestplate", new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
//        gray_ender_leggings = registerItem("gray_ender_leggings", new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
//        gray_ender_boots = registerItem("gray_ender_boots", new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),
//
//        divine_helmet = registerItem("divine_helmet", new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.HELMET, ArmorInfo.divineInfo, PREVENT_FALL_DAMAGE.get(), DIVINE_STRENGTH.get())),
//        divine_chestplate = registerItem("divine_chestplate", new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.CHESTPLATE, ArmorInfo.divineInfo, new int[]{1}, MobEffects.JUMP)),
//        divine_leggings = registerItem("divine_leggings", new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.LEGGINGS, ArmorInfo.divineInfo)),
//        divine_boots = registerItem("divine_boots", new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.BOOTS, ArmorInfo.divineInfo)),
//
//        eden_helmet = registerItem("eden_helmet", new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.HELMET, ArmorInfo.edenInfo)),
//        eden_chestplate = registerItem("eden_chestplate", new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.CHESTPLATE, ArmorInfo.edenInfo)),
//        eden_leggings = registerItem("eden_leggings", new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.LEGGINGS, ArmorInfo.edenInfo)),
//        eden_boots = registerItem("eden_boots", new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.BOOTS, ArmorInfo.edenInfo)),
//
//        wildwood_helmet = registerItem("wildwood_helmet", new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.HELMET, ArmorInfo.wildInfo, WILDWOOD_HEAL.get())),
//        wildwood_chestplate = registerItem("wildwood_chestplate", new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.CHESTPLATE, ArmorInfo.wildInfo)),
//        wildwood_leggings = registerItem("wildwood_leggings", new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.LEGGINGS, ArmorInfo.wildInfo)),
//        wildwood_boots = registerItem("wildwood_boots", new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.BOOTS, ArmorInfo.wildInfo)),
//
//        apalachia_helmet = registerItem("apalachia_helmet", new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.HELMET, ArmorInfo.apInfo, BLOCK_PROTECTION.get())),
//        apalachia_chestplate = registerItem("apalachia_chestplate", new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.CHESTPLATE, ArmorInfo.apInfo)),
//        apalachia_leggings = registerItem("apalachia_leggings", new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.LEGGINGS, ArmorInfo.apInfo)),
//        apalachia_boots = registerItem("apalachia_boots", new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.BOOTS, ArmorInfo.apInfo)),
//
//        skythern_helmet = registerItem("skythern_helmet", new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.HELMET, ArmorInfo.skyInfo, PREVENT_FALL_DAMAGE.get())),
//        skythern_chestplate = registerItem("skythern_chestplate", new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.CHESTPLATE, ArmorInfo.skyInfo, new int[] {5}, MobEffects.JUMP)),
//        skythern_leggings = registerItem("skythern_leggings", new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.LEGGINGS, ArmorInfo.skyInfo)),
//        skythern_boots = registerItem("skythern_boots", new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.BOOTS, ArmorInfo.skyInfo)),
//
//        mortum_helmet = registerItem("mortum_helmet", new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.HELMET, ArmorInfo.mortInfo, MobEffects.NIGHT_VISION)),
//        mortum_chestplate = registerItem("mortum_chestplate", new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.CHESTPLATE, ArmorInfo.mortInfo)),
//        mortum_leggings = registerItem("mortum_leggings", new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.LEGGINGS, ArmorInfo.mortInfo)),
//        mortum_boots = registerItem("mortum_boots", new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.BOOTS, ArmorInfo.mortInfo)),
//
//        halite_helmet = registerItem("halite_helmet", new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.HELMET, ArmorInfo.halInfo, HALITE_STRENGTH.get())),
//        halite_chestplate = registerItem("halite_chestplate", new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.halInfo)),
//        halite_leggings = registerItem("halite_leggings", new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.LEGGINGS, ArmorInfo.halInfo)),
//        halite_boots = registerItem("halite_boots", new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.BOOTS, ArmorInfo.halInfo)),
//
//        awakened_halite_helmet = registerItem("awakened_halite_helmet", new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.HELMET, ArmorInfo.awakened_halInfo, AWAKENED_HALITE_STRENGTH.get())),
//        awakened_halite_chestplate = registerItem("awakened_halite_chestplate", new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.awakened_halInfo)),
//        awakened_halite_leggings = registerItem("awakened_halite_leggings", new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.LEGGINGS, ArmorInfo.awakened_halInfo)),
//        awakened_halite_boots = registerItem("awakened_halite_boots", new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.BOOTS, ArmorInfo.awakened_halInfo)),
//
//        degraded_helmet = registerItemVethean("degraded_helmet", new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, ArmorInfo.basicHelmInfo, DEGRADED_HELMET.get())),
//        degraded_hood = registerItemVethean("degraded_hood", new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, ArmorInfo.basicHoodInfo, DEGRADED_HOOD.get())),
//        degraded_mask = registerItemVethean("degraded_mask", new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, ArmorInfo.basicMaskInfo, DEGRADED_MASK.get())),
//        degraded_chestplate = registerItemVethean("degraded_chestplate", new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.CHESTPLATE)),
//        degraded_leggings = registerItemVethean("degraded_leggings", new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.LEGGINGS)),
//        degraded_boots = registerItemVethean("degraded_boots", new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.BOOTS)),
//
//        finished_helmet = registerItemVethean("finished_helmet", new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, ArmorInfo.basicHelmInfo, FINISHED_HELMET.get())),
//        finished_hood = registerItemVethean("finished_hood", new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, ArmorInfo.basicHoodInfo, FINISHED_HOOD.get())),
//        finished_mask = registerItemVethean("finished_mask", new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, ArmorInfo.basicMaskInfo, FINISHED_MASK.get())),
//        finished_chestplate = registerItemVethean("finished_chestplate", new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.CHESTPLATE)),
//        finished_leggings = registerItemVethean("finished_leggings", new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.LEGGINGS)),
//        finished_boots = registerItemVethean("finished_boots", new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.BOOTS)),
//
//        glistening_helmet = registerItemVethean("glistening_helmet", new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, ArmorInfo.glisteningHelmInfo, GLISTENING_HELMET.get())),
//        glistening_hood = registerItemVethean("glistening_hood", new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, ArmorInfo.glisteningHoodInfo, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, GLISTENING_HOOD.get())),
//        glistening_mask = registerItemVethean("glistening_mask", new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, ArmorInfo.glisteningMaskInfo, MobEffects.MOVEMENT_SPEED, GLISTENING_MASK.get())),
//        glistening_chestplate = registerItemVethean("glistening_chestplate", new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.CHESTPLATE)),
//        glistening_leggings = registerItemVethean("glistening_leggings", new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.LEGGINGS)),
//        glistening_boots = registerItemVethean("glistening_boots", new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.BOOTS)),
//
//        demonized_helmet = registerItemVethean("demonized_helmet", new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, ArmorInfo.demonizedHelmInfo, DEMONIZED_HELMET.get())),
//        demonized_hood = registerItemVethean("demonized_hood", new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, ArmorInfo.demonizedHoodInfo, new int[]{0, 1, 0}, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, DEMONIZED_HOOD.get())),
//        demonized_mask = registerItemVethean("demonized_mask", new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, ArmorInfo.demonizedMaskInfo, new int[]{1, 0}, MobEffects.MOVEMENT_SPEED, DEMONIZED_MASK.get())),
//        demonized_chestplate = registerItemVethean("demonized_chestplate", new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.CHESTPLATE)),
//        demonized_leggings = registerItemVethean("demonized_leggings", new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.LEGGINGS)),
//        demonized_boots = registerItemVethean("demonized_boots", new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.BOOTS)),
//
//        tormented_helmet = registerItemVethean("tormented_helmet", new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, ArmorInfo.tormentedHelmInfo, TORMENTED_HELMET.get())),
//        tormented_hood = registerItemVethean("tormented_hood", new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, ArmorInfo.tormentedHoodInfo, new int[]{0, 2, 0}, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, TORMENTED_HOOD.get())),
//        tormented_mask = registerItemVethean("tormented_mask", new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, ArmorInfo.tormentedMaskInfo, new int[]{2, 0}, MobEffects.MOVEMENT_SPEED, TORMENTED_MASK.get())),
//        tormented_chestplate = registerItemVethean("tormented_chestplate", new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.CHESTPLATE)),
//        tormented_leggings = registerItemVethean("tormented_leggings", new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.LEGGINGS)),
//        tormented_boots = registerItemVethean("tormented_boots", new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.BOOTS));
    }
}

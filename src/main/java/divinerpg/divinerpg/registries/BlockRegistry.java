package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.blocks.arcana.BlockAcceleron;
import divinerpg.divinerpg.blocks.arcana.BlockArcanaDoor;
import divinerpg.divinerpg.blocks.base.*;
import divinerpg.divinerpg.blocks.iceika.BlockCandyCane;
import divinerpg.divinerpg.blocks.iceika.BlockCozybarkLeaves;
import divinerpg.divinerpg.blocks.iceika.BlockLights;
import divinerpg.divinerpg.blocks.vanilla.BlockAquaTorch;
import divinerpg.divinerpg.blocks.vanilla.BlockAquaWallTorch;
import divinerpg.divinerpg.blocks.vanilla.BlockMobPumpkin;
import divinerpg.divinerpg.blocks.vethea.BlockDreamGrass;
import divinerpg.divinerpg.blocks.vethea.BlockLightCrystal;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static divinerpg.divinerpg.DivineRPG.LOGGER;
import static divinerpg.divinerpg.DivineRPG.MOD_ID;
import static divinerpg.divinerpg.registries.SoundRegistry.*;
import static net.minecraft.block.MapColor.*;
import static net.minecraft.particle.ParticleTypes.FLAME;

public class BlockRegistry {

    public static final ArrayList<Block> divinerpg_blocks = new ArrayList<>();

//    private static RegistryObject<FlowerPotBlock> registerFlowerPot(String name, Supplier<? extends Block> flower) {
//        return BLOCKS.register(name, new FlowerPotBlock((FlowerPotBlock) Blocks.FLOWER_POT, flower, BlockBehaviour.FabricBlockSettings.copy(Blocks.FLOWER_POT)));
//    }

    private static <T extends Block> T registerBlock(String name, T block) {
        return registerBlock(name, block, Rarity.COMMON);
    }
    private static <T extends Block> T registerBlock(String registryName, T block, Rarity rarity) {
        T registeredBlock = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, registryName), block);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new BlockItem(block, new FabricItemSettings().rarity(rarity)));

//        try {
//            int burnTime = ((BlockMod) block).flammability;
//            int spreadSpeed = ((BlockMod) block).fireSpread;
//            FlammableBlockRegistry.getDefaultInstance().add(block, burnTime, spreadSpeed);
//        } catch (Exception e) {
//            try {
//                int burnTime = ((BlockModStairs) block).flammability;
//                int spreadSpeed = ((BlockModStairs) block).fireSpread;
//                FlammableBlockRegistry.getDefaultInstance().add(block, burnTime, spreadSpeed);
//            } catch (Exception e) {
//                try {
//                    int burnTime = ((BlockModSlab) block).flammability;
//                    int spreadSpeed = ((BlockModSlab) block).fireSpread;
//                    FlammableBlockRegistry.getDefaultInstance().add(block, burnTime, spreadSpeed);
//                } catch (Exception e) {
//
//                }
//            }
//        }
        try {
            Field flammability = block.getClass().getField("flammability");
            Field fireSpread = block.getClass().getField("fireSpread");

            Object flammabilityValue = flammability.get(block);
            Object fireSpreadValue = fireSpread.get(block);

            int burnTime = 0;
            if (flammabilityValue != null) {
                burnTime = flammability.getInt(block);
            }
            int spreadSpeed = 0;
            if (fireSpreadValue != null) {
                spreadSpeed = fireSpread.getInt(block);
            }

            FlammableBlockRegistry.getDefaultInstance().add(block, burnTime, spreadSpeed);
        } catch (NoSuchFieldException e) {
            // Block is not burnable
        } catch (IllegalAccessException e) {
            LOGGER.error(e.toString());
        }

        divinerpg_blocks.add(block);
        return registeredBlock;
    }

    private static <T extends Block> T registerFireResistantBlock(String registryName, T block) {
        T registeredBlock = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, registryName), block);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new BlockItem(registeredBlock, new FabricItemSettings().fireproof()));
        divinerpg_blocks.add(block);
        return registeredBlock;
    }

//    private static <T extends Block> T registerWithRender(String registryName, T block, Rarity rarity) {
//        T registeredBlock = BLOCKS.register(registryName, block);
//        if(Objects.equals(registryName, "arcanium_extractor")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemArcaniumExtractor(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "bone_chest")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemBoneChest(registeredBlock, new FabricItemSettings().rarity(rarity)));
//        else if(Objects.equals(registryName, "demon_furnace")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemDemonFurnace(registeredBlock, new FabricItemSettings().rarity(rarity)));
//        else if(Objects.equals(registryName, "frosted_chest")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemFrostedChest(registeredBlock, new FabricItemSettings().rarity(rarity)));
//        else if(Objects.equals(registryName, "present_box")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemPresentBox(registeredBlock, new FabricItemSettings().rarity(rarity)));
//        else if(Objects.equals(registryName, "eden_chest")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemEdenChest(registeredBlock, new FabricItemSettings().rarity(rarity)));
//        else if(Objects.equals(registryName, "parasecta_altar")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemParasectaAltar(registeredBlock, new FabricItemSettings().rarity(rarity)));
//        else if(Objects.equals(registryName, "dramix_altar")) Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemDramixAltar(registeredBlock, new FabricItemSettings().rarity(rarity)));
//        else Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new ItemStatueBlock(registeredBlock, new FabricItemSettings().rarity(rarity).fireproof()));
//        return registeredBlock;
//    }

//    private static <T extends Block> RegistryObject<T> registerFireResistantBlock(String registryName, Supplier<T> block) {
//        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
//        BLOCK_ITEMS.register(registryName, new BlockItem(registeredBlock, new Item.Properties().fireResistant()));
//        return registeredBlock;
//    }
//    private static <T extends Block> RegistryObject<T> registerWithRender(String registryName, Supplier<T> block, Rarity rarity) {
//        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
//        if(Objects.equals(registryName, "arcanium_extractor")) BLOCK_ITEMS.register(registryName, new ItemArcaniumExtractor(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "bone_chest")) BLOCK_ITEMS.register(registryName, new ItemBoneChest(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "demon_furnace")) BLOCK_ITEMS.register(registryName, new ItemDemonFurnace(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "frosted_chest")) BLOCK_ITEMS.register(registryName, new ItemFrostedChest(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "present_box")) BLOCK_ITEMS.register(registryName, new ItemPresentBox(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "eden_chest")) BLOCK_ITEMS.register(registryName, new ItemEdenChest(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "parasecta_altar")) BLOCK_ITEMS.register(registryName, new ItemParasectaAltar(registeredBlock, new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "dramix_altar")) BLOCK_ITEMS.register(registryName, new ItemDramixAltar(registeredBlock, new Item.Properties().rarity(rarity)));
//        else BLOCK_ITEMS.register(registryName, new ItemStatueBlock(registeredBlock::get, new Item.Properties().rarity(rarity).fireResistant()));
//        return registeredBlock;
//    }

    //Dirt & Dream Stone
    public static Block dream_dirt;

    //Grass Blocks
    public static Block
            eden_grass,
            wildwood_grass,
            apalachia_grass,
            skythern_grass,
            mortum_grass;

    //Firewood
    public static Block firewood_log;

    //Dreamwood
    public static Block dreamwood_log;

    //Hyrewood
    public static Block hyrewood_log;

    //Mintwood
    public static Block mintwood_log;

    //Plants & Fungi
    public static Block
            eden_brush,
            moonlight_fern,
            apalachia_tallgrass,
            skythern_brush,
            mortum_brush;

    //Other Lamps
    public static Block eden_lamp;

    public static void register() {
        //Dirt & Dream Stone
        Block frozenDirt = registerBlock("frozen_dirt", new BlockModDirt(PALE_PURPLE));
        Block arcaniteDirt = registerBlock("arcanite_dirt", new BlockModDirt(TERRACOTTA_BLUE));
        Block edenDirt = registerBlock("eden_dirt", new BlockModDirt(TERRACOTTA_YELLOW));
        Block wildwoodDirt = registerBlock("wildwood_dirt", new BlockModDirt(LAPIS_BLUE));
        Block apalachiaDirt = registerBlock("apalachia_dirt", new BlockModDirt(TERRACOTTA_BLUE));
        Block skythernDirt = registerBlock("skythern_dirt", new BlockModDirt(LIGHT_GRAY));
        Block mortumDirt = registerBlock("mortum_dirt", new BlockModDirt(GRAY));
        dream_dirt = registerBlock("dream_dirt", new BlockModDirt(CYAN));
        Block dreamStone = registerBlock("dream_stone", new BlockMod(CYAN, 1.5F, 6));

        //Grass Blocks
        registerBlock("frozen_grass", new BlockModGrass(frozenDirt, DIAMOND_BLUE));
        registerBlock("arcanite_grass", new BlockModGrass(arcaniteDirt, TERRACOTTA_LIGHT_BLUE));
        eden_grass = registerBlock("eden_grass", new BlockModGrass(edenDirt, YELLOW));
        registerBlock("wildwood_grass", new BlockModGrass(wildwoodDirt, WATER_BLUE));
        registerBlock("apalachia_grass", new BlockModGrass(apalachiaDirt, PURPLE));
        registerBlock("skythern_grass", new BlockModGrass(skythernDirt, WHITE_GRAY));  // WOOL
        registerBlock("mortum_grass", new BlockModGrass(mortumDirt, STONE_GRAY));
        registerBlock("flame_grass", new BlockDreamGrass(ORANGE));
        Block dream_grass = registerBlock("dream_grass", new BlockDreamGrass(BRIGHT_TEAL));
        registerBlock("evergrass", new BlockDreamGrass(MAGENTA));
        registerBlock("scorched_grass", new BlockModGrass(dreamStone));

        //Mud
        registerBlock("gelidite", new BlockMod(FabricBlockSettings.copy(Blocks.MUD)));

        //Gravel
        registerBlock("frozen_gravel", new GravelBlock(FabricBlockSettings.copy(Blocks.GRAVEL).mapColor(LICHEN_GREEN)));

        //Sand
        registerBlock("arcanite_sand", new SandBlock(7579884, FabricBlockSettings.copy(Blocks.SAND).mapColor(LIGHT_BLUE)));
        registerBlock("arcanic_sand", new SandBlock(7579884, FabricBlockSettings.copy(Blocks.SAND).mapColor(CYAN)));
        registerBlock("arcanium_rich_sand", new SandBlock(7579884, FabricBlockSettings.copy(Blocks.SAND).mapColor(BLUE)));
//        registerBlock("soul_sludge", new BlockModUnbreakable(FabricBlockSettings.copy(Blocks.SOUL_SAND).strength(-1, 3600000).mapColor(GRAY)));
        registerBlock("soul_sludge_breakable", new BlockMod(FabricBlockSettings.copy(Blocks.SOUL_SAND).mapColor(GRAY)));

        //Ice
        registerBlock("glaciline", new BlockMod(FabricBlockSettings.copy(Blocks.BLUE_ICE).mapColor(LIGHT_BLUE).slipperiness(0.992F)));

//        //Moss
//        brittleMoss = registerBlock("brittle_moss", new BlockBrittleMoss());
//        arcaniteMoss = registerBlock("arcanite_moss", new BlockModMoss(FabricBlockSettings.copy(Blocks.MOSS_BLOCK).mapColor(LIGHT_BLUE)));
//
//        //Stone & Stuff
        registerBlock("milk_stone", new BlockMod(WHITE_GRAY, 1.5F, 6));  // WOOL
        Block frozen_stone = registerBlock("frozen_stone", new BlockMod(LICHEN_GREEN, 1.5F, 6));
        registerBlock("frozen_stairs", new BlockModStairs(frozen_stone));
        registerBlock("frozen_slab", new BlockModSlab(frozen_stone));
        registerBlock("frozen_pressure_plate", new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, LICHEN_GREEN, BlockSetType.STONE));
        registerBlock("frozen_button", new BlockModButton(BlockSetType.STONE));
        Block cobbled_frozen_stone = registerBlock("cobbled_frozen_stone", new BlockMod(LICHEN_GREEN, 2, 6));
        registerBlock("cobbled_frozen_stairs", new BlockModStairs(cobbled_frozen_stone));
        registerBlock("cobbled_frozen_slab", new BlockModSlab(cobbled_frozen_stone));
        registerBlock("cobbled_frozen_wall", new BlockModWall(cobbled_frozen_stone));
        registerBlock("cobbled_frozen_pressure_plate", new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, LICHEN_GREEN, BlockSetType.STONE));
        registerBlock("cobbled_frozen_button", new BlockModButton(BlockSetType.STONE));
        Block cobaltite = registerBlock("cobaltite", new BlockMod(LIGHT_BLUE, 1.5F, 6));
        registerBlock("cobaltite_stairs", new BlockModStairs(cobaltite));
        registerBlock("cobaltite_slab", new BlockModSlab(cobaltite));
        registerBlock("cobaltite_wall", new BlockModWall(cobaltite));
        registerBlock("cobaltite_pressure_plate", new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, LIGHT_BLUE, BlockSetType.STONE));
        registerBlock("cobaltite_button", new BlockModButton(BlockSetType.STONE));
        registerBlock("icy_stone", new BlockMod(PALE_PURPLE, 50, 1200));  // ICE
        registerBlock("blue_stone", new BlockLightCrystal(LIGHT_BLUE));
//        registerBlock("icicle", new BlockIcicle());
        Block coalstone = registerBlock("coalstone", new BlockMod(GRAY, 1.5F, 6));
        registerBlock("coalstone_stairs", new BlockModStairs(coalstone));
        registerBlock("coalstone_slab", new BlockModSlab(coalstone));
        registerBlock("coalstone_wall", new BlockModWall(coalstone));
        registerBlock("coalstone_pressure_plate", new BlockModPressurePlate(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE, GRAY, BlockSetType.STONE));
        registerBlock("coalstone_button", new BlockModButton(BlockSetType.STONE));
//        registerBlock("thermal_vent", new BlockThermalVent());
        registerBlock("arcanite_stone", new BlockMod(CYAN, 1.5F, 6));
        registerBlock("ancient_stone", new BlockModUnbreakable(GRAY));
        registerBlock("ancient_stone_breakable", new BlockMod(GRAY, 1.5F, 6));
        registerBlock("soul_stone", new BlockModUnbreakable(TERRACOTTA_BLUE));
        registerBlock("soul_stone_breakable", new BlockMod(TERRACOTTA_BLUE, 1.5F, 6));
        registerBlock("twilight_stone", new BlockMod(TERRACOTTA_LIGHT_BLUE, 1.5F, 6));
        registerBlock("divine_moss_stone", new BlockMod(STONE_GRAY, 2, 6));
        registerBlock("divine_rock", new BlockMod(TERRACOTTA_YELLOW, 1.5F, 6));
        registerBlock("everstone", new BlockModUnbreakable(DARK_GREEN));  // PLANT
        registerBlock("white_everstone", new BlockModUnbreakable(WHITE_GRAY));  // WOOL
        registerBlock("dark_everstone", new BlockModUnbreakable(BLACK));
        registerBlock("black_hungerstone", new BlockModUnbreakable(BLACK));
        registerBlock("green_hungerstone", new BlockModUnbreakable(DARK_GREEN)); // PLANT
        registerBlock("luna_stone", new BlockMod(TERRACOTTA_BLUE, 2, 6));
        registerBlock("hive_wall", new BlockMod(FabricBlockSettings.copy(Blocks.HONEYCOMB_BLOCK).mapColor(GREEN).luminance((state) -> 7)));  // .lightLevel((state) -> 7)
        registerBlock("fire_crystal", new BlockLightCrystal(RED));
        registerBlock("firelight", new BlockLightCrystal(BLUE));

        //Ores
        registerBlock("arlemite_ore", new BlockMod(STONE_GRAY, 3, 3));
        registerBlock("arlemite_ore_deepslate", new BlockMod(DEEPSLATE_GRAY, 4.5F, 3, BlockSoundGroup.DEEPSLATE, Instrument.BASEDRUM));
        registerBlock("realmite_ore", new BlockMod(STONE_GRAY, 3, 3));
        registerBlock("realmite_ore_deepslate", new BlockMod(DEEPSLATE_GRAY, 4.5F, 3, BlockSoundGroup.DEEPSLATE, Instrument.BASEDRUM));
        registerBlock("rupee_ore", new BlockMod(STONE_GRAY, 3, 3));
        registerBlock("rupee_ore_deepslate", new BlockMod(DEEPSLATE_GRAY, 4.5F, 3, BlockSoundGroup.DEEPSLATE, Instrument.BASEDRUM));
//        registerBlock("bloodgem_ore", new DropExperienceBlock(FabricBlockSettings.copy(Blocks.NETHER_GOLD_ORE), UniformInt.of(3, 7)));
        registerBlock("torridite_ore", new BlockMod(DARK_RED, 3, 1200, BlockSoundGroup.NETHER_ORE, Instrument.BASEDRUM));  // NETHER
//        registerBlock("anthracite_ore", new DropExperienceBlock(FabricBlockSettings.copy(Blocks.COAL_ORE).mapColor(LICHEN_GREEN), UniformInt.of(0, 2)));
        registerBlock("oxdrite_ore", new BlockMod(LICHEN_GREEN, 3, 3));
        registerBlock("raw_arcanium", new BlockMod(BLACK, 5, 6));
        registerBlock("eden_ore", new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32));
        registerBlock("wildwood_ore", new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32));
        registerBlock("apalachia_ore", new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32));
        registerBlock("skythern_ore", new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32));
        registerBlock("mortum_ore", new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32));

        //Compressed Ore Blocks
        registerBlock("raw_arlemite_block",new BlockMod(LIME, 5, 6));  // COLOR_LIGHT_GREEN
        registerBlock("arlemite_block", new BlockMod(LIME, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));  // COLOR_LIGHT_GREEN
        registerBlock("raw_realmite_block", new BlockMod(ORANGE, 5, 6));
        registerBlock("realmite_block", new BlockMod(ORANGE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("raw_rupee_block", new BlockMod(LIGHT_BLUE, 5, 6));
        registerBlock("rupee_block", new BlockMod(LIGHT_BLUE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("bloodgem_block", new BlockMod(DULL_PINK, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));  // CRIMSON_STEM
        registerBlock("raw_torridite_block",new BlockMod(DULL_RED, 5, 1200));  // CRIMSON_NYLIUM
        registerFireResistantBlock("torridite_block",new BlockMod(FabricBlockSettings.create().mapColor(DULL_RED).strength(5F, 1200).requiresTool().sounds(BlockSoundGroup.METAL)));  // CRIMSON_NYLIUM
        registerBlock("raw_oxdrite_block", new BlockMod(BROWN, 5, 6));
        registerBlock("oxdrite_block", new BlockMod(BROWN, 5, 6, BlockSoundGroup.COPPER, Instrument.HARP));
        registerBlock("arcanium_block", new BlockMod(LIGHT_BLUE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));

        //Twilight Compressed Ore Blocks
        registerBlock("eden_block", new BlockMod(ORANGE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("wildwood_block", new BlockMod(LAPIS_BLUE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("apalachia_block", new BlockMod(MAGENTA, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("skythern_block", new BlockMod(WHITE_GRAY, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));  // WOOL
        registerBlock("mortum_block", new BlockMod(GRAY, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));

//        //Arcana Portal Frames
//        arcanaHardPortalFrame = registerBlock("arcana_hard_portal_frame", new BlockArcanaPortalFrame(-1, 3600000));
//        arcanaPortalFrame = registerBlock("arcana_portal_frame", new BlockArcanaPortalFrame(5, 6));

//        //Clusters etc.
//        olivineBlock = registerBlock("olivine_block", new AmethystBlock(FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK).mapColor(GREEN).lightLevel((state) -> 1)));
//        buddingOlivine = registerBlock("budding_olivine", new BlockBuddingOlivine(FabricBlockSettings.copy(Blocks.BUDDING_AMETHYST).mapColor(GREEN).lightLevel((state) -> 2)));
//        olivineCluster = registerBlock("olivine_cluster", new AmethystClusterBlock(7, 3, FabricBlockSettings.copy(Blocks.AMETHYST_CLUSTER).mapColor(GREEN).lightLevel((state) -> 3)));

        //Extra Wood Blocks
        registerBlock("plank_design", new BlockModPlanks(OAK_TAN, BlockSoundGroup.WOOD));  // WOOD

        //Divine Tree
//        registerBlock("divine_sapling", new BlockModSapling(GOLD, Blocks.GRASS, Blocks.DIRT, new DivineTreeGrower()));
        registerBlock("divine_leaves", new BlockModLeaves(GOLD, BlockSoundGroup.GRASS));
        registerBlock("divine_log", new BlockModLog(TERRACOTTA_LIME, BlockSoundGroup.CHERRY_WOOD));
        registerBlock("divine_wood", new BlockModLog(TERRACOTTA_LIME, BlockSoundGroup.CHERRY_WOOD));
        registerBlock("stripped_divine_log", new BlockModLog(TERRACOTTA_LIME, BlockSoundGroup.CHERRY_WOOD));
        registerBlock("stripped_divine_wood", new BlockModLog(TERRACOTTA_LIME, BlockSoundGroup.CHERRY_WOOD));
        Block divine_planks = registerBlock("divine_planks", new BlockModPlanks(TERRACOTTA_LIME, BlockSoundGroup.CHERRY_WOOD));
        registerBlock("divine_stairs", new BlockModStairs(divine_planks));
        registerBlock("divine_slab", new BlockModSlab(divine_planks));
        registerBlock("divine_fence", new BlockModFence(TERRACOTTA_LIME, BlockSoundGroup.CHERRY_WOOD));
        registerBlock("divine_fence_gate", new BlockModGate(TERRACOTTA_LIME, WoodType.CHERRY));
        registerBlock("divine_door", new BlockModDoor(TERRACOTTA_LIME, BlockSetType.CHERRY));
        registerBlock("divine_trapdoor", new BlockModTrapdoor(TERRACOTTA_LIME, BlockSetType.CHERRY));
        registerBlock("divine_pressure_plate", new BlockModPressurePlate(TERRACOTTA_LIME, BlockSetType.CHERRY));
        registerBlock("divine_button", new BlockModButton(BlockSetType.CHERRY));

        //Shiverspine
//        registerBlock("shiverspine_sapling", new BlockModSapling(LICHEN_GREEN, frozenGrass, frozenDirt, new ShiverspineTreeGrower()));
        registerBlock("brittle_leaves", new BlockModLeaves(WHITE_GRAY, BlockSoundGroup.GRASS));  // WOOL
        registerBlock("shiverspine_log", new BlockModLog(LICHEN_GREEN, BlockSoundGroup.WOOD));
        registerBlock("shiverspine_wood", new BlockModLog(LIGHT_GRAY, BlockSoundGroup.WOOD));
        registerBlock("stripped_shiverspine_log", new BlockModLog(LICHEN_GREEN, BlockSoundGroup.WOOD));
        registerBlock("stripped_shiverspine_wood", new BlockModLog(LICHEN_GREEN, BlockSoundGroup.WOOD));
        Block shiverspine_planks = registerBlock("shiverspine_planks", new BlockModPlanks(LICHEN_GREEN, BlockSoundGroup.WOOD));
        registerBlock("shiverspine_stairs", new BlockModStairs(shiverspine_planks));
        registerBlock("shiverspine_slab", new BlockModSlab(shiverspine_planks));
        registerBlock("shiverspine_fence", new BlockModFence(LICHEN_GREEN, BlockSoundGroup.WOOD));
        registerBlock("shiverspine_fence_gate", new BlockModGate(LICHEN_GREEN, WoodType.SPRUCE));
        registerBlock("shiverspine_ladder", new BlockModLadder());
        registerBlock("shiverspine_door", new BlockModDoor(LICHEN_GREEN, BlockSetType.SPRUCE));
        registerBlock("shiverspine_trapdoor", new BlockModTrapdoor(LICHEN_GREEN, BlockSetType.SPRUCE));
        registerBlock("shiverspine_pressure_plate", new BlockModPressurePlate(LICHEN_GREEN, BlockSetType.SPRUCE));
        registerBlock("shiverspine_button", new BlockModButton(BlockSetType.SPRUCE));

        //Auroraoak
//        registerBlock("auroraoak_sapling", new BlockModSapling(PURPLE, frozenGrass, frozenDirt, new AuroraoakTreeGrower()));
        registerBlock("auroraoak_leaves", new BlockModLeaves(PURPLE, BlockSoundGroup.CHERRY_LEAVES));
        registerBlock("auroraoak_log", new BlockModLog(PALE_PURPLE, BlockSoundGroup.WOOD));  // ICE
        registerBlock("auroraoak_wood", new BlockModLog(BROWN, BlockSoundGroup.WOOD));
        registerBlock("stripped_auroraoak_log", new BlockModLog(PALE_PURPLE, BlockSoundGroup.WOOD));  // ICE
        registerBlock("stripped_auroraoak_wood", new BlockModLog(PALE_PURPLE, BlockSoundGroup.WOOD));  // ICE
        Block auroraoak_planks = registerBlock("auroraoak_planks", new BlockModPlanks(PALE_PURPLE, BlockSoundGroup.WOOD));  // ICE
        registerBlock("auroraoak_stairs", new BlockModStairs(auroraoak_planks));
        registerBlock("auroraoak_slab", new BlockModSlab(auroraoak_planks));
        registerBlock("auroraoak_fence", new BlockModFence(PALE_PURPLE, BlockSoundGroup.WOOD));  // ICE
        registerBlock("auroraoak_fence_gate", new BlockModGate(PALE_PURPLE, WoodType.OAK));  // ICE
        registerBlock("auroraoak_door", new BlockModDoor(PALE_PURPLE, BlockSetType.OAK));  // ICE
        registerBlock("auroraoak_trapdoor", new BlockModTrapdoor(PALE_PURPLE, BlockSetType.OAK));  // ICE
        registerBlock("auroraoak_pressure_plate", new BlockModPressurePlate(PALE_PURPLE, BlockSetType.OAK));  // ICE
        registerBlock("auroraoak_button", new BlockModButton(BlockSetType.OAK));

        //Cozybark
//        registerBlock("cozybark_sapling", new BlockModSapling(CRIMSON_STEM, frozenGrass, frozenDirt, new CozybarkTreeGrower()));
        registerBlock("cozybark_leaves", new BlockCozybarkLeaves());
        registerBlock("cozybark_log", new BlockModLog(TERRACOTTA_PURPLE, BlockSoundGroup.WOOD));
        registerBlock("cozybark_wood", new BlockModLog(TERRACOTTA_PURPLE, BlockSoundGroup.WOOD));
        registerBlock("stripped_cozybark_log", new BlockModLog(TERRACOTTA_PURPLE, BlockSoundGroup.WOOD));
        registerBlock("stripped_cozybark_wood", new BlockModLog(TERRACOTTA_PURPLE, BlockSoundGroup.WOOD));
        Block cozybark_planks = registerBlock("cozybark_planks", new BlockModPlanks(TERRACOTTA_PURPLE, BlockSoundGroup.WOOD));
        registerBlock("cozybark_stairs", new BlockModStairs(cozybark_planks));
        registerBlock("cozybark_slab", new BlockModSlab(cozybark_planks));
        registerBlock("cozybark_fence", new BlockModFence(TERRACOTTA_PURPLE, BlockSoundGroup.WOOD));
        registerBlock("cozybark_fence_gate", new BlockModGate(TERRACOTTA_PURPLE, WoodType.DARK_OAK));
        registerBlock("cozybark_door", new BlockModDoor(TERRACOTTA_PURPLE, BlockSetType.DARK_OAK));
        registerBlock("cozybark_trapdoor", new BlockModTrapdoor(TERRACOTTA_PURPLE, BlockSetType.DARK_OAK));
        registerBlock("cozybark_pressure_plate", new BlockModPressurePlate(TERRACOTTA_PURPLE, BlockSetType.DARK_OAK));
        registerBlock("cozybark_button", new BlockModButton(BlockSetType.DARK_OAK));

        //Streamleaf
//        registerBlock("streamleaf_sapling", new BlockModSapling(LICHEN_GREEN, frozenGrass, frozenDirt, new StreamleafTreeGrower()));
        registerBlock("streamleaf_leaves", new BlockModLeaves(LICHEN_GREEN, BlockSoundGroup.AZALEA_LEAVES));
        registerBlock("streamleaf_log", new BlockModLog(PALE_PURPLE, BlockSoundGroup.NETHER_WOOD));  // ICE
        registerBlock("streamleaf_wood", new BlockModLog(TERRACOTTA_BROWN, BlockSoundGroup.NETHER_WOOD));
        registerBlock("stripped_streamleaf_log", new BlockModLog(PALE_PURPLE, BlockSoundGroup.NETHER_WOOD));  // ICE
        registerBlock("stripped_streamleaf_wood", new BlockModLog(PALE_PURPLE, BlockSoundGroup.NETHER_WOOD));  // ICE
        Block streamleaf_planks = registerBlock("streamleaf_planks", new BlockModPlanks(PALE_PURPLE, BlockSoundGroup.NETHER_WOOD));  // ICE
        registerBlock("streamleaf_stairs", new BlockModStairs(streamleaf_planks));
        registerBlock("streamleaf_slab", new BlockModSlab(streamleaf_planks));
        registerBlock("streamleaf_fence", new BlockModFence(PALE_PURPLE, BlockSoundGroup.NETHER_WOOD));  // ICE
        registerBlock("streamleaf_fence_gate", new BlockModGate(PALE_PURPLE, WoodType.WARPED));  // ICE
        registerBlock("streamleaf_door", new BlockModDoor(PALE_PURPLE, BlockSetType.WARPED));  // ICE
        registerBlock("streamleaf_trapdoor", new BlockModTrapdoor(PALE_PURPLE, BlockSetType.WARPED));  // ICE
        registerBlock("streamleaf_pressure_plate", new BlockModPressurePlate(PALE_PURPLE, BlockSetType.WARPED));  // ICE
        registerBlock("streamleaf_button", new BlockModButton(BlockSetType.WARPED));

//        //Glowsprout
//        glowsprout = registerBlock("glowsprout", new FungusBlock(FabricBlockSettings.copy(Blocks.WARPED_FUNGUS).mapColor(CYAN), ConfiguredFeatureKeys.GLOWSPROUT, gelidite));
//        glowsproutBulb = registerBlock("glowsprout_bulb", new HalfTransparentBlock(FabricBlockSettings.copy(Blocks.OCHRE_FROGLIGHT).noOcclusion().lightLevel((state) -> 10).mapColor(DIAMOND_BLUE)));
//        glowsproutStem = registerBlock("glowsprout_stem", new BlockModStem(LIGHT_BLUE));
//
//        //Lowsprout
//        lowsprout = registerBlock("lowsprout", new FungusBlock(FabricBlockSettings.copy(Blocks.WARPED_FUNGUS).mapColor(GREEN), ConfiguredFeatureKeys.LOWSPROUT, gelidite));
//        lowsproutBulb = registerBlock("lowsprout_bulb", new HalfTransparentBlock(FabricBlockSettings.copy(Blocks.VERDANT_FROGLIGHT).noOcclusion().lightLevel((state) -> 10).mapColor(WARPED_WART_BLOCK)));
//        lowsproutStem = registerBlock("lowsprout_stem", new BlockModStem(LICHEN_GREEN));
//
//        //Slowsprout
//        slowsprout = registerBlock("slowsprout", new FungusBlock(FabricBlockSettings.copy(Blocks.WARPED_FUNGUS).mapColor(MAGENTA), ConfiguredFeatureKeys.SLOWSPROUT, gelidite));
//        slowsproutBulb = registerBlock("slowsprout_bulb", new HalfTransparentBlock(FabricBlockSettings.copy(Blocks.PEARLESCENT_FROGLIGHT).noOcclusion().lightLevel((state) -> 10).mapColor(ICE)));
//        slowsproutStem = registerBlock("slowsprout_stem", new BlockModStem(COLOR_PINK));
//
        //Eucalyptus
        registerBlock("eucalyptus_log", new BlockModLog(TERRACOTTA_WHITE, BlockSoundGroup.WOOD));
        registerBlock("eucalyptus_wood", new BlockModLog(LIGHT_GRAY, BlockSoundGroup.WOOD));
        registerBlock("stripped_eucalyptus_log", new BlockModLog(TERRACOTTA_WHITE, BlockSoundGroup.WOOD));
        registerBlock("stripped_eucalyptus_wood", new BlockModLog(OAK_TAN, BlockSoundGroup.WOOD));  // WOOD
        Block eucalyptus_planks = registerBlock("eucalyptus_planks", new BlockModPlanks(TERRACOTTA_WHITE, BlockSoundGroup.WOOD));
        registerBlock("eucalyptus_stairs", new BlockModStairs(eucalyptus_planks));
        registerBlock("eucalyptus_slab", new BlockModSlab(eucalyptus_planks));
        registerBlock("eucalyptus_fence", new BlockModFence(TERRACOTTA_WHITE, BlockSoundGroup.WOOD));
        registerBlock("eucalyptus_fence_gate", new BlockModGate(TERRACOTTA_WHITE, WoodType.BIRCH));
        registerBlock("eucalyptus_door", new BlockModDoor(TERRACOTTA_WHITE, BlockSetType.BIRCH));
        registerBlock("eucalyptus_trapdoor", new BlockModTrapdoor(TERRACOTTA_WHITE, BlockSetType.BIRCH));
        registerBlock("eucalyptus_pressure_plate", new BlockModPressurePlate(TERRACOTTA_WHITE, BlockSetType.BIRCH));
        registerBlock("eucalyptus_button", new BlockModButton(BlockSetType.BIRCH));

        //Eden Tree
//        registerBlock("eden_sapling", new BlockModSapling(GOLD, edenGrass, edenDirt, new EdenTreeGrower()));
        registerBlock("eden_leaves", new BlockModLeaves(GOLD, BlockSoundGroup.AZALEA_LEAVES));
        registerBlock("eden_log", new BlockModLog(PALE_YELLOW, BlockSoundGroup.WOOD));  // SAND
        registerBlock("eden_wood", new BlockModLog(BROWN, BlockSoundGroup.WOOD));
        registerBlock("stripped_eden_log", new BlockModLog(PALE_YELLOW, BlockSoundGroup.WOOD));  // SAND
        registerBlock("stripped_eden_wood", new BlockModLog(PALE_YELLOW, BlockSoundGroup.WOOD));  // SAND
        Block eden_planks = registerBlock("eden_planks", new BlockModPlanks(PALE_YELLOW, BlockSoundGroup.WOOD));  // SAND
        registerBlock("eden_stairs", new BlockModStairs(eden_planks));
        registerBlock("eden_slab", new BlockModSlab(eden_planks));
        registerBlock("eden_fence", new BlockModFence(PALE_YELLOW, BlockSoundGroup.WOOD));  // SAND
        registerBlock("eden_fence_gate", new BlockModGate(PALE_YELLOW, WoodType.OAK));  // SAND
        registerBlock("eden_door", new BlockModDoor(PALE_YELLOW, BlockSetType.OAK));  // SAND
        registerBlock("eden_trapdoor", new BlockModTrapdoor(PALE_YELLOW, BlockSetType.OAK));  // SAND
        registerBlock("eden_pressure_plate", new BlockModPressurePlate(PALE_YELLOW, BlockSetType.OAK));  // SAND
        registerBlock("eden_button", new BlockModButton(BlockSetType.OAK));

        //Wildwood Tree
//        registerBlock("wildwood_sapling", new BlockModSapling(LIGHT_BLUE, wildwoodGrass, wildwoodDirt, new WildwoodTreeGrower()));
        registerBlock("wildwood_leaves", new BlockModLeaves(LIGHT_BLUE, BlockSoundGroup.AZALEA_LEAVES));
        registerBlock("wildwood_log", new BlockModLog(LIGHT_BLUE, BlockSoundGroup.WOOD));
        registerBlock("wildwood_wood", new BlockModLog(BLUE, BlockSoundGroup.WOOD));
        registerBlock("stripped_wildwood_log", new BlockModLog(LIGHT_BLUE, BlockSoundGroup.WOOD));
        registerBlock("stripped_wildwood_wood", new BlockModLog(LIGHT_BLUE, BlockSoundGroup.WOOD));
        Block wildwood_planks = registerBlock("wildwood_planks", new BlockModPlanks(LIGHT_BLUE, BlockSoundGroup.WOOD));
        registerBlock("wildwood_stairs", new BlockModStairs(wildwood_planks));
        registerBlock("wildwood_slab", new BlockModSlab(wildwood_planks));
        registerBlock("wildwood_fence", new BlockModFence(LIGHT_BLUE, BlockSoundGroup.WOOD));
        registerBlock("wildwood_fence_gate", new BlockModGate(LIGHT_BLUE, WoodType.DARK_OAK));
        registerBlock("wildwood_door", new BlockModDoor(LIGHT_BLUE, BlockSetType.DARK_OAK));
        registerBlock("wildwood_trapdoor", new BlockModTrapdoor(LIGHT_BLUE, BlockSetType.DARK_OAK));
        registerBlock("wildwood_pressure_plate", new BlockModPressurePlate(LIGHT_BLUE, BlockSetType.DARK_OAK));
        registerBlock("wildwood_button", new BlockModButton(BlockSetType.DARK_OAK));

        //Apalachia Tree
//        registerBlock("apalachia_sapling", new BlockModSapling(MAGENTA, apalachiaGrass, apalachiaDirt, new ApalachiaTreeGrower()));
        registerBlock("apalachia_leaves", new BlockModLeaves(MAGENTA, BlockSoundGroup.AZALEA_LEAVES));
        registerBlock("apalachia_log", new BlockModLog(MAGENTA, BlockSoundGroup.WOOD));
        registerBlock("apalachia_wood", new BlockModLog(DARK_DULL_PINK, BlockSoundGroup.WOOD));  // WARPED_HYPHAE
        registerBlock("stripped_apalachia_log", new BlockModLog(MAGENTA, BlockSoundGroup.WOOD));
        registerBlock("stripped_apalachia_wood", new BlockModLog(MAGENTA, BlockSoundGroup.WOOD));
        Block apalachia_planks = registerBlock("apalachia_planks", new BlockModPlanks(MAGENTA, BlockSoundGroup.WOOD));
        registerBlock("apalachia_stairs", new BlockModStairs(apalachia_planks));
        registerBlock("apalachia_slab", new BlockModSlab(apalachia_planks));
        registerBlock("apalachia_fence", new BlockModFence(MAGENTA, BlockSoundGroup.WOOD));
        registerBlock("apalachia_fence_gate", new BlockModGate(MAGENTA, WoodType.ACACIA));
        registerBlock("apalachia_door", new BlockModDoor(MAGENTA, BlockSetType.ACACIA));
        registerBlock("apalachia_trapdoor", new BlockModTrapdoor(MAGENTA, BlockSetType.ACACIA));
        registerBlock("apalachia_pressure_plate", new BlockModPressurePlate(MAGENTA, BlockSetType.ACACIA));
        registerBlock("apalachia_button", new BlockModButton(BlockSetType.ACACIA));

        //Skythern Tree
//        registerBlock("skythern_sapling", new BlockModSapling(WOOL, skythernGrass, skythernDirt, new SkythernTreeGrower()));
        registerBlock("skythern_leaves", new BlockModLeaves(LIGHT_GRAY, BlockSoundGroup.AZALEA_LEAVES));
        registerBlock("skythern_log", new BlockModLog(WHITE_GRAY, BlockSoundGroup.NETHER_WOOD));  // WOOL
        registerBlock("skythern_wood", new BlockModLog(LIGHT_GRAY, BlockSoundGroup.NETHER_WOOD));
        registerBlock("stripped_skythern_log", new BlockModLog(WHITE_GRAY, BlockSoundGroup.NETHER_WOOD));
        registerBlock("stripped_skythern_wood", new BlockModLog(WHITE_GRAY, BlockSoundGroup.NETHER_WOOD));
        Block skythern_planks = registerBlock("skythern_planks", new BlockModPlanks(WHITE_GRAY, BlockSoundGroup.NETHER_WOOD));  // WOOL
        registerBlock("skythern_stairs", new BlockModStairs(skythern_planks));
        registerBlock("skythern_slab", new BlockModSlab(skythern_planks));
        registerBlock("skythern_fence", new BlockModFence(WHITE_GRAY, BlockSoundGroup.NETHER_WOOD));  // WOOL
        registerBlock("skythern_fence_gate", new BlockModGate(WHITE_GRAY, WoodType.CRIMSON));  // WOOL
        registerBlock("skythern_door", new BlockModDoor(WHITE_GRAY, BlockSetType.CRIMSON));  // WOOL
        registerBlock("skythern_trapdoor", new BlockModTrapdoor(WHITE_GRAY, BlockSetType.CRIMSON));  // WOOL
        registerBlock("skythern_pressure_plate", new BlockModPressurePlate(WHITE_GRAY, BlockSetType.CRIMSON));  // WOOL
        registerBlock("skythern_button", new BlockModButton(BlockSetType.CRIMSON));

        //Mortum Tree
//        registerBlock("mortum_sapling", new BlockModSapling(GRAY, mortumGrass, mortumDirt, new MortumTreeGrower()));
        registerBlock("mortum_leaves", new BlockModLeaves(BLACK, BlockSoundGroup.AZALEA_LEAVES));
        registerBlock("mortum_log", new BlockModLog(TERRACOTTA_PINK, BlockSoundGroup.WOOD));
        registerBlock("mortum_wood", new BlockModLog(TERRACOTTA_PINK, BlockSoundGroup.WOOD));
        registerBlock("stripped_mortum_log", new BlockModLog(TERRACOTTA_PINK, BlockSoundGroup.WOOD));
        registerBlock("stripped_mortum_wood", new BlockModLog(TERRACOTTA_PINK, BlockSoundGroup.WOOD));
        Block mortum_planks = registerBlock("mortum_planks", new BlockModPlanks(GRAY, BlockSoundGroup.WOOD));
        registerBlock("mortum_stairs", new BlockModStairs(mortum_planks));
        registerBlock("mortum_slab", new BlockModSlab(mortum_planks));
        registerBlock("mortum_fence", new BlockModFence(GRAY, BlockSoundGroup.WOOD));
        registerBlock("mortum_fence_gate", new BlockModGate(GRAY, WoodType.MANGROVE));
        registerBlock("mortum_door", new BlockModDoor(GRAY, BlockSetType.MANGROVE));
        registerBlock("mortum_trapdoor", new BlockModTrapdoor(GRAY, BlockSetType.MANGROVE));
        registerBlock("mortum_pressure_plate", new BlockModPressurePlate(GRAY, BlockSetType.MANGROVE));
        registerBlock("mortum_button", new BlockModButton(BlockSetType.MANGROVE));

        //Firewood
        registerBlock("firewood_leaves", new BlockModLeaves(DULL_RED, BlockSoundGroup.GRASS));  // CRIMSON_NYLIUM
        firewood_log = registerBlock("firewood_log", new BlockModLog(TERRACOTTA_ORANGE, BlockSoundGroup.WOOD));
        registerBlock("firewood_wood", new BlockModLog(RED, BlockSoundGroup.WOOD));
        registerBlock("stripped_firewood_log", new BlockModLog(TERRACOTTA_ORANGE, BlockSoundGroup.WOOD));
        registerBlock("stripped_firewood_wood", new BlockModLog(TERRACOTTA_ORANGE, BlockSoundGroup.WOOD));

        //Dreamwood
        registerBlock("dreamwood_leaves", new BlockModLeaves(CYAN, BlockSoundGroup.GRASS));
        dreamwood_log = registerBlock("dreamwood_log", new BlockModLog(LIGHT_BLUE, BlockSoundGroup.WOOD));
        registerBlock("dreamwood_wood", new BlockModLog(CYAN, BlockSoundGroup.WOOD));
        registerBlock("stripped_dreamwood_log", new BlockModLog(LIGHT_BLUE, BlockSoundGroup.WOOD));
        registerBlock("stripped_dreamwood_wood", new BlockModLog(LIGHT_BLUE, BlockSoundGroup.WOOD));

        //Hyrewood
        registerBlock("hyrewood_leaves", new BlockModLeaves(BLUE, BlockSoundGroup.GRASS));
        hyrewood_log = registerBlock("hyrewood_log", new BlockModLog(BLUE, BlockSoundGroup.WOOD));
        registerBlock("hyrewood_wood", new BlockModLog(BLUE, BlockSoundGroup.WOOD));
        registerBlock("stripped_hyrewood_log", new BlockModLog(BLUE, BlockSoundGroup.WOOD));
        registerBlock("stripped_hyrewood_wood", new BlockModLog(BLUE, BlockSoundGroup.WOOD));

        //Mintwood
        registerBlock("mintwood_leaves", new BlockModLeaves(BRIGHT_TEAL, BlockSoundGroup.GRASS));  // WARPED_WART_BLOCK
        mintwood_log = registerBlock("mintwood_log", new BlockModLog(DIAMOND_BLUE, BlockSoundGroup.WOOD));
        registerBlock("mintwood_wood", new BlockModLog(BRIGHT_TEAL, BlockSoundGroup.WOOD));  // WARPED_WART_BLOCK
        registerBlock("stripped_mintwood_log", new BlockModLog(DIAMOND_BLUE, BlockSoundGroup.WOOD));
        registerBlock("stripped_mintwood_wood", new BlockModLog(CYAN, BlockSoundGroup.WOOD));

        //Wool
        registerBlock("checker", new BlockMod(WHITE_GRAY,.8F, .8F, 60, 30, BlockSoundGroup.WOOL, Instrument.GUITAR));  // WOOL
        registerBlock("fancy_wool", new BlockMod(DARK_CRIMSON,.8F, .8F, 60, 30, BlockSoundGroup.WOOL, Instrument.GUITAR));  // CRIMSON_HYPHAE
        registerBlock("rainbow_wool", new BlockMod(PURPLE,.8F, .8F, 60, 30, BlockSoundGroup.WOOL, Instrument.GUITAR));
        registerBlock("workshop_carpet", new BlockMod(TERRACOTTA_RED,.8F, .8F, 60, 30, BlockSoundGroup.WOOL, Instrument.GUITAR));

        //Bookshelves
        registerBlock("workshop_bookcase", new BlockModBookshelf(GRAY));
        registerBlock("dungeon_bookshelf", new BlockModBookshelf(BLUE));

        //Asphalt
        Block asphalt = registerBlock("asphalt", new BlockMod(BLACK, 1.5F, 6));
        registerBlock("asphalt_stairs", new BlockModStairs(asphalt));
        registerBlock("asphalt_slab", new BlockModSlab(asphalt));

        //Darkstone & Crying Obsidian variants
        Block darkstone = registerBlock("darkstone", new BlockMod(TERRACOTTA_GREEN, 4));
        registerBlock("bleeding_obsidian", new BlockMod(BLACK, 10));
        registerBlock("shining_obsidian", new BlockMod(BLACK, 10));
        registerBlock("glittering_obsidian", new BlockMod(BLACK, 10));
        registerBlock("seeping_obsidian", new BlockMod(BLACK, 10));
        registerBlock("vwooping_obsidian", new BlockMod(BLACK, 10));

        //Bricks
        registerBlock("milk_stone_bricks", new BlockMod(WHITE_GRAY, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));  // WOOL
        registerBlock("iron_bricks", new BlockMod(IRON_GRAY, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));  // METAL
        registerFireResistantBlock("torridite_bricks", new BlockMod(DULL_RED, 2, 1200, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));  // CRIMSON_NYLIUM
        registerBlock("lava_bricks", new BlockMod(FabricBlockSettings.create().mapColor(BRIGHT_RED).requiresTool().strength(2, 6).sounds(BlockSoundGroup.NETHER_BRICKS).instrument(Instrument.BASEDRUM).luminance((state) -> 6)));  // FIRE
        registerBlock("realmite_bricks", new BlockMod(ORANGE, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("gold_bricks", new BlockMod(GOLD, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("arlemite_bricks", new BlockMod(LIME, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("green_bricks", new BlockMod(GREEN, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("darkstone_bricks", new BlockMod(FabricBlockSettings.copy(darkstone).strength(6, 1200).sounds(BlockSoundGroup.NETHER_BRICKS)));
        registerBlock("aquatonic_bricks", new BlockMod(TEAL, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));  // WARPED_NYLIUM
        registerBlock("diamond_bricks", new BlockMod(DIAMOND_BLUE, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("lapis_lazuli_bricks", new BlockMod(LAPIS_BLUE, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("purple_bricks", new BlockMod(PURPLE, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("magenta_bricks", new BlockMod(MAGENTA, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("bloodgem_bricks", new BlockMod(DULL_PINK, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));  // CRIMSON_STEM

        //Minibricks
        registerBlock("minibricks", new BlockMod(STONE_GRAY, 2, 6));
        registerFireResistantBlock("bedrock_minibricks", new BlockMod(GRAY, 6, 1200, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerFireResistantBlock("torridite_minibricks", new BlockMod(DULL_RED, 2, 1200, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));  // CRIMSON_NYLIUM
        registerBlock("realmite_minibricks", new BlockMod(ORANGE, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("arlemite_minibricks", new BlockMod(LIME, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("rupee_minibricks", new BlockMod(LIGHT_BLUE, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));
        registerBlock("bloodgem_minibricks", new BlockMod(DULL_PINK, 2, 6, BlockSoundGroup.NETHER_BRICKS, Instrument.BASEDRUM));  // CRIMSON_STEM

        //Iceika Bricks & Other Blocks
        Block frozen_bricks = registerBlock("frozen_bricks", new BlockMod(LICHEN_GREEN, 1.5F, 6));
        registerBlock("frozen_brick_stairs", new BlockModStairs(frozen_bricks));
        registerBlock("frozen_brick_slab", new BlockModSlab(frozen_bricks));
        registerBlock("frozen_brick_wall", new BlockModWall(frozen_bricks));
        registerBlock("frozen_brick_pressure_plate", new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, LICHEN_GREEN, BlockSetType.STONE));
        registerBlock("frozen_brick_button", new BlockModButton(BlockSetType.STONE));
        registerBlock("snow_bricks", new BlockMod(WHITE, 1.5F, 6));  // SNOW
        registerBlock("icy_bricks", new BlockMod(PALE_PURPLE, 50, 1200));  // ICE
        registerBlock("chiseled_icy_bricks", new BlockMod(PALE_PURPLE, 50, 1200));  // ICE
        Block coalstone_bricks = registerBlock("coalstone_bricks", new BlockMod(GRAY, 1.5F, 6));
        registerBlock("coalstone_brick_stairs", new BlockModStairs(coalstone_bricks));
        registerBlock("coalstone_brick_slab", new BlockModSlab(coalstone_bricks));
        registerBlock("coalstone_brick_wall", new BlockModWall(coalstone_bricks));
        registerBlock("coalstone_brick_pressure_plate", new BlockModPressurePlate(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE, GRAY, BlockSetType.POLISHED_BLACKSTONE));
        registerBlock("coalstone_brick_button", new BlockModButton(BlockSetType.POLISHED_BLACKSTONE));
        registerBlock("chiseled_coalstone_bricks", new BlockMod(GRAY, 1.5F, 6));
        Block polished_coalstone = registerBlock("polished_coalstone", new BlockMod(GRAY, 1.5F, 6));
        registerBlock("polished_coalstone_stairs", new BlockModStairs(polished_coalstone));
        registerBlock("polished_coalstone_slab", new BlockModSlab(polished_coalstone));
        registerBlock("polished_coalstone_wall", new BlockModWall(polished_coalstone));
        registerBlock("polished_coalstone_pressure_plate", new BlockModPressurePlate(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE, GRAY, BlockSetType.POLISHED_BLACKSTONE));
        registerBlock("polished_coalstone_button", new BlockModButton(BlockSetType.POLISHED_BLACKSTONE));
        Block polished_cobaltite = registerBlock("polished_cobaltite", new BlockMod(LIGHT_BLUE, 1.5F, 6));
        registerBlock("polished_cobaltite_stairs", new BlockModStairs(polished_cobaltite));
        registerBlock("polished_cobaltite_slab", new BlockModSlab(polished_cobaltite));
        registerBlock("polished_cobaltite_wall", new BlockModWall(polished_cobaltite));
        registerBlock("polished_cobaltite_pressure_plate", new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, LIGHT_BLUE, BlockSetType.STONE));
        registerBlock("polished_cobaltite_button", new BlockModButton(BlockSetType.STONE));
        Block cut_oxdrite = registerBlock("cut_oxdrite", new BlockMod(FabricBlockSettings.create().mapColor(BROWN).requiresTool().strength(5, 6).sounds(BlockSoundGroup.COPPER).notSolid().nonOpaque()));  // .noOcclusion()
        registerBlock("cut_oxdrite_stairs", new BlockModStairs(cut_oxdrite));
        registerBlock("cut_oxdrite_slab", new BlockModSlab(cut_oxdrite));
        registerBlock("cut_oxdrite_wall", new BlockModWall(cut_oxdrite));
        registerBlock("cut_oxdrite_pressure_plate", new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, BROWN, BlockSetType.IRON));
        registerBlock("cut_oxdrite_button", new BlockModButton(BlockSetType.IRON));

        //Arcana Bricks & Other Blocks
        Block ancient_bricks = registerBlock("ancient_bricks", new BlockModUnbreakable(TEAL));  // WARPED_NYLIUM
        registerBlock("ancient_brick_stairs", new BlockModStairs(ancient_bricks));
        registerBlock("ancient_brick_slab", new BlockModSlab(ancient_bricks));
        registerBlock("ancient_brick_wall", new BlockModWall(ancient_bricks));
        Block degraded_bricks = registerBlock("degraded_bricks", new BlockModUnbreakable(BLUE));
        registerBlock("degraded_brick_stairs", new BlockModStairs(degraded_bricks));
        registerBlock("degraded_brick_slab", new BlockModSlab(degraded_bricks));
        registerBlock("degraded_brick_wall", new BlockModWall(degraded_bricks));
        registerBlock("light_degraded_brick", new BlockModUnbreakable(CYAN));
        registerBlock("dark_degraded_brick", new BlockModUnbreakable(BLACK));
        registerBlock("ancient_tile", new BlockModUnbreakable(BLUE));
        registerBlock("arcanium_metal", new BlockModPillar(TERRACOTTA_BLUE, -1, 3600000, BlockSoundGroup.METAL));
        registerBlock("arcanium_power", new BlockModUnbreakable(GRAY));
        registerBlock("battle_bricks", new BlockModUnbreakable(BRIGHT_RED));  // FIRE
        registerBlock("gilded_bricks", new BlockModUnbreakable(ORANGE));
        Block ancient_bricks_breakable = registerBlock("ancient_bricks_breakable", new BlockMod(TEAL, 1.5F, 6));  // WARPED_NYLIUM
        registerBlock("ancient_brick_stairs_breakable", new BlockModStairs(ancient_bricks_breakable));
        registerBlock("ancient_brick_slab_breakable", new BlockModSlab(ancient_bricks_breakable));
        registerBlock("ancient_brick_wall_breakable", new BlockModWall(ancient_bricks_breakable));
        Block degraded_bricks_breakable = registerBlock("degraded_bricks_breakable", new BlockMod(BLUE, 1.5F, 6));
        registerBlock("degraded_brick_stairs_breakable", new BlockModStairs(degraded_bricks_breakable));
        registerBlock("degraded_brick_slab_breakable", new BlockModSlab(degraded_bricks_breakable));
        registerBlock("degraded_brick_wall_breakable", new BlockModWall(degraded_bricks_breakable));
        registerBlock("ancient_tile_breakable", new BlockMod(BLUE, 2, 6));
        registerBlock("arcanium_metal_breakable", new BlockModPillar(TERRACOTTA_BLUE, 5, 6, BlockSoundGroup.METAL));
        registerBlock("arcanium_power_breakable", new BlockMod(GRAY, 2, 6));
        registerBlock("arcanite_tubes", new BlockModLadder());
        registerBlock("arcanite_ladder", new BlockModLadder());

        //Twilight Bricks
        registerBlock("eden_bricks", new BlockMod(YELLOW, 1.5F, 6));
        registerBlock("wildwood_bricks", new BlockMod(LIGHT_BLUE, 1.5F, 6));
        registerBlock("apalachia_bricks", new BlockMod(MAGENTA, 1.5F, 6));
        registerBlock("skythern_bricks", new BlockMod(WHITE_GRAY, 1.5F, 6));  // WOOL
        registerBlock("mortum_bricks", new BlockMod(GRAY, 1.5F, 6));

        //Vethea Bricks & Extra Blocks
        registerBlock("hall_wall", new BlockModUnbreakable(DARK_RED));  // NETHER
        registerBlock("red_dream_bricks", new BlockMod(DULL_RED, 1.5F, 6));  // CRIMSON_NYLIUM
        registerBlock("light_dream_bricks", new BlockMod(LAPIS_BLUE, 1.5F, 6));
        registerBlock("dark_dream_bricks", new BlockMod(BLUE, 1.5F, 6));
        registerBlock("blue_karos_bricks", new BlockModUnbreakable(BLUE));
        registerBlock("black_karos_bricks", new BlockModUnbreakable(BLACK));
        registerBlock("metal_caging", new BlockMod(FabricBlockSettings.create().mapColor(TERRACOTTA_GREEN).requiresTool().strength(5).sounds(BlockSoundGroup.METAL).notSolid().nonOpaque()));  // .noOcclusion()
//        registerBlock("heliotic_beam", new BlockHelioticBeam());
        registerBlock("luna_bricks", new BlockMod(BLUE, 2, 6));
        registerBlock("crypt_floor", new BlockModUnbreakable(TERRACOTTA_GREEN));
        registerBlock("crypt_wall", new BlockModUnbreakable(BROWN));
        registerBlock("chamber_wall", new BlockModUnbreakable(BROWN));
        registerBlock("shifted_chamber_wall", new BlockModUnbreakable(BROWN));
        registerBlock("stacked_chamber_wall", new BlockModUnbreakable(BROWN));

        //Steel
        registerBlock("steel", new BlockMod(IRON_GRAY, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));  // METAL
        registerBlock("black_steel", new BlockMod(BLACK, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("red_steel", new BlockMod(RED, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("orange_steel", new BlockMod(ORANGE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("yellow_steel", new BlockMod(YELLOW, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("green_steel", new BlockMod(GREEN, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("cyan_steel", new BlockMod(CYAN, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("blue_steel", new BlockMod(BLUE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("purple_steel", new BlockMod(PURPLE, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));
        registerBlock("magenta_steel", new BlockMod(MAGENTA, 5, 6, BlockSoundGroup.METAL, Instrument.HARP));

        //Candy Canes
        registerBlock("red_candy_cane", new BlockCandyCane(RED));
        registerBlock("yellow_candy_cane", new BlockCandyCane(YELLOW));
        registerBlock("green_candy_cane", new BlockCandyCane(EMERALD_GREEN));
        registerBlock("blue_candy_cane", new BlockCandyCane(BLUE));
        registerBlock("pink_candy_cane", new BlockCandyCane(MAGENTA));

        //Lights
        registerBlock("red_fairy_lights", new BlockLights());
        registerBlock("yellow_fairy_lights", new BlockLights());
        registerBlock("green_fairy_lights", new BlockLights());
        registerBlock("blue_fairy_lights", new BlockLights());
        registerBlock("purple_fairy_lights", new BlockLights());

        //Torches  // TODO: Double check why
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "aqua_torch"), new BlockAquaTorch());
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "aqua_wall_torch"), new BlockAquaWallTorch());
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "arcanium_torch"), new BlockModTorch());
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "arcanium_wall_torch"), new BlockModWallTorch());
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "eden_torch"), new BlockModTorch());
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "eden_wall_torch"), new BlockModWallTorch());
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "skeleton_torch"), new TorchBlock(FabricBlockSettings.copy(Blocks.TORCH).sounds(BlockSoundGroup.BONE), FLAME));  // .BONE_BLOCK
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "skeleton_wall_torch"), new WallTorchBlock(FabricBlockSettings.copy(Blocks.WALL_TORCH).sounds(BlockSoundGroup.BONE), FLAME));  // .BONE_BLOCK

        //Stone Lamps
        registerBlock("molten_lamp", new BlockModLamp(ORANGE, BlockSoundGroup.GLASS));
        registerBlock("divine_lamp", new BlockModLamp(TERRACOTTA_YELLOW, BlockSoundGroup.GLASS));
        registerBlock("jungle_lamp", new BlockModLamp(LIME, BlockSoundGroup.GLASS));
        registerBlock("terran_lamp", new BlockModLamp(EMERALD_GREEN, BlockSoundGroup.GLASS));
        registerBlock("ice_lamp", new BlockModLamp(CYAN, BlockSoundGroup.GLASS));
        registerBlock("soulfire_lamp", new BlockModLamp(WATER_BLUE, BlockSoundGroup.GLASS));
        registerBlock("ender_stone_lamp", new BlockModLamp(PURPLE, BlockSoundGroup.GLASS));

        //Other Lamps
        registerBlock("milky_lamp", new BlockModLamp(OFF_WHITE));  // QUARTZ
        eden_lamp = registerBlock("eden_lamp", new BlockModLamp(RED));
        registerBlock("torridite_lamp", new BlockModLamp(DULL_RED));  // CRIMSON_NYLIUM
        registerBlock("lava_lamp", new BlockModLamp(BRIGHT_RED));  // FIRE
        registerBlock("draken_lamp", new BlockModLamp(ORANGE));
        registerBlock("realmite_lamp", new BlockModLamp(ORANGE));
        registerBlock("blaze_lamp", new BlockModLamp(YELLOW));
        registerBlock("gold_lamp", new BlockModLamp(GOLD));
        registerBlock("arlemite_lamp", new BlockModLamp(LIME));
        registerBlock("kraken_lamp", new BlockModLamp(TEAL));  // WARPED_NYLIUM
        registerBlock("diamond_lamp", new BlockModLamp(DIAMOND_BLUE));
        registerBlock("rupee_lamp", new BlockModLamp(LIGHT_BLUE));
        registerBlock("lapis_lazuli_lamp", new BlockModLamp(LAPIS_BLUE));
        registerBlock("aqua_lamp", new BlockModLamp(BLUE));
        registerBlock("ender_lamp", new BlockModLamp(PURPLE));
        registerBlock("bloodgem_lamp", new BlockModLamp(PINK));

        //Extra Lamps
//        registerBlock("slime_light", new BlockModLight());
        registerBlock("workshop_lamp", new BlockModLamp(LIGHT_BLUE, BlockSoundGroup.GLASS));
        registerBlock("dungeon_lamp", new BlockModUnbreakable(OFF_WHITE, true));  // QUARTZ
        registerBlock("dungeon_lamp_breakable", new BlockMod(FabricBlockSettings.create().mapColor(OFF_WHITE).strength(.3F).sounds(BlockSoundGroup.GLASS).instrument(Instrument.HAT).luminance(15)));  // QUARTZ
        registerBlock("cell_lamp", new BlockModLamp(LIME, BlockSoundGroup.GLASS));
        registerBlock("village_lamp", new BlockModLamp(TERRACOTTA_RED, BlockSoundGroup.GLASS));
//        registerBlock("dream_lamp", new BlockDreamLamp());

        //Bridges
        registerBlock("dark_bridge", new BlockModBridge());
        registerBlock("star_bridge", new BlockModBridge());

//        //Powered Fences
//        registerBlock("red_fence", new BlockModLightFence(RED));
//        registerBlock("blue_fence", new BlockModLightFence(BLUE));
//        registerBlock("green_fence", new BlockModLightFence(GREEN));

//        //Glass
//        registerBlock("frosted_glass", new BlockModGlass());
//        registerBlock("stained_glass", new BlockModGlass());
//        registerBlock("smooth_glass", new BlockModGlass());

        //Plants & Fungi
//        registerBlock("brittle_grass", BlockBrittleGrass);
//        registerBlock("winterberry_bush", BlockWinterberryBush);
//        BLOCKS.register("winterberry_vines_body", new BlockWinterberryVinesBody(FabricBlockSettings.copy(Blocks.WEEPING_VINES_PLANT).sound(BlockSoundGroup.CAVE_VINES)));
//        registerBlock("winterberry_vines_head", new BlockWinterberryVinesHead(FabricBlockSettings.copy(Blocks.WEEPING_VINES).sound(BlockSoundGroup.CAVE_VINES)));
        registerBlock("crimpetal", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 7, FabricBlockSettings.copy(Blocks.POPPY).mapColor(MAGENTA)));
        registerBlock("roofbell", new FlowerBlock(StatusEffects.POISON, 14, FabricBlockSettings.copy(Blocks.RED_MUSHROOM).mapColor(PINK)));
        registerBlock("winterbloom", new FlowerBlock(StatusEffects.LEVITATION, 8, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY).mapColor(WHITE)));  // SNOW
        registerBlock("wisp_leaf", new FlowerBlock(StatusEffects.DOLPHINS_GRACE, 10, FabricBlockSettings.copy(Blocks.ALLIUM).mapColor(LIGHT_GRAY)));
//        registerBlock("globebrush", new BlockModDoublePlant(frozenGrass, WHITE));  // SNOW
//        registerBlock("thermoliage", new BlockModDoublePlant(frozenGrass, PINK));
//        registerBlock("arcana_brush", new BlockTwilightGrass(arcaniteSand, ICE_BLUE));
//        registerBlock("arcana_bush", new BlockTwilightGrass(arcaniteSand, TERRACOTTA_BLUE));
//        registerBlock("gem_of_the_dunes", new BlockTwilightFlower(arcaniteSand, MAGENTA), Rarity.EPIC),
//        BLOCKS.register("arcanite_vines_body", new BlockArcaniteVinesBody(FabricBlockSettings.copy(Blocks.WEEPING_VINES_PLANT).sounds(BlockSoundGroup.CAVE_VINES)));
//        registerBlock("arcanite_vines_head", new BlockArcaniteVinesHead(FabricBlockSettings.copy(Blocks.WEEPING_VINES).sounds(BlockSoundGroup.CAVE_VINES)));
//        eden_brush = registerBlock("eden_brush", new BlockTwilightGrass(edenGrass, COLOR_YELLOW));
//        registerBlock("sun_blossom", new BlockTwilightFlower(edenGrass, .9, .6, PLANT));
//        registerBlock("sunbloom", new BlockTwilightFlower(edenGrass, TERRACOTTA_YELLOW));
//        moonlight_fern = registerBlock("moonlight_fern", new BlockTwilightGrass(wildwoodGrass, ICE));
//        registerBlock("moon_bud", new BlockTwilightFlower(wildwoodGrass, .8, .7, QUARTZ));
//        registerBlock("wildwood_tallgrass", new BlockModDoublePlant(wildwoodGrass, BLUE, BlockSoundGroup.GRASS));
        registerBlock("truffle", new BlockMod(FabricBlockSettings.create().mapColor(TERRACOTTA_BROWN).strength(1).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.WOOD)));
//        registerBlock("wildwood_vine", new BlockModVine(LIGHT_BLUE));
//        apalachia_tallgrass = registerBlock("apalachia_tallgrass", new BlockTwilightGrass(apalachiaGrass, TERRACOTTA_BLUE));
//        registerBlock("dusk_bloom", new BlockTwilightFlower(apalachiaGrass, .5, .5, TERRACOTTA_BLUE));
//        registerBlock("dusk_flower", new BlockModDoublePlant(apalachiaGrass, TERRACOTTA_BLUE));
//        skythern_brush = registerBlock("skythern_brush", new BlockTwilightGrass(skythern_grass, WHITE_GRAY));  // WOOL
//        registerBlock("dust_lily", new BlockTwilightFlower(skythernGrass, WHITE_GRAY));  // WOOL
//        registerBlock("dust_brambles", new BlockBrambles(skythernGrass, WHITE_GRAY));  // WOOL
//        registerBlock("mortum_brush", new BlockTwilightGrass(mortumGrass, GRAY));
//        registerBlock("eye_plant", new BlockTwilightFlower(mortumGrass, .5, .5, GRAY));
//        registerBlock("demon_brambles", new BlockBrambles(mortumGrass, GRAY));
//        registerBlock("shine_grass", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("cracklespike", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("fernite", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("dreamglow", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("bulbatobe", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("shimmer", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("yellow_dulah", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("green_dulah", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("green_gemtop", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("purple_gemtop", new BlockTwilightFlower(dream_grass, CYAN));
//        registerBlock("weedwood_vine", new BlockModVine(BLUE));
//        registerBlock("blossomed_weedwood_vine", new BlockModVine(BLUE));

//        //Crops
//        registerBlock("tomato_plant", new BlockModCrop(ItemRegistry.tomato_seeds.getId()));
//        registerBlock("white_mushroom_plant", new BlockModCrop(ItemRegistry.white_mushroom_seeds.getId()));
//        registerBlock("aquamarine_plant", new BlockModCrop(ItemRegistry.aquamarine_seeds.getId()));
//        registerBlock("eucalyptus_plant", new BlockModCrop(ItemRegistry.eucalyptus_root_seeds.getId()));
//        registerBlock("firestock_plant", new BlockStackPlant(ItemRegistry.firestock_seeds.getId()));
//        registerBlock("hitchak_plant", new BlockModCrop(ItemRegistry.hitchak_seeds.getId()));
//        registerBlock("lamona_plant", new BlockModCrop(ItemRegistry.lamona_seeds.getId()));
//        registerBlock("marsine_plant", new BlockModCrop(ItemRegistry.marsine_seeds.getId()));
//        registerBlock("pinfly_plant", new BlockStackPlant(ItemRegistry.pinfly_seeds.getId()));
//        registerBlock("veilo_plant", new BlockModCrop(ItemRegistry.veilo_seeds.getId()));
//        registerBlock("moonbulb_plant", new BlockModDoubleCrop(4, ItemRegistry.moonbulb_seeds.getId()));
//        registerBlock("purple_glowbone_plant", new BlockModDoubleCrop(6, ItemRegistry.purple_glowbone_seeds.getId()));
//        registerBlock("pink_glowbone_plant", new BlockModDoubleCrop(6, ItemRegistry.pink_glowbone_seeds.getId()));
//        registerBlock("sky_plant", new BlockModCrop(ItemRegistry.sky_plant_seeds.getId()));

        //Mob Pumpkins
        registerBlock("blaze_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_BLAZE_AMBIENT, YELLOW));
        registerBlock("creeper_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_CREEPER_PRIMED, EMERALD_GREEN));
        registerBlock("cyclops_pumpkin", new BlockMobPumpkin(CYCLOPS, TERRACOTTA_LIME));
        registerBlock("ender_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_ENDERMAN_SCREAM, BLACK));
        registerBlock("ender_watcher_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_ENDERMAN_AMBIENT, TERRACOTTA_BLUE));
        registerBlock("frost_pumpkin", new BlockMobPumpkin(FROST, DARK_AQUA));  // WARPED_STEM
        registerBlock("ghast_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_GHAST_SCREAM, WHITE));  // SNOW
        registerBlock("glacon_pumpkin", new BlockMobPumpkin(GLACIDE, CYAN));
        registerBlock("hellspider_pumpkin", new BlockMobPumpkin(HELL_SPIDER, DARK_RED));  // NETHER
        registerBlock("jungle_spider_pumpkin", new BlockMobPumpkin(JUNGLE_SPIDER, DARK_GREEN));  // PLANT
        registerBlock("skeleton_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_SKELETON_AMBIENT, WHITE_GRAY));  // WOOL
        registerBlock("spider_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_SPIDER_AMBIENT, GRAY));
        registerBlock("zombie_pumpkin", new BlockMobPumpkin(SoundEvents.ENTITY_ZOMBIE_AMBIENT, GREEN));

//        //Statues
//        registerWithRender("ancient_entity_statue", new BlockStatue(IRON_GOLEM_DEATH), Rarity.RARE);
//        registerWithRender("the_watcher_statue", new BlockStatue(ROAR), Rarity.RARE);
//        registerWithRender("king_of_scorchers_statue", new BlockStatue(KING_OF_SCORCHERS), Rarity.RARE);
//        registerWithRender("kitra_statue", new BlockStatue(WHALE), Rarity.RARE);
//        registerWithRender("ayeraco_statue", BlockStatueColored, Rarity.RARE);
//        registerWithRender("dramix_statue", new BlockStatue(DRAMIX), Rarity.RARE);
//        registerWithRender("parasecta_statue", new BlockStatue(PARASECTA), Rarity.RARE);
//        registerWithRender("sunstorm_statue", new BlockStatue(SPARKLER), Rarity.RARE);
//        registerWithRender("termasect_statue", new BlockStatue(WOOD_STEP), Rarity.RARE);
//        registerWithRender("eternal_archer_statue", new BlockStatue(ARCHER), Rarity.RARE);
//        registerWithRender("experienced_cori_statue", new BlockStatue(CORI), Rarity.RARE);
//        registerWithRender("vamacheron_statue", new BlockStatue(null), Rarity.RARE);
//        registerWithRender("karot_statue", new BlockStatue(null), Rarity.RARE);
//        registerWithRender("twilight_demon_statue", new BlockStatue(INSECT), Rarity.RARE);
//        registerWithRender("densos_statue", new BlockStatue(DENSOS), Rarity.RARE);
//        registerWithRender("reyvor_statue", new BlockStatue(REYVOR), Rarity.RARE);
//        registerWithRender("soul_fiend_statue", new BlockStatue(null), Rarity.RARE);

//        //Proximity Spawner
//        registerBlock("proximity_spawner", new BlockModProximitySpawner());

//        //Encaged Arcana Creatures
//        registerBlock("encaged_captain_merik", new BlockModMobCage(EntityRegistry.CAPTAIN_MERIK.getId(), ItemRegistry.firestock.getId()));
//        registerBlock("encaged_datticon", new BlockModMobCage(EntityRegistry.DATTICON.getId(), ItemRegistry.aquamarine.getId()));
//        registerBlock("encaged_kazari", new BlockModMobCage(EntityRegistry.KAZARI.getId(), ItemRegistry.lamona.getId()));
//        registerBlock("encaged_leorna", new BlockModMobCage(EntityRegistry.LEORNA.getId(), ItemRegistry.hitchak.getId()));
//        registerBlock("encaged_lord_vatticus", new BlockModMobCage(EntityRegistry.LORD_VATTICUS.getId(), ItemRegistry.marsine.getId()));
//        registerBlock("encaged_war_general", new BlockModMobCage(EntityRegistry.WAR_GENERAL.getId(), ItemRegistry.pinfly.getId()));
//        registerBlock("encaged_zelus", new BlockModMobCage(EntityRegistry.ZELUS.getId(), ItemRegistry.veilo.getId()));

//        //Boss Spawners
//        registerBlock("calcified_brain", new BlockModMobCage(FabricBlockSettings.copy(Blocks.BONE_BLOCK), EntityRegistry.KITRA.getId(), ItemRegistry.liopleurodon_skull.getId(), new BlockPos(0, 5, 0)));
//        registerBlock("sunstorm_spawner", new BlockModMobCage(EntityRegistry.SUNSTORM.getId(), ItemRegistry.eden_chunk.getId(), COLOR_YELLOW));
//        registerBlock("termasect_spawner", new BlockModMobCage(EntityRegistry.TERMASECT.getId(), ItemRegistry.wildwood_chunk.getId(), LIGHT_BLUE, new BlockPos(0, 11, 0)));
//        registerBlock("eternal_archer_spawner", new BlockModMobCage(EntityRegistry.ETERNAL_ARCHER.getId(), ItemRegistry.apalachia_chunk.getId(), MAGENTA));
//        registerBlock("experienced_cori_spawner", new BlockModMobCage(EntityRegistry.EXPERIENCED_CORI.getId(), ItemRegistry.skythern_chunk.getId(), LIGHT_GRAY, new BlockPos(0, 11, 0)));

//        //Boss Altars
//        registerWithRender("dramix_altar", new BlockModAltar(CRIMSON_HYPHAE), Rarity.COMMON);
//        registerWithRender("parasecta_altar", new BlockModAltar(TERRACOTTA_BROWN), Rarity.COMMON);
//        registerBlock("karos_altar", new BlockKarosAltar(WARPED_WART_BLOCK));
//        registerBlock("lunic_altar", new BlockLunicAltar(BLUE));
//        registerBlock("quadrotic_altar", new BlockQuadroticAltar(BLUE));
//        registerBlock("raglok_altar", new BlockRaglokAltar(BROWN));
//        registerBlock("wreck_altar", new BlockWreckAltar(RED));

//        //Hive Egg
//        registerBlock("hive_egg", new BlockHiveEgg());

//        //Ayeraco Technical Blocks// TODO: Double check why
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ayeraco_beam_red"), new BlockAyeracoBeam(BossBar.Color.RED));
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ayeraco_beam_yellow"), new BlockAyeracoBeam(BossBar.Color.YELLOW));
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ayeraco_beam_green"), new BlockAyeracoBeam(BossBar.Color.GREEN));
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ayeraco_beam_blue"), new BlockAyeracoBeam(BossBar.Color.BLUE));
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ayeraco_beam_purple"), new BlockAyeracoBeam(BossBar.Color.PURPLE));
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ayeraco_beam_pink"), new BlockAyeracoBeam(BossBar.Color.PINK));
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ayeraco_spawn"), new BlockAyeracoSpawn());
        
        //Doors
        registerBlock("steel_door", new BlockModDoor(IRON_GRAY));  // METAL
        registerBlock("ancient_brick_door", new BlockArcanaDoor(MapColor.TEAL, ItemRegistry.ancient_key));  // WARPED_NYLIUM
        registerBlock("degraded_brick_door", new BlockArcanaDoor(MapColor.BLUE, ItemRegistry.degraded_key));
        registerBlock("soul_sludge_door", new BlockArcanaDoor(MapColor.GRAY, ItemRegistry.sludge_key));
        registerBlock("soul_stone_door", new BlockArcanaDoor(TERRACOTTA_BLUE, ItemRegistry.soul_key));
        registerBlock("barred_door", new BlockModDoor(DARK_GREEN));  // PLANT

//        //Crafting & Stuff
//        registerBlock("altar_of_corruption", new BlockAltarOfCorruption(), Rarity.UNCOMMON);
//        registerWithRender("arcanium_extractor", new BlockArcaniumExtractor(), Rarity.RARE);
//        registerBlock("infusion_table", new BlockInfusionTable(), Rarity.RARE);

//        //Furnaces
//        registerBlock("coalstone_furnace", new BlockModInfiniFurnace(BlockEntityRegistry.COALSTONE_FURNACE::get, COLOR_GRAY));
//        registerBlock("molten_furnace", new BlockModInfiniFurnace(BlockEntityRegistry.MOLTEN_FURNACE::get, TERRACOTTA_LIGHT_GRAY), Rarity.UNCOMMON);
//        registerBlock("greenlight_furnace", new BlockModFurnace(BlockEntityRegistry.GREENLIGHT_FURNACE::get, TERRACOTTA_LIGHT_GREEN), Rarity.UNCOMMON);
//        registerBlock("oceanfire_furnace", new BlockModInfiniFurnace(BlockEntityRegistry.OCEANFIRE_FURNACE::get, COLOR_CYAN), Rarity.UNCOMMON);
//        registerBlock("moonlight_furnace", new BlockModFurnace(BlockEntityRegistry.MOONLIGHT_FURNACE::get, TERRACOTTA_BLUE), Rarity.UNCOMMON);
//        registerBlock("whitefire_furnace", new BlockModInfiniFurnace(BlockEntityRegistry.WHITEFIRE_FURNACE::get, SNOW), Rarity.UNCOMMON);
//        registerWithRender("demon_furnace", new BlockDemonFurnace(), Rarity.EPIC);

//        //Chests
//        registerBlock("crate", new BlockCrate());
//        registerWithRender("bone_chest", new BlockBoneChest(), Rarity.COMMON);
//        registerWithRender("frosted_chest", new BlockFrostedChest(), Rarity.COMMON);
//        registerWithRender("present_box", new BlockPresentBox(), Rarity.COMMON);
//        registerWithRender("eden_chest", new BlockEdenChest(), Rarity.COMMON);

//        //Nightmare Bed
//        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "nightmare_bed", new BlockNightmareBed()));

        //Other Utility Blocks
//        registerBlock("hellfire_sponge", new BlockHellfireSponge());
//        registerBlock("cold_hellfire_sponge", new BlockColdHellfireSponge());
//        registerBlock("frosted_allure", new BlockFrostedAllure(), Rarity.UNCOMMON);
//        registerBlock("robbin_nest", new BlockRobbinNest());
//        registerBlock("robbin_hut", new BlockRobbinHut());
        registerBlock("acceleron", new BlockAcceleron(), Rarity.UNCOMMON);
//        registerBlock("elevantium", new BlockElevantium(), Rarity.UNCOMMON);
//        registerBlock("soul_trap", new BlockModSoulTrap());

//        //Traps
//        registerBlock("spike_block", new BlockSpike(false, METAL));
//        registerBlock("hot_spike_block", new BlockSpike(true, CRIMSON_NYLIUM));
//        registerBlock("heat_trap", new BlockHeatTrap());
//        registerBlock("karos_heat_tile", new BlockKarosHeatTile());
//        registerBlock("karos_dispenser", new BlockKarosDispenser());

//        //Acid
//        registerBlock("acid_block", new BlockAcid());
//        registerBlock("bacterial_acid", new BlockAcid());
//        registerBlock("lunic_acid", new BlockAcid());

//        //Fire
//        registerBlock("iceika_fire", new BlockIceikaFire());
//        registerBlock("blue_fire", new BlockBlueFire());

//        //Portals
//        registerBlock("arcana_portal", new BlockArcanaPortal());
//        registerBlock("iceika_portal", new BlockModPortal(Blocks.SNOW_BLOCK));
//        registerBlock("eden_portal", new BlockModPortal(divineRock.get()));
//        registerBlock("wildwood_portal", new BlockModPortal(edenBlock.get()));
//        registerBlock("apalachia_portal", new BlockModPortal(wildwoodBlock.get()));
//        registerBlock("skythern_portal", new BlockModPortal(apalachiaBlock.get()));
//        registerBlock("mortum_portal", new BlockModPortal(skythernBlock.get()));
//        registerBlock("vethea_portal", new BlockModPortal(mortumBlock.get()));

//        //Air
//        registerBlock("dungeon_air", new BlockModDungeonAir(), Rarity.EPIC);

//        //Creative Mode Blocks
//        registerBlock("random_item_dropper", new BlockRandomItemDropper());


//        //Saplings
//        registerFlowerPot("divine_sapling_pot", new divineSapling());
//        registerFlowerPot("shiverspine_sapling_pot", new shiverspineSapling());
//        registerFlowerPot("auroraoak_sapling_pot", new auroraoakSapling());
//        registerFlowerPot("cozybark_sapling_pot", new cozybarkSapling());
//        registerFlowerPot("streamleaf_sapling_pot", new streamleafSapling());
//        registerFlowerPot("eden_sapling_pot", new edenSapling());
//        registerFlowerPot("wildwood_sapling_pot", new wildwoodSapling());
//        registerFlowerPot("apalachia_sapling_pot", new apalachiaSapling());
//        registerFlowerPot("skythern_sapling_pot", new skythernSapling());
//        registerFlowerPot("mortum_sapling_pot", new mortumSapling());
//
//        //Mushrooms
//        registerFlowerPot("glowsprout_pot", new glowsprout());
//        registerFlowerPot("lowsprout_pot", new lowsprout());
//        registerFlowerPot("slowsprout_pot", new slowsprout());
//        registerFlowerPot("dreamglow_pot", new dreamglow());
//
//        //Short Flowers
//        registerFlowerPot("crimpetal_pot", new crimpetal());
//        registerFlowerPot("roofbell_pot", new roofbell());
//        registerFlowerPot("winterbloom_pot", new winterbloom());
//        registerFlowerPot("wisp_leaf_pot", new wispLeaf());
//        registerFlowerPot("gem_of_the_dunes_pot", new gemOfTheDunes());
//        registerFlowerPot("sun_blossom_pot", new sunBlossom());
//        registerFlowerPot("sunbloom_pot", new sunbloom());
//        registerFlowerPot("moonlight_fern_pot", new moonlightFern());
//        registerFlowerPot("moon_bud_pot", new moonBud());
//        registerFlowerPot("dusk_bloom_pot", new duskBloom());
//        registerFlowerPot("dust_lily_pot", new dustLily());
//        registerFlowerPot("eye_plant_pot", new eyePlant());
//        registerFlowerPot("shine_grass_pot", new shineGrass());
//        registerFlowerPot("cracklespike_pot", new cracklespike());
//        registerFlowerPot("fernite_pot", new fernite());
//        registerFlowerPot("bulbatobe_pot", new bulbatobe());
//        registerFlowerPot("shimmer_pot", new shimmer());
//        registerFlowerPot("yellow_dulah_pot", new yellowDulah());
//        registerFlowerPot("green_dulah_pot", new greenDulah());
//        registerFlowerPot("green_gemtop_pot", new greenGemtop());
//        registerFlowerPot("purple_gemtop_pot", new purpleGemtop());
//
//        //Tall Flowers
//        registerFlowerPot("globebrush_pot", new globebrush());
//        registerFlowerPot("thermoliage_pot", new thermoliage());
//        registerFlowerPot("dusk_flower_pot", new duskFlower());
//        registerFlowerPot("dust_brambles_pot", new dustBrambles());
//        registerFlowerPot("demon_brambles_pot", new demonBrambles());
//
//        //Bushes
//        registerFlowerPot("arcana_bush_pot", new arcanaBush());
    }
}

package naturix.divinerpg.registry;

import java.util.ArrayList;
import java.util.List;

import naturix.divinerpg.enums.WoodVariant;
import naturix.divinerpg.objects.blocks.BlockDoorBase;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.objects.blocks.BlockModFire;
import naturix.divinerpg.objects.blocks.BlockModGlass;
import naturix.divinerpg.objects.blocks.BlockModGrass;
import naturix.divinerpg.objects.blocks.BlockModLeaves;
import naturix.divinerpg.objects.blocks.BlockModLog;
import naturix.divinerpg.objects.blocks.BlockModPortal;
import naturix.divinerpg.objects.blocks.BlockModSlab;
import naturix.divinerpg.objects.blocks.BlockModSpawner;
import naturix.divinerpg.objects.blocks.BlockModStairs;
import naturix.divinerpg.objects.blocks.BlockModTorch;
import naturix.divinerpg.objects.blocks.BlockModVine;
import naturix.divinerpg.objects.blocks.BlockStatue;
import naturix.divinerpg.objects.blocks.arcana.BlockDemonFurnace;
import naturix.divinerpg.objects.blocks.arcana.BlockMoltenFurnace;
import naturix.divinerpg.objects.blocks.arcana.BlockOceanfireFurnace;
import naturix.divinerpg.objects.blocks.arcana.BlockWhitefireFurnace;
import naturix.divinerpg.objects.blocks.eden.BlockSinglePlant;
import naturix.divinerpg.objects.blocks.fluid.BlockTar;
import naturix.divinerpg.objects.blocks.iceika.BlockCandyCane;
import naturix.divinerpg.objects.blocks.iceika.BlockChristmasLights;
import naturix.divinerpg.objects.blocks.iceika.BlockCoalstoneFurnace;
import naturix.divinerpg.objects.blocks.iceika.BlockFrostedChest;
import naturix.divinerpg.objects.blocks.iceika.BlockPresentBox;
import naturix.divinerpg.objects.blocks.iceika.BlockWinterberryBush;
import naturix.divinerpg.objects.blocks.vanilla.BlockAyeracoBeam;
import naturix.divinerpg.objects.blocks.vanilla.BlockAyeracoSpawn;
import naturix.divinerpg.objects.blocks.vanilla.BlockBloodgemOre;
import naturix.divinerpg.objects.blocks.vanilla.BlockDarkBridge;
import naturix.divinerpg.objects.blocks.vanilla.BlockHotSpike;
import naturix.divinerpg.objects.blocks.vanilla.BlockLightFence;
import naturix.divinerpg.objects.blocks.vanilla.BlockMobPumpkin;
import naturix.divinerpg.objects.blocks.vanilla.BlockSlimeLight;
import naturix.divinerpg.objects.blocks.vanilla.BlockSpike;
import naturix.divinerpg.objects.blocks.vanilla.VanillaBlock;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.GenerateJSON;
import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSlab;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    private static int WOOD_GOLD = 0, STONE = 1, IRON = 2, DIAMOND = 3;

    // Vanilla
    public static Block rupeeOre = new VanillaBlock(EnumBlockType.ROCK, "rupee_ore", 3.0F, DIAMOND)
            .setResistance(2000.0F);
    public static Block arlemiteOre = new VanillaBlock(EnumBlockType.ROCK, "arlemite_ore", 3.0F, DIAMOND)
            .setResistance(2000.0F);
    public static Block realmiteOre = new VanillaBlock(EnumBlockType.ROCK, "realmite_ore", 3.0F, IRON)
            .setResistance(2000.0F);
    public static Block bloodgemOre = new BlockBloodgemOre("bloodgem_ore");
    public static Block netheriteOre = new VanillaBlock(EnumBlockType.ROCK, "netherite_ore", 3.0F, DIAMOND)
            .setResistance(2000.0F);

    public static Block rupeeBlock = new VanillaBlock(EnumBlockType.ROCK, "rupee_block", 5.0F, DIAMOND)
            .setResistance(10F);
    public static Block arlemiteBlock = new VanillaBlock(EnumBlockType.ROCK, "arlemite_block", 5.0F, DIAMOND)
            .setResistance(10F);
    public static Block realmiteBlock = new VanillaBlock(EnumBlockType.ROCK, "realmite_block", 5.0F, IRON)
            .setResistance(10F);
    public static Block bloodgemBlock = new VanillaBlock(EnumBlockType.ROCK, "bloodgem_block", 5.0F, DIAMOND)
            .setResistance(10F);
    public static Block netheriteBlock = new VanillaBlock(EnumBlockType.ROCK, "netherite_block", 5.0F, DIAMOND)
            .setResistance(10F);

    public static Block spiderPumpkin = new BlockMobPumpkin("spider_pumpkin");
    public static Block enderPumpkin = new BlockMobPumpkin("ender_pumpkin");
    public static Block creeperPumpkin = new BlockMobPumpkin("creeper_pumpkin");
    public static Block skeletonPumpkin = new BlockMobPumpkin("skeleton_pumpkin");
    public static Block blazePumpkin = new BlockMobPumpkin("blaze_pumpkin");
    public static Block zombiePumpkin = new BlockMobPumpkin("zombie_pumpkin");
    public static Block frostPumpkin = new BlockMobPumpkin("frost_pumpkin");
    public static Block cyclopsPumpkin = new BlockMobPumpkin("cyclops_pumpkin");
    public static Block ghastPumpkin = new BlockMobPumpkin("ghast_pumpkin");
    public static Block glaconPumpkin = new BlockMobPumpkin("glacon_pumpkin");
    public static Block enderWatcherPumpkin = new BlockMobPumpkin("ender_watcher_pumpkin");
    public static Block jungleSpiderPumpkin = new BlockMobPumpkin("jungle_spider_pumpkin");
    public static Block hellspiderPumpkin = new BlockMobPumpkin("hellspider_pumpkin");

    public static Block aquaTorch = new BlockModTorch("aqua_torch", DRPGParticleTypes.BLUE_FLAME);
    public static Block skeletonTorch = new BlockModTorch("skeleton_torch", DRPGParticleTypes.BLACK_FLAME);

    public static Block checker = new VanillaBlock(EnumBlockType.WOOL, "checker", 0.8F, WOOD_GOLD);
    public static Block rainbowWool = new VanillaBlock(EnumBlockType.WOOL, "rainbow_wool", 0.8F, WOOD_GOLD);
    public static Block crate = new VanillaBlock(EnumBlockType.WOOD, "crate", 2.5F, WOOD_GOLD);
    public static Block plankDesign = new VanillaBlock(EnumBlockType.WOOD, "plank_design", 2.5F, WOOD_GOLD);
    public static Block blueStone = new VanillaBlock(EnumBlockType.ROCK, "blue_stone", 1.5F, WOOD_GOLD)
            .setResistance(10F).setLightLevel(1);

    public static Block blueVane = new VanillaBlock(EnumBlockType.ROCK, "blue_vane", 2.0F, IRON).setResistance(10F);
    public static Block cyanVane = new VanillaBlock(EnumBlockType.ROCK, "cyan_vane", 2.0F, IRON).setResistance(10F);
    public static Block purpleVane = new VanillaBlock(EnumBlockType.ROCK, "purple_vane", 2.0F, IRON).setResistance(10F);
    public static Block redVane = new VanillaBlock(EnumBlockType.ROCK, "red_vane", 2.0F, IRON).setResistance(10F);
    public static Block yellowVane = new VanillaBlock(EnumBlockType.ROCK, "yellow_vane", 2.0F, IRON).setResistance(10F);

    public static Block divineRock = new VanillaBlock(EnumBlockType.ROCK, "divine_rock", 1.5F, STONE)
            .setResistance(10F);
    public static Block tar = new BlockTar();

    public static Block fancyWool = new VanillaBlock(EnumBlockType.WOOL, "fancy_wool", 0.8F, WOOD_GOLD);

    public static Block tealSteel = new VanillaBlock(EnumBlockType.ROCK, "teal_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block redSteel = new VanillaBlock(EnumBlockType.ROCK, "red_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block purpleSteel = new VanillaBlock(EnumBlockType.ROCK, "purple_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block greenSteel = new VanillaBlock(EnumBlockType.ROCK, "green_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block yellowSteel = new VanillaBlock(EnumBlockType.ROCK, "yellow_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block blueSteel = new VanillaBlock(EnumBlockType.ROCK, "blue_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block whiteSteel = new VanillaBlock(EnumBlockType.ROCK, "white_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block blackSteel = new VanillaBlock(EnumBlockType.ROCK, "black_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block orangeSteel = new VanillaBlock(EnumBlockType.ROCK, "orange_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);
    public static Block brightRedSteel = new VanillaBlock(EnumBlockType.ROCK, "bright_red_steel", 10.0F, DIAMOND)
            .setResistance(60.0F);

    public static Block aquatonicBricks = new VanillaBlock(EnumBlockType.ROCK, "aquatonic_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block arlemiteBricks = new VanillaBlock(EnumBlockType.ROCK, "arlemite_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block darkstoneBricks = new VanillaBlock(EnumBlockType.ROCK, "darkstone_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block diamondBricks = new VanillaBlock(EnumBlockType.ROCK, "diamond_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block goldBricks = new VanillaBlock(EnumBlockType.ROCK, "gold_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block greenBricks = new VanillaBlock(EnumBlockType.ROCK, "green_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block ironBricks = new VanillaBlock(EnumBlockType.ROCK, "iron_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block lapisLazuliBricks = new VanillaBlock(EnumBlockType.ROCK, "lapis_lazuli_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block lavaBricks = new VanillaBlock(EnumBlockType.ROCK, "lava_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block netheriteBricks = new VanillaBlock(EnumBlockType.ROCK, "netherite_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block pinkBricks = new VanillaBlock(EnumBlockType.ROCK, "pink_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block purpleBricks = new VanillaBlock(EnumBlockType.ROCK, "purple_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block realmiteBricks = new VanillaBlock(EnumBlockType.ROCK, "realmite_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block redstoneBricks = new VanillaBlock(EnumBlockType.ROCK, "redstone_bricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block milkStoneBricks = new VanillaBlock(EnumBlockType.ROCK, "milk_stone_bricks", 3.0F, IRON)
            .setResistance(30.0F);

    public static Block rupeeMinibricks = new VanillaBlock(EnumBlockType.ROCK, "rupee_minibricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block realmiteMinibricks = new VanillaBlock(EnumBlockType.ROCK, "realmite_minibricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block arlemiteMinibricks = new VanillaBlock(EnumBlockType.ROCK, "arlemite_minibricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block minibricks = new VanillaBlock(EnumBlockType.ROCK, "minibricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block bloodgemMinibricks = new VanillaBlock(EnumBlockType.ROCK, "bloodgem_minibricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block netheriteMinibricks = new VanillaBlock(EnumBlockType.ROCK, "netherite_minibricks", 3.0F, IRON)
            .setResistance(30.0F);
    public static Block bedrockMinibricks = new VanillaBlock(EnumBlockType.ROCK, "bedrock_minibricks", 3.0F, IRON)
            .setResistance(30.0F);

    public static Block aquaLamp = new VanillaBlock(EnumBlockType.GLASS, "aqua_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block arlemiteLamp = new VanillaBlock(EnumBlockType.GLASS, "arlemite_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block blazeLamp = new VanillaBlock(EnumBlockType.GLASS, "blaze_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block bluefireLamp = new VanillaBlock(EnumBlockType.GLASS, "bluefire_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block diamondLamp = new VanillaBlock(EnumBlockType.GLASS, "diamond_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block divineLamp = new VanillaBlock(EnumBlockType.GLASS, "divine_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block drakenLamp = new VanillaBlock(EnumBlockType.GLASS, "draken_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block edenLamp = new VanillaBlock(EnumBlockType.GLASS, "eden_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block enderLamp = new VanillaBlock(EnumBlockType.GLASS, "ender_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block enderStoneLamp = new VanillaBlock(EnumBlockType.GLASS, "ender_stone_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block goldLamp = new VanillaBlock(EnumBlockType.GLASS, "gold_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block iceLamp = new VanillaBlock(EnumBlockType.GLASS, "ice_lamp", 3.0F, DIAMOND).setResistance(30.0F)
            .setLightLevel(1);
    public static Block jungleLamp = new VanillaBlock(EnumBlockType.GLASS, "jungle_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block krakenLamp = new VanillaBlock(EnumBlockType.GLASS, "kraken_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block lapisLazuliLamp = new VanillaBlock(EnumBlockType.GLASS, "lapis_lazuli_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block lavaLamp = new VanillaBlock(EnumBlockType.GLASS, "lava_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block milkyLamp = new VanillaBlock(EnumBlockType.GLASS, "milky_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block moltenLamp = new VanillaBlock(EnumBlockType.GLASS, "molten_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block netheriteLamp = new VanillaBlock(EnumBlockType.GLASS, "netherite_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block realmiteLamp = new VanillaBlock(EnumBlockType.GLASS, "realmite_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block redstoneOrekLamp = new VanillaBlock(EnumBlockType.GLASS, "redstone_ore_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block rupeeLamp = new VanillaBlock(EnumBlockType.GLASS, "rupee_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);
    public static Block terranLamp = new VanillaBlock(EnumBlockType.GLASS, "terran_lamp", 3.0F, DIAMOND)
            .setResistance(30.0F).setLightLevel(1);

    public static Block milkStone = new VanillaBlock(EnumBlockType.ROCK, "milk_stone", 1.5F, WOOD_GOLD)
            .setResistance(10F);
    public static Block darkstone = new VanillaBlock(EnumBlockType.ROCK, "darkstone", 50f, DIAMOND)
            .setResistance(2000.0F).setLightLevel(1);
    public static Block spikeBlock = new BlockSpike("spike_block");
    public static Block hotSpikeBlock = new BlockHotSpike("hot_spike_block");
    public static Block slimeLight = new BlockSlimeLight("slime_light", false);
    public static Block slimeLightOn = new BlockSlimeLight("slime_light_on", true);
    public static Block darkBridge = new BlockDarkBridge("dark_bridge", false);
    public static Block darkBridgeOn = new BlockDarkBridge("dark_bridge_on", true);

    public static Block redFence = new BlockLightFence(MapColor.RED, "red_fence", false, 0.5F);
    public static Block greenFence = new BlockLightFence(MapColor.GREEN, "green_fence", false, 0.5F);
    public static Block blueFence = new BlockLightFence(MapColor.BLUE, "blue_fence", false, 0.5F);
    public static Block redFenceOn = new BlockLightFence(MapColor.RED, "red_fence_on", true, 0.5F);
    public static Block greenFenceOn = new BlockLightFence(MapColor.GREEN, "green_fence_on", true, 0.5F);
    public static Block blueFenceOn = new BlockLightFence(MapColor.BLUE, "blue_fence_on", true, 0.5F);

    public static Block ayeracoBeamBlue = new BlockAyeracoBeam("ayeraco_beam_blue", "blue");
    public static Block ayeracoBeamGreen = new BlockAyeracoBeam("ayeraco_beam_green", "green");
    public static Block ayeracoBeamRed = new BlockAyeracoBeam("ayeraco_beam_red", "red");
    public static Block ayeracoBeamYellow = new BlockAyeracoBeam("ayeraco_beam_yellow", "yellow");
    public static Block ayeracoBeamPurple = new BlockAyeracoBeam("ayeraco_beam_purple", "purple");
    public static Block ayeracoSpawn = new BlockAyeracoSpawn();

    public static BlockStatue kosStatue = new BlockStatue("king_of_scorchers_statue");
    public static BlockStatue ancientEntityStatue = new BlockStatue("ancient_entity_statue");
    public static BlockStatue ayeracoStatue = new BlockStatue("ayeraco_statue");
    public static BlockStatue twilightDemonStatue = new BlockStatue("twilight_demon_statue");
    public static BlockStatue vamacheronStatue = new BlockStatue("vamacheron_statue");
    public static BlockStatue densosStatue = new BlockStatue("densos_statue");
    public static BlockStatue reyvorStatue = new BlockStatue("reyvor_statue");
    public static BlockStatue dramixStatue = new BlockStatue("dramix_statue");
    public static BlockStatue parasectaStatue = new BlockStatue("parasecta_statue");
    public static BlockStatue soulFiendStatue = new BlockStatue("soul_fiend_statue");
    public static BlockStatue theWatcherStatue = new BlockStatue("the_watcher_statue");
    public static BlockStatue eternalArcherStatue = new BlockStatue("eternal_archer_statue");
    public static BlockStatue karotStatue = new BlockStatue("karot_statue");

    public static Block tomatoPlant = new BlockModCrop("tomato_plant", 7, ModItems.tomatoSeeds, ModItems.tomato);
    public static Block whiteMushroomPlant = new BlockModCrop("white_mushroom_plant", 1, ModItems.whiteMushroomSeeds,
            ModItems.whiteMushroom);

    public static Block divineWood = new BlockModLog("divine_log");
    public static Block divineLeaves = new BlockModLeaves("divine_leaves", 0.3F);
    public static Block divineMossystone = new BlockMod("divine_moss_stone", 2.0F).setResistance(10);

    // FIXME - Need to add
    // public static Block altarOfCorruption = new
    // BlockAltarOfCorruption("altar_of_corruption");
    // public static Block boneChest = new BlockBoneChest("bone_chest");

    // Iceika
    public static Block frozenDirt = new BlockMod(EnumBlockType.DIRT, "frozen_dirt", 2.5F);
    public static Block frozenGrass = new BlockModGrass((BlockMod) frozenDirt, "frozen_grass", "frozen_dirt", 2.5F);
    public static Block frozenStone = new BlockMod("frozen_stone", 6.0F);
    public static Block frozenWood = new BlockModLog("frozen_log").setHardness(5.0F);
    public static Block brittleLeaves = new BlockModLeaves("brittle_leaves", 0.1F);

    public static Block winterberryBush = new BlockWinterberryBush(false, "winterberry_bush");
    public static Block ripeWinterberryBush = new BlockWinterberryBush(true, "ripe_winterberry_bush");

    public static Block icyStone = new BlockMod("icy_stone", -1F);
    public static Block icyBricks = new BlockMod("icy_bricks", -1F);
    public static Block frostedChest = new BlockFrostedChest("frosted_chest", true).setHardness(2.5F);
    public static Block decorativeFrostedChest = new BlockFrostedChest("decorative_frosted_chest", false)
            .setHardness(2.5F);
    public static Block rollumSpawner = new BlockModSpawner("rollum_spawner", "rollum").setHardness(5.0F);
    public static Block frostArcherSpawner = new BlockModSpawner("frost_archer_spawner", "frost_archer")
            .setHardness(5.0F);
    public static Block snowBricks = new BlockMod("snow_bricks", 6.0F);
    public static Block coalstone = new BlockMod("coalstone", 3.0F);
    public static Block coalstoneStairs = new BlockModStairs(coalstone, "coalstone_stairs");
    public static Block workshopCarpet = new BlockMod(EnumBlockType.WOOL, "workshop_carpet", 0.1F);
    public static Block frostedGlass = new BlockModGlass("frosted_glass", 1.0F);
    public static Block workshopBookcase = new BlockMod(EnumBlockType.ROCK, "workshop_bookcase",
            DRPGCreativeTabs.BlocksTab).setHardness(1.5F);
    public static Block workshopLamp = new BlockMod(EnumBlockType.GLASS, "workshop_lamp", 0.3F).setLightLevel(1);
    public static Block steelDoor = new BlockDoorBase("steel_door", Material.ANVIL);
    public static Block coalstoneFurnace = new BlockCoalstoneFurnace("coalstone_furnace", false);
    public static Block coalstoneFurnaceOn = new BlockCoalstoneFurnace("coalstone_furnace_on", true);

    public static Block redChristmasLights = new BlockChristmasLights("red_christmas_lights");
    public static Block greenChristmasLights = new BlockChristmasLights("green_christmas_lights");
    public static Block blueChristmasLights = new BlockChristmasLights("blue_christmas_lights");
    public static Block yellowChristmasLights = new BlockChristmasLights("yellow_christmas_lights");
    public static Block purpleChristmasLights = new BlockChristmasLights("purple_christmas_lights");
    public static Block blueCandyCane = new BlockCandyCane("blue_candy_cane");
    public static Block greenCandyCane = new BlockCandyCane("green_candy_cane");
    public static Block pinkCandyCane = new BlockCandyCane("pink_candy_cane");
    public static Block redCandyCane = new BlockCandyCane("red_candy_cane");
    public static Block yellowCandyCane = new BlockCandyCane("yellow_candy_cane");

    public static Block presentBox = new BlockPresentBox("present_box");

    public static Block iceikaFire = new BlockModFire("iceika_fire");
    public static BlockModPortal iceikaPortal = new BlockModPortal("iceika_portal",
            ModDimensions.iceikaDimension.getId(), iceikaFire, Blocks.SNOW, DRPGParticleTypes.FROST);

    // Twilight
    public static Block edenDirt = new BlockMod(EnumBlockType.DIRT, "eden_dirt", 5.0F);
    public static Block wildwoodDirt = new BlockMod(EnumBlockType.DIRT, "wildwood_dirt", 5.0F);
    public static Block apalachiaDirt = new BlockMod(EnumBlockType.DIRT, "apalachia_dirt", 5.0F);
    public static Block skythernDirt = new BlockMod(EnumBlockType.DIRT, "skythern_dirt", 5.0F);
    public static Block mortumDirt = new BlockMod(EnumBlockType.DIRT, "mortum_dirt", 5.0F);
    public static Block edenGrass = new BlockModGrass((BlockMod) edenDirt, "eden_grass", "eden_dirt", 5.0F);
    public static Block wildwoodGrass = new BlockModGrass((BlockMod) wildwoodDirt, "wildwood_grass", "wildwood_dirt",
            5.0F);
    public static Block apalachiaGrass = new BlockModGrass((BlockMod) apalachiaDirt, "apalachia_grass",
            "apalachia_dirt", 5.0F);
    public static Block skythernGrass = new BlockModGrass((BlockMod) skythernDirt, "skythern_grass", "skythern_dirt",
            5.0F);
    public static Block mortumGrass = new BlockModGrass((BlockMod) mortumDirt, "mortum_grass", "mortum_dirt", 5.0F);

    public static Block edenOre = new BlockMod("eden_ore", 9).toggleExp(true).setTwilightOre(true)
            .setDropItem(ModItems.edenFragments);
    public static Block wildwoodOre = new BlockMod("wildwood_ore", 9).setTwilightOre(true)
            .setDropItem(ModItems.wildwoodFragments);
    public static Block apalachiaOre = new BlockMod("apalachia_ore", 9).setTwilightOre(true)
            .setDropItem(ModItems.apalachiaFragments);
    public static Block skythernOre = new BlockMod("skythern_ore", 9).setTwilightOre(true)
            .setDropItem(ModItems.skythernFragments);
    public static Block mortumOre = new BlockMod("mortum_ore", 9).setTwilightOre(true)
            .setDropItem(ModItems.mortumFragments);

    public static Block edenBlock = new BlockMod("eden_block", 9);
    public static Block wildwoodBlock = new BlockMod("wildwood_block", 9);
    public static Block apalachiaBlock = new BlockMod("apalachia_block", 9);
    public static Block skythernBlock = new BlockMod("skythern_block", 9);
    public static Block mortumBlock = new BlockMod("mortum_block", 9);

    // public static Block edenLeaves = new BlockModLeaves("eden_leaves", 0.5F,
    // edenSapling);
    // public static Block wildwoodLeaves = new BlockModLeaves("wildwood_leaves",
    // 0.5F, wildwoodSapling);
    // public static Block apalachiaLeaves = new BlockModLeaves("apalachia_leaves",
    // 0.5F, apalachiaSapling).setLightLevel(0.5F);
    // public static Block skythernLeaves = new BlockModLeaves("skythern_leaves",
    // 0.5F, skythernSapling);
    // public static Block mortumLeaves = new BlockModLeaves("mortum_leaves", 0.5F,
    // mortumSapling);
    public static Block edenLeaves = new BlockModLeaves("eden_leaves", 0.5F);
    public static Block wildwoodLeaves = new BlockModLeaves("wildwood_leaves", 0.5F);
    public static Block apalachiaLeaves = new BlockModLeaves("apalachia_leaves", 0.5F).setLightLevel(0.5F);
    public static Block skythernLeaves = new BlockModLeaves("skythern_leaves", 0.5F);
    public static Block mortumLeaves = new BlockModLeaves("mortum_leaves", 0.5F);

    public static Block edenLogs = new BlockModLog("eden_log");
    public static Block wildwoodLogs = new BlockModLog("wildwood_log");
    public static Block apalachiaLogs = new BlockModLog("apalachia_log");
    public static Block skythernLogs = new BlockModLog("skythern_log");
    public static Block mortumLogs = new BlockModLog("mortum_log");

    public static Block twilightStone = new BlockMod("twilight_stone", 6.0F);
    public static Block blueFire = new BlockModFire("blue_fire");
    public static BlockModPortal edenPortal = new BlockModPortal("eden_portal", ModDimensions.edenDimension.getId(),
            blueFire, divineRock, DRPGParticleTypes.EDEN_PORTAL);
    public static BlockModPortal wildwoodPortal = new BlockModPortal("wildwood_portal",
            ModDimensions.wildWoodDimension.getId(), blueFire, edenBlock, DRPGParticleTypes.WILDWOOD_PORTAL);
    public static BlockModPortal apalachiaPortal = new BlockModPortal("apalachia_portal",
            ModDimensions.apalachiaDimension.getId(), blueFire, wildwoodBlock, DRPGParticleTypes.APALACHIA_PORTAL);
    public static BlockModPortal skythernPortal = new BlockModPortal("skythern_portal",
            ModDimensions.skythernDimension.getId(), blueFire, apalachiaBlock, DRPGParticleTypes.SKYTHERN_PORTAL);
    public static BlockModPortal mortumPortal = new BlockModPortal("mortum_portal",
            ModDimensions.mortumDimension.getId(), blueFire, skythernBlock, DRPGParticleTypes.MORTUM_PORTAL);

    public static Block edenBrush = new BlockSinglePlant("eden_brush");
    public static Block sunbloom = new BlockSinglePlant("sunbloom");
    public static Block sunBlossom = new BlockSinglePlant("sun_blossom");

    // Arcana
    public static Block stainedGlass = new BlockModGlass("stained_glass", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass2 = new BlockModGlass("stained_glass2", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass3 = new BlockModGlass("stained_glass3", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass4 = new BlockModGlass("stained_glass4", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass5 = new BlockModGlass("stained_glass5", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass6 = new BlockModGlass("stained_glass6", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass7 = new BlockModGlass("stained_glass7", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass8 = new BlockModGlass("stained_glass8", 0.3F).setUnlocalizedName("stained_glass");

    // public static Block greenlightFurnace = new
    // BlockGreenlightFurnace("greenlight_furnace", false);
    // public static Block greenlightFurnaceOn = new
    // BlockGreenlightFurnace("greenlight_furnace_on", true);
    public static Block oceanfireFurnace = new BlockOceanfireFurnace("oceanfire_furnace", false);
    public static Block oceanfireFurnaceOn = new BlockOceanfireFurnace("oceanfire_furnace_on", true);
    public static Block moltenFurnace = new BlockMoltenFurnace("molten_furnace", false);
    public static Block moltenFurnaceOn = new BlockMoltenFurnace("molten_furnace_on", true);
    public static Block whitefireFurnace = new BlockWhitefireFurnace("whitefire_furnace", false);
    public static Block whitefireFurnaceOn = new BlockWhitefireFurnace("whitefire_furnace_on", true);
    // public static Block moonlightFurnace = new
    // BlockMoonlightFurnace("moonlight_furnace", false);
    // public static Block moonlightFurnaceOn = new
    // BlockMoonlightFurnace("moonlight_furnace_on", true);
    public static Block demonFurnace = new BlockDemonFurnace("demon_furnace", false);
    public static Block demonFurnaceOn = new BlockDemonFurnace("demon_furnace_on", true);

    //public static Block weedwoodVine = new BlockModVine("weedwood_vine");
    //public static Block blossomedWeedWoodVine = new BlockModVine("blossomed_weedwood_vine");
    //public static Block hyrewoodVine = new BlockModVine("hyrewood_vine");
    public static Block wildwoodVine = new BlockModVine("wildwood_vine");

    public static void AddWoodVariants() {
        for (WoodVariant woodType : WoodVariant.values()) {
            String woodName = woodType.getName();

            // Make special property key that allows ONLY one value because slabs are special level of stupid
            final PropertyEnum<WoodVariant> restrictedKey = PropertyEnum.create("variant", WoodVariant.class,
                    input -> input == woodType);

            BlockMod planks = new BlockMod(EnumBlockType.WOOD, woodName + "_planks", 2, DRPGCreativeTabs.BlocksTab);
            Block stairs = new BlockModStairs(planks, woodName + "_stairs");
            Block singleSlab = new BlockModSlab(planks, null, woodType) {
                @Override
                public boolean isDouble() {
                    return false;
                }

                protected Block getSingle() {
                    return this;
                }

                @Override
                public IProperty<WoodVariant> getVariantProperty() {
                    return restrictedKey;
                }
            };

            Block doubleSlab = new BlockModSlab(planks, singleSlab, woodType) {
                @Override
                public boolean isDouble() {
                    return true;
                }

                protected Block getSingle() {
                    return singleSlab;
                }

                @Override
                public IProperty<WoodVariant> getVariantProperty() {
                    return restrictedKey;
                }
            };

            ModItems.ITEMS.add(new ItemSlab(singleSlab, (BlockSlab) singleSlab, (BlockSlab) doubleSlab)
                    .setRegistryName(singleSlab.getRegistryName()));
            ModItems.ITEMS.add(new ItemSlab(doubleSlab, (BlockSlab) singleSlab, (BlockSlab) doubleSlab)
                    .setRegistryName(doubleSlab.getRegistryName()));
        }
    }

    public static void CreateJSONs() {
        GenerateJSON.generateBlockstateJSONs();
        GenerateJSON.generateModelBlockJSONs();
    }
}
package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.blocks.arcana.BlockAcceleron;
import divinerpg.divinerpg.blocks.arcana.BlockArcanaDoor;
import divinerpg.divinerpg.blocks.base.BlockMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Objects;
import java.util.function.Supplier;

import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class BlockRegistry {

//    private static RegistryObject<FlowerPotBlock> registerFlowerPot(String name, Supplier<? extends Block> flower) {
//        return BLOCKS.register(name, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flower, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
//    }

    private static <T extends Block> T registerBlock(String name, T block) {
        return registerBlock(name, block, Rarity.COMMON);
    }
    private static <T extends Block> T registerBlock(String registryName, T block, Rarity rarity) {
        T registeredBlock = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, registryName), block);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, registryName), new BlockItem(block, new FabricItemSettings().rarity(rarity)));

        try {
            int burnTime = ((BlockMod) block).flammability;
            int spreadSpeed = ((BlockMod) block).fireSpread;
            FlammableBlockRegistry.getDefaultInstance().add(block, burnTime, spreadSpeed);
        } catch (Exception e) {

        }

        return registeredBlock;
    }

//    private static <T extends Block> RegistryObject<T> registerFireResistantBlock(String registryName, Supplier<T> block) {
//        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
//        BLOCK_ITEMS.register(registryName, () -> new BlockItem(registeredBlock.get(), new Item.Properties().fireResistant()));
//        return registeredBlock;
//    }
//    private static <T extends Block> RegistryObject<T> registerWithRender(String registryName, Supplier<T> block, Rarity rarity) {
//        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
//        if(Objects.equals(registryName, "arcanium_extractor")) BLOCK_ITEMS.register(registryName, () -> new ItemArcaniumExtractor(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "bone_chest")) BLOCK_ITEMS.register(registryName, () -> new ItemBoneChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "demon_furnace")) BLOCK_ITEMS.register(registryName, () -> new ItemDemonFurnace(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "frosted_chest")) BLOCK_ITEMS.register(registryName, () -> new ItemFrostedChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "present_box")) BLOCK_ITEMS.register(registryName, () -> new ItemPresentBox(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "eden_chest")) BLOCK_ITEMS.register(registryName, () -> new ItemEdenChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "parasecta_altar")) BLOCK_ITEMS.register(registryName, () -> new ItemParasectaAltar(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else if(Objects.equals(registryName, "dramix_altar")) BLOCK_ITEMS.register(registryName, () -> new ItemDramixAltar(registeredBlock.get(), new Item.Properties().rarity(rarity)));
//        else BLOCK_ITEMS.register(registryName, () -> new ItemStatueBlock(registeredBlock::get, new Item.Properties().rarity(rarity).fireResistant()));
//        return registeredBlock;
//    }

    public static void register() {
        //Doors
//        steelDoor = registerBlock("steel_door", () -> new BlockModDoor(METAL)),
        registerBlock("ancient_brick_door", new BlockArcanaDoor(MapColor.DARK_AQUA, ItemRegistry.ancient_key));  // MapColor.WARPED_NYLIUM
        registerBlock("degraded_brick_door", new BlockArcanaDoor(MapColor.BLUE, ItemRegistry.degraded_key));
        registerBlock("soul_sludge_door", new BlockArcanaDoor(MapColor.GRAY, ItemRegistry.sludge_key));
        registerBlock("soul_stone_door", new BlockArcanaDoor(MapColor.TERRACOTTA_BLUE, ItemRegistry.soul_key));
//        Block barredDoor = registerBlock("barred_door", () -> new BlockModDoor(PLANT)),

        //Other Utility Blocks
//        hellfireSponge = registerBlock("hellfire_sponge", BlockHellfireSponge::new);
//        coldHellfireSponge = registerBlock("cold_hellfire_sponge", BlockColdHellfireSponge::new);
//        frostedAllure = registerBlock("frosted_allure", BlockFrostedAllure::new, Rarity.UNCOMMON);
//        robbinNest = registerBlock("robbin_nest", BlockRobbinNest::new);
//        robbinHut = registerBlock("robbin_hut", BlockRobbinHut::new);
        final BlockAcceleron acceleron = registerBlock("acceleron", new BlockAcceleron(), Rarity.UNCOMMON);
//        final BlockAcceleron acceleron = registerBlock("acceleron", BlockAcceleron::new, Rarity.UNCOMMON);
//        elevantium = registerBlock("elevantium", BlockElevantium::new, Rarity.UNCOMMON);
//        soulTrap = registerBlock("soul_trap", BlockModSoulTrap::new);
    }
}

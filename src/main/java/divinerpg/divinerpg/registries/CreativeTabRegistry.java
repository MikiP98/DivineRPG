package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.items.base.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static divinerpg.divinerpg.DivineRPG.LOGGER;
import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class CreativeTabRegistry {

    static final ItemGroup DIVINERPG_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BlockRegistry.eden_lamp))
            .displayName(Text.translatable("itemGroup.divinerpg.blocks"))
            .entries((displayContext, entries) -> {
                for (Block entry : BlockRegistry.divinerpg_blocks) {
                    String name = Registries.BLOCK.getId(entry).toTranslationKey();
                    if (!name.contains("plant") || name.contains("eye_plant"))
                        entries.add(entry);
                }
//                for (Item entry : ItemRegistry.divinerpg_items) {
//                    if (entry instanceof ItemNightmareBed || entry instanceof StandingAndWallBlockItem)
//                        entries.add(entry);
//                }
            })
            .build();

    static final ItemGroup DIVINERPG_TOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BlockRegistry.eden_lamp))
            .displayName(Text.translatable("itemGroup.divinerpg.tools"))
            .entries((displayContext, entries) -> {
                for (Item entry : ItemRegistry.divinerpg_items) {
                    String name = Registries.ITEM.getId(entry).toTranslationKey();
                    if (
//                            entry instanceof ItemMeriksMissile ||
                            name.contains("bullet") ||
                            name.contains("bucket") ||
                            name.contains("serenade") ||
//                            entry instanceof ItemEnderScepter ||
//                            entry instanceof ItemDivineAccumulator ||
//                            entry instanceof ItemGhostbane ||
//                            entry instanceof ItemStaffEnrichment ||
                            name.contains("arrow") ||
                            entry instanceof DivineShield ||
//                            entry instanceof ItemDivineArmor ||
                            entry instanceof ItemModAxe ||
                            entry instanceof ItemModBow ||
                            entry instanceof ItemModHoe ||
                            entry instanceof ItemModPickaxe ||
//                            entry instanceof ItemModRanged ||
                            entry instanceof ItemModShovel ||
                            entry instanceof ItemModSword ||
                            entry instanceof ItemShickaxe //||
//                            entry instanceof ItemArmorPouch
                    ) {
                        entries.add(entry);
                    }
                }
            })
            .build();

    static final ItemGroup DIVINERPG_MISC = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ItemRegistry.divine_shards))
            .displayName(Text.translatable("itemGroup.divinerpg.misc"))
            .entries((displayContext, entries) -> {
                for (Item entry : ItemRegistry.divinerpg_items) {
                    String name = Registries.ITEM.getId(entry).toTranslationKey();
                    if (!(
//                            entry instanceof ItemMeriksMissile ||
                            name.contains("bullet") ||
                            name.contains("bucket") ||
                            name.contains("serenade") ||
//                            entry instanceof ItemEnderScepter ||
//                            entry instanceof ItemDivineAccumulator ||
//                            entry instanceof ItemGhostbane ||
//                            entry instanceof ItemStaffEnrichment ||
                            name.contains("arrow") ||
//                            entry instanceof ItemNightmareBed ||
//                            entry instanceof StandingAndWallBlockItem ||
                            entry instanceof DivineShield ||
//                            entry instanceof ItemDivineArmor ||
                            entry instanceof ItemModAxe ||
                            entry instanceof ItemModBow ||
                            entry instanceof ItemModHoe ||
                            entry instanceof ItemModPickaxe ||
//                            entry instanceof ItemModRanged ||
                            entry instanceof ItemModShovel ||
                            entry instanceof ItemModSword ||
                            entry instanceof ItemShickaxe //||
//                            entry instanceof ItemArmorPouch
                    )) {
                        entries.add(entry);
                    }
                }
            })
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "blocks"), DIVINERPG_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "tools"), DIVINERPG_TOOLS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "misc"), DIVINERPG_MISC);
    }
}

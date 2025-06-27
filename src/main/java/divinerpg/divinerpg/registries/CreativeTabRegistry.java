package divinerpg.divinerpg.registries;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.ArrayList;

import static divinerpg.divinerpg.DivineRPG.getId;

public class CreativeTabRegistry {
    public static final ArrayList<Item>
            blocks = new ArrayList<>(),
            tools = new ArrayList<>(),
            misc = new ArrayList<>();

    public static final ItemGroup BLOCKS = Registry.register(
            Registries.ITEM_GROUP,
            getId("blocks"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable(("itemGroup.divinerpg.blocks")))
                    .icon(() -> new ItemStack(BlockRegistry.edenLamp))
                    .entries((displayContext, entries) -> {
                        entries.addAll(blocks.stream().map(ItemStack::new).toList());
                    })
                    .build()
    );

    public static final ItemGroup TOOLS = Registry.register(
            Registries.ITEM_GROUP,
            getId("tools"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable(("itemGroup.divinerpg.tools")))
                    .icon(() -> new ItemStack(ItemRegistry.halite_blade))
                    .entries((displayContext, entries) -> {
                        entries.addAll(tools.stream().map(ItemStack::new).toList());
                    })
                    .build()
    );

    public static final ItemGroup MISC = Registry.register(
            Registries.ITEM_GROUP,
            getId("misc"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable(("itemGroup.divinerpg.misc")))
                    .icon(() -> new ItemStack(ItemRegistry.divine_shards))
                    .entries((displayContext, entries) -> {
                        entries.addAll(misc.stream().map(ItemStack::new).toList());
                    })
                    .build()
    );
}
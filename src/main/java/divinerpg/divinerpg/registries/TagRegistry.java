package divinerpg.divinerpg.registries;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.gen.structure.Structure;

import static divinerpg.divinerpg.DivineRPG.getId;

public class TagRegistry {
    //Ammunition
    public static final TagKey<Item>
        ROPE = TagKey.of(RegistryKeys.ITEM, getId("ammo/rope")),
        GRENADES = TagKey.of(RegistryKeys.ITEM, getId("ammo/grenades")),
        AQUATIC_CANNON_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/aquatic_cannon")),
        CORRUPTED_CANNON_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/corrupted_cannon")),
        FROST_CANNON_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/frost_cannon")),
        FRACTITE_CANNON_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/fractite_cannon")),
        GOLDEN_FURY_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/golden_fury")),
        EDEN_BLITZ_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/eden_blitz")),
        WILDWOOD_BLITZ_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/wildwood_blitz")),
        APALACHIA_BLITZ_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/apalachia_blitz")),
        SKYTHERN_BLITZ_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/skythern_blitz")),
        MORTUM_BLITZ_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/mortum_blitz")),
        HALITE_BLITZ_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/halite_blitz")),
        VETHEAN_CANNON_AMMO = TagKey.of(RegistryKeys.ITEM, getId("ammo/vethean_cannon"));

    //Rift related Items
    public static final TagKey<Item>
        EDEN_RIFT_REPLENISHING = TagKey.of(RegistryKeys.ITEM, getId("rift_replenishing/eden")),
        WILDWOOD_RIFT_REPLENISHING = TagKey.of(RegistryKeys.ITEM, getId("rift_replenishing/wildwood")),
        APALACHIA_RIFT_REPLENISHING = TagKey.of(RegistryKeys.ITEM, getId("rift_replenishing/apalachia")),
        SKYTHERN_RIFT_REPLENISHING = TagKey.of(RegistryKeys.ITEM, getId("rift_replenishing/skythern")),
        MORTUM_RIFT_REPLENISHING = TagKey.of(RegistryKeys.ITEM, getId("rift_replenishing/mortum"));

    //Crafting Items
    public static final TagKey<Item>
        MAULS = TagKey.of(RegistryKeys.ITEM, getId("tools/maul")),
        FURNACES = TagKey.of(RegistryKeys.ITEM, getId("furnaces"));

    //Blocks
    public static final TagKey<Block> GATEWAY_RECEIVER = TagKey.of(RegistryKeys.BLOCK, getId("gateway_receiver"));

    //Rift related Blocks
    public static final TagKey<Block>
        EDEN_RIFT_RESONATING = TagKey.of(RegistryKeys.BLOCK, getId("rift_resonating/eden")),
        WILDWOOD_RIFT_RESONATING = TagKey.of(RegistryKeys.BLOCK, getId("rift_resonating/wildwood")),
        APALACHIA_RIFT_RESONATING = TagKey.of(RegistryKeys.BLOCK, getId("rift_resonating/apalachia")),
        SKYTHERN_RIFT_RESONATING = TagKey.of(RegistryKeys.BLOCK, getId("rift_resonating/skythern")),
        MORTUM_RIFT_RESONATING = TagKey.of(RegistryKeys.BLOCK, getId("rift_resonating/mortum"));

    //Structures
    public static final TagKey<Structure>
        ICEIKA_DUNGEON = TagKey.of(RegistryKeys.STRUCTURE, getId("iceika_dungeon")),
        GRUZZORLUG_RAID_TARGETS = TagKey.of(RegistryKeys.STRUCTURE, getId("gruzzorlug_raid_targets")),
        RAID_TARGETS = TagKey.of(RegistryKeys.STRUCTURE, getId("groglin_raid_targets")),
        WHALE_SKULL = TagKey.of(RegistryKeys.STRUCTURE, getId("whale_skull"));
}
package divinerpg.divinerpg.registries;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

import static divinerpg.divinerpg.DivineRPG.getId;

public class DamageRegistry {
    public static final RegistryKey<DamageType>
        ACID = get("acid"),
        ARCANA = get("arcana"),
        SPIKE = get("spike"),
        TAR = get("tar"),
        TURTLE = get("turtle");

    private static RegistryKey<DamageType> get(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, getId(name));
    }

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
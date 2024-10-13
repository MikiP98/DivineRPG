package divinerpg.divinerpg.registries;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import divinerpg.divinerpg.components.ArcanaComponent;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class DivineComponentRegistry implements EntityComponentInitializer {
    // retrieving a type for my component or for a required dependency's
    public static final ComponentKey<ArcanaComponent> ARCANA_COMPONENT =
            ComponentRegistry.getOrCreate(Identifier.of(MOD_ID, "arcana"), ArcanaComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
//        registry.registerFor(ARCANA_COMPONENT, new ArcanaComponent(0));

        registry.registerForPlayers(ARCANA_COMPONENT, player -> new ArcanaComponent(), RespawnCopyStrategy.ALWAYS_COPY);
    }

    public static ArcanaComponent getArcana(Entity provider) {
        return ARCANA_COMPONENT.get(provider);
    }
}

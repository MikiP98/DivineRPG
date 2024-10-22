package divinerpg.divinerpg;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import divinerpg.divinerpg.components.ArcanaComponent;
import divinerpg.divinerpg.registries.*;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivineRPG implements ModInitializer {
	public static final String MOD_ID = "divinerpg";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

//	public static final ComponentKey<ArcanaComponent> ARCANA_COMPONENT =
//			ComponentRegistry.getOrCreate(Identifier.of(MOD_ID, "arcana"), ArcanaComponent.class);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ParticleRegistry.init();
		SoundRegistry.init();
		ItemRegistry.register();
		BlockRegistry.register();
		CreativeTabRegistry.register();
		// BlockRegistry.BLOCK_ITEMS.register(bus);
		//        BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
		//        FluidRegistry.FLUIDS.register(bus);
		//        FluidRegistry.FLUID_TYPES.register(bus);
		//        MenuTypeRegistry.CONTAINERS.register(bus);
		//        EntityRegistry.ENTITIES.register(bus);
		//        ParticleRegistry.PARTICLES.register(bus);
		//        RecipeRegistry.Serailizers.SERIALIZER.register(bus);
		//        SoundRegistry.SOUNDS.register(bus);
		//        EnchantmentRegistry.ENCHANTS.register(bus);
		//        MobEffectRegistry.EFFECTS.register(bus);
		//        PotionRegistry.POTIONS.register(bus);
		//        RecipeRegistry.Types.RECIPE_TYPES.register(bus);
		//        FeatureRegistry.FEATURES.register(bus);
		//        StructureRegistry.STRUCTURE_TYPE.register(bus);
		//        PaintingRegistry.PAINTING_VARIANTS.register(bus);
		//        PointOfInterestRegistry.POI.register(bus);
		//        LootModifierRegistry.GLOBAL_LOOT_MODIFIERS.register(bus);
		//        CreativeTabRegistry.TAB.register(bus);
	}
}
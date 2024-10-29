package divinerpg.divinerpg.registries;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class ParticleRegistry {
    public static void init() {}

    public static DefaultParticleType register(String name) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, name), FabricParticleTypes.simple());
    }

    public static final DefaultParticleType EDEN_PORTAL = register("eden_portal");
    public static final DefaultParticleType WILDWOOD_PORTAL = register("wildwood_portal");
    public static final DefaultParticleType APALACHIA_PORTAL = register("apalachia_portal");
    public static final DefaultParticleType SKYTHERN_PORTAL = register("skythern_portal");
    public static final DefaultParticleType MORTUM_PORTAL = register("mortum_portal");
    public static final DefaultParticleType HALITE_PORTAL = register("halite_portal");
    public static final DefaultParticleType TWILIGHT_PORTAL = register("twilight_portal");
    public static final DefaultParticleType BLACK_FLAME = register("black_flame");
    public static final DefaultParticleType BLUE_FLAME = register("blue_flame");
    public static final DefaultParticleType GREEN_FLAME = register("green_flame");
    public static final DefaultParticleType PURPLE_FLAME = register("purple_flame");
    public static final DefaultParticleType FROST = register("frost");
    public static final DefaultParticleType SPARKLER = register("sparkler");
    public static final DefaultParticleType ENDER_TRIPLET = register("ender_triplets");
    public static final DefaultParticleType TAR = register("tar");
    public static final DefaultParticleType SPLASH = register("splash");

//    public static final ParticleType<ParticleColouredType.ParticleColour>> COLORED = register("colored", () -> new ParticleColouredType(false));

//    @OnlyIn(Dist.CLIENT)
//    @SubscribeEvent public static void registerFactories(RegisterParticleProvidersEvent event) {
//        event.registerSpriteSet(ParticleRegistry.EDEN_PORTAL.get(), ParticlePortal.EdenProvider::new);
//        event.registerSpriteSet(ParticleRegistry.WILDWOOD_PORTAL.get(), ParticlePortal.WildwoodProvider::new);
//        event.registerSpriteSet(ParticleRegistry.APALACHIA_PORTAL.get(), ParticlePortal.ApalachiaProvider::new);
//        event.registerSpriteSet(ParticleRegistry.SKYTHERN_PORTAL.get(),ParticlePortal.SkythernProvider::new);
//        event.registerSpriteSet(ParticleRegistry.MORTUM_PORTAL.get(), ParticlePortal.MortumProvider::new);
//        event.registerSpriteSet(ParticleRegistry.HALITE_PORTAL.get(), ParticlePortal.HaliteProvider::new);
//        event.registerSpriteSet(ParticleRegistry.TWILIGHT_PORTAL.get(), ParticlePortal.TwilightProvider::new);
//        event.registerSpriteSet(ParticleRegistry.BLACK_FLAME.get(), FlameParticle.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.BLUE_FLAME.get(), FlameParticle.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.GREEN_FLAME.get(), FlameParticle.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.PURPLE_FLAME.get(), FlameParticle.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.FROST.get(), ParticleFrost.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.SPARKLER.get(), ParticleSparkler.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.ENDER_TRIPLET.get(), ParticleEnderTriplet.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.TAR.get(), ParticleTar.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.SPLASH.get(), ParticleSplash.Provider::new);
//        event.registerSpriteSet(ParticleRegistry.COLORED.get(), ParticleColored.Provider::new);
//    }
}

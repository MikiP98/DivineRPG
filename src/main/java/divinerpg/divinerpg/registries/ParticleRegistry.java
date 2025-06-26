package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.particles.ModDefaultParticleType;
import net.minecraft.particle.DefaultParticleType;
//import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static divinerpg.divinerpg.DivineRPG.getId;

public class ParticleRegistry {
    public static final DefaultParticleType EDEN_PORTAL = register("eden_portal", true);
    public static final DefaultParticleType WILDWOOD_PORTAL = register("wildwood_portal", false);
    public static final DefaultParticleType APALACHIA_PORTAL = register("apalachia_portal", false);
    public static final DefaultParticleType SKYTHERN_PORTAL = register("skythern_portal", false);
    public static final DefaultParticleType MORTUM_PORTAL = register("mortum_portal", false);
    public static final DefaultParticleType HALITE_PORTAL = register("halite_portal", false);
    public static final DefaultParticleType TWILIGHT_PORTAL = register("twilight_portal", false);
    public static final DefaultParticleType BLACK_FLAME = register("black_flame", false);
    public static final DefaultParticleType BLUE_FLAME = register("blue_flame", false);
    public static final DefaultParticleType GREEN_FLAME = register("green_flame", false);
    public static final DefaultParticleType PURPLE_FLAME = register("purple_flame", false);
    public static final DefaultParticleType FROST = register("frost", false);
    public static final DefaultParticleType SPARKLER = register("sparkler", false);
    public static final DefaultParticleType ENDER_TRIPLET = register("ender_triplets", false);
    public static final DefaultParticleType TAR = register("tar", false);
    public static final DefaultParticleType SPLASH = register("splash", false);
//    public static final ParticleType<ParticleColouredOption> COLORED = register("colored", new ParticleType<>(false) {@Override public MapCodec<ParticleColouredOption> codec() {return null;} @Override public StreamCodec<? super RegistryFriendlyByteBuf, ParticleColouredOption> streamCodec() {return null;}});
    public static final DefaultParticleType EDEN_RIFT = register("eden_rift", false);
    public static final DefaultParticleType WILDWOOD_RIFT = register("wildwood_rift", false);
    public static final DefaultParticleType APALACHIA_RIFT = register("apalachia_rift", false);
    public static final DefaultParticleType SKYTHERN_RIFT = register("skythern_rift", false);
    public static final DefaultParticleType MORTUM_RIFT = register("mortum_rift", false);

    private static DefaultParticleType register(String name, boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, getId(name), new ModDefaultParticleType(alwaysShow));
    }
}
package divinerpg.divinerpg.registries;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static divinerpg.divinerpg.DivineRPG.getId;

public class PaintingRegistry {
    public static PaintingVariant FALL = register("fall", new PaintingVariant(32,32));
    public static PaintingVariant MOONLIGHT_RAVE = register("moonlight_rave", new PaintingVariant(32,16));
    public static PaintingVariant GRAZING = register("grazing", new PaintingVariant(16,16));
    public static PaintingVariant DISTURBED = register("disturbed", new PaintingVariant(16,32));
    public static PaintingVariant LEVELS = register("levels", new PaintingVariant(32,32));
    public static PaintingVariant ICE_AGE = register("ice_age", new PaintingVariant(64,64));
    public static PaintingVariant CRAWLING = register("crawling", new PaintingVariant(16,16));
    public static PaintingVariant HOWLING_AT_THE_MOON = register("howling_at_the_moon", new PaintingVariant(64,32));
    public static PaintingVariant LURKING_TERROR = register("lurking_terror", new PaintingVariant(32,32));

    private static PaintingVariant register(String name, PaintingVariant paintingVariant) {
        return Registry.register(
                Registries.PAINTING_VARIANT,
                getId(name),
                paintingVariant
        );
    }
}

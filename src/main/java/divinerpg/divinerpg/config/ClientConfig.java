package divinerpg.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.IntValue ARCANA_X = BUILDER.comment("arcana x").defineInRange("arcanaX", 111, 1, 255), ARCANA_Y = BUILDER.comment("arcana y").defineInRange("arcanaY", 18, 1, 255);
    private static final ModConfigSpec.BooleanValue WELCOME_MSG = BUILDER.comment("Show welcome message").define("welcomeMessage", true), HIDE_ARCANA = BUILDER.comment("Hide Arcana bar unless depleted").define("hideArcanaBar", true);
    public static final ModConfigSpec SPEC = BUILDER.build();
    public static class Values {
        public static final int ARCANAX = ARCANA_X.get(), ARCANAY = ARCANA_Y.get();
        public static final boolean WELCOME_MESSAGE = WELCOME_MSG.get(), HIDE_ARCANA_BAR = HIDE_ARCANA.get();
    }
}
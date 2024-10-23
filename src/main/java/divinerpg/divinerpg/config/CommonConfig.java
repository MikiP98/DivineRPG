package divinerpg.divinerpg.config;

public class CommonConfig {

    public static final int
            // Maximum stored arcana; Default: 200, Min: 200, Max: 10000
            maxArcana = 200,

            // Maximum amount of loaded mobs before the frosted allure stops working; Default: 300, Min: 150, Max: 1000
            allureMaxMobs = 300;

    public static final boolean
            // Safer handling of the Vethean inventory
            saferVetheanInventory = false;
}

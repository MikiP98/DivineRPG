package divinerpg.divinerpg.registries;

import divinerpg.divinerpg.block_entities.block.FrostedAllureBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class BlockEntityRegistry {

    public static void init() {}

    public static final BlockEntityType<FrostedAllureBlockEntity> FROSTED_ALLURE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(MOD_ID, "frosted_allure"),
            FabricBlockEntityTypeBuilder.create(FrostedAllureBlockEntity::new, BlockRegistry.frosted_allure).build()
    );
}

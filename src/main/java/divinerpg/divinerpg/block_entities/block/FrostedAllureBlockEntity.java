package divinerpg.divinerpg.block_entities.block;

import divinerpg.divinerpg.blocks.iceika.BlockFrostedAllure;
import divinerpg.divinerpg.config.CommonConfig;
import divinerpg.divinerpg.registries.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.MobSpawnerEntry;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FrostedAllureBlockEntity extends BlockEntity {
    public FrostedAllureBlockEntity(BlockPos p_155077_, BlockState p_155078_) {
        super(BlockEntityRegistry.FROSTED_ALLURE, p_155077_, p_155078_);
    }

//    @Override @Nullable
//    public ClientboundBlockEntityDataPacket getUpdatePacket() {
//        return ClientboundBlockEntityDataPacket.create(this);
//    }

    public static void serverTick(World level, BlockPos pos, BlockState state, FrostedAllureBlockEntity block) {
        if (level instanceof ServerWorld && level.random.nextInt(5000) == 0 && ((ServerWorld) level).getEntitiesByType(TypeFilter.instanceOf(MobEntity.class), (a) -> true).spliterator().estimateSize() <= CommonConfig.allureMaxMobs) {  // .getEntitiesByClass(MobEntity.class, new Box(pos), (TypeFilter) -> true) .getAllEntities()
//            switch(state.get(BlockFrostedAllure.CATEGORY)) {
//                case 1:
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MONSTER, (ServerWorld) level, pos.up());
//                    break;
//                case 2:
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.CREATURE, (ServerWorld) level, pos.up());
//                    break;
//                case 3:
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AMBIENT, (ServerWorld) level, pos.up());
//                    break;
//                case 4:
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AXOLOTLS, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.UNDERGROUND_WATER_CREATURE, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_CREATURE, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_AMBIENT, (ServerWorld) level, pos.up());
//                    break;
//                case 5:
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MISC, (ServerWorld) level, pos.up());
//                    break;
//                default:
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MONSTER, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.CREATURE, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AMBIENT, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.AXOLOTLS, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.UNDERGROUND_WATER_CREATURE, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_CREATURE, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.WATER_AMBIENT, (ServerWorld) level, pos.up());
//                    NaturalSpawner.spawnCategoryForPosition(MobCategory.MISC, (ServerWorld) level, pos.up());
//                    break;
//            }
        }
    }
}

package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.registries.BlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockModLog extends PillarBlock {
    public int flammability, fireSpread;

    public BlockModLog(MapColor color, BlockSoundGroup sound) {
        super(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(color).sounds(sound));
        flammability = 5;
        fireSpread = 5;
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if(this == BlockRegistry.dreamwood_log || this == BlockRegistry.firewood_log || this == BlockRegistry.hyrewood_log || this == BlockRegistry.mintwood_log) {
            if (!world.isClient) {
//                EntityRegistry.ENT.spawn((ServerWorld) world, stack, player, pos, MobSpawnType.MOB_SUMMONED, true, false);  // TODO: add back;
            }
        }
        super.afterBreak(world, player, pos, state, blockEntity, stack);
    }

    // Done in the registry
//    @Override
//    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 5;
//    }
//
//    @Override
//    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 5;
//    }
}

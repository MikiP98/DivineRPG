package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import divinerpg.divinerpg.registries.BlockRegistry;
import divinerpg.divinerpg.registries.EntityRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockModLog extends PillarBlock implements AlwaysFlammable {
    public BlockModLog(MapColor color, BlockSoundGroup sound) {
        super(Settings.copy(Blocks.OAK_LOG).mapColor(color).sounds(sound));
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        // TODO: Convert to a set of Vethea logs
        if (
                this == BlockRegistry.dreamwoodLog
                || this == BlockRegistry.firewoodLog
                || this == BlockRegistry.hyrewoodLog
                || this == BlockRegistry.mintwoodLog
        ) {
            if(!world.isClient) EntityRegistry.ENT.spawn((ServerWorld) world, tool, player, pos, SpawnReason.MOB_SUMMONED, true, false);
        } super.afterBreak(world, player, pos, state, blockEntity, tool);
    }

    @Override
    public int getFlammability() {return 5;}
    @Override
    public int getFireSpreadSpeed() {return 5;}
}
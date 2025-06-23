package divinerpg.blocks.base;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.ENT;
import static net.minecraft.world.entity.MobSpawnType.MOB_SUMMONED;
import static net.minecraft.world.level.block.Blocks.OAK_LOG;

public class BlockModLog extends RotatedPillarBlock {
    public BlockModLog(MapColor color, SoundType sound) {
        super(Properties.ofFullCopy(OAK_LOG).mapColor(color).sound(sound));
    }
    @Override public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if(this == BlockRegistry.dreamwoodLog.get() || this == BlockRegistry.firewoodLog.get() || this == BlockRegistry.hyrewoodLog.get() || this == BlockRegistry.mintwoodLog.get()) {
            if(!world.isClientSide) ENT.get().spawn((ServerLevel) world, stack, player, pos, MOB_SUMMONED, true, false);
        } super.playerDestroy(world, player, pos, state, blockEntity, stack);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 5;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 5;}
}
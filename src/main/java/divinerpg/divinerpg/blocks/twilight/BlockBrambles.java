package divinerpg.blocks.twilight;

import divinerpg.blocks.base.BlockModDoublePlant;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;
import static net.minecraft.world.level.block.SoundType.ROOTS;
import static net.neoforged.neoforge.common.Tags.Items.TOOLS;

public class BlockBrambles extends BlockModDoublePlant {
    public BlockBrambles(MapColor color) {super(color, ROOTS);}
    @Override public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if(entity instanceof Player) entity.hurt(world.damageSources().cactus(), 6);
    }
    @Override public void playerDestroy(Level worldIn, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity te, ItemStack stack) {
        super.playerDestroy(worldIn, player, pos, state, te, stack);
        if(!stack.is(TOOLS)) player.hurt(worldIn.damageSources().cactus(), 1);
    }
}
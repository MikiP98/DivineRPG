package divinerpg.divinerpg.blocks.twilight;

import divinerpg.divinerpg.blocks.base.BlockModDoublePlant;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockBrambles extends BlockModDoublePlant {
    public BlockBrambles(MapColor color) {super(color, BlockSoundGroup.ROOTS);}

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity) entity.damage(world.getDamageSources().cactus(), 6);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        if (!tool.isIn(ItemTags.TOOLS)) player.damage(world.getDamageSources().cactus(), 1);
    }
}
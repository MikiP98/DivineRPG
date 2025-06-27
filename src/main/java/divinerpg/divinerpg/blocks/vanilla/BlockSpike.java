package divinerpg.divinerpg.blocks.vanilla;

import divinerpg.divinerpg.blocks.base.BlockMod;
import divinerpg.divinerpg.registries.DamageRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSpike extends BlockMod {
    private final boolean isHot;

    public BlockSpike(boolean isHot, MapColor color) {
        super(Settings.create().mapColor(color).strength(5, 6).requiresTool().sounds(BlockSoundGroup.METAL));
        this.isHot = isHot;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (isHot) {
                entity.damage(world.getDamageSources().create(DamageRegistry.SPIKE), 8);
                entity.setOnFireFor(10);
            }
            else entity.damage(world.getDamageSources().create(DamageRegistry.SPIKE), 5);
        }
    }
}
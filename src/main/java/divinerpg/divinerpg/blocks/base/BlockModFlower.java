package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlockModFlower extends FlowerBlock implements AlwaysFlammable {
    private final boolean canGrowOnSand;

    public BlockModFlower(StatusEffect statusEffect, int seconds, MapColor color, boolean canGrowOnSand) {
        super(statusEffect, seconds, Block.Settings.copy(Blocks.POPPY).mapColor(color).sounds(BlockSoundGroup.CROP));
        this.canGrowOnSand = canGrowOnSand;
    }
    public BlockModFlower(StatusEffect statusEffect, int seconds, MapColor color) {
        this(statusEffect, seconds, color, false);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return canGrowOnSand ? super.canPlantOnTop(floor, world, pos) || floor.isIn(BlockTags.SAND) : super.canPlantOnTop(floor, world, pos);
    }

    @Override
    public int getFlammability() {return 100;}
    @Override
    public int getFireSpreadSpeed() {return 60;}
}
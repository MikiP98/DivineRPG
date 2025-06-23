package divinerpg.blocks.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.tags.BlockTags.SAND;
import static net.minecraft.world.level.block.Blocks.POPPY;
import static net.minecraft.world.level.block.SoundType.CROP;

public class BlockModFlower extends FlowerBlock {
    private final boolean canGrowOnSand;
    public BlockModFlower(Holder<MobEffect> mobEffects, float seconds, MapColor color, boolean canGrowOnSand) {
        super(mobEffects, seconds, Properties.ofFullCopy(POPPY).mapColor(color).sound(CROP));
        this.canGrowOnSand = canGrowOnSand;
    }
    public BlockModFlower(Holder<MobEffect> mobEffects, float seconds, MapColor color) {
        this(mobEffects, seconds, color, false);
    }
    @Override protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return canGrowOnSand ? super.mayPlaceOn(state, level, pos) || state.is(SAND) : super.mayPlaceOn(state, level, pos);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
	@Override public MapCodec<? extends FlowerBlock> codec() {
		//TODO: Auto-generated method stub
		return null;
	}
}
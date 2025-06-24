package divinerpg.divinerpg.blocks.base;

//import net.minecraft.core.*;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.tags.FluidTags;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.level.LevelReader;
//import net.minecraft.world.level.block.*;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.lighting.LightEngine;
//import net.minecraft.world.level.material.MapColor;
import net.minecraft.block.*;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;

import static divinerpg.divinerpg.registries.BlockRegistry.*;

public class BlockModGrassBlock extends GrassBlock {
    private final boolean requiresLightToRegrow;
    protected final Block dirtSupplier;

    public BlockModGrassBlock(Block dirt, MapColor color, boolean requiresLightToRegrow) {
        super(Block.Settings.copy(Blocks.GRASS_BLOCK).mapColor(color));
        dirtSupplier = dirt;
        this.requiresLightToRegrow = requiresLightToRegrow;
    }
    public BlockModGrassBlock(Block dirt, MapColor color) {
        this(dirt, color, true);
    }
    public BlockModGrassBlock(Block dirt) {
        super(Block.Settings.copy(Blocks.CRIMSON_NYLIUM).mapColor(MapColor.CYAN).strength(2, 6));
        dirtSupplier = dirt;
        requiresLightToRegrow = false;
    }

    public BlockState grass() {
        if(this == edenGrass) return edenBrush.getDefaultState();
        if(this == wildwoodGrass) return moonlightFern.getDefaultState();
        if(this == apalachiaGrass) return apalachiaTallgrass.getDefaultState();
        if(this == skythernGrass) return skythernBrush.getDefaultState();
        if(this == mortumGrass) return mortumBrush.getDefaultState();
        return null;
    }

    public void place(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if(random.nextBoolean()) pos = pos.offset(Direction.random(random));
        BlockPos above = pos.up();
        if(canPropagate(state, world, pos)) {
            if(world.getBlockState(pos).isOf(dirtSupplier)) world.setBlockState(pos, state, 3);
            else if(world.getBlockState(pos).isOf(this)) {
                BlockState grass = grass();
                if(grass != null) world.setBlockState(above, grass, 3);
            }
        }
    }

    //TODO: to do it the way vanilla does that
    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockState myState = getDefaultState();
        place(world, random, pos.up(), myState);
        place(world, random, pos.down(), myState);
        place(world, random, pos.north(), myState);
        place(world, random, pos.east(), myState);
        place(world, random, pos.south(), myState);
        place(world, random, pos.west(), myState);
    }

    private static boolean canBeGrass(BlockState state, WorldView levelReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        if(blockstate.isOf(Blocks.SNOW) && (blockstate.get(Properties.LAYERS) == 1 || state.getBlock() == frozenGrass)) return true;
        else if(blockstate.getFluidState().getHeight() == 8) return false;
        else {
            int i = levelReader.getLightLevel(blockpos);
//            int i = LightEngine.getLightBlockInto(levelReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(levelReader, blockpos));
            return i < levelReader.getMaxLightLevel();
        }
    }

    private static boolean canPropagate(BlockState state, WorldView level, BlockPos pos) {
        BlockPos blockpos = pos.up();
        return canBeGrass(state, level, pos) && !level.getFluidState(blockpos).isIn(FluidTags.WATER);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
//    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!canBeGrass(state, world, pos)) {
            if(!isAreaLoaded(world, pos, 1)) return;
            world.setBlockState(pos, dirtSupplier.getDefaultState());
        } else {
            if(!isAreaLoaded(world, pos, 3)) return;
            if(world.getLightLevel(pos.up()) >= 9 || !requiresLightToRegrow) {
                BlockState blockstate = getDefaultState();
                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = offset(pos, random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if(world.getBlockState(blockpos).isOf(dirtSupplier) && canPropagate(blockstate, world, blockpos))
                        world.setBlockState(blockpos, blockstate.with(SNOWY, world.getBlockState(blockpos.up()).isOf(Blocks.SNOW)));
                }
            }
        }
    }

    public static BlockPos offset(BlockPos pos, int dx, int dy, int dz) {
        return dx == 0 && dy == 0 && dz == 0 ? pos : new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz);
    }

    @SuppressWarnings("deprecation")
    public static boolean isAreaLoaded(WorldView world, BlockPos pos, int radius) {
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos checkPos = pos.add(x, y, z);
                    if (!world.isChunkLoaded(checkPos)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
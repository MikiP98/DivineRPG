package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.registries.BlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BlockModGrass extends BlockMod implements Fertilizable {
    protected final Block dirtSupplier;

    public BlockModGrass(Block dirt, MapColor colour) {
        super(FabricBlockSettings.create().mapColor(colour).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
        dirtSupplier = dirt;
    }
    public BlockModGrass(Block dirt) {
        super(FabricBlockSettings.create().mapColor(MapColor.CYAN).ticksRandomly().strength(2F, 6F).sounds(BlockSoundGroup.NYLIUM).instrument(Instrument.BASEDRUM));
        dirtSupplier = dirt;
    }

//    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
//        return level.getBlockState(pos.above()).isAir();
//    }
    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

//    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
//        return true;
//    }
    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

//    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
//        BlockState myState = defaultBlockState();
//        place(level, random, pos.above(), myState);
//        place(level, random, pos.below(), myState);
//        place(level, random, pos.north(), myState);
//        place(level, random, pos.east(), myState);
//        place(level, random, pos.south(), myState);
//        place(level, random, pos.west(), myState);
//    }
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

    public void place(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        if(random.nextBoolean()) pos = pos.offset(Direction.random(random));  // .relative(Direction.getRandom(random));

        BlockPos above = pos.up();

        if(canPropagate(state, level, pos)) {
            if(level.getBlockState(pos).isOf(dirtSupplier)) level.setBlockState(pos, state, 3);
            else if(level.getBlockState(pos).isOf(this)) {
                BlockState grass = grass();
                if(grass != null) level.setBlockState(above, grass, 3);
            }
        }
    }

//    @Override
//    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
//        Block block = plantable.getPlant(world, pos.above()).getBlock();
//        if (block instanceof BushBlock && !(block instanceof WaterlilyBlock) && !(block instanceof CropBlock)) {
//            return true;
//        }
//        return false;
//    }

    public BlockState grass() {
//        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_brush")).defaultBlockState();
//        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonlight_fern")).defaultBlockState();
//        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_tallgrass")).defaultBlockState();
//        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_brush")).defaultBlockState();
//        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_brush")).defaultBlockState();
        if (this == BlockRegistry.eden_grass) return BlockRegistry.eden_brush.getDefaultState();
        if (this == BlockRegistry.wildwood_grass) return BlockRegistry.moonlight_fern.getDefaultState();
        if (this == BlockRegistry.apalachia_grass) return BlockRegistry.apalachia_tallgrass.getDefaultState();
        if (this == BlockRegistry.skythern_grass) return BlockRegistry.skythern_brush.getDefaultState();
        if (this == BlockRegistry.mortum_grass) return BlockRegistry.mortum_brush.getDefaultState();
        return null;
    }


    private static boolean canBeGrass(BlockState state, ServerWorld level, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = level.getBlockState(blockpos);
        if(blockstate.isOf(Blocks.SNOW) || blockstate.isOf(Blocks.SNOW_BLOCK) || blockstate.isOf(Blocks.POWDER_SNOW)) return true;
        else if(blockstate.getFluidState().getHeight() == 8) return false;  // .getAmount() was an int
        else {
//            int i = LightEngine.getLightBlockInto(level, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(level, blockpos));
            int i = level.getBaseLightLevel(blockpos.up(), level.getAmbientDarkness());
            return i < level.getMaxLightLevel();
        }
    }

    private static boolean canPropagate(BlockState state, ServerWorld level, BlockPos pos) {
        return canBeGrass(state, level, pos) && !level.getFluidState(pos.up()).isIn(FluidTags.WATER);
    }

    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if(!canBeGrass(state, level, pos)) level.setBlockState(pos, dirtSupplier.getDefaultState());  // .setBlockAndUpdate(pos, dirtSupplier.getDefaultState())
        else if(level.getLightLevel(pos.up()) >= 9) {
            BlockState blockstate = getDefaultState();
            for(int i = 0; i < 4; ++i) {
                BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);  // .offset() -> .add()
                if (level.getBlockState(blockpos).isOf(dirtSupplier) && canPropagate(blockstate, level, blockpos)) {
                    // ???
                    // Todo: Figure out what should be here
                }
            }
        }
    }
}

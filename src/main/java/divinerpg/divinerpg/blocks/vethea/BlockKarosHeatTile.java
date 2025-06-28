package divinerpg.divinerpg.blocks.vethea;

import divinerpg.divinerpg.blocks.base.BlockModUnbreakable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

//import net.minecraft.core.BlockPos;
//import net.minecraft.server.level.*;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.entity.*;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.*;
//import net.minecraft.world.level.block.state.properties.*;
//import net.minecraft.world.level.material.MapColor;

public class BlockKarosHeatTile extends BlockModUnbreakable {
    public static final BooleanProperty ACTIVE = Properties.ENABLED;
    
    public BlockKarosHeatTile() {
        super(Settings.create().mapColor(MapColor.EMERALD_GREEN).ticksRandomly().instrument(Instrument.BASEDRUM));
        setDefaultState(getDefaultState().with(ACTIVE, false));
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(ACTIVE) && random.nextInt(5) == 0)
            world.setBlockState(pos, state.with(ACTIVE, false), 2);
    }
    
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (state.get(ACTIVE) && entity instanceof ServerPlayerEntity) {
            entity.damage(entity.getDamageSources().hotFloor(), 6);
            entity.setOnFireFor(5);
        }
    }

    // TODO: Very similar to BlockHeatTrap, consider merging them or extending from it
}
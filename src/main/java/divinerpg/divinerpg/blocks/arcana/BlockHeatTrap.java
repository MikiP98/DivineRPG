package divinerpg.divinerpg.blocks.arcana;

import divinerpg.divinerpg.blocks.base.BlockModUnbreakable;
import divinerpg.divinerpg.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BlockHeatTrap extends BlockModUnbreakable {
    public static final BooleanProperty ACTIVE = Properties.ENABLED;

    public BlockHeatTrap() {
        super(Settings.create().mapColor(MapColor.BLUE).ticksRandomly().dropsNothing().instrument(Instrument.BASEDRUM));
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
        if (state.isOf(this) && entity instanceof LivingEntity) {
            if (!state.get(ACTIVE))
                world.setBlockState(pos, BlockRegistry.heatTrap.getDefaultState().with(ACTIVE, true), 2);
            entity.damage(entity.getDamageSources().hotFloor(), 4);
            entity.setOnFireFor(7);
        }
    }
}
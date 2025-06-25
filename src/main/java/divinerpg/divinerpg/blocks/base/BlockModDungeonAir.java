package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.registries.BlockRegistry;
import divinerpg.divinerpg.registries.MobEffectRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockModDungeonAir extends BlockMod {
    /**
     * remove the {@code .air()} property for better managing when building with this block
     */
    public BlockModDungeonAir() {
        super(Block.Settings.create().dropsNothing().nonOpaque().noCollision().air());
    }

	@SuppressWarnings("deprecation")
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if(entity instanceof ServerPlayerEntity && !((ServerPlayerEntity) entity).isCreative())
			((ServerPlayerEntity) entity).addStatusEffect(new StatusEffectInstance(MobEffectRegistry.HEAVY_AIR, 20, 1, true, false, false));
	}

	@SuppressWarnings("deprecation")
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return context.isHolding(BlockRegistry.dungeonAir.asItem()) ? VoxelShapes.fullCube() : VoxelShapes.empty();
	}

	@SuppressWarnings("deprecation")
    @Override
	public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
		return 1.0F;
    }

	@SuppressWarnings("deprecation")
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.INVISIBLE;
	}

	@Override
	public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
		return true;
    }

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		if(random.nextInt(500) == 0)
			world.addParticle(
					ParticleTypes.SMOKE,
					pos.getX() + random.nextDouble(),
					pos.getY() + random.nextDouble(),
					pos.getZ() + random.nextDouble(),
					.0, .0, .0
			);
	}
}
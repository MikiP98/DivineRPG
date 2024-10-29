package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.particle.ParticleTypes;

public class BlockModWallTorch extends WallTorchBlock {
    public BlockModWallTorch() {super(FabricBlockSettings.copy(Blocks.WALL_TORCH), ParticleTypes.FLAME);}

//    @OnlyIn(Dist.CLIENT)
//    @Override public void animateTick(BlockState state, World level, BlockPos pos, Random random) {
//        double d0 = pos.getX() + .5;
//        double d1 = pos.getY() + .7;
//        double d2 = pos.getZ() + .5;
//        double d3 = .22;
//        double d4 = .27;
//        Direction dir1 = state.getValue(FACING).getOpposite();
//        level.addParticle(ParticleTypes.SMOKE, d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
//        if(this == BlockRegistry.arcaniumWallTorch.get()) level.addParticle(ParticleRegistry.PURPLE_FLAME.get(), d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
//        if(this == BlockRegistry.edenWallTorch.get()) level.addParticle(ParticleRegistry.GREEN_FLAME.get(), d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
//    }
}
package divinerpg.divinerpg.blocks.base;

import divinerpg.divinerpg.registries.*;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;

public class BlockModTorch extends TorchBlock {
//    TODO: I don't know why it refuses to work when I insert the needed particle into the constructor directly
    // TODO: Check if it works fine on Fabric
    public BlockModTorch() { super(Settings.copy(Blocks.TORCH), ParticleTypes.FLAME); }
    public BlockModTorch(ParticleEffect particle) { super(Settings.copy(Blocks.TORCH), particle); }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
//        double d0 = pos.getX() + .5;
//        double d1 = pos.getY() + .7;
//        double d2 = pos.getZ() + .5;
//        level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
//        if(this == BlockRegistry.arcaniumTorch.get()) level.addParticle(ParticleRegistry.PURPLE_FLAME.get(), d0, d1, d2, 0, 0, 0);
//        if(this == BlockRegistry.edenTorch.get()) level.addParticle(ParticleRegistry.GREEN_FLAME.get(), d0, d1, d2, 0, 0, 0);
//    }
}
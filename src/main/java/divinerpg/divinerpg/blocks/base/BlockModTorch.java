package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleTypes;

public class BlockModTorch extends TorchBlock {
    //TODO: FORGE: I don't know why it refuses to work when I insert the needed particle into the constructor directly
    public BlockModTorch() {
        super(FabricBlockSettings.copy(Blocks.TORCH), ParticleTypes.FLAME);
    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void animateTick(BlockState state, World level, BlockPos pos, Random random) {
//        double d0 = pos.getX() + .5;
//        double d1 = pos.getY() + .7;
//        double d2 = pos.getZ() + .5;
//        level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
//        if(this == BlockRegistry.arcaniumTorch) level.addParticle(ParticleRegistry.PURPLE_FLAME, d0, d1, d2, 0, 0, 0);
//        if(this == BlockRegistry.edenTorch) level.addParticle(ParticleRegistry.GREEN_FLAME, d0, d1, d2, 0, 0, 0);
//    }
}

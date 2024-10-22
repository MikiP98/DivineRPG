package divinerpg.divinerpg.blocks.iceika;

import divinerpg.divinerpg.blocks.base.BlockModLadder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class BlockLights extends BlockModLadder {
    public BlockLights() {
        super(FabricBlockSettings.create().strength(0.4F).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.WOOD).dynamicBounds().nonOpaque().notSolid().luminance(15));  // .noOcclusion()
    }

//    @Override
//    public boolean isLadder(BlockState state, LevelReader world, BlockPos pos, LivingEntity entity) {
//        return false;
//    }
}

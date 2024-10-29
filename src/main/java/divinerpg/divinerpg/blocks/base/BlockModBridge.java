package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BlockModBridge extends BlockModPowered {
    public BlockModBridge() {
        super(FabricBlockSettings.create()
                .strength(0.3F)
                .blockVision(BlockModBridge::never)
                .notSolid().nonOpaque() // .noOcclusion()
                .sounds(BlockSoundGroup.GLASS)
                .luminance((state) -> state.get(POWERED) ? 15 : 0)
        );
    }

    private static boolean never(BlockState state, BlockView reader, BlockPos pos) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(POWERED) ? super.getCollisionShape(state, world, pos, context) : VoxelShapes.empty();
    }
}

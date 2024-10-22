package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder() {
        super(FabricBlockSettings.create().strength(0.4F).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.LADDER).dynamicBounds().nonOpaque());  // .noOcclusion()
    }

    public BlockModLadder(Settings properties) {
        super(properties);
    }
}

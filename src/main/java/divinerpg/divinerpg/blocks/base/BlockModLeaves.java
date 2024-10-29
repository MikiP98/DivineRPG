package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModLeaves extends LeavesBlock {
    public int flammability, fireSpread;

    public BlockModLeaves(MapColor color, BlockSoundGroup sound) {
        super(FabricBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(color).sounds(sound));
        flammability = 60;
        fireSpread = 30;
    }

    // Done in the registry
//    @Override
//    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 60;
//    }
//
//    @Override
//    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
//        return 30;
//    }
}

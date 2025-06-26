package divinerpg.divinerpg.blocks.arcana;

import divinerpg.divinerpg.blocks.AlwaysFlammable;
import divinerpg.divinerpg.registries.BlockRegistry;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.WeepingVinesPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class BlockArcaniteVinesBody extends WeepingVinesPlantBlock implements AlwaysFlammable {
    public BlockArcaniteVinesBody(Settings settings) {
        super(settings);
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) BlockRegistry.arcaniteVinesHead;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public int getFlammability() {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed() {
        return 15;
    }
}

package divinerpg.divinerpg.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class BlockModBookshelf extends BlockMod {
    public BlockModBookshelf(MapColor color) {
        super(FabricBlockSettings.create().mapColor(color).requiresTool().strength(2F, 6.0F).sounds(BlockSoundGroup.STONE).instrument(Instrument.BASEDRUM));
    }

    // Done in the vanilla data tag `enchantment_power_provider.json`
//    @Override
//    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
//        return 1.0F;
//    }
}

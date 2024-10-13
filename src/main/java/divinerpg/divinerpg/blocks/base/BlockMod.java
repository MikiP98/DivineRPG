package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class BlockMod extends Block {
    public int flammability, fireSpread;

    public BlockMod(Settings settings) {
        super(settings);
    }
    public BlockMod(MapColor color, float hardness, float resistance) {
        super(Settings.create().mapColor(color).requiresTool().strength(hardness, resistance).instrument(Instrument.BASEDRUM));
        flammability = fireSpread = 0;
    }
    public BlockMod(MapColor color, float hardness, float resistance, BlockSoundGroup sound, Instrument instrument) {
        super(Settings.create().mapColor(color).requiresTool().strength(hardness, resistance).sounds(sound).instrument(instrument));
        flammability = fireSpread = 0;
    }
    public BlockMod(MapColor color, float hardness, float resistance, int fAbility, int fSpread, BlockSoundGroup sound, Instrument instrument) {
        super(Settings.create().mapColor(color).strength(hardness, resistance).sounds(sound).instrument(instrument));
        flammability = fAbility;
        fireSpread = fSpread;
    }
    public BlockMod(MapColor color, int luminance) {
        super(Settings.create().mapColor(color).requiresTool().strength(50, 1200).pistonBehavior(PistonBehavior.BLOCK).instrument(Instrument.BASEDRUM).luminance((state) -> luminance));
        flammability = fireSpread = 0;
    }

//    public int getFlammability() {return flammability;}
//    public int getFireSpread() {return fireSpread;}

//    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return flammability;}
//    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return fireSpread;}
}

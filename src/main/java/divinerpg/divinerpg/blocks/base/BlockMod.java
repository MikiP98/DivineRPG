package divinerpg.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class BlockMod extends Block {
    //Blocks with specific properties
    public BlockMod(Block.Settings settings) {super(settings);}
    //Regular stone-like properties
    public BlockMod(MapColor color) {this(color, 1.5F, 6);}
    //Regular stone-like properties, but custom hardness/resistance
    public BlockMod(MapColor color, float hardness, float resistance) {
        super(Block.Settings.copy(Blocks.STONE).mapColor(color).strength(hardness, resistance));
    }
    //Custom hardness/resistance + instrument and sound
    public BlockMod(MapColor color, float hardness, float resistance, BlockSoundGroup sound, Instrument instrument) {
        super(Block.Settings.create().mapColor(color).requiresTool().strength(hardness, resistance).sounds(sound).instrument(instrument));
    }
    //Hard blocks like obsidian, but luminous
    public BlockMod(MapColor color, int luminance) {
        super(Block.Settings.copy(Blocks.OBSIDIAN).mapColor(color).pistonBehavior(PistonBehavior.BLOCK).luminance((state) -> luminance));
    }
}
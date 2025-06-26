package divinerpg.divinerpg.enums;

import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public enum BlockColor implements StringIdentifiable {
    RED("red"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    PURPLE("purple"),
    PINK("pink"),
    WHITE("white");

    public static final EnumProperty<BlockColor> COLOR = EnumProperty.of("color", BlockColor.class);
    private final String name;

    BlockColor(String name) {this.name = name;}

    @Override
    public String toString() { return this.asString(); }

    @Override
    public String asString() { return this.name; }
}
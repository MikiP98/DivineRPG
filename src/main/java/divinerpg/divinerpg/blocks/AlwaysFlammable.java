package divinerpg.divinerpg.blocks;

public interface AlwaysFlammable {
    /**
     * Returns the flammability of the block.
     * @return The flammability value.
     */
    int getFlammability();

    /**
     * Returns the fire spread speed of the block.
     * @return The fire spread speed value.
     */
    int getFireSpreadSpeed();
}

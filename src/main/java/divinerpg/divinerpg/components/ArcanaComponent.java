package divinerpg.divinerpg.components;

import dev.onyxstudios.cca.api.v3.component.Component;
import net.minecraft.nbt.NbtCompound;

import java.time.LocalTime;

public class ArcanaComponent implements Component {
    private static final int maxArcana = 100;
    private static final int tickDelay = 4;
    private static final int tickRegen = 1;

    private int arcana;
    private LocalTime lastUse;
    private boolean justUsed;

    public ArcanaComponent() {
        this.arcana = maxArcana;

        new Thread(() -> {
            while (true) {
                try {
                    if (arcana < maxArcana) {
                        if (justUsed) {
                            wait(1000 / tickDelay / 20);
                            justUsed = false;
                        }
                        arcana += tickRegen;
                        wait(1000 / 20);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public boolean tryUse(int amount, int cooldown) {
        LocalTime now = LocalTime.now();
        if (lastUse == null || now.isAfter(lastUse.plusSeconds(cooldown/20)) && arcana >= amount) {
            justUsed = true;
            lastUse = now;
            arcana -= amount;
            return true;
        } else {
            return false;
        }
    }

    public int getArcana() {
        return this.arcana;
    }

    public void setArcana(int mana) {
        this.arcana = mana;
    }

    public void modifyArcana(int amount) {
        this.arcana += amount;
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound) {
        arcana = nbtCompound.getInt("arcana");
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound) {
        nbtCompound.putInt("arcana", arcana);
    }
}

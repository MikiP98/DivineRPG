package divinerpg.divinerpg.items.base;

import divinerpg.divinerpg.enums.ToolStats;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class ItemModSword extends SwordItem {
    public int arcanaConsumedUse;
    public int arcanaConsumedAttack;
    public int cooldown;
    public ToolStats sword;

    //Have rarity
    public ItemModSword(Rarity rarity, ToolMaterial tier) {
        super(tier, 1, tier.getMiningSpeedMultiplier(), new Settings().rarity(rarity));
        sword = (ToolStats) tier;
    }
    //No rarity
    public ItemModSword(ToolMaterial tier) {
        super(tier, 1, tier.getMiningSpeedMultiplier(), new Settings());
        sword = (ToolStats) tier;
    }
    //Fire-resistant swords
    public ItemModSword(ToolMaterial tier, Settings properties) {
        super(tier, 1, tier.getMiningSpeedMultiplier(), properties);
        sword = (ToolStats) tier;
    }

    public ItemModSword setAttackArcanaConsumption(int amount) {
        arcanaConsumedAttack = amount;
        return this;
    }
}

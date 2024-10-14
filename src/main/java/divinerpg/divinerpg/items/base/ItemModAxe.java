package divinerpg.divinerpg.items.base;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

import java.util.List;

public class ItemModAxe extends AxeItem {
    public ItemModAxe(ToolMaterial tier, float attackSpeed, Rarity rarity) {super(tier, 0, attackSpeed, new Settings().rarity(rarity));}
    public ItemModAxe(ToolMaterial tier, float attackSpeed) {super(tier, 0, attackSpeed, new Settings());}
    public ItemModAxe(ToolMaterial tier, Settings properties) {super(tier, 0, -2.9F, properties);}

//    @SuppressWarnings("deprecation")
//    @OnlyIn(Dist.CLIENT)
//    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.efficiency((int)speed));
//        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
//        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
//    }
}

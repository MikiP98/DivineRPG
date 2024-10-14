package divinerpg.divinerpg.items.base;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class ItemModHoe extends HoeItem {
    // My
    public ItemModHoe(ToolMaterial tier) {super(tier, 0, 0, new Settings());}

    public ItemModHoe(ToolMaterial tier, Rarity rarity) {super(tier, 0, 0, new Settings().rarity(rarity));}
    public ItemModHoe(ToolMaterial tier, float attackSpeed) {super(tier, 0, attackSpeed, new Settings());}
    public ItemModHoe(ToolMaterial tier, Settings properties) {super(tier, 0, 0, properties);}

//    @SuppressWarnings("deprecation")
//    @OnlyIn(Dist.CLIENT)
//    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.efficiency((int)speed));
//        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
//        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
//    }
}

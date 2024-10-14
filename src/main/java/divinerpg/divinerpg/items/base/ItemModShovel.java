package divinerpg.divinerpg.items.base;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

import java.util.List;

public class ItemModShovel extends ShovelItem {
    public ItemModShovel(ToolMaterial tier, Rarity rarity) {super(tier, 0, -3, new Settings().rarity(rarity));}
    public ItemModShovel(ToolMaterial tier) {super(tier, 0, -3, new Settings());}
    public ItemModShovel(ToolMaterial tier, Settings properties) {super(tier, 0, -3, properties);}

//    @SuppressWarnings("deprecation")
//    @OnlyIn(Dist.CLIENT)
//    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.efficiency((int)speed));
//        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
//        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
//    }
}

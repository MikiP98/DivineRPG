package divinerpg.divinerpg.items.base;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

import java.util.List;

public class ItemModPickaxe extends PickaxeItem {
    public ItemModPickaxe(ToolMaterial tier, Rarity rarity) {super(tier, 0, -2.8F, new Settings().rarity(rarity));}
    public ItemModPickaxe(ToolMaterial tier) {super(tier, 0, -2.8F, new Settings());}
    public ItemModPickaxe(ToolMaterial tier, Settings properties) {super(tier, 0, -2.8F, properties);}

//    @SuppressWarnings("deprecation")
//    @OnlyIn(Dist.CLIENT)
//    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.efficiency((int)speed));
//        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
//        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
//    }
}

package divinerpg.items.iceika;

import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;
import net.minecraft.sounds.*;
import net.minecraft.world.item.*;

public class ItemEggNog extends ItemModFood {
    public ItemEggNog() {super(new Properties().food(FoodList.EGG_NOG).stacksTo(1));}
    @Override public UseAnim getUseAnimation(ItemStack stack) {return UseAnim.DRINK;}
    @Override public SoundEvent getEatingSound() {return SoundEvents.HONEY_DRINK;}
}
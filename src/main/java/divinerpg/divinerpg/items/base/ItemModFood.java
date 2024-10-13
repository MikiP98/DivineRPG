package divinerpg.divinerpg.items.base;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;

public class ItemModFood extends ItemMod {
    FoodComponent food;
    boolean fastFood;

    public ItemModFood(Settings settings) {
        super(settings);
    }
    public ItemModFood(FoodComponent food) {
        super(new Settings());
        this.food = food;
    }
    public ItemModFood(FoodComponent food, boolean fastFood) {
        super(new Settings());
        this.food = food;
        this.fastFood = fastFood;
    }

    @Override
    public boolean isFood() {return true;}

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return fastFood ? 1 : super.getMaxUseTime(stack);
    }

    @Override
    public FoodComponent getFoodComponent() {return food;}

//    @OnlyIn(Dist.CLIENT)
//    @Override public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
//        if(fastFood) tooltip.add(LocalizeUtils.instantConsumption());
//        super.appendHoverText(stack, level, tooltip, flagIn);
//    }
}

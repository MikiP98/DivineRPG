package divinerpg.divinerpg.items.base;

import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.function.Consumer;

import static divinerpg.divinerpg.DivineRPG.MOD_ID;

public class DivineShield extends ShieldItem {
    public Identifier resource;
//    public ResourceLocation resource;
    private final Ingredient repairMaterial;

    public DivineShield(Rarity rarity, Item repairMaterial, int damage, String name) {
        super(new Settings().maxDamage(damage).rarity(rarity));
        this.repairMaterial = Ingredient.ofStacks(repairMaterial.getDefaultStack());
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
        resource = new Identifier(MOD_ID, "textures/shield/" + name + ".png");
    }
    public DivineShield(Item repairMaterial, int damage, String name) {
        super(new Settings().maxDamage(damage));
        this.repairMaterial = Ingredient.ofStacks(repairMaterial.getDefaultStack());
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
        resource = new Identifier(MOD_ID, "textures/shield/" + name + ".png");
    }

    @Override public boolean canRepair(ItemStack shield, ItemStack ingredient) {
        if(repairMaterial != null) return repairMaterial.test(ingredient);
        else return super.canRepair(shield, ingredient);
    }

//    @Override public void initializeClient(Consumer<IClientItemExtensions> consumer) {
//        super.initializeClient(consumer);
//        consumer.accept(RenderProps.INSTANCE);
//    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
//    }
//    static class RenderProps implements IClientItemExtensions {
//        public static RenderProps INSTANCE = new RenderProps();
//        @Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new DivineShieldRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());}
//    }
}

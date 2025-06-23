package divinerpg.items.arcana;

import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemFirefly extends ItemRangedWeapon {
    public ItemFirefly() {
        super(EntityRegistry.FIREFLY::value, 1216);
        sound = SoundRegistry.FIREFLY.get();
        cooldown = 30;
        arcanaConsumedUse = 25;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaDam(8));
        tooltip.add(LocalizeUtils.homingShots());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}
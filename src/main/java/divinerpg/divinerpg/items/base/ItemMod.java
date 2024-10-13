package divinerpg.divinerpg.items.base;

import divinerpg.divinerpg.DivineRPGDataGenerator;
import divinerpg.divinerpg.components.ArcanaComponent;
import divinerpg.divinerpg.registries.DivineComponentRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stat;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ItemMod extends Item {
    public int arcanaConsumedUse, cooldown;

    public ItemMod() {super(new Item.Settings());}
    public ItemMod(Item.Settings settings) {super(settings);}

    public ItemMod setArcanaUseConsumption(int amount) {
        arcanaConsumedUse = amount;
        return this;
    }
    public ItemMod setArcanaUseCooldown(int amount) {
        cooldown = amount;
        return this;
    }

    protected TypedActionResult<ItemStack> arcanicUse(World level, PlayerEntity player, Hand hand) {
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ArcanaComponent arcana = DivineComponentRegistry.getArcana(player);
        if (arcanaConsumedUse != 0) {
//            arcana.modifyArcana(-arcanaConsumedUse);
            if (!(arcana.tryUse(arcanaConsumedUse, cooldown))) {
                player.sendMessage(Text.of("Insufficient Arcana or cooldown remaining"), true);
                return super.use(level, player, hand);
            }
            player.sendMessage(Text.of("Arcana used"), true);
//            player.getCooldowns().addCooldown(this, cooldown);
//            player.awardStat(Stats.ITEM_USED.get(this));
//            player.incrementStat();
            return arcanicUse(level, player, hand);
        }
        player.sendMessage(Text.of("Arcana not used"), true);
        return super.use(level, player, hand);
//        return player.get .getCapability(ArcanaProvider.ARCANA).map(arcana -> {
//            if(arcanaConsumedUse != 0 && arcana.getAmount(level.isClientSide()) >= arcanaConsumedUse) {
//                arcana.modifyAmount(player, -arcanaConsumedUse);
//                player.getCooldowns().addCooldown(this, cooldown);
//                player.awardStat(Stats.ITEM_USED.get(this));
//                return arcanicUse(level, player, hand);
//            } return super.use(level, player, hand);
//        }).orElse(super.use(level, player, hand));
    }

//    @OnlyIn(Dist.CLIENT)
//    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//        if(getDescriptionId().contains("torridite")) tooltip.add(LocalizeUtils.i18n("torridite"));
//        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
//    }
}

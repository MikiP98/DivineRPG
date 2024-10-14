package divinerpg.divinerpg.items.vanilla;

import divinerpg.divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.divinerpg.enums.BulletType;
import divinerpg.divinerpg.items.base.ItemModFood;
import divinerpg.divinerpg.util.FoodList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ItemTomato extends ItemModFood {
    public ItemTomato() {super(FoodList.TOMATO);}

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if(player.isSneaking()) {
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, .5F, .4F / (player.getRandom().nextFloat() * .4F + .8F));
            if (!player.isCreative()) stack.decrement(1);
            if (!world.isClient) {
//                EntityShooterBullet bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, BulletType.TOMATO_SHOT);
//                bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, 1);
//                world.spawnEntity(bullet);  // .addFreshEntity(bullet)
            }
//            player.awardStat(Stats.ITEM_USED.getshrink(this));
            if (!player.isCreative()) stack.decrement(1);
            return TypedActionResult.success(stack);

//        } else if (player.getHungerManager(). .canEat(stack.getFoodProperties(player).canAlwaysEat())) {
//            player.startUsingItem(hand);
//            return TypedActionResult.consume(stack);

        } else return super.use(world, player, hand);
    }
}

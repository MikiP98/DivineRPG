package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.IAttackTimer;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.network.syncher.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;

public class EntityStoneGolem extends EntityDivineTameable implements IAttackTimer {
    public int attackTimer = 0;
    public EntityStoneGolem(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    @Override
    public void tick() {
        super.tick();
        if(attackTimer > 0) attackTimer--;
    }
    @Override
    public int getAttackTimer() {
        return attackTimer;
    }
    @Override
    public boolean isFood(ItemStack item) {
    	return item.is(ItemTags.STONE_CRAFTING_MATERIALS);
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(ItemTags.STONE_CRAFTING_MATERIALS);
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean attack = super.doHurtTarget(entity);
        if(attack) {
            entity.setDeltaMovement(-Mth.sin(getXRot() * (float) Math.PI / 180F), .1, Mth.cos(getXRot() * (float) Math.PI / 180F));
            attackTimer = 10;
        } return attack;
    }

}

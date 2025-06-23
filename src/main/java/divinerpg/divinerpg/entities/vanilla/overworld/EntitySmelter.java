package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.IAttackTimer;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.network.syncher.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;

public class EntitySmelter extends EntityDivineTameable implements IAttackTimer {
    public EntitySmelter(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    public int attackTimer = 0;
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
    	return item.is(Items.FLINT);
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(Items.FLINT);
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean attack = super.doHurtTarget(entity);
        if(attack) {
            entity.setDeltaMovement(-Mth.sin(getXRot() * (float) Math.PI / 180.0F), 0.1D,
                    Mth.cos(getXRot() * (float) Math.PI / 180.0F));
            entity.igniteForSeconds(5);
            attackTimer = 10;
        }
        return attack;
    }

}

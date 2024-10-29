package divinerpg.divinerpg.entities.projectile;

import divinerpg.divinerpg.enums.BulletType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

import java.util.Random;

public class EntityShooterBullet extends ThrownEntity {
//    private static final EntityDataAccessor<Byte> BULLET_ID = SynchedEntityData.defineId(EntityShooterBullet.class, EntityDataSerializers.BYTE);
    public BulletType bulletType;
    public int bounces;
    public int color = new Random().nextInt(25);
    public LivingEntity thrower;

    protected EntityShooterBullet(EntityType<? extends ThrownEntity> entityType, World world) {super(entityType, world);}
    protected EntityShooterBullet(EntityType<? extends ThrownEntity> type, LivingEntity owner, World world, BulletType bulletType) {
        super(type, owner, world);
        this.bulletType = bulletType;
        thrower = owner;
//        setBulletId((byte)bulletType.ordinal());
//        //TODO: to add a more universal check or move it somewhere else
//        if(getBulletType() == BulletType.REFLECTOR_SHOT || getBulletType() == BulletType.ATTRACTOR_SHOT || getBulletType() == BulletType.SERENADE_OF_ICE_SHOT) setDeltaMovement(getDeltaMovement().x * 3, getDeltaMovement().y * 3, getDeltaMovement().z * 3);
//        if(getBulletType().getBulletSpecial() == BulletType.BulletSpecial.SKY) setDeltaMovement(world.getRandom().nextGaussian() * .05, -.5, level().getRandom().nextGaussian() * .05);
    }
    public EntityShooterBullet(EntityType<? extends ThrownEntity> type, double x, double y, double z, World world, BulletType bulletType) {
        super(type, x, y, z, world);
        this.bulletType = bulletType;
    }

//    private byte getBulletId() {return entityData.get(BULLET_ID);}
//    private void setBulletId(byte projectileId) {
//        DataTracker.registerData(this, BULLET_ID, projectileId).set(BULLET_ID, projectileId);}
//    public BulletType getBulletType() {
//        if(bulletType == null) bulletType = BulletType.getBulletFromOrdinal(getBulletId());
//        return bulletType;
//    }

    @Override
    protected void initDataTracker() {

    }
}

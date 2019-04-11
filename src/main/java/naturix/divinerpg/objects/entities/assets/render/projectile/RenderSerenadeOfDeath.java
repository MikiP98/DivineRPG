package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntitySerenadeOfDeath;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSerenadeOfDeath extends RenderProjectile<EntitySerenadeOfDeath> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/serenade_of_death.png");

    public RenderSerenadeOfDeath(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySerenadeOfDeath entity) {
        return TEXTURE;
    }
}

package divinerpg.client.renders.entity.projectile;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineArrow extends ArrowRenderer<DivineArrow> {
    protected final ResourceLocation TEXTURE;
    public RenderDivineArrow(EntityRendererProvider.Context context, String textureName) {
        super(context);
        TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/projectiles/" + textureName + ".png");
    }
    @Override public ResourceLocation getTextureLocation(DivineArrow arrow) {return TEXTURE;}
}
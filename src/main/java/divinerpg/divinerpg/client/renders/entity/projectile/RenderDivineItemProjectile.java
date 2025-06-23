package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class RenderDivineItemProjectile<T extends Projectile> extends EntityRenderer<T> {
    private final Supplier<Item> item;
    private final ItemRenderer itemRenderer;
    public RenderDivineItemProjectile(EntityRendererProvider.Context context, Supplier<Item> item) {
        super(context);
        itemRenderer = context.getItemRenderer();
        this.item = item;
    }
    @Override public void render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.tickCount > 2 || !(entityRenderDispatcher.camera.getEntity().distanceToSqr(entity) < 12.25)) {
            poseStack.pushPose();
            poseStack.mulPose(entityRenderDispatcher.cameraOrientation());
            itemRenderer.renderStatic(item.get().getDefaultInstance(), ItemDisplayContext.GROUND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, entity.level(), entity.getId());
            poseStack.popPose();
            super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        }
    }
    @SuppressWarnings("deprecation")
    @Override public ResourceLocation getTextureLocation(Projectile entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
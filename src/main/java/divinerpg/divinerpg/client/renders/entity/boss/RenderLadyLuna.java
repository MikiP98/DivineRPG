package divinerpg.client.renders.entity.boss;

import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.*;
import divinerpg.registries.AttachmentRegistry;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.neoforged.api.distmarker.*;

import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class RenderLadyLuna extends RenderDivineMob<EntityLadyLuna> {
	private final ResourceLocation arcanic = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/lady_luna_arcanic.png"), ranged = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/lady_luna_ranged.png");
    public RenderLadyLuna(Context context) {
        super(context, "lady_luna", new ModelLadyLuna(context), 0.8F);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityLadyLuna entity) {
        return switch(AttachmentRegistry.VARIANT.getOrDefault(entity, (byte)2)) {
          case 0 -> arcanic;
          case 1 -> ranged;
          default -> TEXTURE;
        };
    }
}
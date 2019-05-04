package naturix.divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.render.MainHandLayerRenderFrostArcher;
import naturix.divinerpg.objects.entities.entity.iceika.FrostArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFrostArcher extends RenderLiving<FrostArcher> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/frost_archer.png");

    public RenderFrostArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), shadowsizeIn);
        addLayer(new MainHandLayerRenderFrostArcher(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(FrostArcher entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<FrostArcher> {
        @Override
        public Render<? super FrostArcher> createRenderFor(RenderManager manager) {
            return new RenderFrostArcher(manager, new ModelBiped(), 1F);
        }
    }
}
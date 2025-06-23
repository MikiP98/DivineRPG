package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.ArcaniumExtractorMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ArcaniumExtractorScreen extends AbstractContainerScreen<ArcaniumExtractorMenu> {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/arcanium_extractor.png");
    public static final ResourceLocation FLAME_SPRITE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "extractor_flame");
    public ArcaniumExtractorScreen(ArcaniumExtractorMenu screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }
    @Override public void render(GuiGraphics stack, int x, int y, float partialTicks) {
        super.render(stack, x, y, partialTicks);
        renderTooltip(stack, x, y);
    }
    @Override protected void renderBg(GuiGraphics stack, float p_282530_, int p_281621_, int p_283333_) {
        int i = leftPos;
        int j = topPos;
        stack.blit(GUI_TEXTURE, i, j, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        if(menu.isLit()) {
            int l = Mth.ceil(menu.getLitProgress() * 13F) + 1;
            stack.blitSprite(FLAME_SPRITE, 14, 14, 0, 14 - l, i + 57, j + 50 - l, 14, l);
        } stack.blitSprite(DivineFurnaceScreen.PROGRESS_ARROW_SPRITE, 24, 16, 0, 0, i + 79, j + 34, Mth.ceil(menu.getBurnProgress() * 24F), 16);
    }
}
package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.DreamLampMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DreamLampScreen extends AbstractContainerScreen<DreamLampMenu> {
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/dream_lamp.png");
    public DreamLampScreen(DreamLampMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        titleLabelY -= 2;
    }
    @Override public void render(GuiGraphics stack, int mouseX, int mouseY, float partialTicks) {
        super.render(stack, mouseX, mouseY, partialTicks);
        renderTooltip(stack, mouseX, mouseY);
    }
    @Override protected void renderLabels(GuiGraphics stack, int mouseX, int mouseY) {
        stack.drawString(font, title, 12, 7, 13563562);
        stack.drawString(font, playerInventoryTitle, 12, 71, 13563562);
    }
    @Override protected void renderBg(GuiGraphics stack, float partialTicks, int mouseX, int mouseY) {
        int edgeSpacingX = (width - getXSize()) / 2;
        int edgeSpacingY = (height - getYSize()) / 2;
        stack.blit(texture, edgeSpacingX, edgeSpacingY, 0, 0, getXSize(), getYSize(), 176, 166);
    }
}
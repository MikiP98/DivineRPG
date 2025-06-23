package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.InfusionTableMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class InfusionTableScreen extends AbstractContainerScreen<InfusionTableMenu> implements MenuAccess<InfusionTableMenu> {
    private static final ResourceLocation LOCATION = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/infusion_table.png");
    public InfusionTableScreen(InfusionTableMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

        this.titleLabelY -= 2;
    }

    @Override public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        renderTooltip(matrixStack, mouseX, mouseY);
    }


    @Override
    protected void renderBg(GuiGraphics matrixStack, float partialTicks, int mouseX, int mouseY) {
        int edgeSpacingX = (this.width - this.getXSize()) / 2;
        int edgeSpacingY = (this.height - this.getYSize()) / 2;
        matrixStack.blit(LOCATION, edgeSpacingX, edgeSpacingY, 0, 0, this.getXSize(), this.getYSize(), 176, 166);
    }

    @Override
    protected void renderLabels(GuiGraphics matrixStack, int mouseX, int mouseY) {
        matrixStack.drawString(font, this.title, 50, 18, 4210752);
    }

}

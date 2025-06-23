package divinerpg.client.screen;

import divinerpg.client.menu.InfiniFurnaceMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public abstract class InfiniFurnaceScreen<T extends InfiniFurnaceMenu> extends AbstractContainerScreen<T> implements RecipeUpdateListener {
	public final AbstractFurnaceRecipeBookComponent recipeBookComponent = new SmeltingRecipeBookComponent();
	private boolean widthTooNarrow;
	private final ResourceLocation texture, flame;
	private final int titleColor;
	private final int invColor;
	public InfiniFurnaceScreen(T container, Inventory inv, Component c, ResourceLocation location, int titleColor, int invColor) {
		super(container, inv, c);
		texture = location;
		this.flame = DivineFurnaceScreen.FLAME_SPRITE;
		this.titleColor = titleColor;
		this.invColor = invColor;
	}
	public InfiniFurnaceScreen(T container, Inventory inv, Component c, ResourceLocation location, int titleColor, int invColor, ResourceLocation flame) {
		super(container, inv, c);
		texture = location;
		this.flame = flame;
		this.titleColor = titleColor;
		this.invColor = invColor;
	}
	@Override public void init() {
		super.init();
		this.widthTooNarrow = this.width < 379;
		this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
		this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
		this.addRenderableWidget(new ImageButton(this.leftPos + 20, this.height / 2 - 49, 20, 18, RecipeBookComponent.RECIPE_BUTTON_SPRITES, (p_313431_) -> {
			this.recipeBookComponent.toggleVisibility();
			this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
			p_313431_.setPosition(this.leftPos + 20, this.height / 2 - 49);
		}));
		this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
	}
	@Override protected void containerTick() {
		super.containerTick();
		recipeBookComponent.tick();
	}
	@Override public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		if(this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
			this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
			this.recipeBookComponent.render(guiGraphics, mouseX, mouseY, partialTick);
		} else {
			super.render(guiGraphics, mouseX, mouseY, partialTick);
			this.recipeBookComponent.render(guiGraphics, mouseX, mouseY, partialTick);
			this.recipeBookComponent.renderGhostRecipe(guiGraphics, this.leftPos, this.topPos, true, partialTick);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		this.recipeBookComponent.renderTooltip(guiGraphics, this.leftPos, this.topPos, mouseX, mouseY);
	}
	@Override protected void renderLabels(GuiGraphics stack, int p_282681_, int p_283686_) {
		stack.drawString(font, title, titleLabelX, titleLabelY, titleColor, false);
		stack.drawString(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, invColor, false);
	}
	@Override protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		int i = leftPos;
		int j = topPos;
		guiGraphics.blit(texture, i, j, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
		if(menu.isLit()) guiGraphics.blitSprite(flame, 14, 14, 0, 0, i + 56, j + 36, 14, 14);
		guiGraphics.blitSprite(DivineFurnaceScreen.PROGRESS_ARROW_SPRITE, 24, 16, 0, 0, i + 79, j + 34, menu.getBurnProgress(), 16);
	}
	@Override public boolean mouseClicked(double mouseX, double mouseY, int button) {
		return this.recipeBookComponent.mouseClicked(mouseX, mouseY, button) || this.widthTooNarrow && this.recipeBookComponent.isVisible() || super.mouseClicked(mouseX, mouseY, button);
	}
	@Override protected void slotClicked(Slot slot, int slotId, int mouseButton, ClickType type) {
		super.slotClicked(slot, slotId, mouseButton, type);
		this.recipeBookComponent.slotClicked(slot);
	}
	@Override public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		return this.recipeBookComponent.keyPressed(keyCode, scanCode, modifiers) || super.keyPressed(keyCode, scanCode, modifiers);
	}
	@Override protected boolean hasClickedOutside(double mouseX, double mouseY, int guiLeft, int guiTop, int mouseButton) {
		boolean flag = mouseX < (double)guiLeft || mouseY < (double)guiTop || mouseX >= (double)(guiLeft + this.imageWidth) || mouseY >= (double)(guiTop + this.imageHeight);
		return this.recipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, mouseButton) && flag;
	}
	@Override public boolean charTyped(char codePoint, int modifiers) {
		return this.recipeBookComponent.charTyped(codePoint, modifiers) || super.charTyped(codePoint, modifiers);
	}
	@Override public void recipesUpdated() {recipeBookComponent.recipesUpdated();}
	@Override public RecipeBookComponent getRecipeBookComponent() {return recipeBookComponent;}
}
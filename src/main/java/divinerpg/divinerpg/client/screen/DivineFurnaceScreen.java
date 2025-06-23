package divinerpg.client.screen;

import divinerpg.DivineRPG;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public abstract class DivineFurnaceScreen<T extends AbstractFurnaceMenu> extends AbstractFurnaceScreen<T> {
    public static final ResourceLocation FLAME_SPRITE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "furnace_flame");
    public static final ResourceLocation PROGRESS_ARROW_SPRITE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "progress_arrow");
    private final int titleColor;
    private final int invColor;
    public DivineFurnaceScreen(T container, Inventory inv, Component c, ResourceLocation location, int titleColor, int invColor, ResourceLocation flame_sprite) {
        super(container, new SmeltingRecipeBookComponent(), inv, c, location, flame_sprite, PROGRESS_ARROW_SPRITE);
        this.titleColor = titleColor;
        this.invColor = invColor;
    }
    public DivineFurnaceScreen(T container, Inventory inv, Component c, ResourceLocation location, int titleColor, int invColor) {
        super(container, new SmeltingRecipeBookComponent(), inv, c, location, FLAME_SPRITE, PROGRESS_ARROW_SPRITE);
        this.titleColor = titleColor;
        this.invColor = invColor;
    }
    @Override protected void renderLabels(GuiGraphics stack, int p_282681_, int p_283686_) {
        stack.drawString(font, title, titleLabelX, titleLabelY, titleColor, false);
        stack.drawString(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, invColor, false);
    }
}
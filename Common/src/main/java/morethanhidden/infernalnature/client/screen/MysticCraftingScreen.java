package morethanhidden.infernalnature.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.inventory.MysticCraftingMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;

public class MysticCraftingScreen extends AbstractContainerScreen<MysticCraftingMenu> implements RecipeUpdateListener {
    private static final ResourceLocation CRAFTING_TABLE_LOCATION = new ResourceLocation(Constants.MOD_ID, "textures/gui/mystic_crafting_table.png");
    private boolean widthTooNarrow;

    public MysticCraftingScreen(MysticCraftingMenu craftingMenu, Inventory inventory, Component component) {
        super(craftingMenu, inventory, component);
    }

    protected void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.titleLabelX = 129;
    }

    public void containerTick() {
        super.containerTick();
    }

    public void render(PoseStack poseStack, int i, int j, float f) {
        this.renderBackground(poseStack);
        if (this.widthTooNarrow) {
            this.renderBg(poseStack, f, i, j);
        } else {
            super.render(poseStack, i, j, f);
        }

        this.renderTooltip(poseStack, i, j);
    }

    protected void renderBg(PoseStack poseStack, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CRAFTING_TABLE_LOCATION);
        int k = this.leftPos;
        int l = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, k, l, 0, 0, this.imageWidth, this.imageHeight);
    }

    protected boolean isHovering(int i, int j, int k, int l, double d, double e) {
        return (!this.widthTooNarrow) && super.isHovering(i, j, k, l, d, e);
    }

    public boolean mouseClicked(double d, double e, int i) {
       return this.widthTooNarrow || super.mouseClicked(d, e, i);
    }

    protected void slotClicked(Slot slot, int i, int j, ClickType clickType) {
        super.slotClicked(slot, i, j, clickType);
    }

    @Override
    public void recipesUpdated() {

    }

    @Override
    public RecipeBookComponent getRecipeBookComponent() {
        return null;
    }
}

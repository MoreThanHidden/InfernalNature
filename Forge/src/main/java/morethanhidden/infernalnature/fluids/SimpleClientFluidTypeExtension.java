package morethanhidden.infernalnature.fluids;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

/**
 * Simple implementation of IClientFluidTypeExtensions
 */
public class SimpleClientFluidTypeExtension implements IClientFluidTypeExtensions {

    final ResourceLocation stillTexture;
    final ResourceLocation flowingTexture;
    final int tintColor;

    /**
     * Create a new SimpleClientFluidTypeExtension
     * @param stillTexture The still texture
     * @param flowingTexture The flowing texture
     * @param tintColor The tint color
     */
    public SimpleClientFluidTypeExtension(ResourceLocation stillTexture, ResourceLocation flowingTexture, int tintColor) {
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
        this.tintColor = tintColor;
    }

    @Override
    public int getTintColor() {
        return tintColor;
    }

    @Override
    public ResourceLocation getFlowingTexture() {
        return flowingTexture;
    }

    @Override
    public ResourceLocation getStillTexture() {
        return stillTexture;
    }
}

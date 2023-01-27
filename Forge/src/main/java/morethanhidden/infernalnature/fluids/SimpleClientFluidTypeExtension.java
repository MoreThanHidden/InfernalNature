package morethanhidden.infernalnature.fluids;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

public class SimpleClientFluidTypeExtension implements IClientFluidTypeExtensions {

    final ResourceLocation stillTexture;
    final ResourceLocation flowingTexture;
    final int tintColor;

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

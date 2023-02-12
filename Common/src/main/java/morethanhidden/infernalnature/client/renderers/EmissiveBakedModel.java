package morethanhidden.infernalnature.client.renderers;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmissiveBakedModel implements BakedModel {
    private final BakedModel baseModel;

    public EmissiveBakedModel(BakedModel baseModel) {
        this.baseModel = baseModel;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, RandomSource rand) {
        List<BakedQuad> quads = new ArrayList<>();
        // make tinted layer emmisive
        for (BakedQuad quad : baseModel.getQuads(state, side, rand)) {
            // check if quad is tinted
            if (quad.getTintIndex() != -1) {
                int[] vertices = quad.getVertices();
                // set lightmap to full brightness
                vertices[6] = 0xFFFFFF;
                // add quad to list
                quads.add(new BakedQuad(vertices, quad.getTintIndex(), quad.getDirection(), quad.getSprite(), false));
            }else {
                // add quad to list
                quads.add(quad);
            }
        }

        return quads;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return baseModel.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return baseModel.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return baseModel.usesBlockLight();
    }

    @Override
    public boolean isCustomRenderer() {
        return baseModel.isCustomRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return baseModel.getParticleIcon();
    }

    @Override
    public ItemTransforms getTransforms() {
        return baseModel.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return baseModel.getOverrides();
    }
}

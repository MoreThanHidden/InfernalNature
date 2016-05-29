package morethanhidden.powerofmagic.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;
import java.util.List;

/**
 * Takes a blockmodel and applies the standard-block-perspective for third_person to it
 */
public class BlockItemModelWrapper implements IPerspectiveAwareModel, IBakedModel {

    // copied from the forge variants V1 default-block transform
    public static final Matrix4f THIRD_PERSON_BLOCK_TRANSFORM = new TRSRTransformation(
            new Vector3f(0, 1.5f / 16, -2.75f / 16), // translation
            TRSRTransformation.quatFromXYZDegrees(new Vector3f(10, -45, 170)), // rotation
            new Vector3f(0.375f, 0.375f, 0.375f), // scale
            null).getMatrix();

    private final IBakedModel parent;

    public BlockItemModelWrapper(IBakedModel parent) {
        this.parent = parent;
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
        Matrix4f matrix = null;
        // fix transformation in hand
        if (cameraTransformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
            matrix = THIRD_PERSON_BLOCK_TRANSFORM;
        }

        return Pair.of(this, matrix);
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
        return parent.getQuads(state, side, rand);
    }

    @Override
    public boolean isAmbientOcclusion() {
        return parent.isAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return parent.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return parent.isBuiltInRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return parent.getParticleTexture();
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return parent.getItemCameraTransforms();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return parent.getOverrides();
    }
}
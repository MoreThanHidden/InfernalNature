package morethanhidden.infernalnature.client;

import morethanhidden.infernalnature.client.renderers.EmissiveBakedModel;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

/**
 * Forge Client Event Handler
 * @author morethanhidden
 */
@Mod.EventBusSubscriber(Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class InfernalNatureClient {

    /**
     * Register the emissive models
     * @param event Model Bake Event
     */
    @SubscribeEvent
    public void onModelBakeEvent(ModelEvent.ModifyBakingResult event) {
        // Use Baked Model for Emissive Ore
        BakedModel oreModel = event.getModels().get(new ModelResourceLocation("infernalnature","gem_ore",""));
        BakedModel oreEmissiveModel = new EmissiveBakedModel(oreModel){
            @Override
            public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data) {
                return oreModel.getRenderTypes(state, rand, data);
            }
        };
        // Replace the model for the ore
        event.getModels().put(new ModelResourceLocation("infernalnature","gem_ore",""), oreEmissiveModel);
        event.getModels().put(new ModelResourceLocation("infernalnature","gem_ore","inventory"), oreEmissiveModel);

        // Use Baked Model for Emissive Deepslate Ore
        BakedModel deepslateModel = event.getModels().get(new ModelResourceLocation("infernalnature","gem_deepslate",""));
        BakedModel deepslateEmissiveModel = new EmissiveBakedModel(deepslateModel){
            @Override
            public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data) {
                return deepslateModel.getRenderTypes(state, rand, data);
            }
        };
        // Replace the model for the deepslate ore
        event.getModels().put(new ModelResourceLocation("infernalnature","gem_deepslate",""), deepslateEmissiveModel);
    }

}

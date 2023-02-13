package morethanhidden.infernalnature.client;

import morethanhidden.infernalnature.client.colours.WandColour;
import morethanhidden.infernalnature.client.renderers.EmissiveBakedModel;
import morethanhidden.infernalnature.items.Wand;
import morethanhidden.infernalnature.registry.InfernalNatureItems;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
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
        String[] types = {"gem_ore", "gem_deepslate"};
        for (String type : types) {
            // Use Baked Model for Emissive Ore
            BakedModel baseModel = event.getModels().get(new ModelResourceLocation("infernalnature", type, ""));
            BakedModel emissiveModel = new EmissiveBakedModel(baseModel) {
                @Override
                public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data) {
                    return baseModel.getRenderTypes(state, rand, data);
                }
            };
            // Replace the model for the ore
            event.getModels().put(new ModelResourceLocation("infernalnature", type, ""), emissiveModel);
            event.getModels().put(new ModelResourceLocation("infernalnature", type, "inventory"), emissiveModel);
        }
    }

    /**
     * Register Item Color Handlers
     * @param event Item Color Handler Event
     */
    @SubscribeEvent
    public void onItemColorHandlerEvent(RegisterColorHandlersEvent.Item event) {
        // Register the Wand Color Handler
        event.register(new WandColour(), InfernalNatureItems.crude_wand);
    }

}

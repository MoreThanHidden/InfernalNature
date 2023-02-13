package morethanhidden.infernalnature.client;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.client.colours.WandColour;
import morethanhidden.infernalnature.client.renderers.EmissiveBakedModel;
import morethanhidden.infernalnature.registry.InfernalNatureBlocks;
import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import morethanhidden.infernalnature.registry.InfernalNatureItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.mixin.registry.sync.client.ItemColorsMixin;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

/**
 * Client side initialization for Infernal Nature (Fabric)
 * @author morethanhidden
 */
public class InfernalNatureClient implements ClientModInitializer {

    /**
     * Register the fluid render handlers and the emissive models
     */
    @Override
    public void onInitializeClient() {
        // Register the fluid render handlers
        FluidRenderHandlerRegistry.INSTANCE.register(InfernalNatureFluids.LIQUID_FIRE, InfernalNatureFluids.LIQUID_FIRE, new SimpleFluidRenderHandler(
                new ResourceLocation("minecraft:block/water_still"),
                new ResourceLocation("minecraft:block/water_flow"),
                Constants.LIQUID_FIRE_COLOR
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(InfernalNatureFluids.LIQUID_GRASS, InfernalNatureFluids.LIQUID_GRASS, new SimpleFluidRenderHandler(
                new ResourceLocation("minecraft:block/water_still"),
                new ResourceLocation("minecraft:block/water_flow"),
                Constants.LIQUID_GRASS_COLOR
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(InfernalNatureFluids.LIQUID_WATERSOURCE, InfernalNatureFluids.LIQUID_WATERSOURCE, new SimpleFluidRenderHandler(
                new ResourceLocation("minecraft:block/water_still"),
                new ResourceLocation("minecraft:block/water_flow"),
                Constants.LIQUID_WATERSOURCE_COLOR
        ));

        // Register the gem ores as translucent
        BlockRenderLayerMap.INSTANCE.putBlock(InfernalNatureBlocks.gemOre, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(InfernalNatureBlocks.gemDeepslate, RenderType.translucent());

        // Register the emissive model loader
        ModelLoadingRegistry.INSTANCE.registerVariantProvider(res -> (location, context) -> {
            String[] types = new String[]{"gem_ore", "gem_deepslate"};
            for (String type : types) {
                if (location.equals(new ModelResourceLocation("infernalnature", type, ""))) {
                    return new UnbakedModel() {
                        @Override
                        public @NotNull Collection<ResourceLocation> getDependencies() {return Collections.emptyList();}

                        @Override
                        public void resolveParents(@NotNull Function<ResourceLocation, UnbakedModel> function) {}

                        @Override
                        public BakedModel bake(@NotNull ModelBaker modelBaker, @NotNull Function<Material, TextureAtlasSprite> function, @NotNull ModelState modelState, @NotNull ResourceLocation resourceLocation) {
                            return new EmissiveBakedModel(modelBaker.bake(new ModelResourceLocation("infernalnature", type, "inventory"), modelState));
                        }
                    };
                }
            }
            return null;
        });

        // Register Item Colour Handlers
        ColorProviderRegistry.ITEM.register(new WandColour(), InfernalNatureItems.crude_wand);

    }

}

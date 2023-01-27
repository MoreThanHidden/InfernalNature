package morethanhidden.infernalnature;

import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.resources.ResourceLocation;

public class InfernalNatureClient implements ClientModInitializer {

    /**
     * Register the fluid render handlers
     */
    @Override
    public void onInitializeClient() {
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
    }

}

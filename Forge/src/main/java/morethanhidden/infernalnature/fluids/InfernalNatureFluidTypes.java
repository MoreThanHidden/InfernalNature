package morethanhidden.infernalnature.fluids;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.Consumer;

public class InfernalNatureFluidTypes {

    @SubscribeEvent
    public static void registerFluidTypes(RegisterEvent event) {
        //Register Fluid Types
        if(ForgeRegistries.FLUID_TYPES.get().getRegistryKey().equals(event.getRegistryKey())){

            //Register the fire fluid type
            event.register(ForgeRegistries.FLUID_TYPES.get().getRegistryKey(), new ResourceLocation(Constants.MOD_ID, "liquid_fire"), () -> new FluidType(FluidType.Properties.create()){
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new SimpleClientFluidTypeExtension(
                            new ResourceLocation("minecraft:block/water_still"),
                            new ResourceLocation("minecraft:block/water_flow"),
                            Constants.LIQUID_FIRE_COLOR
                    ));
                }
            });

            //Register the grass fluid type
            event.register(ForgeRegistries.FLUID_TYPES.get().getRegistryKey(), new ResourceLocation(Constants.MOD_ID, "liquid_grass"), () -> new FluidType(FluidType.Properties.create()){
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new SimpleClientFluidTypeExtension(
                            new ResourceLocation("minecraft:block/water_still"),
                            new ResourceLocation("minecraft:block/water_flow"),
                            Constants.LIQUID_GRASS_COLOR
                    ));
                }
            });

            //Register the watersource fluid type
            event.register(ForgeRegistries.FLUID_TYPES.get().getRegistryKey(), new ResourceLocation(Constants.MOD_ID, "liquid_watersource"), () -> new FluidType(FluidType.Properties.create()){
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new SimpleClientFluidTypeExtension(
                            new ResourceLocation("minecraft:block/water_still"),
                            new ResourceLocation("minecraft:block/water_flow"),
                            Constants.LIQUID_WATERSOURCE_COLOR
                    ));
                }
            });

        //Create the fluids
        }else if (ForgeRegistries.FLUIDS.getRegistryKey().equals(event.getRegistryKey())) {

            //Create the fire fluid
            InfernalNatureFluids.LIQUID_FIRE = new LiquidBlockFluid(Blocks.FIRE,
                    () -> InfernalNatureFluids.LIQUID_FIRE_BUCKET,
                    () -> InfernalNatureFluids.LIQUID_FIRE_BLOCK) {
                @Override
                public FluidType getFluidType() {
                    return ForgeRegistries.FLUID_TYPES.get().getValue(new ResourceLocation(Constants.MOD_ID, "liquid_fire"));
                }
            };

            //Create the grass fluid
            InfernalNatureFluids.LIQUID_GRASS = new LiquidBlockFluid(Blocks.GRASS_BLOCK,
                    () -> InfernalNatureFluids.LIQUID_GRASS_BUCKET,
                    () -> InfernalNatureFluids.LIQUID_GRASS_BLOCK) {
                @Override
                public FluidType getFluidType() {
                    return ForgeRegistries.FLUID_TYPES.get().getValue(new ResourceLocation(Constants.MOD_ID, "liquid_grass"));
                }
            };

            //Create the watersource fluid
            InfernalNatureFluids.LIQUID_WATERSOURCE = new LiquidBlockFluid(Blocks.WATER,
                    () -> InfernalNatureFluids.LIQUID_WATERSOURCE_BUCKET,
                    () -> InfernalNatureFluids.LIQUID_WATERSOURCE_BLOCK) {
                @Override
                public FluidType getFluidType() {
                    return ForgeRegistries.FLUID_TYPES.get().getValue(new ResourceLocation(Constants.MOD_ID, "liquid_watersource"));
                }
            };
        }
    }


}

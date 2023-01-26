package morethanhidden.infernalnature;

import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class InfernalNature implements ModInitializer {

    @Override
    public void onInitialize() {
        InfernalNatureFluids.registerFluid(((fluid, resourceLocation) -> Registry.register(BuiltInRegistries.FLUID, resourceLocation, fluid)));
        InfernalNatureFluids.registerBlock(((block, resourceLocation) -> Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block)));
        InfernalNatureFluids.registerItem(((item, resourceLocation) -> Registry.register(BuiltInRegistries.ITEM, resourceLocation, item)));
    }
}
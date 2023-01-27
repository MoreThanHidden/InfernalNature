package morethanhidden.infernalnature;

import morethanhidden.infernalnature.fluids.LiquidBlockFluid;
import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class InfernalNature implements ModInitializer {

    //Creative tab
    public static CreativeModeTab tabinfernalnature = FabricItemGroup.builder(new ResourceLocation(Constants.MOD_ID, "infernalnature")).title(Component.translatable("itemGroup.infernalnature")).icon(() -> new ItemStack(InfernalNatureFluids.LIQUID_FIRE_BUCKET)).build();

    @Override
    public void onInitialize() {

        InfernalNatureFluids.LIQUID_FIRE = new LiquidBlockFluid(Blocks.FIRE,
                () -> InfernalNatureFluids.LIQUID_FIRE_BUCKET,
                () -> InfernalNatureFluids.LIQUID_FIRE_BLOCK
        );

        InfernalNatureFluids.LIQUID_GRASS = new LiquidBlockFluid(Blocks.GRASS_BLOCK,
                () -> InfernalNatureFluids.LIQUID_GRASS_BUCKET,
                () -> InfernalNatureFluids.LIQUID_GRASS_BLOCK
        );

        InfernalNatureFluids.LIQUID_WATERSOURCE = new LiquidBlockFluid(Blocks.WATER,
                () -> InfernalNatureFluids.LIQUID_WATERSOURCE_BUCKET,
                () -> InfernalNatureFluids.LIQUID_WATERSOURCE_BLOCK
        );

        InfernalNatureFluids.registerFluid(((fluid, resourceLocation) -> Registry.register(BuiltInRegistries.FLUID, resourceLocation, fluid)));
        InfernalNatureFluids.registerBlock(((block, resourceLocation) -> Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block)));
        InfernalNatureFluids.registerItem(((item, resourceLocation) -> Registry.register(BuiltInRegistries.ITEM, resourceLocation, item)));

        ItemGroupEvents.modifyEntriesEvent(tabinfernalnature).register(content -> {
            content.accept(InfernalNatureFluids.LIQUID_FIRE_BUCKET);
            content.accept(InfernalNatureFluids.LIQUID_GRASS_BUCKET);
            content.accept(InfernalNatureFluids.LIQUID_WATERSOURCE_BUCKET);
        });

    }
}
package morethanhidden.infernalnature;

import morethanhidden.infernalnature.fluids.LiquidBlockFluid;
import morethanhidden.infernalnature.registry.InfernalNatureBlocks;
import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import morethanhidden.infernalnature.registry.InfernalNatureItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;

/**
 * Main fabric mod class
 * @author morethanhidden
 */
public class InfernalNature implements ModInitializer {

    /**
     * Creative Tab Builder
     */
    public static CreativeModeTab tabinfernalnature = FabricItemGroup.builder(new ResourceLocation(Constants.MOD_ID, "infernalnature")).title(Component.translatable("itemGroup.infernalnature")).icon(() -> new ItemStack(InfernalNatureFluids.LIQUID_FIRE_BUCKET)).build();

    /**
     * Main mod initializer
     */
    @Override
    public void onInitialize() {
        //Register the fluids
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

        //Register the fluid Blocks and Items
        InfernalNatureFluids.registerFluid(((fluid, resourceLocation) -> Registry.register(BuiltInRegistries.FLUID, resourceLocation, fluid)));
        InfernalNatureFluids.registerBlock(((block, resourceLocation) -> Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block)));
        InfernalNatureFluids.registerItem(((item, resourceLocation) -> Registry.register(BuiltInRegistries.ITEM, resourceLocation, item)));
        InfernalNatureBlocks.registerBlocks(((block, resourceLocation) -> Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block)));
        InfernalNatureBlocks.registerBlockItems(((item, resourceLocation) -> Registry.register(BuiltInRegistries.ITEM, resourceLocation, item)));
        InfernalNatureItems.registerItems(((item, resourceLocation) -> Registry.register(BuiltInRegistries.ITEM, resourceLocation, item)));

        //Register the creative tab items
        ItemGroupEvents.modifyEntriesEvent(tabinfernalnature).register(content -> {
            content.accept(InfernalNatureFluids.LIQUID_FIRE_BUCKET);
            content.accept(InfernalNatureFluids.LIQUID_GRASS_BUCKET);
            content.accept(InfernalNatureFluids.LIQUID_WATERSOURCE_BUCKET);
            content.accept(InfernalNatureBlocks.blockGemInfernal);
            content.accept(InfernalNatureBlocks.blockGemNature);
            content.accept(InfernalNatureBlocks.blockGemMystic);
            content.accept(InfernalNatureBlocks.gemOre);
            content.accept(InfernalNatureBlocks.gemDeepslate);
            content.accept(InfernalNatureBlocks.blockMysticCrafting);
            content.accept(InfernalNatureItems.infernalGem);
            content.accept(InfernalNatureItems.natureGem);
            content.accept(InfernalNatureItems.mysticGem);
            content.accept(InfernalNatureItems.infernalFragment);
            content.accept(InfernalNatureItems.natureFragment);
            content.accept(InfernalNatureItems.mysticFragment);
            content.accept(InfernalNatureItems.crude_wand);
        });

        //Add the gem ore to the world
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE,new ResourceLocation("infernalnature","gem_ore")));

    }
}
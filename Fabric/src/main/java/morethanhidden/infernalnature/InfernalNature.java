package morethanhidden.infernalnature;

import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;

public class InfernalNature implements ModInitializer {

    @Override
    public void onInitialize() {

        InfernalNatureFluids.register();

        //Liquid Fire Block and Bucket
        InfernalNatureFluids.LIQUID_FIRE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, "liquid_fire"),
                new LiquidBlock(InfernalNatureFluids.LIQUID_FIRE, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        InfernalNatureFluids.LIQUID_FIRE_BUCKET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "liquid_fire_bucket"),
                new BucketItem(InfernalNatureFluids.LIQUID_FIRE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)){ });

        //Liquid Grass Block and Bucket
        InfernalNatureFluids.LIQUID_GRASS_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, "liquid_grass"),
                new LiquidBlock(InfernalNatureFluids.LIQUID_GRASS, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        InfernalNatureFluids.LIQUID_GRASS_BUCKET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "liquid_grass_bucket"),
                new BucketItem(InfernalNatureFluids.LIQUID_GRASS, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)){ });

        //Liquid Water Source Block and Bucket
        InfernalNatureFluids.LIQUID_WATERSOURCE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, "liquid_watersource"),
                new LiquidBlock(InfernalNatureFluids.LIQUID_WATERSOURCE, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        InfernalNatureFluids.LIQUID_WATERSOURCE_BUCKET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "liquid_watersource_bucket"),
                new BucketItem(InfernalNatureFluids.LIQUID_WATERSOURCE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)){ });
    }
}
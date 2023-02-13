package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import java.util.function.BiConsumer;

/**
 * Fluid Registry for Infernal Nature
 * @author morethanhidden
 */
public class InfernalNatureFluids {

    //Liquid Fire Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
    public static FlowingFluid LIQUID_FIRE;
    public static Block LIQUID_FIRE_BLOCK;
    public static Item LIQUID_FIRE_BUCKET;

    //Liquid Grass Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
    public static FlowingFluid LIQUID_GRASS;
    public static Block LIQUID_GRASS_BLOCK;
    public static Item LIQUID_GRASS_BUCKET;

    // Liquid Water Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
    public static FlowingFluid LIQUID_WATERSOURCE;
    public static Block LIQUID_WATERSOURCE_BLOCK;
    public static Item LIQUID_WATERSOURCE_BUCKET;

    /**
     * Register Fluids
     * @param register - BiConsumer to register the fluids
     */
    public static void registerFluid(BiConsumer<Fluid, ResourceLocation> register) {
        register.accept(LIQUID_FIRE, new ResourceLocation(Constants.MOD_ID, "liquid_fire"));
        register.accept(LIQUID_GRASS, new ResourceLocation(Constants.MOD_ID, "liquid_grass"));
        register.accept(LIQUID_WATERSOURCE, new ResourceLocation(Constants.MOD_ID, "liquid_watersource"));
    }

    /**
     * Register Blocks
     * @param register - BiConsumer to register the blocks
     */
    public static void registerBlock(BiConsumer<Block, ResourceLocation> register) {
        register.accept(LIQUID_FIRE_BLOCK = new LiquidBlock(LIQUID_FIRE, BlockBehaviour.Properties.copy(Blocks.WATER)){}, new ResourceLocation(Constants.MOD_ID, "liquid_fire"));
        register.accept(LIQUID_GRASS_BLOCK = new LiquidBlock(LIQUID_GRASS, BlockBehaviour.Properties.copy(Blocks.WATER)){}, new ResourceLocation(Constants.MOD_ID, "liquid_grass"));
        register.accept(LIQUID_WATERSOURCE_BLOCK = new LiquidBlock(LIQUID_WATERSOURCE, BlockBehaviour.Properties.copy(Blocks.WATER)){}, new ResourceLocation(Constants.MOD_ID, "liquid_watersource"));
    }

    /**
     * Register Items
     * @param register - BiConsumer to register the items
     */
    public static void registerItem(BiConsumer<Item, ResourceLocation> register) {
        LIQUID_FIRE_BUCKET = new BucketItem(LIQUID_FIRE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1));
        register.accept(LIQUID_FIRE_BUCKET, new ResourceLocation(Constants.MOD_ID, "liquid_fire_bucket"));
        LIQUID_GRASS_BUCKET = new BucketItem(LIQUID_GRASS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1));
        register.accept(LIQUID_GRASS_BUCKET, new ResourceLocation(Constants.MOD_ID, "liquid_grass_bucket"));
        LIQUID_WATERSOURCE_BUCKET = new BucketItem(LIQUID_WATERSOURCE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1));
        register.accept(LIQUID_WATERSOURCE_BUCKET, new ResourceLocation(Constants.MOD_ID, "liquid_watersource_bucket"));
    }

}

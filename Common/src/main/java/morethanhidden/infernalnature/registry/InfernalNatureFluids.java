package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.fluids.LiquidBlockFluid;
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

public class InfernalNatureFluids {

    //Liquid Fire Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
    public static FlowingFluid LIQUID_FIRE = new LiquidBlockFluid(Blocks.FIRE) {
        @Override
        public Block getBlock() {
            return LIQUID_FIRE_BLOCK;
        }

        @Override
        public Item getBucket() {
            return LIQUID_FIRE_BUCKET;
        }
    };

    public static Block LIQUID_FIRE_BLOCK;
    public static Item LIQUID_FIRE_BUCKET;

    //Liquid Grass Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
    public static FlowingFluid LIQUID_GRASS = new LiquidBlockFluid(Blocks.GRASS_BLOCK) {
        @Override
        public Block getBlock() {
            return LIQUID_GRASS_BLOCK;
        }

        @Override
        public Item getBucket() {
            return LIQUID_GRASS_BUCKET;
        }
    };

    public static Block LIQUID_GRASS_BLOCK;
    public static Item LIQUID_GRASS_BUCKET;

    // Liquid Water Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
    public static FlowingFluid LIQUID_WATERSOURCE = new LiquidBlockFluid(Blocks.WATER) {
        @Override
        public Block getBlock() {
            return LIQUID_WATERSOURCE_BLOCK;
        }

        @Override
        public Item getBucket() {
            return LIQUID_WATERSOURCE_BUCKET;
        }
    };

    public static Block LIQUID_WATERSOURCE_BLOCK;
    public static Item LIQUID_WATERSOURCE_BUCKET;

    /**
     * Register Fluids
     */
    public static void registerFluid(BiConsumer<Fluid, ResourceLocation> register) {
        register.accept(LIQUID_FIRE, new ResourceLocation(Constants.MOD_ID, "liquid_fire"));
        register.accept(LIQUID_GRASS, new ResourceLocation(Constants.MOD_ID, "liquid_grass"));
        register.accept(LIQUID_WATERSOURCE, new ResourceLocation(Constants.MOD_ID, "liquid_watersource"));
    }

    /**
     * Register Blocks
     */
    public static void registerBlock(BiConsumer<Block, ResourceLocation> register) {
        register.accept(LIQUID_FIRE_BLOCK = new LiquidBlock(LIQUID_FIRE, BlockBehaviour.Properties.copy(Blocks.WATER)){}, new ResourceLocation(Constants.MOD_ID, "liquid_fire"));
        register.accept(LIQUID_GRASS_BLOCK = new LiquidBlock(LIQUID_GRASS, BlockBehaviour.Properties.copy(Blocks.WATER)){}, new ResourceLocation(Constants.MOD_ID, "liquid_grass"));
        register.accept(LIQUID_WATERSOURCE_BLOCK = new LiquidBlock(LIQUID_WATERSOURCE, BlockBehaviour.Properties.copy(Blocks.WATER)){}, new ResourceLocation(Constants.MOD_ID, "liquid_watersource"));
    }

    /**
     * Register Items
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

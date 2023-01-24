package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.fluids.LiquidBlockFluid;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FlowingFluid;

public class InfernalNatureFluids {

    public static FlowingFluid LIQUID_FIRE;
    public static Item LIQUID_FIRE_BUCKET;
    public static Block LIQUID_FIRE_BLOCK;

    public static FlowingFluid LIQUID_GRASS;
    public static Item LIQUID_GRASS_BUCKET;
    public static Block LIQUID_GRASS_BLOCK;

    public static FlowingFluid LIQUID_WATERSOURCE;
    public static Item LIQUID_WATERSOURCE_BUCKET;
    public static Block LIQUID_WATERSOURCE_BLOCK;

    /**
     * Register Fluids
     */
    public static void register() {
        //Liquid Fire Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
        LIQUID_FIRE = Registry.register(BuiltInRegistries.FLUID, new ResourceLocation(Constants.MOD_ID, "liquid_fire"), new LiquidBlockFluid(Blocks.FIRE) {
            @Override
            public Block getBlock() {
                return LIQUID_FIRE_BLOCK;
            }

            @Override
            public Item getBucket() {
                return LIQUID_FIRE_BUCKET;
            }
        });

        //Liquid Grass Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
        LIQUID_GRASS = Registry.register(BuiltInRegistries.FLUID, new ResourceLocation(Constants.MOD_ID, "liquid_grass"), new LiquidBlockFluid(Blocks.GRASS_BLOCK) {
            @Override
            public Block getBlock() {
                return LIQUID_GRASS_BLOCK;
            }

            @Override
            public Item getBucket() {
                return LIQUID_GRASS_BUCKET;
            }
        });

        //Liquid Water Source Fluid using the LiquidBlockFluid class and overriding the getBlock and getBucket methods
        LIQUID_WATERSOURCE = Registry.register(BuiltInRegistries.FLUID, new ResourceLocation(Constants.MOD_ID, "liquid_watersource"), new LiquidBlockFluid(Blocks.WATER) {
            @Override
            public Block getBlock() {
                return LIQUID_WATERSOURCE_BLOCK;
            }

            @Override
            public Item getBucket() {
                return LIQUID_WATERSOURCE_BUCKET;
            }
        });

    }

}

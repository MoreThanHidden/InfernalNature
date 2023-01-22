package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

public class PMFluidRegistry {

    public static Fluid liquidMana = new Fluid("mana", new ResourceLocation(Constants.MOD_ID, "blocks/liquidmana_still"), new ResourceLocation(Constants.MOD_ID, "blocks/liquidmana_flow"));
    public static Fluid liquidGrass = new Fluid("grass", new ResourceLocation(Constants.MOD_ID, "blocks/liquidgrass_still"), new ResourceLocation(Constants.MOD_ID, "blocks/liquidgrass_flow"));
    public static Fluid liquidFire = new Fluid("fire", new ResourceLocation(Constants.MOD_ID, "blocks/liquidfire_still"), new ResourceLocation(Constants.MOD_ID, "blocks/liquidfire_flow"));
    public static Fluid liquidWaterSource = new Fluid("watersource", new ResourceLocation(Constants.MOD_ID, "blocks/watersource_still"),new ResourceLocation(Constants.MOD_ID, "blocks/watersource_flow"));

    public static ItemStack bucketMana;
    public static ItemStack bucketFire;
    public static ItemStack bucketGrass;
    public static ItemStack bucketWaterSource;

    public static void init() {

        liquidMana = registerFluid(liquidMana);
        liquidWaterSource = registerFluid(liquidWaterSource);
        liquidGrass = registerFluid(liquidGrass);
        liquidFire = registerFluid(liquidFire);

        FluidRegistry.addBucketForFluid(liquidMana);
        FluidRegistry.addBucketForFluid(liquidWaterSource);
        FluidRegistry.addBucketForFluid(liquidGrass);
        FluidRegistry.addBucketForFluid(liquidFire);

        bucketMana = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, liquidMana);
        bucketFire = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, liquidFire);
        bucketGrass = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, liquidGrass);
        bucketWaterSource = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, liquidWaterSource);

        bucketMana.getItem().setCreativeTab(infernalnature.tabinfernalnature);
        bucketFire.getItem().setCreativeTab(infernalnature.tabinfernalnature);
        bucketGrass.getItem().setCreativeTab(infernalnature.tabinfernalnature);
        bucketWaterSource.getItem().setCreativeTab(infernalnature.tabinfernalnature);
    }

    public static Fluid registerFluid(Fluid fluid) {

        if (!FluidRegistry.isFluidRegistered(fluid.getName())) {
            FluidRegistry.registerFluid(fluid);
        }
        return FluidRegistry.getFluid(fluid.getName());
    }

}

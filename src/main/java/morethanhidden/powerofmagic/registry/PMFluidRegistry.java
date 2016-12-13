package morethanhidden.powerofmagic.registry;

import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;

public class PMFluidRegistry {

    public static Fluid liquidMana = new Fluid("mana", new ResourceLocation(powerofmagic.MODID, "blocks/liquidmana_still"), new ResourceLocation(powerofmagic.MODID, "blocks/liquidmana_flow"));
    public static Fluid liquidGrass = new Fluid("grass", new ResourceLocation(powerofmagic.MODID, "blocks/liquidgrass_still"), new ResourceLocation(powerofmagic.MODID, "blocks/liquidgrass_flow"));
    public static Fluid liquidFire = new Fluid("fire", new ResourceLocation(powerofmagic.MODID, "blocks/liquidfire_still"), new ResourceLocation(powerofmagic.MODID, "blocks/liquidfire_flow"));
    public static Fluid liquidWaterSource = new Fluid("watersource", new ResourceLocation(powerofmagic.MODID, "blocks/watersource_still"),new ResourceLocation(powerofmagic.MODID, "blocks/watersource_flow"));

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

        bucketMana.getItem().setCreativeTab(powerofmagic.tabpowerofmagic);
        bucketFire.getItem().setCreativeTab(powerofmagic.tabpowerofmagic);
        bucketGrass.getItem().setCreativeTab(powerofmagic.tabpowerofmagic);
        bucketWaterSource.getItem().setCreativeTab(powerofmagic.tabpowerofmagic);
    }

    public static Fluid registerFluid(Fluid fluid) {

        if (!FluidRegistry.isFluidRegistered(fluid.getName())) {
            FluidRegistry.registerFluid(fluid);
        }
        return FluidRegistry.getFluid(fluid.getName());
    }

}

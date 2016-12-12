package morethanhidden.powerofmagic.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class MGFluids {

    public static Fluid liquidMana = new Fluid("liquidelectricooze", new ResourceLocation("powerofmagic:fluidElectricStill"), new ResourceLocation("powerofmagic:fluidElectricFlowing"));
    public static Fluid liquidGrass = new Fluid("liquidgrass", new ResourceLocation("powerofmagic:fluidGrassStill"), new ResourceLocation(""));
    public static Fluid liquidFire = new Fluid("liquidfire", new ResourceLocation("powerofmagic:fluidFireStill"), new ResourceLocation("powerofmagic:fluidFireFlowing"));
    public static Fluid liquidWaterSource = new Fluid("liquidwatersource", new ResourceLocation("powerofmagic:fluidLiquidSourceStill"),new ResourceLocation("powerofmagic:fluidLiquidSourceFlowing"));

    public static void init() {

        FluidRegistry.registerFluid(liquidMana);
        FluidRegistry.registerFluid(liquidWaterSource);
        FluidRegistry.registerFluid(liquidGrass);
        FluidRegistry.registerFluid(liquidFire);

        FluidRegistry.addBucketForFluid(liquidMana);
        FluidRegistry.addBucketForFluid(liquidWaterSource);
        FluidRegistry.addBucketForFluid(liquidGrass);
        FluidRegistry.addBucketForFluid(liquidFire);
    }

}

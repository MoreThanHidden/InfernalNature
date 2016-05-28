package morethanhidden.powerofmagic.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class MGFluids {

    public static Fluid liquidElectricOoze = new Fluid("liquidelectricooze", new ResourceLocation("powerofmagic:fluidElectricStill"), new ResourceLocation("powerofmagic:fluidElectricFlowing"));
    public static Fluid liquidGrass = new Fluid("liquidgrass", new ResourceLocation("powerofmagic:fluidGrassStill"), new ResourceLocation(""));
    public static Fluid liquidFire = new Fluid("liquidfire", new ResourceLocation("powerofmagic:fluidFireStill"), new ResourceLocation("powerofmagic:fluidFireFlowing"));
    public static Fluid liquidWaterSource = new Fluid("liquidwatersource", new ResourceLocation("powerofmagic:fluidLiquidSourceStill"),new ResourceLocation("powerofmagic:fluidLiquidSourceFlowing"));

    public static void init() {

        FluidRegistry.registerFluid(liquidElectricOoze);
        FluidRegistry.registerFluid(liquidWaterSource);
        FluidRegistry.registerFluid(liquidGrass);
        FluidRegistry.registerFluid(liquidFire);

        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidelectricooze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidElectricOoze), new ItemStack(Items.BUCKET));
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidwatersource", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidWaterSource), new ItemStack(Items.BUCKET));
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidgrass", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidGrass), new ItemStack(Items.BUCKET));
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidfire", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidFire), new ItemStack(Items.BUCKET));

    }

}

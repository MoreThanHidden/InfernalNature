package morethanhidden.MolecularGems.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class MGFluids {

    public static Fluid liquidElectricOoze = new Fluid("liquidelectricooze", new ResourceLocation("moleculargems:fluidElectricStill"), new ResourceLocation("moleculargems:fluidElectricFlowing"));
    public static Fluid liquidGrass = new Fluid("liquidgrass", new ResourceLocation("moleculargems:fluidGrassStill"), new ResourceLocation(""));
    public static Fluid liquidFire = new Fluid("liquidfire", new ResourceLocation("moleculargems:fluidFireStill"), new ResourceLocation("moleculargems:fluidFireFlowing"));
    public static Fluid liquidWaterSource = new Fluid("liquidwatersource", new ResourceLocation("moleculargems:fluidLiquidSourceStill"),new ResourceLocation("moleculargems:fluidLiquidSourceFlowing"));

    public static void init() {

        FluidRegistry.registerFluid(liquidElectricOoze);
        FluidRegistry.registerFluid(liquidWaterSource);
        FluidRegistry.registerFluid(liquidGrass);
        FluidRegistry.registerFluid(liquidFire);

        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidelectricooze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidElectricOoze), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidwatersource", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidWaterSource), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidgrass", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidGrass), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidfire", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ItemRegistry.bucketliquidFire), new ItemStack(Items.bucket));

    }

}

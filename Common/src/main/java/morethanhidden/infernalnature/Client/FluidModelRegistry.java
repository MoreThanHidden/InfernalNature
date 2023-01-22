package morethanhidden.infernalnature.Client;

import morethanhidden.MTHCore.util.FluidStateMapper;
import morethanhidden.infernalnature.InfernalNature;
import morethanhidden.infernalnature.registry.PMFluidRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;

public class FluidModelRegistry {

    public static void init() {
        registerFluidModels(PMFluidRegistry.liquidFire);
        registerFluidModels(PMFluidRegistry.liquidGrass);
        registerFluidModels(PMFluidRegistry.liquidMana);
        registerFluidModels(PMFluidRegistry.liquidWaterSource);
    }

    public static void registerFluidModels(Fluid fluid) {
        if(fluid == null) {
            return;
        }

        Block block = fluid.getBlock();
        if(block != null) {
            Item item = Item.getItemFromBlock(block);
            FluidStateMapper mapper = new FluidStateMapper(fluid, powerofmagic.MODID, "fluid_block");

            if(item != null) {
                ModelLoader.registerItemVariants(item);
                ModelLoader.setCustomMeshDefinition(item, mapper);
            }

            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }


}
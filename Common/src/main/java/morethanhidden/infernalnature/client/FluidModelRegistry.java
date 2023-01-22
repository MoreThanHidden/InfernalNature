package morethanhidden.infernalnature.client;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.registry.PMFluidRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

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
            Item item = Item.byBlock(block);
            FluidStateMapper mapper = new FluidStateMapper(fluid, Constants.MOD_ID, "fluid_block");

            if(item != null) {
                ModelLoader.registerItemVariants(item);
                ModelLoader.setCustomMeshDefinition(item, mapper);
            }

            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }


}
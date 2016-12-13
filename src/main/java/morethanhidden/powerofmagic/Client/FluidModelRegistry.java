package morethanhidden.powerofmagic.Client;

import morethanhidden.powerofmagic.powerofmagic;
import morethanhidden.powerofmagic.registry.PMFluidRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.Nonnull;

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
            FluidStateMapper mapper = new FluidStateMapper(fluid);

            if(item != null) {
                ModelLoader.registerItemVariants(item);
                ModelLoader.setCustomMeshDefinition(item, mapper);
            }

            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }

    public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

        public final Fluid fluid;
        public final ModelResourceLocation location;

        public FluidStateMapper(Fluid fluid) {
            this.fluid = fluid;
            this.location = new ModelResourceLocation(new ResourceLocation(powerofmagic.MODID, "fluid_block"), fluid.getName());
        }

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            return location;
        }

        @Nonnull
        @Override
        public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
            return location;
        }
    }



}
package morethanhidden.powerofmagic.util;

import morethanhidden.powerofmagic.api.IModelRegister;
import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Map;

@SideOnly(Side.CLIENT)
public class BlockModelResolver {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onModelBake(ModelBakeEvent event) {

        Map<IBlockState, ModelResourceLocation> stateMap = event.getModelManager().getBlockModelShapes().getBlockStateMapper().putAllStateModelLocations();

        for (ResourceLocation identifier : Item.REGISTRY.getKeys()) {
            if (!identifier.getResourceDomain().equals(powerofmagic.MODID)) {
                continue;
            }
            Object o = Item.REGISTRY.getObject(identifier);
            if (!(o instanceof ItemBlock)) {
                Item item = (Item) o;
                if (item != null) {
                    if (item instanceof IModelRegister) {
                        ((IModelRegister) item).registerModels();
                    }
                }
                continue;
            }
            ItemBlock item = (ItemBlock) o;

            ModelResourceLocation loc = new ModelResourceLocation(identifier, "inventory");

            Object model = event.getModelRegistry().getObject(loc);
            if (model != null) {
                continue;
            }

            Block block = item.getBlock();
            boolean first = true;

            for (int i = 0; i < 16; i++) {
                IBlockState state = block.getStateFromMeta(i);
                int meta = block.getMetaFromState(state);
                if (meta != i) {
                    continue;
                }

                ModelResourceLocation blockLoc = stateMap.get(state);
                if (blockLoc != null) {
                    IBakedModel bakedBlockModel = event.getModelRegistry().getObject(blockLoc);
                    if (bakedBlockModel != null) {
                        bakedBlockModel = new BlockItemModelWrapper(bakedBlockModel);

                        if (first) {
                            event.getModelRegistry().putObject(loc, bakedBlockModel);
                            first = false;
                        }
                    }

                    ModelHelper.registerItemModel(item, meta, loc);
                    //if (block instanceof IModelRegister) {
                    //    ((IModelRegister) block).registerModels();
                    //}
                    //if (block instanceof ICustomStateMapper) {
                    //    ((ICustomStateMapper) block).setCusomStateMappers();
                    //}
                }
            }
        }
    }
}
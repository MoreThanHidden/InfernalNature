package morethanhidden.powerofmagic.Client;

import morethanhidden.MTHCore.api.IModelRegister;
import morethanhidden.MTHCore.util.BlockModelResolver;
import morethanhidden.MTHCore.util.ModelHelper;
import morethanhidden.powerofmagic.powerofmagic;
import morethanhidden.powerofmagic.registry.BlockRegistry;
import morethanhidden.powerofmagic.registry.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;

public class ItemModelRegistry {

    public static void init() {
        //Blocks
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemGreen), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemOrange), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemPurple), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.gemOre), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockCable), 0);

        OBJLoader.INSTANCE.addDomain(powerofmagic.MODID.toLowerCase());
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.gemCube), 0);

        //Items
        ((IModelRegister)ItemRegistry.gem).registerModels();

        MinecraftForge.EVENT_BUS.register(new BlockModelResolver());
    }
}
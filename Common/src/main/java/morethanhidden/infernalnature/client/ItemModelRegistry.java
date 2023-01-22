package morethanhidden.infernalnature.client;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.registry.BlockRegistry;
import morethanhidden.infernalnature.registry.ItemRegistry;
import net.minecraft.world.item.Item;

public class ItemModelRegistry {

    public static void init() {
        //Blocks
        ModelHelper.registerItemModel(Item.byBlock(BlockRegistry.blockGemGreen), 0);
        ModelHelper.registerItemModel(Item.byBlock(BlockRegistry.blockGemOrange), 0);
        ModelHelper.registerItemModel(Item.byBlock(BlockRegistry.blockGemPurple), 0);
        ModelHelper.registerItemModel(Item.byBlock(BlockRegistry.gemOre), 0);
        ModelHelper.registerItemModel(Item.byBlock(BlockRegistry.blockCable), 0);

        OBJLoader.INSTANCE.addDomain(Constants.MOD_ID.toLowerCase());
        ModelHelper.registerItemModel(Item.byBlock(BlockRegistry.gemCube), 0);

        //Items
        ((IModelRegister)ItemRegistry.gem).registerModels();

        MinecraftForge.EVENT_BUS.register(new BlockModelResolver());
    }
}
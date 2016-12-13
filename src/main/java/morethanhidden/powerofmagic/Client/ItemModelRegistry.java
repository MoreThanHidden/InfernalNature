package morethanhidden.powerofmagic.Client;

        import morethanhidden.powerofmagic.registry.BlockRegistry;
import morethanhidden.powerofmagic.util.BlockModelResolver;
import morethanhidden.powerofmagic.util.ModelHelper;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public class ItemModelRegistry {

    public static void init() {
        //Blocks
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemGreen), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemOrange), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemPurple), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.gemOre), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockCable), 0);

        MinecraftForge.EVENT_BUS.register(new BlockModelResolver());
    }
}
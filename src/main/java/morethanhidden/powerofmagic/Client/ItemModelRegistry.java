package morethanhidden.powerofmagic.Client;

        import morethanhidden.powerofmagic.powerofmagic;
        import morethanhidden.powerofmagic.registry.BlockRegistry;
        import morethanhidden.powerofmagic.registry.ItemRegistry;
        import net.minecraft.client.renderer.block.model.ModelResourceLocation;
        import net.minecraft.item.Item;
        import net.minecraftforge.client.model.ModelLoader;

        import java.util.Locale;


public class ItemModelRegistry {

    public static void init() {
        //Items
        registerItemModelWithMeta(ItemRegistry.regularGem, 0, "gemOrange");
        registerItemModelWithMeta(ItemRegistry.regularGem, 1, "gemPurple");
        registerItemModelWithMeta(ItemRegistry.regularGem, 2, "gemGreen");
        registerItemModel(ItemRegistry.bucketliquidFire, "bucket_liquidFire");
        registerItemModel(ItemRegistry.bucketliquidGrass, "bucket_liquidGrass");
        registerItemModel(ItemRegistry.bucketliquidElectricOoze, "bucket_liquidMana");

        //Blocks
        registerItemModel(Item.getItemFromBlock(BlockRegistry.gemBlock), "gemBlock");
    }

    private static void registerItemModel(Item item, String name) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(powerofmagic.MODID + ":" + name, "inventory"));
    }

    private static void registerItemModelWithMeta(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(powerofmagic.MODID + ":" + name, "inventory"));
    }
}
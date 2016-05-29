package morethanhidden.powerofmagic.Client;

        import morethanhidden.powerofmagic.powerofmagic;
        import morethanhidden.powerofmagic.registry.BlockRegistry;
        import morethanhidden.powerofmagic.registry.ItemRegistry;
        import morethanhidden.powerofmagic.util.BlockModelResolver;
        import morethanhidden.powerofmagic.util.ModelHelper;
        import net.minecraft.client.renderer.block.model.ModelResourceLocation;
        import net.minecraft.item.Item;
        import net.minecraftforge.client.model.ModelLoader;
        import net.minecraftforge.common.MinecraftForge;

public class ItemModelRegistry {

    public static void init() {
        //Items
        //ModelHelper.registerItemModel(ItemRegistry.regularGem, 0);
        //ModelHelper.registerItemModel(ItemRegistry.regularGem, 1);
        //ModelHelper.registerItemModel(ItemRegistry.regularGem, 2);
        ModelHelper.registerItemModel(ItemRegistry.bucketliquidFire, 0);
        ModelHelper.registerItemModel(ItemRegistry.bucketliquidGrass, 0);
        ModelHelper.registerItemModel(ItemRegistry.bucketliquidMana, 0);

        //Blocks
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemGreen), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemOrange), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockGemPurple), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.gemOre), 0);

        MinecraftForge.EVENT_BUS.register(new BlockModelResolver());
    }
}
package morethanhidden.MolecularGems.Client;

        import morethanhidden.MolecularGems.MolecularGems;
        import morethanhidden.MolecularGems.registry.BlockRegistry;
        import morethanhidden.MolecularGems.registry.ItemRegistry;
        import net.minecraft.block.Block;
        import net.minecraft.client.resources.model.ModelResourceLocation;
        import net.minecraft.item.Item;
        import net.minecraft.util.IStringSerializable;
        import net.minecraft.util.ResourceLocation;
        import net.minecraftforge.client.model.ModelLoader;
        import net.minecraftforge.fml.common.registry.GameData;

        import java.util.Locale;


public class ItemModelRegistry {

    public static void init() {
        //Items
        registerItemModelWithMeta(ItemRegistry.regularGem, 0, "gemOrange");
        registerItemModelWithMeta(ItemRegistry.regularGem, 1, "gemPurple");
        registerItemModelWithMeta(ItemRegistry.regularGem, 2, "gemGreen");
        registerItemModelWithMeta(ItemRegistry.fragmentGem, 0, "gemOrangeF");
        registerItemModelWithMeta(ItemRegistry.fragmentGem, 1, "gemPurpleF");
        registerItemModelWithMeta(ItemRegistry.fragmentGem, 2, "gemGreenF");
        registerItemModelWithMeta(ItemRegistry.refinedGem, 0, "gemOrangeR");
        registerItemModelWithMeta(ItemRegistry.refinedGem, 1, "gemPurpleR");
        registerItemModelWithMeta(ItemRegistry.refinedGem, 2, "gemGreenR");
        registerItemModel(ItemRegistry.bucketliquidFire, "bucket_liquidFire");
        registerItemModel(ItemRegistry.bucketliquidGrass, "bucket_liquidGrass");
        registerItemModel(ItemRegistry.bucketliquidElectricOoze, "bucket_liquidElectricOoze");

        //Blocks
        registerItemModel(Item.getItemFromBlock(BlockRegistry.gemBlock), "gemBlock");
    }

    private static void registerItemModel(Item item, String name) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(MolecularGems.MODID + ":" + name, "inventory"));
    }

    private static void registerItemModelWithMeta(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MolecularGems.MODID + ":" + name, "inventory"));
    }
}
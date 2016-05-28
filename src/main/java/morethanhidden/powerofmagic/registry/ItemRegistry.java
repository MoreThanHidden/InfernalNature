package morethanhidden.powerofmagic.registry;

import morethanhidden.powerofmagic.items.BucketItem;
import morethanhidden.powerofmagic.items.FragmentGem;
import morethanhidden.powerofmagic.items.Gem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {

    public static Item regularGem = new Gem();
    public static Item fragmentGem = new FragmentGem();
    public static Item bucketliquidElectricOoze = new BucketItem(BlockRegistry.blockElectricOoze);
    public static Item bucketliquidFire = new BucketItem(BlockRegistry.blockLiquidFire);
    public static Item bucketliquidGrass = new BucketItem(BlockRegistry.blockLiquidGrass);
    public static Item bucketliquidWaterSource = new BucketItem(BlockRegistry.blockLiquidWaterSource);

    public static void init() {
        registerItem(regularGem);
        registerItem(fragmentGem);
        registerItem(bucketliquidElectricOoze);
        registerItem(bucketliquidFire);
        registerItem(bucketliquidGrass);
        registerItem(bucketliquidWaterSource);

    }

    private static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

}

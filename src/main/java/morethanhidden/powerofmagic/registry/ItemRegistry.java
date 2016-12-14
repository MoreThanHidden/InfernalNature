package morethanhidden.powerofmagic.registry;

import morethanhidden.powerofmagic.items.Gem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {

    public static Item gem = new Gem();

    public static void init() {
        registerItem(gem);
    }

    private static void registerItem(Item item) {
        GameRegistry.register(item);
    }

}

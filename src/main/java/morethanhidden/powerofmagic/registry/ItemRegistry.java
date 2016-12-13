package morethanhidden.powerofmagic.registry;

import morethanhidden.powerofmagic.items.FragmentGem;
import morethanhidden.powerofmagic.items.Gem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {

    public static Item regularGem = new Gem();
    public static Item fragmentGem = new FragmentGem();

    public static void init() {
        registerItem(regularGem);
        registerItem(fragmentGem);
    }

    private static void registerItem(Item item) {
        GameRegistry.register(item);
    }

}

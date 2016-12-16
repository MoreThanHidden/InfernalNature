package morethanhidden.powerofmagic.registry;

import morethanhidden.MTHCore.items.SubItem;
import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {


    public static Item gem = new SubItem(powerofmagic.MODID, "gem", new String[] {"orange", "purple", "green", "orangef", "purplef", "greenf"});

    public static void init() {
        registerItem(gem);
    }

    private static void registerItem(Item item) {
        GameRegistry.register(item);
    }

}

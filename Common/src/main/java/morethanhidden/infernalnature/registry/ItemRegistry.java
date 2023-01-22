package morethanhidden.infernalnature.registry;

import morethanhidden.MTHCore.items.SubItem;
import morethanhidden.infernalnature.InfernalNature;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {

    //Can create subItems with a one liner now :)
    public static Item gem = new SubItem(powerofmagic.MODID, "gem",
            new String[] {"orange", "purple", "green", "orangef", "purplef", "greenf"})
            .setCreativeTab(powerofmagic.tabpowerofmagic);

    public static void init() {
        registerItem(gem);
    }

    private static void registerItem(Item item) {
        GameRegistry.register(item);
    }

}

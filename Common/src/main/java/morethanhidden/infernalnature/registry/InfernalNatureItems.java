package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.items.Wand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

/**
 * Item Registry for Infernal Nature
 * @author morethanhidden
 */
public class InfernalNatureItems {

    public static Item infernalGem = new Item(new Item.Properties());
    public static Item natureGem = new Item(new Item.Properties());
    public static Item mysticGem = new Item(new Item.Properties());

    public static Item infernalFragment = new Item(new Item.Properties());
    public static Item natureFragment = new Item(new Item.Properties());
    public static Item mysticFragment = new Item(new Item.Properties());

    public static Item crude_wand = new Wand();

    /**
     * Register Items
     * @param register - BiConsumer to register items
     */
    public static void registerItems(BiConsumer<Item, ResourceLocation> register) {
        register.accept(infernalGem, new ResourceLocation(Constants.MOD_ID, "infernal_gem"));
        register.accept(natureGem, new ResourceLocation(Constants.MOD_ID, "nature_gem"));
        register.accept(mysticGem, new ResourceLocation(Constants.MOD_ID, "mystic_gem"));
        register.accept(infernalFragment, new ResourceLocation(Constants.MOD_ID, "infernal_fragment"));
        register.accept(natureFragment, new ResourceLocation(Constants.MOD_ID, "nature_fragment"));
        register.accept(mysticFragment, new ResourceLocation(Constants.MOD_ID, "mystic_fragment"));
        register.accept(crude_wand, new ResourceLocation(Constants.MOD_ID, "crude_wand"));
    }

}

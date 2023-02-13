package morethanhidden.infernalnature.client.colours;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

import static morethanhidden.infernalnature.items.Wand.TAG_GEM_BOTTOM;
import static morethanhidden.infernalnature.items.Wand.TAG_GEM_TOP;

/**
 * Wand Colour ItemColor implementation
 * @author MoreThanHidden
 */
public class WandColour implements ItemColor {

    /**
     * Get the color of the item based on the layer and NBT data
     * @param itemStack The itemstack in question
     * @param i The layer of the item
     * @return The color for this layer
     */
    @Override
    public int getColor(ItemStack itemStack, int i) {
        //Top Layer
        if(i == 1) {
            //Nature (Green)
            if (itemStack.getOrCreateTag().getInt(TAG_GEM_TOP) == 0) {
                return 0x00FF00;
                //Infernal (Orange)
            } else if (itemStack.getOrCreateTag().getInt(TAG_GEM_TOP) == 1) {
                return 0xFF6600;
                //Mystic (Purple)
            } else if (itemStack.getOrCreateTag().getInt(TAG_GEM_TOP) == 2) {
                return 0xA32CC4;
            }
            //Bottom Layer
        }else if(i == 2) {
            //Nature (Green)
            if (itemStack.getOrCreateTag().getInt(TAG_GEM_BOTTOM) == 0) {
                return 0x00FF00;
                //Infernal (Orange)
            } else if (itemStack.getOrCreateTag().getInt(TAG_GEM_BOTTOM) == 1) {
                return 0xFF6600;
                //Mystic (Purple)
            } else if (itemStack.getOrCreateTag().getInt(TAG_GEM_BOTTOM) == 2) {
                return 0xA32CC4;
            }
        }
        //Default (White)
        return 0xFFFFFF;
    }
}

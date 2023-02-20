package morethanhidden.infernalnature.inventory;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;

public class MysticCraftingMenu extends CraftingMenu {

    public MysticCraftingMenu(int i, Inventory inventory) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    public MysticCraftingMenu(int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(i, inventory, containerLevelAccess);
    }
}

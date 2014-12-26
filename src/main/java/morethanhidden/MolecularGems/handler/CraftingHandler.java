package morethanhidden.MolecularGems.handler;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler
{
/**
     * Adds Coffee achievement after crafting mug of coffee
     */
@SubscribeEvent
    public void onCrafting(ItemCraftedEvent event)
    {
     if (event.crafting.getItem() == MainRegistry.bucketliquidWaterSource ) {
         event.player.addStat(MainRegistry.stickyooze, 1);
         
        }
     if (event.crafting.getItem() == MainRegistry.bucketliquidFire ) {
         event.player.addStat(MainRegistry.stickyooze, 1);
     	}
     if (event.crafting.getItem() == MainRegistry.bucketliquidGrass ) {
         event.player.addStat(MainRegistry.stickyooze, 1);
     	}
     if (event.crafting.isItemEqual((new ItemStack(MainRegistry.molecularAdaptorEmpty, 1))) ) {
         event.player.addStat(MainRegistry.agemerator, 1);
     	}
    }
}
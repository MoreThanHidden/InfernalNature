package morethanhidden.MolecularGems.handler;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CraftingHandler
{
/**
     * Adds Coffee achievement after crafting mug of coffee
     */
@SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event)
    {
     if (event.crafting.getItem() == MolecularGems.bucketliquidWaterSource ) {
         event.player.addStat(MolecularGems.stickyooze, 1);
         
        }
     if (event.crafting.getItem() == MolecularGems.bucketliquidFire ) {
         event.player.addStat(MolecularGems.stickyooze, 1);
     	}
     if (event.crafting.getItem() == MolecularGems.bucketliquidGrass ) {
         event.player.addStat(MolecularGems.stickyooze, 1);
     	}
    }
}
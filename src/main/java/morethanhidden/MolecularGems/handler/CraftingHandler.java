package morethanhidden.MolecularGems.handler;

import morethanhidden.MolecularGems.registry.AchievementRegistry;
import morethanhidden.MolecularGems.registry.ItemRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CraftingHandler
{
@SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event)
    {
     if (event.crafting.getItem() == ItemRegistry.bucketliquidWaterSource ) {
         event.player.addStat(AchievementRegistry.stickyooze, 1);
        }
     if (event.crafting.getItem() == ItemRegistry.bucketliquidFire ) {
         event.player.addStat(AchievementRegistry.stickyooze, 1);
     	}
     if (event.crafting.getItem() == ItemRegistry.bucketliquidGrass ) {
         event.player.addStat(AchievementRegistry.stickyooze, 1);
     	}
    }
}
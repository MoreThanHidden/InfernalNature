package morethanhidden.infernalnature.handler;

import morethanhidden.infernalnature.registry.ItemRegistry;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class GemOnMineEvent {

	@SubscribeEvent
	public void onPickupGemOre(PlayerEvent.ItemPickupEvent event){
		if(event.getStack().is(ItemRegistry.infernalGem)){
			//event.getEntity().addStat(AchievementRegistry.minegem, 1);
		}
	}
}

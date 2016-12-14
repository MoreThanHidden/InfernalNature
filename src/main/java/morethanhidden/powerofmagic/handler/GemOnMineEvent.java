package morethanhidden.powerofmagic.handler;

import morethanhidden.powerofmagic.registry.AchievementRegistry;
import morethanhidden.powerofmagic.registry.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


public class GemOnMineEvent {

	@SubscribeEvent
	public void onPickupGemOre(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ItemRegistry.gem, 1, 0))){
			e.player.addStat(AchievementRegistry.minegem, 1);
		}
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ItemRegistry.gem, 1, 1))){
			e.player.addStat(AchievementRegistry.minegem, 1);
		}
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ItemRegistry.gem, 1, 2))){
			e.player.addStat(AchievementRegistry.minegem, 1);
		}
	}
}

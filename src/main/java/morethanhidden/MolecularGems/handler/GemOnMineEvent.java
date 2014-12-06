package morethanhidden.MolecularGems.handler;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;


public class GemOnMineEvent {

	@SubscribeEvent
	public void onPickupGemOre(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(MainRegistry.cleanGem, 1, 0))){
			e.player.addStat(MainRegistry.minegem, 1);
		}
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(MainRegistry.cleanGem, 1, 1))){
			e.player.addStat(MainRegistry.minegem, 1);
		}
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(MainRegistry.cleanGem, 1, 2))){
			e.player.addStat(MainRegistry.minegem, 1);
		}
	}
}

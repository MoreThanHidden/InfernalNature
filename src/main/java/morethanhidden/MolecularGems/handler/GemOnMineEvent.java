package morethanhidden.MolecularGems.handler;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


public class GemOnMineEvent {

	@SubscribeEvent
	public void onPickupGemOre(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(MolecularGems.regularGem, 1, 0))){
			e.player.addStat(MolecularGems.minegem, 1);
		}
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(MolecularGems.regularGem, 1, 1))){
			e.player.addStat(MolecularGems.minegem, 1);
		}
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(MolecularGems.regularGem, 1, 2))){
			e.player.addStat(MolecularGems.minegem, 1);
		}
	}
}

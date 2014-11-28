package com.github.morethanhidden.MolecularGems.handler;

import net.minecraft.item.ItemStack;

import com.github.morethanhidden.MolecularGems.MainRegistry;

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
     if (event.crafting.getItem() == MainRegistry.bucketliquidAquoticOoze ) {
         event.player.addStat(MainRegistry.stickyooze, 1);
        }
     if (event.crafting.getItem() == MainRegistry.bucketliquidFlamingOoze ) {
         event.player.addStat(MainRegistry.stickyooze, 1);
     	}
     if (event.crafting.getItem() == MainRegistry.bucketliquidMuddyOoze ) {
         event.player.addStat(MainRegistry.stickyooze, 1);
     	}
     if (event.crafting.isItemEqual((new ItemStack(MainRegistry.GemeratorEmpty, 1))) ) {
         event.player.addStat(MainRegistry.agemerator, 1);
     	}
    }
}
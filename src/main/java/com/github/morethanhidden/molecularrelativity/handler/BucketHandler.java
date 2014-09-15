package com.github.morethanhidden.molecularrelativity.handler;

import com.github.morethanhidden.molecularrelativity.MainRegistry;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketHandler {

	@SubscribeEvent
		public void onBucketFill(FillBucketEvent event) {

			ItemStack result = fillCustomBucket(event.world, event.target);

			if (result == null)
				return;

			event.result = result;
			event.setResult(Result.ALLOW);
		}

		public ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {
			Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

			if ((block == MainRegistry.blockLiquidEUze)
					&& world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				return new ItemStack(MainRegistry.bucketliquidEUzItem);
			} else
				return null;
		}

	}

package morethanhidden.MolecularGems.handler;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import morethanhidden.MolecularGems.MainRegistry;
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

			if ((block == MainRegistry.blockElectricOooze)
					&& world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				return new ItemStack(MainRegistry.bucketliquidElectricOoze);
				
			} else if ((block == MainRegistry.blockLiquidGrass)
					&& world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				return new ItemStack(MainRegistry.bucketliquidGrass);
				
			} else if ((block == MainRegistry.blockLiquidFire)
					&& world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
				world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
				return new ItemStack(MainRegistry.bucketliquidFire);
				
			} else
				return null;
		}

	}

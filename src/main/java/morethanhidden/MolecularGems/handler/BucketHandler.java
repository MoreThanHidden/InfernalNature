package morethanhidden.MolecularGems.handler;

import morethanhidden.MolecularGems.MolecularGems;
import morethanhidden.MolecularGems.blocks.BlockLiquidElectricOoze;
import morethanhidden.MolecularGems.blocks.BlockLiquidFire;
import morethanhidden.MolecularGems.blocks.BlockLiquidGrass;
import morethanhidden.MolecularGems.registry.BlockRegistry;
import morethanhidden.MolecularGems.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BucketHandler {

	@SubscribeEvent
		public void onBucketFill(FillBucketEvent event) {

			ItemStack result = fillCustomBucket(event.world, event.target);

			if (result == null)
				return;

			event.result = result;
			event.setResult(Event.Result.ALLOW);
		}

		public ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {
			Block block = world.getBlockState(pos.getBlockPos()).getBlock();

			if ((block == BlockRegistry.blockElectricOoze)
					&& world.getBlockState(pos.getBlockPos()).getValue(((BlockLiquidElectricOoze) block).LEVEL) == 0) {
				world.setBlockToAir(pos.getBlockPos());
				return new ItemStack(ItemRegistry.bucketliquidElectricOoze);
				
			} else if ((block == BlockRegistry.blockLiquidGrass)
					&& world.getBlockState(pos.getBlockPos()).getValue(((BlockLiquidGrass) block).LEVEL) == 0) {
				world.setBlockToAir(pos.getBlockPos());
				return new ItemStack(ItemRegistry.bucketliquidGrass);
				
			} else if ((block == BlockRegistry.blockLiquidFire)
					&& world.getBlockState(pos.getBlockPos()).getValue(((BlockLiquidFire) block).LEVEL) == 0) {
				world.setBlockToAir(pos.getBlockPos());
				return new ItemStack(ItemRegistry.bucketliquidFire);
				
			} else
				return null;
		}

	}

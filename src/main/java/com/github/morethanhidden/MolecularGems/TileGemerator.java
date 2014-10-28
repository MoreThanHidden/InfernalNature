package com.github.morethanhidden.MolecularGems;

import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import cpw.mods.fml.common.Optional;


public class TileGemerator extends TileEntity implements IEnergyConnection{
	
	    //API Energy Variables
	    public int energy = MainRegistry.gemeratorEnergyAmt;
	    public int maxEnergy = MainRegistry.gemeratorEnergyAmt;
	    public boolean initialized;
	    
	    @Override
	    public void writeToNBT(NBTTagCompound data) {
	        super.writeToNBT(data);
	        	data.setInteger("energy", this.energy);
	    }
	 
	    @Override
	    public void readFromNBT(NBTTagCompound data) {
	        super.readFromNBT(data);
	        		this.energy = data.getInteger("energy");
	    }
	    
	    
	    private boolean deadCache;
		private IEnergyHandler[] handlerCache;
	    
	    @Override
	    @Optional.Method(modid = "CoFHAPI")
		public void validate()
		{
			super.validate();
			deadCache = true;
			handlerCache = null;
		}
	    
	    @Override
	    @Optional.Method(modid = "CoFHAPI")
		public void updateEntity()
		{
			super.updateEntity();
			if (!worldObj.isRemote)
			{
				if (deadCache) reCache();
				
				int pulse = Math.min(energy, 800);
				energy -= pulse;
				energy += transmitEnergy(pulse);
				}
			}
	    
	    @Optional.Method(modid = "CoFHAPI")
	    protected final int transmitEnergy(int energy){
			if (energy <= 0)
				return 0;

			if (handlerCache != null)
				for (int i = handlerCache.length; i-- > 0; )
				{
					IEnergyHandler tile = handlerCache[i];
					if (tile == null)
						continue;

					ForgeDirection from = ForgeDirection.VALID_DIRECTIONS[i];
					if (tile.receiveEnergy(from, energy, true) > 0)
						energy -= tile.receiveEnergy(from, energy, false);
					if (energy <= 0)
						return 0;
				}

			return energy;
		}
	    
	    @Optional.Method(modid = "CoFHAPI")
		private void addCache(TileEntity tile, int side)
		{
			if (handlerCache != null)
				handlerCache[side] = null;

			if (tile instanceof IEnergyHandler)
			{
				if(tile instanceof IEnergyHandler && ((IEnergyHandler)tile).canConnectEnergy(ForgeDirection.VALID_DIRECTIONS[side])) {
					if (handlerCache == null) 
						handlerCache = new IEnergyHandler[6];
					handlerCache[side] = (IEnergyHandler)tile;
				}
			}
		}
	    
	    @Optional.Method(modid = "CoFHAPI")
		private void reCache() {
			if (deadCache) {
				for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
					onNeighborTileChange(xCoord + dir.offsetX,
							yCoord + dir.offsetY, zCoord + dir.offsetZ);
				deadCache = false;
			}
		}
		
		@Optional.Method(modid = "CoFHAPI")
		public void onNeighborTileChange(int x, int y, int z) {
			TileEntity tile = worldObj.getTileEntity(x, y, z);

			if(x < xCoord)
				addCache(tile, 5);
			else if(x > xCoord)
				addCache(tile, 4);
			else if(z < zCoord)
				addCache(tile, 3);
			else if(z > zCoord)
				addCache(tile, 2);
			else if(y < yCoord)
				addCache(tile, 1);
			else if(y > yCoord)
				addCache(tile, 0);
		}

	    
		@Override
		public boolean canConnectEnergy(ForgeDirection from) {
			return true;
		}

	}



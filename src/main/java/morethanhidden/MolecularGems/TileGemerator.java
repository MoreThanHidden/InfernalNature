package morethanhidden.MolecularGems;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySource;
import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
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


public class TileGemerator extends TileEntity implements IEnergyConnection, IEnergySource, IInventory{
	
	    //API Energy Variables
	    public int energy;
	    public int maxEnergy = MainRegistry.gemeratorEnergyAmt * 4;
	    public boolean initialized;
	    
		// IC2-related fields
		
		private boolean _isAddedToIC2EnergyNet;
		private boolean _addToNetOnNextTick;
	    
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
			
			if(!_isAddedToIC2EnergyNet)
			{
				_addToNetOnNextTick = true;
			}
			
		}
	    
	    @Override
		public void updateEntity()
		{
			super.updateEntity();
			if (!worldObj.isRemote)
			{
				if (deadCache) reCache();
				
				int pulse = Math.min(energy, 4000);
				energy -= pulse;
				energy += transmitEnergy(pulse);
				}
			
			if(_addToNetOnNextTick)
			{
				if(!worldObj.isRemote)
				{
					MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
				}
				_addToNetOnNextTick = false;
				_isAddedToIC2EnergyNet = true;
			}
			
		}
	  
	    @Override
		public void invalidate()
		{
			if(_isAddedToIC2EnergyNet)
			{
				if(!worldObj.isRemote)
				{
					MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
				}
				_isAddedToIC2EnergyNet = false;
			}
			super.invalidate();
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
		@Optional.Method(modid = "CoFHAPI")
		public boolean canConnectEnergy(ForgeDirection from) {
			return true;
		}

		@Override
		@Optional.Method(modid = "IC2API")
		public boolean emitsEnergyTo(TileEntity receiver,
				ForgeDirection direction) {
			return true;
		}

		@Override
		@Optional.Method(modid = "IC2API")
		public double getOfferedEnergy() {
			return Math.min(energy / 4, 2047);
		}

		@Override
		@Optional.Method(modid = "IC2API")
		public void drawEnergy(double amount) {
			energy = energy - (int) (amount * 4);
			
		}

		@Override
		@Optional.Method(modid = "IC2API")
		public int getSourceTier() {
			return 3;
		}

		@Override
		public int getSizeInventory() {
			return 1;
		}

		@Override
		public ItemStack getStackInSlot(int slot) {
			if (slot == 0 && energy == 0 && worldObj.getBlock(xCoord, yCoord, zCoord) == MainRegistry.Gemerator){
				return new ItemStack (MainRegistry.ascendedGem, 1);}
			else return null;
		}

		@Override
		public ItemStack decrStackSize(int slot, int amount) {
			if (slot == 0 && energy == 0 && worldObj.getBlock(xCoord, yCoord, zCoord) == MainRegistry.Gemerator){
				worldObj.setBlock(xCoord, yCoord, zCoord, MainRegistry.GemeratorEmpty, worldObj.getBlockMetadata(xCoord, yCoord, zCoord), 2);
				return new ItemStack (MainRegistry.ascendedGem, 1);}
			else return null;
		}

		@Override
		public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
			return null;
		}
		
		@Override
		public void setInventorySlotContents(int slot, ItemStack itemstack) {
				worldObj.setBlock(xCoord, yCoord, zCoord, MainRegistry.GemeratorEmpty, worldObj.getBlockMetadata(xCoord, yCoord, zCoord), 2);
				if (worldObj.getBlock(xCoord, yCoord, zCoord) == MainRegistry.GemeratorEmpty){
				worldObj.setBlock(xCoord, yCoord, zCoord, MainRegistry.Gemerator, worldObj.getBlockMetadata(xCoord, yCoord, zCoord), 2);
				
				int energy = 0;
				if(itemstack.stackTagCompound != null){
					energy = itemstack.getTagCompound().getInteger("Energy");}
				TileGemerator te2 = (TileGemerator) worldObj.getTileEntity(xCoord, yCoord, zCoord);
				te2.energy = energy;
				}
		}

		@Override
		public String getInventoryName() {
			return null;
		}

		@Override
		public boolean hasCustomInventoryName() {
			return false;
		}

		@Override
		public int getInventoryStackLimit() {
			return 1;
		}

		@Override
		public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
			return false;
		}

		@Override
		public void openInventory() {			
		}

		@Override
		public void closeInventory() {
		}

		@Override
		public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
			if (slot == 0 && worldObj.getBlock(xCoord, yCoord, zCoord) == MainRegistry.GemeratorEmpty && itemstack.getItem() == MainRegistry.ascendedGem){
	
				return true;
			}else return false;
		}

	}



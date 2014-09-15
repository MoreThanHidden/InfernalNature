package com.github.morethanhidden.molecularrelativity;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.tile.IWrenchable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;


public class TileMoleculizer extends TileEntity implements IEnergySink, IFluidHandler, IWrenchable{

	protected FluidTank euzebuffer = new FluidTank(4000);
	
    //IC2 API Energy Variables
    public double energy = 0.00;
    public int euzebufferamount = euzebuffer.getFluidAmount();
    public double maxEnergy = 8192.00;
    public boolean initialized;
 
    @Override
    public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        	data.setDouble("energy", this.energy);
        euzebuffer.writeToNBT(data);
    }
 
    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
            // Any other values should ONLY BE READ BY THE MASTER
        	if (data.hasKey("energy")){
        		this.energy = data.getDouble("energy");
        }
        euzebuffer.readFromNBT(data);
    }
 
 
    
    @Override
    public void updateEntity() {
        super.updateEntity();
        if(!worldObj.isRemote){
        	EnergyTileLoadEvent loadEvent = new EnergyTileLoadEvent(this);
        	MinecraftForge.EVENT_BUS.post(loadEvent);
        			
        		}
        		initialized = true;
        		euzebufferamount = euzebuffer.getFluidAmount();    		
                if(this.energy >= 1024){
                	if(this.euzebufferamount < 4000){
                		this.energy -= 1024;
                		this.euzebufferamount += 500;
                		this.euzebuffer.setFluid(FluidRegistry.getFluidStack("liquideuze", this.euzebufferamount));
              }
                	
         }
    
    }
    
	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter,
			ForgeDirection direction) {
		//Import from any direction
		return true;
	}

	public void invalidate() {
		EnergyTileUnloadEvent unloadEvent = new EnergyTileUnloadEvent(this);
		MinecraftForge.EVENT_BUS.post(unloadEvent);
		this.tileEntityInvalid = true;
	}

	@Override
	public boolean canDrain(ForgeDirection arg0, Fluid arg1) {
		return true;
	}

	@Override
	public boolean canFill(ForgeDirection arg0, Fluid arg1) {
		return false;
	}

	@Override
	 public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain){
		
        if (resource == null || !resource.isFluidEqual(euzebuffer.getFluid())){
            return null;
        }
        return euzebuffer.drain(resource.amount, doDrain);
    }

	@Override
	public FluidStack drain(ForgeDirection arg0, int maxDrain, boolean doDrain) {
		return euzebuffer.drain(maxDrain, doDrain);
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return euzebuffer.fill(resource, doFill);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { euzebuffer.getInfo() };
	}

	@Override
	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public short getFacing() {
		return 0;
	}

	@Override
	public void setFacing(short facing) {
		
	}

	@Override
	public boolean wrenchCanRemove(EntityPlayer entityPlayer) {
		return true;
	}

	@Override
	public float getWrenchDropRate() {
		return 1;
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(MainRegistry.moleculizer);
	}

	@Override
	public double getDemandedEnergy() {
		// Amount of energy to demand
		return this.maxEnergy - this.energy;
	}

	@Override
	public int getSinkTier() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public double injectEnergy(ForgeDirection directionFrom, double amount,
			double voltage) {
		// injected amounts
		if (this.energy >= this.maxEnergy)return amount;
		
		double openEnergy = this.maxEnergy - this.energy;
		
		if(openEnergy >= amount) {
			this.energy += amount;
			return 0.0D;
		}else if (amount > openEnergy){
			this.energy = this.maxEnergy;
			return amount = openEnergy;
		}
		
		return 0;
	}
}

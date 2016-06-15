package morethanhidden.powerofmagic.blocks.tiles;

import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileCable extends TileEntity implements IEnergyProvider, IEnergyReceiver, ITickable {

    protected int energy;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;



    public TileCable(int capacity) {

        this(capacity, capacity, capacity);
    }

    public TileCable(int capacity, int maxTransfer) {

        this(capacity, maxTransfer, maxTransfer);
    }

    public TileCable(int capacity, int maxReceive, int maxExtract) {

        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public void readFromNBT(NBTTagCompound nbt) {

        this.energy = nbt.getInteger("Energy");

        if (energy > capacity) {
            energy = capacity;
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        if (energy < 0) {
            energy = 0;
        }
        nbt.setInteger("Energy", energy);
        return nbt;
    }

    @Override
    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
        int exEnergy;
        if ((energy - maxExtract) >= 0) {
            if (!simulate) {
                energy -= maxExtract;
            }
            exEnergy = maxExtract;
        } else {
            exEnergy = maxExtract + (energy - maxExtract);
            if (!simulate) {
                energy = 0;
            }
        }
        return exEnergy;
    }

    @Override
    public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
        int reEnergy;
        if ((energy + maxReceive) <= capacity) {
            if (!simulate) {
                energy += maxReceive;
            }
            reEnergy = maxReceive;
        } else {
            reEnergy = (maxReceive - ((energy + maxReceive) - capacity));
            if (!simulate) {
                energy = capacity;
            }
        }
        return reEnergy;
    }

    @Override
    public int getEnergyStored(EnumFacing from) {
        return energy;
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from) {
        return capacity;
    }

    @Override
    public boolean canConnectEnergy(EnumFacing from) {
        return true;
    }

    @Override
    public void update() {
        if (getWorld().isRemote) {
            return;
        }
        for (EnumFacing face : EnumFacing.VALUES) {
            if (canConnectEnergy(face)) {
                BlockPos ofs = pos.offset(face);
                TileEntity tile = getWorld().getTileEntity(ofs);
                if (tile != null) {
                    if (IEnergyConnection.class.isAssignableFrom(tile.getClass())) {
                        if (IEnergyProvider.class.isAssignableFrom(tile.getClass())) {
                            IEnergyProvider prov = (IEnergyProvider) tile;
                            if (prov.canConnectEnergy(face)) {
                                int move = prov.extractEnergy(face.getOpposite(), capacity - energy, false);
                                if (move != 0) {
                                    energy += move;
                                }
                            }
                        }
                        if (IEnergyReceiver.class.isAssignableFrom(tile.getClass())) {
                            IEnergyReceiver rec = (IEnergyReceiver) tile;
                            if (rec.canConnectEnergy(face)) {
                                int move = rec.receiveEnergy(face.getOpposite(), energy, false);
                                if (move != 0) {
                                    energy -= move;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

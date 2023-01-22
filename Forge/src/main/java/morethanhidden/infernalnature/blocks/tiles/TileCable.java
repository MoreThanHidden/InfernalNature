package morethanhidden.infernalnature.blocks.tiles;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraftforge.energy.IEnergyStorage;

public class TileCable extends BlockEntity implements IEnergyStorage, TickingBlockEntity {

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
    public int extractEnergy(int maxExtract, boolean simulate) {
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
    public int receiveEnergy(int maxReceive, boolean simulate) {
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
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return false;
    }


    @Override
    public void tick() {
        if (getLevel().isClientSide) {
            return;
        }
        for (Direction face : Direction.values()) {
            if (canConnectEnergy(face)) {
                BlockPos ofs = getBlockPos().relative(face);
                BlockEntity tile = getLevel().getBlockEntity(ofs);
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

    @Override
    public BlockPos getPos() {
        return getBlockPos();
    }
}

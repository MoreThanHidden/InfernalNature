package morethanhidden.powerofmagic.handler;


import morethanhidden.powerofmagic.blocks.tiles.TileCable;

import java.util.ArrayList;
import java.util.UUID;

public class EnergyNet {

    protected int energy;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;
    private UUID netUUID;
    ArrayList<TileCable> cables = new ArrayList<>();

    protected EnergyNet(int capacity, UUID uuid){
        this.capacity = capacity;
        this.netUUID = (uuid!=null) ? uuid : UUID.randomUUID();
        EnergyNetUtil.addNetwork(this);
    }



}

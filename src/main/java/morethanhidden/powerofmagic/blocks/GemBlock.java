package morethanhidden.powerofmagic.blocks;

import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GemBlock extends Block{
	
	public GemBlock (String uname) {
		super(Material.ROCK);
		setCreativeTab(powerofmagic.tabpowerofmagic);
        setUnlocalizedName(uname);
        setRegistryName(powerofmagic.MODID, uname);
	}

    public String getUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }
}



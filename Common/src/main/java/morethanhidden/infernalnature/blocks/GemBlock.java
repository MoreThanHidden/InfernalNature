package morethanhidden.infernalnature.blocks;

import morethanhidden.infernalnature.InfernalNature;
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



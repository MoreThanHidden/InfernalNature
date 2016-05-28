package morethanhidden.powerofmagic.blocks;

import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GemBlock extends Block {
	
	public GemBlock () {
		super(Material.ROCK);
		setCreativeTab(powerofmagic.tabpowerofmagic);
		setUnlocalizedName("gemBlock");
	}
	
}



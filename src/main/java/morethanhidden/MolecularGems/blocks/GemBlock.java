package morethanhidden.MolecularGems.blocks;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GemBlock extends Block {
	
	public GemBlock () {
		super(Material.rock);
		setCreativeTab(MolecularGems.tabmoleculargems);
	}
	
}



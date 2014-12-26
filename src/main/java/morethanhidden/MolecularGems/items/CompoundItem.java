package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CompoundItem extends Item {

	public CompoundItem() {
        setMaxStackSize(64);
        setCreativeTab(MainRegistry.tabmoleculargems);
        setUnlocalizedName("CompoundMolecularBattery");
        setTextureName("moleculargems:CompoundMolecularBattery");
}
	
}



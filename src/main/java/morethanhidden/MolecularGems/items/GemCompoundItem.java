package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GemCompoundItem extends Item {

	public GemCompoundItem() {
        setMaxStackSize(64);
        setCreativeTab(MainRegistry.tabmoleculargems);
        setUnlocalizedName("GemCompound");
        setTextureName("moleculargems:GemCompound");
}
	
}



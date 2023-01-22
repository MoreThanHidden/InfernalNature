package morethanhidden.infernalnature.items;

import morethanhidden.infernalnature.InfernalNature;
import net.minecraft.item.Item;

public class CompoundItem extends Item {

	public CompoundItem() {
        setMaxStackSize(64);
        setCreativeTab(powerofmagic.tabpowerofmagic);
        setUnlocalizedName("CompoundMolecularBattery");
        setRegistryName(powerofmagic.MODID, "compoundmolecularbattery");
}
	
}



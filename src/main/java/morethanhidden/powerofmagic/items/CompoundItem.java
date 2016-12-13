package morethanhidden.powerofmagic.items;

import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.item.Item;

public class CompoundItem extends Item {

	public CompoundItem() {
        setMaxStackSize(64);
        setCreativeTab(powerofmagic.tabpowerofmagic);
        setUnlocalizedName("CompoundMolecularBattery");
        setRegistryName(powerofmagic.MODID, "compoundmolecularbattery");
}
	
}



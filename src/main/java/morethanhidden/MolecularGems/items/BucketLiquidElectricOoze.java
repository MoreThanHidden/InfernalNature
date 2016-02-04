package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class BucketLiquidElectricOoze extends ItemBucket {

	public BucketLiquidElectricOoze(Block block) {
		super(block);
	        setCreativeTab(MolecularGems.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidElectricOoze");
	        setContainerItem(Items.bucket);
	}

}

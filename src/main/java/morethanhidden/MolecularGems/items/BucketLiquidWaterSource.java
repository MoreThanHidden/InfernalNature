package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class BucketLiquidWaterSource extends ItemBucket {

	public BucketLiquidWaterSource(Block block) {
		super(block);
	        setCreativeTab(MolecularGems.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidWaterSOurce");
	        setContainerItem(Items.bucket);
	}

}

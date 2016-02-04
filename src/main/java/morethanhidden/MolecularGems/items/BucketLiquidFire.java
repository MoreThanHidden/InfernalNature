package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class BucketLiquidFire extends ItemBucket {

	public BucketLiquidFire(Block block) {
		super(block);
	        setCreativeTab(MolecularGems.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidFire");
	        setContainerItem(Items.bucket);
	}

}

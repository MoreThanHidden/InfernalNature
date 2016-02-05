package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class BucketItem extends ItemBucket {

	public BucketItem(Block block) {
		super(block);
	        setCreativeTab(MolecularGems.tabmoleculargems);
	        setUnlocalizedName("bucket_" + block.getUnlocalizedName().replace("tile.", ""));
	        setContainerItem(Items.bucket);
	}

}

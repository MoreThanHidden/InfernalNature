package morethanhidden.powerofmagic.items;

import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class BucketItem extends ItemBucket {

	public BucketItem(Block block) {
		super(block);
	        setCreativeTab(powerofmagic.tabpowerofmagic);
	        setUnlocalizedName("bucket_" + block.getUnlocalizedName().replace("tile.", ""));
	        setContainerItem(Items.BUCKET);
			setRegistryName(powerofmagic.MODID, "bucket_" + block.getUnlocalizedName().replace("tile.", ""));
	}

}

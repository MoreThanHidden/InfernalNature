package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class BucketLiquidMuddyOoze extends ItemBucket {

	public BucketLiquidMuddyOoze(Block block) {
		super(block);
	        setCreativeTab(MainRegistry.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidMuddyOoze");
	        setContainerItem(Items.bucket);
	        setTextureName("moleculargems:bucket_liquidMuddyOoze");
	}

}

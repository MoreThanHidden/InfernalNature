package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class BucketLiquidAquoticOoze extends ItemBucket {

	public BucketLiquidAquoticOoze(Block block) {
		super(block);
	        setCreativeTab(MainRegistry.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidAquoticOoze");
	        setContainerItem(Items.bucket);
	        setTextureName("moleculargems:bucket_liquidAquoticOoze");
	}

}

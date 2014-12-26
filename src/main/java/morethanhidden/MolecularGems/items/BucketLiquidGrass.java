package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class BucketLiquidGrass extends ItemBucket {

	public BucketLiquidGrass(Block block) {
		super(block);
	        setCreativeTab(MainRegistry.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidGrass");
	        setContainerItem(Items.bucket);
	        setTextureName("moleculargems:bucket_liquidGrass");
	}

}

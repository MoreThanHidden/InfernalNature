package morethanhidden.MolecularGems.items;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class BucketLiquidGrass extends ItemBucket {

	public BucketLiquidGrass(Block block) {
		super(block);
	        setCreativeTab(MolecularGems.tabmoleculargems);
	        setUnlocalizedName("BucketLiquidGrass");
	        setContainerItem(Items.bucket);
	}

}

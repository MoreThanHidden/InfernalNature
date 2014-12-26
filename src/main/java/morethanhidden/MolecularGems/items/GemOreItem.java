package morethanhidden.MolecularGems.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class GemOreItem extends ItemBlock {
	 
	    public GemOreItem(Block block) {
	 
	        super(block);
	        setHasSubtypes(true);
	    }	    
	    
	    @Override
	    public String getUnlocalizedName(ItemStack itemStack) {

	        String name;
	        switch(itemStack.getItemDamage()) {

	            case 0:
	                name = "ClinohumiteOre";
	                break;
	            case 1:
	                name = "SugiliteOre";
	                break;
	            case 2:
	                name = "JaditeOre";
	                break;
	            default:
	                name = "noMeta";
	        }
	        return getUnlocalizedName() + "." + name;
	    }
	    
	    @Override
	    public int getMetadata(int meta) {

	        return meta;
	    }
}

package morethanhidden.powerofmagic.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class GemBlockItem extends ItemBlock {
	 
	    public GemBlockItem(Block block) {
	 
	        super(block);
	        setHasSubtypes(true);
	    }	    
	    
	    @Override
	    public String getUnlocalizedName(ItemStack itemStack) {

	        String name;
	        switch(itemStack.getItemDamage()) {

	            case 0:
	                name = "yellowGemBlock";
	                break;
	            case 1:
	                name = "blueGemBlock";
	                break;
	            case 2:
	                name = "greenGemBlock";
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

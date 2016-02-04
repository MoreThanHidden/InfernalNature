package morethanhidden.MolecularGems.items;

import java.util.List;

import morethanhidden.MolecularGems.MolecularGems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class Gem extends Item{
	public static final String[] itemNames = new String[] {"gemYellow", "gemBlue", "gemGreen"};

	
	public Gem() {
		setHasSubtypes(true);
		maxStackSize = 64;
        setCreativeTab(MolecularGems.tabmoleculargems);
}

	int itemcount = 3;

	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, itemcount-1);
	         return super.getUnlocalizedName() + "." + itemNames[i];
	}
	
	@Override
	public void getSubItems(Item par1, CreativeTabs creativeTabs, List list)
	{
		         for (int j = 0; j < itemcount; ++j)
		         {
		                 list.add(new ItemStack(this, 1, j));
		         }
	}
	
	
}



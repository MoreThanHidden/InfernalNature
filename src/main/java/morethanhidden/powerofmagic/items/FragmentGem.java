package morethanhidden.powerofmagic.items;

import java.util.List;


import morethanhidden.powerofmagic.api.IModelRegister;
import morethanhidden.powerofmagic.powerofmagic;
import morethanhidden.powerofmagic.util.ModelHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FragmentGem extends Item implements IModelRegister {
	public static final String[] itemNames = new String[] {"gemOrangeF", "gemPurpleF", "gemGreenF"};
	
	public FragmentGem() {
		 super();
		setHasSubtypes(true);
		maxStackSize = 64;
        setCreativeTab(powerofmagic.tabpowerofmagic);
		setUnlocalizedName(itemNames[0]);
}

	int itemcount = 3;

	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, itemcount-1);
	         return itemNames[i];
	}
	
	@Override
		public void getSubItems(Item par1, CreativeTabs creativeTabs, List list)
		{
		         for (int j = 0; j < itemcount; ++j)
		         {
		                 list.add(new ItemStack(this, 1, j));
		         }
		}

    @Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		for (int j = 0; j < itemcount; ++j)
		{
			ModelHelper.registerItemModel(this, j, itemNames[j], "");
		}
	}

}



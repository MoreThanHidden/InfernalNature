package morethanhidden.powerofmagic.items;

import morethanhidden.MTHCore.api.IModelRegister;
import morethanhidden.powerofmagic.powerofmagic;
import morethanhidden.MTHCore.util.ModelHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Gem extends Item implements IModelRegister{
	public static final String[] itemNames = new String[] {"orange", "purple", "green", "orangef", "purplef", "greenf"};


	public Gem() {
		setHasSubtypes(true);
		maxStackSize = 64;
        setCreativeTab(powerofmagic.tabpowerofmagic);
		setUnlocalizedName("gem");
		setRegistryName("gem");
	}

	int itemcount = 6;

	public String getUnlocalizedName(ItemStack par1ItemStack)	{
	         int i = MathHelper.clamp(par1ItemStack.getItemDamage(), 0, itemcount-1);
	         return itemNames[i];
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for (int j = 0; j < itemcount; ++j)
		{
			subItems.add(new ItemStack(this, 1, j));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
        for (int j = 0; j < itemcount; ++j)
        {
            ModelHelper.registerItemModel(this, j, "gem", itemNames[j]);
        }
	}
	
	
}



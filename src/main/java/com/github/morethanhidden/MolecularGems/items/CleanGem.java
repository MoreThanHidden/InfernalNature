package com.github.morethanhidden.MolecularGems.items;

import java.util.List;

import com.github.morethanhidden.MolecularGems.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class CleanGem extends Item {
	public static final String[] itemNames = new String[] {"RedGem", "BlueGem", "GreenGem"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] item_icon;
	
	public CleanGem() {
		setHasSubtypes(true);
		maxStackSize = 64;
        setCreativeTab(MainRegistry.tabmoleculargems);
}

	int itemcount = 3;

	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, itemcount-1);
	         return super.getUnlocalizedName() + "." + itemNames[i];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
		public void getSubItems(Item par1, CreativeTabs creativeTabs, List list)
		{
		         for (int j = 0; j < itemcount; ++j)
		         {
		                 list.add(new ItemStack(this, 1, j));
		         }
		}
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
	         this.item_icon = new IIcon[itemNames.length];

	         for (int i = 0; i < itemNames.length; ++i)
	         {
	                 this.item_icon[i] = par1IconRegister.registerIcon("moleculargems:" + itemNames[i]);
	         }
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
	{
	         int j = MathHelper.clamp_int(par1, 0, itemcount-1);
	         return this.item_icon[j];
	}
	
	
}



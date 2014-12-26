package morethanhidden.MolecularGems.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class GemBlock extends Block {
	public static final String[] blockNames = new String[] {"ClinohumiteBlock", "SugiliteGemBlock", "JaditeBlock"};
		
	private IIcon[] block_icon;
	
	public GemBlock () {
		super(Material.rock);
		setBlockName("GemBlock");
		setCreativeTab(MainRegistry.tabmoleculargems);
	}

	int blockcount = 3;

	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, blockcount-1);
	         return super.getUnlocalizedName() + "." + blockNames[i];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item par1, CreativeTabs creativeTabs, List list)
		{
		         for (int j = 0; j < blockcount; ++j)
		         {
		                 list.add(new ItemStack(this, 1, j));
		         }
		}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	         this.block_icon = new IIcon[blockNames.length];

	         for (int i = 0; i < blockNames.length; ++i)
	         {
	                 this.block_icon[i] = par1IconRegister.registerIcon("moleculargems:" + blockNames[i]);
	         }
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
		int j = MathHelper.clamp_int(par2, 0, blockcount-1);
        return this.block_icon[j];
    }
	
}



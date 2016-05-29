package morethanhidden.powerofmagic.blocks;

import morethanhidden.powerofmagic.api.IModelRegister;
import morethanhidden.powerofmagic.powerofmagic;
import morethanhidden.powerofmagic.util.ModelHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GemBlock extends Block{
	
	public GemBlock (String uname) {
		super(Material.ROCK);
		setCreativeTab(powerofmagic.tabpowerofmagic);
        setUnlocalizedName(uname);
	}

    public String getUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }
}



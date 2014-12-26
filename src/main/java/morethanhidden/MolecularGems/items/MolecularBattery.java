package morethanhidden.MolecularGems.items;

import java.util.List;
import java.util.Random;

import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.ItemEnergyContainer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MolecularBattery extends ItemEnergyContainer {

	public MolecularBattery() {
        setMaxStackSize(1);
        setCreativeTab(MainRegistry.tabmoleculargems);
        setUnlocalizedName("MolecularBattery");
        setTextureName("moleculargems:MolecularBattery");
        setMaxReceive(MainRegistry.gemeratorEnergyAmt * 4);
        setCapacity(MainRegistry.gemeratorEnergyAmt * 4);
        setMaxDamage(0);
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int amnt = this.getEnergyStored(par1ItemStack);
		int CapacityEU = (int) (capacity / 4);
		int length = String.valueOf(amnt).length();
		int lengtheu = String.valueOf(amnt / 4).length();
		par3List.add("Stored:");
		if (length >= 7 && lengtheu >= 7){
			par3List.add(amnt / 4 / 1000000 + "M/" + CapacityEU / 1000000 + "M EU or " + amnt / 1000000 + "M/" + capacity / 1000000 + "M RF");
		}else if (length >= 7 && lengtheu < 7){  
        	par3List.add(amnt / 4 / 1000 + "K/" + CapacityEU / 1000000 + "M EU or " + (double) (amnt / 10000) / 100 + "M/" + capacity / 1000000 + "M RF");
		}else if (length < 4){  
        	par3List.add(amnt / 4 + "/" + CapacityEU / 1000000 + "M EU or " + amnt + "/" + capacity / 1000000 + "M RF");
		}else if (length < 7){  
        	par3List.add(amnt / 4 / 1000 + "K/" + CapacityEU / 1000000 + "M EU or " + amnt / 1000 + "K/" + capacity / 1000000 + "M RF");
		}
	}
	
	@Override
    public boolean showDurabilityBar(ItemStack itemStack) {
            return true;
    }
	
	@Override
    public double getDurabilityForDisplay(ItemStack itemStack) {
        double stored = this.getMaxEnergyStored(itemStack) - this.getEnergyStored(itemStack) + 1;
        double max = this.getMaxEnergyStored(itemStack) + 1;
        return stored / max;
    }
	
	
}

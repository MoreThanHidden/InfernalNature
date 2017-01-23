package morethanhidden.powerofmagic.registry;

import morethanhidden.powerofmagic.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    public static Block gemOre = new GemOre();
    public static Block gemCube = new GemCube();
    public static Block blockCable = new BlockCable("mage_cable");
    public static Block blockGemGreen = new GemBlock("blockgem_green");
    public static Block blockGemPurple = new GemBlock("blockgem_purple");
    public static Block blockGemOrange = new GemBlock("blockgem_orange");
    public static Block blockLiquidMana = new BlockLiquidMana(PMFluidRegistry.liquidMana, Material.WATER);
    public static Block blockLiquidGrass = new BlockLiquidGrass(PMFluidRegistry.liquidGrass, Material.WATER);
    public static Block blockLiquidFire = new BlockLiquidFire(PMFluidRegistry.liquidFire, Material.LAVA);
    public static Block blockLiquidWaterSource = new BlockLiquidWaterSource(PMFluidRegistry.liquidWaterSource, Material.WATER);

    public static void init() {
        registerBlock(gemOre);
        registerBlock(gemCube);
        registerBlock(blockCable);
        registerBlock(blockGemGreen);
        registerBlock(blockGemPurple);
        registerBlock(blockGemOrange);
        registerBlock(blockLiquidMana);
        registerBlock(blockLiquidFire);
        registerBlock(blockLiquidGrass);
        registerBlock(blockLiquidWaterSource);
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

}
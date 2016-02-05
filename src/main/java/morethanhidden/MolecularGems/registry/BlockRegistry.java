package morethanhidden.MolecularGems.registry;

import morethanhidden.MolecularGems.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    public static Block gemOre = new GemOre();
    public static Block gemBlock = new GemBlock();
    public static Block blockElectricOoze = new BlockLiquidElectricOoze(MGFluids.liquidElectricOoze, Material.water);
    public static Block blockLiquidGrass = new BlockLiquidGrass(MGFluids.liquidGrass, Material.water);
    public static Block blockLiquidFire = new BlockLiquidFire(MGFluids.liquidFire, Material.lava);
    public static Block blockLiquidWaterSource = new BlockLiquidWaterSource(MGFluids.liquidWaterSource, Material.water);

    public static void init() {
        registerBlock(gemOre);
        registerBlock(gemBlock);
        registerBlock(blockElectricOoze);
        registerBlock(blockLiquidFire);
        registerBlock(blockLiquidGrass);
        registerBlock(blockLiquidWaterSource);
    }

    private static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }

}
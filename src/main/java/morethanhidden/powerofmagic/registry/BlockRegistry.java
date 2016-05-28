package morethanhidden.powerofmagic.registry;

import morethanhidden.powerofmagic.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    public static Block gemOre = new GemOre();
    public static Block gemBlock = new GemBlock();
    public static Block blockElectricOoze = new BlockLiquidMana(MGFluids.liquidElectricOoze, Material.WATER);
    public static Block blockLiquidGrass = new BlockLiquidGrass(MGFluids.liquidGrass, Material.WATER);
    public static Block blockLiquidFire = new BlockLiquidFire(MGFluids.liquidFire, Material.LAVA);
    public static Block blockLiquidWaterSource = new BlockLiquidWaterSource(MGFluids.liquidWaterSource, Material.WATER);

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
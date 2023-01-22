package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockRegistry {

    public static Block gemOre = new GemOre();
    public static Block gemCube = new GemCube();
    public static Block blockGemGreen = new GemBlock();
    public static Block blockGemPurple = new GemBlock();
    public static Block blockGemOrange = new GemBlock();
    public static Block blockLiquidMana = new BlockLiquidMana(PMFluidRegistry.liquidMana, Material.WATER);
    public static Block blockLiquidGrass = new BlockLiquidGrass(PMFluidRegistry.liquidGrass, Material.WATER);
    public static Block blockLiquidFire = new BlockLiquidFire(PMFluidRegistry.liquidFire, Material.LAVA);
    public static Block blockLiquidWaterSource = new BlockLiquidWaterSource(PMFluidRegistry.liquidWaterSource, Material.WATER);

}
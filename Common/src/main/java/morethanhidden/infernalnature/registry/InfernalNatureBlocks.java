package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class InfernalNatureBlocks {

    public static Block gemOre = new GemOre(Block.Properties.of(Material.STONE));
    public static Block gemCube = new GemCube(Block.Properties.of(Material.STONE));
    public static Block blockGemGreen = new GemBlock(Block.Properties.of(Material.STONE));
    public static Block blockGemPurple = new GemBlock(Block.Properties.of(Material.STONE));
    public static Block blockGemOrange = new GemBlock(Block.Properties.of(Material.STONE));

}
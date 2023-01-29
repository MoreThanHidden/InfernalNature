package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.blocks.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.BiConsumer;

public class InfernalNatureBlocks {

    public static Block gemOre = new GemOre(Block.Properties.copy(Blocks.DIAMOND_ORE));
    public static Block gemDeepslate = new GemOre(Block.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE));
    public static Block blockGemNature = new GemBlock(Block.Properties.copy(Blocks.DIAMOND_BLOCK));
    public static Block blockGemMystic = new GemBlock(Block.Properties.copy(Blocks.DIAMOND_BLOCK));
    public static Block blockGemInfernal = new GemBlock(Block.Properties.copy(Blocks.DIAMOND_BLOCK));


    /**
     * Register Blocks
     */
    public static void registerBlocks(BiConsumer<Block, ResourceLocation> register) {
        register.accept(gemOre, new ResourceLocation(Constants.MOD_ID, "gem_ore"));
        register.accept(gemDeepslate, new ResourceLocation(Constants.MOD_ID, "gem_deepslate"));
        register.accept(blockGemNature, new ResourceLocation(Constants.MOD_ID, "nature_block"));
        register.accept(blockGemMystic, new ResourceLocation(Constants.MOD_ID, "mystic_block"));
        register.accept(blockGemInfernal, new ResourceLocation(Constants.MOD_ID, "infernal_block"));
    }

    /**
     * Register Block Items
     */
    public static void registerBlockItems(BiConsumer<Item, ResourceLocation> register) {
        register.accept(new BlockItem(gemOre, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "gem_ore"));
        register.accept(new BlockItem(gemDeepslate, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "gem_deepslate"));
        register.accept(new BlockItem(blockGemNature, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "nature_block"));
        register.accept(new BlockItem(blockGemMystic, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "mystic_block"));
        register.accept(new BlockItem(blockGemInfernal, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "infernal_block"));
    }


}
package morethanhidden.infernalnature.registry;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.blocks.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiConsumer;

/**
 * Block Registry for Infernal Nature
 * @author morethanhidden
 */
public class InfernalNatureBlocks {

    public static Block gemOre = new GemOre(Block.Properties.copy(Blocks.DIAMOND_ORE));
    public static Block gemDeepslate = new GemOre(Block.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE));
    public static Block blockGemNature = new GemBlock(Block.Properties.copy(Blocks.DIAMOND_BLOCK));
    public static Block blockGemMystic = new GemBlock(Block.Properties.copy(Blocks.DIAMOND_BLOCK));
    public static Block blockGemInfernal = new GemBlock(Block.Properties.copy(Blocks.DIAMOND_BLOCK));
    public static Block blockMysticCrafting = new MysticCraftingTable(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE));


    /**
     * Register Blocks
     * @param register - BiConsumer to register the blocks
     */
    public static void registerBlocks(BiConsumer<Block, ResourceLocation> register) {
        register.accept(gemOre, new ResourceLocation(Constants.MOD_ID, "gem_ore"));
        register.accept(gemDeepslate, new ResourceLocation(Constants.MOD_ID, "gem_deepslate"));
        register.accept(blockGemNature, new ResourceLocation(Constants.MOD_ID, "nature_block"));
        register.accept(blockGemMystic, new ResourceLocation(Constants.MOD_ID, "mystic_block"));
        register.accept(blockGemInfernal, new ResourceLocation(Constants.MOD_ID, "infernal_block"));
        register.accept(blockMysticCrafting, new ResourceLocation(Constants.MOD_ID, "mystic_crafting"));
    }

    /**
     * Register Block Items
     * @param register - BiConsumer to register the block items
     */
    public static void registerBlockItems(BiConsumer<Item, ResourceLocation> register) {
        register.accept(new BlockItem(gemOre, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "gem_ore"));
        register.accept(new BlockItem(gemDeepslate, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "gem_deepslate"));
        register.accept(new BlockItem(blockGemNature, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "nature_block"));
        register.accept(new BlockItem(blockGemMystic, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "mystic_block"));
        register.accept(new BlockItem(blockGemInfernal, new Item.Properties()), new ResourceLocation(Constants.MOD_ID, "infernal_block"));
    }


}
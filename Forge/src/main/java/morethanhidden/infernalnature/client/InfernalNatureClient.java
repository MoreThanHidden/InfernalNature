package morethanhidden.infernalnature.client;

import morethanhidden.infernalnature.Constants;
import morethanhidden.infernalnature.client.colours.WandColour;
import morethanhidden.infernalnature.client.renderers.EmissiveBakedModel;
import morethanhidden.infernalnature.client.screen.MysticCraftingScreen;
import morethanhidden.infernalnature.inventory.MysticCraftingMenu;
import morethanhidden.infernalnature.registry.InfernalNatureItems;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

/**
 * Forge Client Event Handler
 * @author morethanhidden
 */
@Mod.EventBusSubscriber(Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class InfernalNatureClient {

    /**
     * Register the emissive models
     * @param event Model Bake Event
     */
    @SubscribeEvent
    public void onModelBakeEvent(ModelEvent.ModifyBakingResult event) {
        String[] types = {"gem_ore", "gem_deepslate"};
        for (String type : types) {
            // Use Baked Model for Emissive Ore
            BakedModel baseModel = event.getModels().get(new ModelResourceLocation("infernalnature", type, ""));
            BakedModel emissiveModel = new EmissiveBakedModel(baseModel) {
                @Override
                public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data) {
                    return baseModel.getRenderTypes(state, rand, data);
                }
            };
            // Replace the model for the ore
            event.getModels().put(new ModelResourceLocation("infernalnature", type, ""), emissiveModel);
            event.getModels().put(new ModelResourceLocation("infernalnature", type, "inventory"), emissiveModel);
        }
    }

    public static final RegistryObject<MenuType<MysticCraftingMenu>> MYSTIC_CRAFTING;

    static  {
        DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "mystic_crafting");
        MYSTIC_CRAFTING = MENUS.register("mystic_crafting", () -> new MenuType<>(MysticCraftingMenu::new));
        MENUS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    /**
     * Register Screens
     * @param event Client Setup Event
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Register the Mystic Crafting Screen
        MenuScreens.register(MYSTIC_CRAFTING.get(), MysticCraftingScreen::new);
    }

    /**
     * Register Item Color Handlers
     * @param event Item Color Handler Event
     */
    @SubscribeEvent
    public void onItemColorHandlerEvent(RegisterColorHandlersEvent.Item event) {
        // Register the Wand Color Handler
        event.register(new WandColour(), InfernalNatureItems.crude_wand);
    }

}

package morethanhidden.infernalnature;

import morethanhidden.infernalnature.client.ClientProxy;
import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
	public class InfernalNature {
	        public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	        
	        //Creative tab
	        public static CreativeModeTab tabinfernalnature;

			@SubscribeEvent
			public void onRegisterCreativeModeTabs(CreativeModeTabEvent.Register event) {
 				tabinfernalnature = event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "infernalnature"), (builder) -> builder.title(Component.translatable("itemGroup.infernalnature")).icon(() -> new ItemStack(InfernalNatureFluids.LIQUID_FIRE_BUCKET)));
			}

			@SubscribeEvent
			public void creativeTabEvent(CreativeModeTabEvent.BuildContents event) {
				if(event.getTab() == tabinfernalnature) {
					//event.accept(InfernalNatureItems.infernalGem);
					//event.accept(InfernalNatureItems.natureGem);
					//event.accept(InfernalNatureItems.mysticGem);
					//event.accept(InfernalNatureItems.infernalFragment);
					//event.accept(InfernalNatureItems.natureFragment);
					//event.accept(InfernalNatureItems.mysticFragment);
					event.accept(InfernalNatureFluids.LIQUID_FIRE_BUCKET);
					//event.accept(InfernalNatureFluids.LIQUID_GRASS_BUCKET);
					//event.accept(InfernalNatureFluids.LIQUID_WATERSOURCE_BUCKET);
					//event.accept(InfernalNatureFluids.LIQUID_MANA_BUCKET);
				}
			}

			public InfernalNature(){
				//MinecraftForge.EVENT_BUS.register(new CraftingHandler());
				//MinecraftForge.EVENT_BUS.register(new GemOnMineEvent());
				FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
				addListener(ForgeRegistries.FLUIDS.getRegistryKey(), InfernalNatureFluids::registerFluid);
				addListener(ForgeRegistries.BLOCKS.getRegistryKey(), InfernalNatureFluids::registerBlock);
				addListener(ForgeRegistries.ITEMS.getRegistryKey(), InfernalNatureFluids::registerItem);
				proxy.registerRenderers();

	        }

			private static <T> void addListener(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> consumer) {
				FMLJavaModLoadingContext.get().getModEventBus().addListener((RegisterEvent event) -> {
					if (registry.equals(event.getRegistryKey())) {
						consumer.accept((typeObj, resLocation) -> event.register(registry, resLocation, () -> typeObj));
					}
				});
			}

			@SubscribeEvent
			public void setup(FMLCommonSetupEvent event) {
				//MolecularMobs.mainRegistry();
			}
	        
	}

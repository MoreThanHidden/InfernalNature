package morethanhidden.infernalnature;

import morethanhidden.infernalnature.fluids.InfernalNatureFluidTypes;
import morethanhidden.infernalnature.registry.InfernalNatureBlocks;
import morethanhidden.infernalnature.registry.InfernalNatureFluids;
import morethanhidden.infernalnature.registry.InfernalNatureItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class InfernalNature {
	//Creative tab
	public static CreativeModeTab tabinfernalnature;

	@SubscribeEvent
	public void onRegisterCreativeModeTabs(CreativeModeTabEvent.Register event) {
		tabinfernalnature = event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "infernalnature"), (builder) -> builder.title(Component.translatable("itemGroup.infernalnature")).icon(() -> new ItemStack(InfernalNatureFluids.LIQUID_FIRE_BUCKET)));
	}

	@SubscribeEvent
	public void creativeTabEvent(CreativeModeTabEvent.BuildContents event) {
		if(event.getTab() == tabinfernalnature) {
			event.accept(InfernalNatureFluids.LIQUID_FIRE_BUCKET);
			event.accept(InfernalNatureFluids.LIQUID_GRASS_BUCKET);
			event.accept(InfernalNatureFluids.LIQUID_WATERSOURCE_BUCKET);
			event.accept(InfernalNatureBlocks.blockGemInfernal);
			event.accept(InfernalNatureBlocks.blockGemNature);
			event.accept(InfernalNatureBlocks.blockGemMystic);
			event.accept(InfernalNatureBlocks.gemOre);
			event.accept(InfernalNatureBlocks.gemDeepslate);
			event.accept(InfernalNatureItems.infernalGem);
			event.accept(InfernalNatureItems.natureGem);
			event.accept(InfernalNatureItems.mysticGem);
			event.accept(InfernalNatureItems.infernalFragment);
			event.accept(InfernalNatureItems.natureFragment);
			event.accept(InfernalNatureItems.mysticFragment);
		}
	}

	public InfernalNature(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterCreativeModeTabs);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::creativeTabEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(InfernalNatureFluidTypes::registerFluidTypes);
		addListener(ForgeRegistries.FLUIDS.getRegistryKey(), InfernalNatureFluids::registerFluid);
		addListener(ForgeRegistries.BLOCKS.getRegistryKey(), InfernalNatureFluids::registerBlock);
		addListener(ForgeRegistries.ITEMS.getRegistryKey(), InfernalNatureFluids::registerItem);
		addListener(ForgeRegistries.BLOCKS.getRegistryKey(), InfernalNatureBlocks::registerBlocks);
		addListener(ForgeRegistries.ITEMS.getRegistryKey(), InfernalNatureBlocks::registerBlockItems);
		addListener(ForgeRegistries.ITEMS.getRegistryKey(), InfernalNatureItems::registerItems);

	}

	private static <T> void addListener(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> consumer) {
		FMLJavaModLoadingContext.get().getModEventBus().addListener((RegisterEvent event) -> {
			if (registry.equals(event.getRegistryKey())) {
				consumer.accept((typeObj, resLocation) -> event.register(registry, resLocation, () -> typeObj));
			}
		});
	}

}
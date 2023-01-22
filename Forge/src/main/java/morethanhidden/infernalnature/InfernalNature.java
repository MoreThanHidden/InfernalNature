package morethanhidden.infernalnature;

import morethanhidden.infernalnature.client.ClientProxy;
import morethanhidden.infernalnature.handler.CraftingHandler;
import morethanhidden.infernalnature.handler.GemOnMineEvent;
import morethanhidden.infernalnature.mob.MolecularMobs;
import morethanhidden.infernalnature.registry.AchievementRegistry;
import morethanhidden.infernalnature.registry.BlockRegistry;
import morethanhidden.infernalnature.registry.ItemRegistry;
import morethanhidden.infernalnature.registry.PMFluidRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Constants.MOD_ID)
	public class InfernalNature {
	        public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	        
	        //Creative tab
	        public static CreativeModeTab tabinfernalnature;

			@SubscribeEvent
			public void onRegisterCreativeModeTabs(CreativeModeTabEvent.Register event) {
 				tabinfernalnature = event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "infernalnature"), (builder) -> builder.title(Component.translatable("itemGroup.infernalnature")).icon(() -> PMFluidRegistry.bucketMana));
			}

			@SubscribeEvent
			public void creativeTabEvent(CreativeModeTabEvent.BuildContents event) {
				if(event.getTab() == tabinfernalnature) {
					event.accept(ItemRegistry.infernalGem);
					event.accept(ItemRegistry.natureGem);
					event.accept(ItemRegistry.mysticGem);
					event.accept(ItemRegistry.infernalFragment);
					event.accept(ItemRegistry.natureFragment);
					event.accept(ItemRegistry.mysticFragment);
					event.accept(PMFluidRegistry.bucketMana);
					event.accept(PMFluidRegistry.bucketFire);
					event.accept(PMFluidRegistry.bucketGrass);
					event.accept(PMFluidRegistry.bucketWaterSource);
				}
			}

			public InfernalNature(){

				MinecraftForge.EVENT_BUS.register(new CraftingHandler());
				MinecraftForge.EVENT_BUS.register(new GemOnMineEvent());

				PMFluidRegistry.init();
				BlockRegistry.init();
				AchievementRegistry.init();

				proxy.registerRenderers();

	        }

			@SubscribeEvent
			public void setup(FMLCommonSetupEvent event) {
				MolecularMobs.mainRegistry();
	        }
	        
	}

package morethanhidden.infernalnature;

import morethanhidden.infernalnature.blocks.tiles.TileCable;
import morethanhidden.infernalnature.handler.CraftingHandler;
import morethanhidden.infernalnature.handler.GemOnMineEvent;
import morethanhidden.infernalnature.mob.MolecularMobs;
import morethanhidden.infernalnature.registry.AchievementRegistry;
import morethanhidden.infernalnature.registry.BlockRegistry;
import morethanhidden.infernalnature.registry.ItemRegistry;
import morethanhidden.infernalnature.registry.PMFluidRegistry;
import morethanhidden.infernalnature.world.MolecularWorld;
import morethanhidden.infernalnature.world.WorldGenMoleculer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

	@Mod(Constants.MOD_ID)
	public class InfernalNature {

			public static String MODID = "infernalnature";

			public static int config_gemrate = 7;
			public static boolean ShockingLiquid = true;

	        @SidedProxy(clientSide="morethanhidden.infernalnature.Client.ClientProxy", serverSide="morethanhidden.infernalnature.common")
	        public static common proxy;
	        
	        //Creative tab for my mod
	        public static CreativeTabs tabpowerofmagic = new CreativeTabs("Infernal Nature") {
	            @Override
	            @SideOnly(Side.CLIENT)
	            public ItemStack getTabIconItem() {
	                return PMFluidRegistry.bucketMana;
	            }
	        };

			static {
				FluidRegistry.enableUniversalBucket();
			}

	        @Mod.EventHandler
	        public void preInit(FMLPreInitializationEvent event) {

	            FMLCommonHandler.instance().bus().register(new CraftingHandler());
	            FMLCommonHandler.instance().bus().register(new GemOnMineEvent());

				PMFluidRegistry.init();
				BlockRegistry.init();
				ItemRegistry.init();
				AchievementRegistry.init();

				GameRegistry.registerTileEntity(TileCable.class, "tilecable");

				proxy.registerRenderers();

	        }
	        
	        @Mod.EventHandler
	        public void load(FMLInitializationEvent event) {

				GameRegistry.registerWorldGenerator(new WorldGenMoleculer(), 10);

				MolecularWorld.mainRegistry();
				MolecularMobs.mainRegistry();

	        }
	        
	}

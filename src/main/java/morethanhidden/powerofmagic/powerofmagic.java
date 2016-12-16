package morethanhidden.powerofmagic;

import morethanhidden.powerofmagic.blocks.tiles.TileCable;
import morethanhidden.powerofmagic.handler.CraftingHandler;
import morethanhidden.powerofmagic.handler.GemOnMineEvent;
import morethanhidden.powerofmagic.mob.MolecularMobs;
import morethanhidden.powerofmagic.registry.AchievementRegistry;
import morethanhidden.powerofmagic.registry.BlockRegistry;
import morethanhidden.powerofmagic.registry.ItemRegistry;
import morethanhidden.powerofmagic.registry.PMFluidRegistry;
import morethanhidden.powerofmagic.world.MolecularWorld;
import morethanhidden.powerofmagic.world.WorldGenMoleculer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

	@Mod(modid="powerofmagic", name="Power Of Magic", version="0.2", dependencies = "required-after:mthcore")
	public class powerofmagic {

			public static String MODID = "powerofmagic";

			public static int config_gemrate = 7;
			public static boolean ShockingLiquid = true;

	        @Mod.Instance(value = "powerofmagic")
	        public static powerofmagic instance;

	        @SidedProxy(clientSide="morethanhidden.powerofmagic.Client.ClientProxy", serverSide="morethanhidden.powerofmagic.common")
	        public static common proxy;
	        
	        //Creative tab for my mod
	        public static CreativeTabs tabpowerofmagic = new CreativeTabs("Power Of Magic") {
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

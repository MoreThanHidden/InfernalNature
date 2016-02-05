package morethanhidden.MolecularGems;

	import morethanhidden.MolecularGems.handler.BucketHandler;
	import morethanhidden.MolecularGems.handler.CraftingHandler;
	import morethanhidden.MolecularGems.handler.GemOnMineEvent;
	import morethanhidden.MolecularGems.mob.MolecularMobs;
	import morethanhidden.MolecularGems.registry.AchievementRegistry;
	import morethanhidden.MolecularGems.registry.BlockRegistry;
	import morethanhidden.MolecularGems.registry.ItemRegistry;
	import morethanhidden.MolecularGems.registry.MGFluids;
	import morethanhidden.MolecularGems.world.MolecularWorld;
	import morethanhidden.MolecularGems.world.WorldGenMoleculer;
	import net.minecraft.creativetab.CreativeTabs;
	import net.minecraft.init.Items;
	import net.minecraft.item.Item;
	import net.minecraftforge.common.MinecraftForge;
	import net.minecraftforge.fml.common.FMLCommonHandler;
	import net.minecraftforge.fml.common.Mod;
	import net.minecraftforge.fml.common.SidedProxy;
	import net.minecraftforge.fml.common.event.FMLInitializationEvent;
	import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
	import net.minecraftforge.fml.common.registry.GameRegistry;
	import net.minecraftforge.fml.relauncher.Side;
	import net.minecraftforge.fml.relauncher.SideOnly;
	import net.minecraftforge.oredict.OreDictionary;

	@Mod(modid="moleculargems", name="Molecular Gems", version="0.1")
	public class MolecularGems {

			public static String MODID = "moleculargems";

			public static int config_gemrate = 7;
			public static boolean ShockingLiquid = true;

	        @Mod.Instance(value = "moleculargems")
	        public static MolecularGems instance;

	        @SidedProxy(clientSide="morethanhidden.MolecularGems.Client.ClientProxy", serverSide="morethanhidden.MolecularGems.common")
	        public static common proxy;
	        
	        //Creative tab for my mod
	        public static CreativeTabs tabmoleculargems = new CreativeTabs("Molecular Gems") {
	            @Override
	            @SideOnly(Side.CLIENT)
	            public Item getTabIconItem() {
	                return Items.book;
	            }
	        };
	        
	        @Mod.EventHandler
	        public void preInit(FMLPreInitializationEvent event) {

	            GameRegistry.registerWorldGenerator(new WorldGenMoleculer(), 1);

	            MinecraftForge.EVENT_BUS.register(new BucketHandler());
	            FMLCommonHandler.instance().bus().register(new CraftingHandler());
	            FMLCommonHandler.instance().bus().register(new GemOnMineEvent());

				MGFluids.init();
				BlockRegistry.init();
				ItemRegistry.init();
				AchievementRegistry.init();

				proxy.registerRenderers();

	        }
	        
	        @Mod.EventHandler
	        public void load(FMLInitializationEvent event) {

				MolecularWorld.mainRegistry();
				MolecularMobs.mainRegistry();

	            oreRegistration();
	        }

	        
	        public static void oreRegistration()
	        {
	                OreDictionary.registerOre("bucketElectricOoze", ItemRegistry.bucketliquidElectricOoze);
	                OreDictionary.registerOre("bucketLiquidGrass", ItemRegistry.bucketliquidGrass);
	                OreDictionary.registerOre("bucketLiquidFire", ItemRegistry.bucketliquidFire);
	        }
	        
	}

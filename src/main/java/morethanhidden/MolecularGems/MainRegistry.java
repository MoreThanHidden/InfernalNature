package morethanhidden.MolecularGems;

	import morethanhidden.MolecularGems.Client.ClientProxy;
import morethanhidden.MolecularGems.blocks.BlockLiquidWaterSource;
import morethanhidden.MolecularGems.blocks.BlockLiquidElectricOoze;
import morethanhidden.MolecularGems.blocks.BlockLiquidFire;
import morethanhidden.MolecularGems.blocks.BlockLiquidGrass;
import morethanhidden.MolecularGems.blocks.GemBlock;
import morethanhidden.MolecularGems.blocks.GemOre;
import morethanhidden.MolecularGems.blocks.MolecularAdaptor;
import morethanhidden.MolecularGems.handler.BucketHandler;
import morethanhidden.MolecularGems.handler.CraftingHandler;
import morethanhidden.MolecularGems.handler.GemOnMineEvent;
import morethanhidden.MolecularGems.items.FragmentGem;
import morethanhidden.MolecularGems.items.GemOreItem;
import morethanhidden.MolecularGems.items.MolecularBattery;
import morethanhidden.MolecularGems.items.BucketLiquidWaterSource;
import morethanhidden.MolecularGems.items.BucketLiquidElectricOoze;
import morethanhidden.MolecularGems.items.BucketLiquidFire;
import morethanhidden.MolecularGems.items.BucketLiquidGrass;
import morethanhidden.MolecularGems.items.Gem;
import morethanhidden.MolecularGems.items.RefinedGem;
import morethanhidden.MolecularGems.items.GemBlockItem;
import morethanhidden.MolecularGems.items.CompoundItem;
import morethanhidden.MolecularGems.mob.MolecularMobs;
import morethanhidden.MolecularGems.world.MolecularWorld;
import morethanhidden.MolecularGems.world.WorldGenMoleculer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
	//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
	//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
	//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
	//import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	@Mod(modid="moleculargems", name="Molecular Gems", version="0.2.0")
	//@NetworkMod(clientSideRequired=true) // not used in 1.7
	public class MainRegistry {
			//Items I have Added

			public static Item regularGem;
			public static Item refinedGem;
			public static Item fragmentGem;
			public static Item molecularBattery;
			public static Item compoundBattery;
			public static Block gemOre;
			public static Block gemBlock;
			public static Block molecularAdaptor;
			public static Block molecularAdaptorEmpty;
			public static Block blockElectricOooze;
			public static Fluid liquidElectricOoze = new Fluid("liquidelectricooze");
			public static Item bucketliquidElectricOoze;
			public static Block blockLiquidGrass;
			public static Fluid liquidGrass = new Fluid("liquidgrass");
			public static Item bucketliquidGrass;
			public static Block blockLiquidFire;
			public static Fluid liquidFire = new Fluid("liquidfire");
			public static Item bucketliquidWaterSource;
			public static Block blockLiquidWaterSource;
			public static Fluid liquidWaterSource = new Fluid("liquidwatersource");
			public static Item bucketliquidFire;
			public static Achievement electrifying;
			public static Achievement minegem;
			public static Achievement stickyooze;
			public static Achievement agemerator;
			
			public static int gemeratorEnergyAmt = 1000000;
			public static int config_gemrate = 7;
			public static boolean ShockingLiquid = true;
			
			
	        // The instance of your mod that Forge uses.
	        @Instance(value = "moleculargems")
	        public static MainRegistry instance;
	        
	        // Says where the client and server 'proxy' code is loaded.
	        @SidedProxy(clientSide="morethanhidden.MolecularGems.Client.ClientProxy", serverSide="morethanhidden.MolecularGems.common")
	        public static common proxy;
	        
	        @EventHandler // used in 1.6.2
	        //@PreInit    // used in 1.5.2
	        public void preLoad(FMLPreInitializationEvent PreEvent) {
	        MolecularWorld.mainRegistry();
	        MolecularMobs.mainRegistry();
	        }
	        
	        //Creative tab for my mod
	        public static CreativeTabs tabmoleculargems = new CreativeTabs("Molecular Gems") {
	            @Override
	            @SideOnly(Side.CLIENT)
	            public Item getTabIconItem() {
	                return Item.getItemFromBlock(molecularAdaptor);
	            }
	        };
	        
	        @EventHandler // used in 1.6.2
	        //@PreInit    // used in 1.5.2
	        public void preInit(FMLPreInitializationEvent event) {  
	        	
	        	
	        	FluidRegistry.registerFluid(liquidElectricOoze);
	        	blockElectricOooze = new BlockLiquidElectricOoze(liquidElectricOoze, Material.water).setBlockName("liquidelectricooze");
	        	GameRegistry.registerBlock(blockElectricOooze, "moleculargems" + "_" + blockElectricOooze.getUnlocalizedName().substring(5));
	        	liquidElectricOoze.setUnlocalizedName(blockElectricOooze.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidWaterSource);
	        	blockLiquidWaterSource = new BlockLiquidWaterSource(liquidWaterSource, Material.water).setBlockName("liquidwatersource");
	        	GameRegistry.registerBlock(blockLiquidWaterSource, "moleculargems" + "_" + blockLiquidWaterSource.getUnlocalizedName().substring(5));
	        	liquidWaterSource.setUnlocalizedName(blockLiquidWaterSource.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidGrass);
	        	blockLiquidGrass = new BlockLiquidGrass(liquidGrass, Material.water).setBlockName("liquidgrass");
	        	GameRegistry.registerBlock(blockLiquidGrass, "moleculargems" + "_" + blockLiquidGrass.getUnlocalizedName().substring(5));
	        	liquidGrass.setUnlocalizedName(blockLiquidGrass.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidFire);
	        	blockLiquidFire = new BlockLiquidFire(liquidFire, Material.lava).setBlockName("liquidfire");
	        	GameRegistry.registerBlock(blockLiquidFire, "moleculargems" + "_" + blockLiquidFire.getUnlocalizedName().substring(5));
	        	liquidFire.setUnlocalizedName(blockLiquidFire.getUnlocalizedName());
	        	
	        	bucketliquidElectricOoze = new BucketLiquidElectricOoze(blockElectricOooze);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidelectricooze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidElectricOoze), new ItemStack(Items.bucket));
	        	
	        	bucketliquidWaterSource = new BucketLiquidWaterSource(blockLiquidWaterSource);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidwatersource", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidWaterSource), new ItemStack(Items.bucket));
	        	
	        	bucketliquidGrass = new BucketLiquidGrass(blockLiquidGrass);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidgrass", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidGrass), new ItemStack(Items.bucket));
	        	
	        	bucketliquidFire = new BucketLiquidFire(blockLiquidFire);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidfire", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidFire), new ItemStack(Items.bucket));
	        	
	        	regularGem = new Gem().setUnlocalizedName("RegularGem");
	        	refinedGem = new RefinedGem().setUnlocalizedName("RefinedGem");
	        	fragmentGem = new FragmentGem().setUnlocalizedName("FragmentGem");
	        	compoundBattery = new CompoundItem();
	        	gemOre = new GemOre();
	        	gemBlock = new GemBlock();
	        	molecularAdaptor = new MolecularAdaptor(false);
	        	molecularAdaptorEmpty = new MolecularAdaptor(true);
	        	molecularBattery = new MolecularBattery();
	        	
	            GameRegistry.registerItem(regularGem, regularGem.getUnlocalizedName());
	            GameRegistry.registerItem(refinedGem, refinedGem.getUnlocalizedName());
	            GameRegistry.registerItem(fragmentGem, fragmentGem.getUnlocalizedName());
	            GameRegistry.registerItem(compoundBattery, compoundBattery.getUnlocalizedName());
	            GameRegistry.registerItem(molecularBattery, molecularBattery.getUnlocalizedName());
	            GameRegistry.registerBlock(gemOre, GemOreItem.class, "gemOre");
	            GameRegistry.registerBlock(gemBlock, GemBlockItem.class, "gemBlock");
	            GameRegistry.registerBlock(molecularAdaptor, "Gemerator");
	            GameRegistry.registerBlock(molecularAdaptorEmpty, "GemeratorEmpty");
	            GameRegistry.registerWorldGenerator(new WorldGenMoleculer(), 1);
	            
	            GameRegistry.registerItem(bucketliquidElectricOoze, bucketliquidElectricOoze.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidWaterSource, bucketliquidWaterSource.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidGrass, bucketliquidGrass.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidFire, bucketliquidFire.getUnlocalizedName());
	            
	            GameRegistry.registerTileEntity(TileMolecularAdaptor.class, "TileGemerator");
	                    
	            MinecraftForge.EVENT_BUS.register(new BucketHandler());
	            FMLCommonHandler.instance().bus().register(new CraftingHandler());
	            FMLCommonHandler.instance().bus().register(new GemOnMineEvent());
	            
	        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	        	
	        	minegem = new Achievement("achievement.minegem", "minegem", 0, 0, gemOre, (Achievement)null).initIndependentStat().registerStat();
	        	stickyooze  = new Achievement("achievement.stickyooze", "stickyooze", 2, 1, bucketliquidGrass, minegem).registerStat();
	        	agemerator  = new Achievement("achievement.agemerator", "agemerator", 2, 2, molecularAdaptor, minegem).registerStat();
	        	if (ShockingLiquid = true){
	        	electrifying = new Achievement("achievement.electrifying", "electrifying", 2, 3, bucketliquidElectricOoze, minegem).registerStat();
	        	}
	        	
	        	AchievementPage.registerAchievementPage(new AchievementPage("Molecular Gems", new Achievement[]{minegem, electrifying, stickyooze, agemerator}));
	        	
	        	config.load();

	        	// Configuration goes here.
	        	gemeratorEnergyAmt = config.get(config.CATEGORY_GENERAL, "Gemerator Energy Amount", 1000000).getInt();
	        	ShockingLiquid = config.get(config.CATEGORY_GENERAL, "Lightning in ElectricOoze", true).getBoolean();
	        	config_gemrate = config.get(config.CATEGORY_GENERAL, "Spawn Rate of Gem Ores", 7).getInt();
	        	
	        	config.save();
	            
	        }
	        
	        @EventHandler // used in 1.6.2
	        //@Init       // used in 1.5.2
	        public void load(FMLInitializationEvent event) {
	        	
      	       	proxy.registerRenderers();
	        	addNames();
	            oreRegistration();
	            addOreRecipes();
	                 
	        }
	        public static void addNames()
	        {
	                LanguageRegistry.addName(molecularBattery, "Molecular Battery");
	                LanguageRegistry.addName(molecularAdaptor, "Molecular Adaptor");
	                LanguageRegistry.addName(bucketliquidElectricOoze, "Electric Ooze Bucket");
	                LanguageRegistry.addName(blockElectricOooze, "Electric Ooze");
	                LanguageRegistry.addName(bucketliquidWaterSource, "Liquid Water Source Bucket");
	                LanguageRegistry.addName(bucketliquidGrass, "Liquid Grass Bucket");
	                LanguageRegistry.addName(bucketliquidFire, "Liquid Fire Bucket");
		            LanguageRegistry.addName(blockLiquidFire, "Liquid Fire");
	                LanguageRegistry.addName(blockLiquidGrass, "Liquid Grass");
	                LanguageRegistry.addName(blockLiquidWaterSource, "Liquid Water Source");
	                LanguageRegistry.addName(compoundBattery, "Molecular Battery Compound");
	                LanguageRegistry.addName(new ItemStack(regularGem, 1, 0), "Clinohumite");
	                LanguageRegistry.addName(new ItemStack(regularGem, 1, 1), "Sugilite");
	                LanguageRegistry.addName(new ItemStack(regularGem, 1, 2), "Jadite");
	                LanguageRegistry.addName(new ItemStack(refinedGem, 1, 0), "Refined Clinohumite");
	                LanguageRegistry.addName(new ItemStack(refinedGem, 1, 1), "Refined Sugilite");
	                LanguageRegistry.addName(new ItemStack(refinedGem, 1, 2), "Refined Jadite");
	                LanguageRegistry.addName(new ItemStack(gemBlock, 1, 0), "Clinohumite Block");
	                LanguageRegistry.addName(new ItemStack(gemBlock, 1, 1), "Sugilite Block");
	                LanguageRegistry.addName(new ItemStack(gemBlock, 1, 2), "Jadite Block");
	                LanguageRegistry.addName(new ItemStack(gemOre, 1, 0), "Clinohumite Ore");
	                LanguageRegistry.addName(new ItemStack(gemOre, 1, 1), "Sugilite Ore");
	                LanguageRegistry.addName(new ItemStack(gemOre, 1, 2), "Jadite Ore");
	                
	                LanguageRegistry.instance().addStringLocalization("achievement.minegem", "en_US", "Oooh Shiny!");
	                LanguageRegistry.instance().addStringLocalization("achievement.electrifying", "en_US", "A Electrifying Experience!");
	                LanguageRegistry.instance().addStringLocalization("achievement.minegem.desc", "en_US", "Mine a Gem Ore");
	                LanguageRegistry.instance().addStringLocalization("achievement.electrifying.desc", "en_US", "Step into some Electric Ooze");
	                LanguageRegistry.instance().addStringLocalization("itemGroup.Molecular Gems", "en_US", "Molecular Gems");
	                LanguageRegistry.instance().addStringLocalization("entity.Ghost of Ancients.name", "Ghost of the Ancients");
	                LanguageRegistry.instance().addStringLocalization("achievement.stickyooze", "en_US", "Thats Sticky! (for now)");
	                LanguageRegistry.instance().addStringLocalization("achievement.stickyooze.desc", "en_US", "Craft a bucket of Ooze");
	                LanguageRegistry.instance().addStringLocalization("achievement.agemerator", "en_US", "Hmm, a Power Creation Device");
	                LanguageRegistry.instance().addStringLocalization("achievement.agemerator.desc", "en_US", "Craft a Gemerator");
	        
	        }
	        
	        public static void oreRegistration()
	        {
	                //1.3.2 OreDictionary.registerOre("ingotCopper", new ItemStack(ingotCopper));
	                //1.6.4
                	OreDictionary.registerOre("oreClinohumite", new ItemStack(gemOre, 1, 0));
                	OreDictionary.registerOre("oreSugilite", new ItemStack(gemOre, 1, 1));
                	OreDictionary.registerOre("oreJadite", new ItemStack(gemOre, 1, 2));
	                OreDictionary.registerOre("gemClinohumite", new ItemStack(regularGem, 1, 0));
	                OreDictionary.registerOre("gemSugilite", new ItemStack(regularGem, 1, 1));
	                OreDictionary.registerOre("gemJadite", new ItemStack(regularGem, 1, 2));
	                OreDictionary.registerOre("blockClinohumite", new ItemStack(gemBlock, 1, 0));
	                OreDictionary.registerOre("blockSugilite", new ItemStack(gemBlock, 1, 1));
	                OreDictionary.registerOre("blockJadite", new ItemStack(gemBlock, 1, 2));
	                OreDictionary.registerOre("gemMolecular", new ItemStack(regularGem, 1, 0));
	                OreDictionary.registerOre("gemMolecular", new ItemStack(regularGem, 1, 1));
	                OreDictionary.registerOre("gemMolecular", new ItemStack(regularGem, 1, 2));
	                OreDictionary.registerOre("batteryMolecular", molecularBattery);
	                OreDictionary.registerOre("bucketElectricOoze", bucketliquidElectricOoze);
	                OreDictionary.registerOre("bucketLiquidGrass", bucketliquidGrass);
	                OreDictionary.registerOre("bucketLiquidFire", bucketliquidFire);
	                OreDictionary.registerOre("bucketLiquidWaterSource", bucketliquidWaterSource);
	        }
	        public static void addOreRecipes()
	        {
	        	
	                GameRegistry.addRecipe(new ShapedOreRecipe(molecularAdaptorEmpty, true, new Object[]{
	                		"DRD","BIG","DPD",
	                		Character.valueOf('D'), "gemDiamond",
	                		Character.valueOf('R'), "gemClinohumite",
	                		Character.valueOf('B'), "gemSugilite",
	                		Character.valueOf('G'), "gemJadite",
	                		Character.valueOf('P'), Blocks.piston,
	                		Character.valueOf('I'), "blockIron"
	                		}));
	                	                
	                GameRegistry.addRecipe(new ShapedOreRecipe(compoundBattery, true, new Object[]{
	                		"EEE","ECE","EEE",
	                		Character.valueOf('C'), "blockCoal",
	                		Character.valueOf('E'), "gemMolecular",
	                		}));
	                
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidElectricOoze, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.bucket,
	                		Character.valueOf('E'), "gemAscended",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidFire, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.bucket,
	                		Character.valueOf('E'), "gemClinohumite",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidGrass, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.bucket,
	                		Character.valueOf('E'), "gemJadite",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidWaterSource, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.bucket,
	                		Character.valueOf('E'), "gemSugilite",
	                		}));
	                
	                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(gemBlock, 1, 0), true, new Object[]{
	                		"EEE","EEE","EEE",
	                		Character.valueOf('E'), "gemClinohumite",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(gemBlock, 1, 1), true, new Object[]{
	                		"EEE","EEE","EEE",
	                		Character.valueOf('E'), "gemSugilite",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(gemBlock, 1, 2), true, new Object[]{
	                		"EEE","EEE","EEE",
	                		Character.valueOf('E'), "gemJadite",
	                		}));
	                
	                GameRegistry.addShapelessRecipe(new ItemStack(regularGem, 9, 0), new ItemStack(gemBlock, 1, 0));
	                GameRegistry.addShapelessRecipe(new ItemStack(regularGem, 9, 1), new ItemStack(gemBlock, 1, 1));
	                GameRegistry.addShapelessRecipe(new ItemStack(regularGem, 9, 2), new ItemStack(gemBlock, 1, 2));
	                
	                ItemStack itembattery = new ItemStack(molecularBattery);
					if(itembattery.stackTagCompound == null) itembattery.setTagCompound(new NBTTagCompound());
					itembattery.stackTagCompound.setInteger("Energy", gemeratorEnergyAmt * 4); 
	                
	               GameRegistry.addSmelting(compoundBattery, itembattery, 3.0f);
	        }
	        
	        @EventHandler // used in 1.6.2
	        //@PostInit   // used in 1.5.2
	        public void postInit(FMLPostInitializationEvent event) {
	                // Stub Method
	        	
	        }
	        
	}

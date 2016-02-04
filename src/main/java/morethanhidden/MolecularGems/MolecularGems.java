package morethanhidden.MolecularGems;

	import morethanhidden.MolecularGems.blocks.BlockLiquidWaterSource;
	import morethanhidden.MolecularGems.blocks.BlockLiquidElectricOoze;
	import morethanhidden.MolecularGems.blocks.BlockLiquidFire;
	import morethanhidden.MolecularGems.blocks.BlockLiquidGrass;
	import morethanhidden.MolecularGems.blocks.GemBlock;
	import morethanhidden.MolecularGems.blocks.GemOre;
	import morethanhidden.MolecularGems.handler.BucketHandler;
	import morethanhidden.MolecularGems.handler.CraftingHandler;
	import morethanhidden.MolecularGems.handler.GemOnMineEvent;
	import morethanhidden.MolecularGems.items.FragmentGem;
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
	import net.minecraft.util.ResourceLocation;
	import net.minecraftforge.common.AchievementPage;
	import net.minecraftforge.common.MinecraftForge;
	import net.minecraftforge.common.config.Configuration;
	import net.minecraftforge.fluids.Fluid;
	import net.minecraftforge.fluids.FluidContainerRegistry;
	import net.minecraftforge.fluids.FluidRegistry;
	import net.minecraftforge.fml.common.FMLCommonHandler;
	import net.minecraftforge.fml.common.Mod;
	import net.minecraftforge.fml.common.SidedProxy;
	import net.minecraftforge.fml.common.event.FMLInitializationEvent;
	import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
	import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
	import net.minecraftforge.fml.common.registry.GameRegistry;
	import net.minecraftforge.fml.common.registry.LanguageRegistry;
	import net.minecraftforge.fml.relauncher.Side;
	import net.minecraftforge.fml.relauncher.SideOnly;
	import net.minecraftforge.oredict.OreDictionary;
	import net.minecraftforge.oredict.ShapedOreRecipe;

	@Mod(modid="moleculargems", name="Molecular Gems", version="0.2.0")
	public class MolecularGems {
			public static Item regularGem;
			public static Item refinedGem;
			public static Item fragmentGem;
			public static Block gemOre;
			public static Block gemBlock;
			public static Block blockElectricOooze;
			public static Fluid liquidElectricOoze = new Fluid("liquidelectricooze", new ResourceLocation(""), new ResourceLocation(""));
			public static Item bucketliquidElectricOoze;
			public static Block blockLiquidGrass;
			public static Fluid liquidGrass = new Fluid("liquidgrass", new ResourceLocation(""), new ResourceLocation(""));
			public static Item bucketliquidGrass;
			public static Block blockLiquidFire;
			public static Fluid liquidFire = new Fluid("liquidfire", new ResourceLocation(""), new ResourceLocation(""));
			public static Item bucketliquidWaterSource;
			public static Block blockLiquidWaterSource;
			public static Fluid liquidWaterSource = new Fluid("liquidwatersource", new ResourceLocation(""),new ResourceLocation(""));
			public static Item bucketliquidFire;
			public static Achievement electrifying;
			public static Achievement minegem;
			public static Achievement stickyooze;

			public static int config_gemrate = 7;
			public static boolean ShockingLiquid = true;
			
			
	        // The instance of your mod that Forge uses.
	        @Mod.Instance(value = "moleculargems")
	        public static MolecularGems instance;
	        
	        // Says where the client and server 'proxy' code is loaded.
	        @SidedProxy(clientSide="morethanhidden.MolecularGems.Client.ClientProxy", serverSide="morethanhidden.MolecularGems.common")
	        public static common proxy;
	        
	        @Mod.EventHandler
	        public void preLoad(FMLPreInitializationEvent PreEvent) {
	        MolecularWorld.mainRegistry();
	        MolecularMobs.mainRegistry();
	        }
	        
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
	        	
	        	
	        	FluidRegistry.registerFluid(liquidElectricOoze);
	        	blockElectricOooze = new BlockLiquidElectricOoze(liquidElectricOoze, Material.water);
	        	GameRegistry.registerBlock(blockElectricOooze, "liquidElectricOoze");
	        	liquidElectricOoze.setUnlocalizedName(blockElectricOooze.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidWaterSource);
	        	blockLiquidWaterSource = new BlockLiquidWaterSource(liquidWaterSource, Material.water);
	        	GameRegistry.registerBlock(blockLiquidWaterSource, "liquidWaterSource");
	        	liquidWaterSource.setUnlocalizedName(blockLiquidWaterSource.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidGrass);
	        	blockLiquidGrass = new BlockLiquidGrass(liquidGrass, Material.water);
	        	GameRegistry.registerBlock(blockLiquidGrass, "liquidGrass");
	        	liquidGrass.setUnlocalizedName(blockLiquidGrass.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidFire);
	        	blockLiquidFire = new BlockLiquidFire(liquidFire, Material.lava);
	        	GameRegistry.registerBlock(blockLiquidFire, "liquidFire");
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
	        	gemOre = new GemOre();
	        	gemBlock = new GemBlock();
	        	
	            GameRegistry.registerItem(regularGem, regularGem.getUnlocalizedName());
	            GameRegistry.registerItem(refinedGem, refinedGem.getUnlocalizedName());
	            GameRegistry.registerItem(fragmentGem, fragmentGem.getUnlocalizedName());
	            GameRegistry.registerBlock(gemOre, "gemOre");
	            GameRegistry.registerBlock(gemBlock, GemBlockItem.class, "gemBlock");
	            GameRegistry.registerWorldGenerator(new WorldGenMoleculer(), 1);
	            
	            GameRegistry.registerItem(bucketliquidElectricOoze, bucketliquidElectricOoze.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidWaterSource, bucketliquidWaterSource.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidGrass, bucketliquidGrass.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidFire, bucketliquidFire.getUnlocalizedName());

	            MinecraftForge.EVENT_BUS.register(new BucketHandler());
	            FMLCommonHandler.instance().bus().register(new CraftingHandler());
	            FMLCommonHandler.instance().bus().register(new GemOnMineEvent());
	        	
	        	minegem = new Achievement("achievement.minegem", "minegem", 0, 0, gemOre, (Achievement)null).initIndependentStat().registerStat();
	        	stickyooze  = new Achievement("achievement.stickyooze", "stickyooze", 2, 1, bucketliquidGrass, minegem).registerStat();
	        	if (ShockingLiquid = true){
	        	electrifying = new Achievement("achievement.electrifying", "electrifying", 2, 3, bucketliquidElectricOoze, minegem).registerStat();
	        	}
	        	
	        	AchievementPage.registerAchievementPage(new AchievementPage("Molecular Gems", new Achievement[]{minegem, electrifying, stickyooze}));
	            
	        }
	        
	        @Mod.EventHandler
	        public void load(FMLInitializationEvent event) {
	        	
      	       	proxy.registerRenderers();
	        	addNames();
	            oreRegistration();
	            addOreRecipes();
	                 
	        }
	        public static void addNames()
	        {
	                LanguageRegistry.addName(bucketliquidElectricOoze, "Electric Ooze Bucket");
	                LanguageRegistry.addName(blockElectricOooze, "Electric Ooze");
	                LanguageRegistry.addName(bucketliquidWaterSource, "Liquid Water Source Bucket");
	                LanguageRegistry.addName(bucketliquidGrass, "Liquid Grass Bucket");
	                LanguageRegistry.addName(bucketliquidFire, "Liquid Fire Bucket");
		            LanguageRegistry.addName(blockLiquidFire, "Liquid Fire");
	                LanguageRegistry.addName(blockLiquidGrass, "Liquid Grass");
	                LanguageRegistry.addName(blockLiquidWaterSource, "Liquid Water Source");
	                
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
	                OreDictionary.registerOre("bucketElectricOoze", bucketliquidElectricOoze);
	                OreDictionary.registerOre("bucketLiquidGrass", bucketliquidGrass);
	                OreDictionary.registerOre("bucketLiquidFire", bucketliquidFire);
	                OreDictionary.registerOre("bucketLiquidWaterSource", bucketliquidWaterSource);
	        }
	        public static void addOreRecipes()
	        {
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidFire, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.bucket,
	                		Character.valueOf('E'), "gemYellow",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidGrass, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.bucket,
	                		Character.valueOf('E'), "gemGreen",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidWaterSource, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.bucket,
	                		Character.valueOf('E'), "gemBlue",
	                		}));
	                
	                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(gemBlock, 1, 0), true, new Object[]{
	                		"EEE","EEE","EEE",
	                		Character.valueOf('E'), "gemYellow",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(gemBlock, 1, 1), true, new Object[]{
	                		"EEE","EEE","EEE",
	                		Character.valueOf('E'), "gemBlue",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(gemBlock, 1, 2), true, new Object[]{
	                		"EEE","EEE","EEE",
	                		Character.valueOf('E'), "gemGreen",
	                		}));
	                
	                GameRegistry.addShapelessRecipe(new ItemStack(regularGem, 9, 0), new ItemStack(gemBlock, 1, 0));
	                GameRegistry.addShapelessRecipe(new ItemStack(regularGem, 9, 1), new ItemStack(gemBlock, 1, 1));
	                GameRegistry.addShapelessRecipe(new ItemStack(regularGem, 9, 2), new ItemStack(gemBlock, 1, 2));


	        }
	        
	        @Mod.EventHandler
	        public void postInit(FMLPostInitializationEvent event) {
	                // Stub Method
	        	
	        }
	        
	}

package morethanhidden.MolecularGems;

	import morethanhidden.MolecularGems.Client.ClientProxy;
import morethanhidden.MolecularGems.blocks.BlockLiquidAquoticOoze;
import morethanhidden.MolecularGems.blocks.BlockLiquidElectricOoze;
import morethanhidden.MolecularGems.blocks.BlockLiquidFlamingOoze;
import morethanhidden.MolecularGems.blocks.BlockLiquidMuddyOoze;
import morethanhidden.MolecularGems.blocks.GemOre;
import morethanhidden.MolecularGems.blocks.Gemerator;
import morethanhidden.MolecularGems.blocks.GemeratorEmpty;
import morethanhidden.MolecularGems.handler.BucketHandler;
import morethanhidden.MolecularGems.handler.CraftingHandler;
import morethanhidden.MolecularGems.handler.GemOnMineEvent;
import morethanhidden.MolecularGems.items.AscendedGem;
import morethanhidden.MolecularGems.items.BucketLiquidAquoticOoze;
import morethanhidden.MolecularGems.items.BucketLiquidElectricOoze;
import morethanhidden.MolecularGems.items.BucketLiquidFlamingOoze;
import morethanhidden.MolecularGems.items.BucketLiquidMuddyOoze;
import morethanhidden.MolecularGems.items.CleanGem;
import morethanhidden.MolecularGems.items.GemCompoundItem;
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
import cpw.mods.fml.common.registry.GameRegistry;
	//import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	@Mod(modid="moleculargems", name="Molecular Gems", version="0.0.4")
	//@NetworkMod(clientSideRequired=true) // not used in 1.7
	public class MainRegistry {
			//Items I have Added

			public static Item cleanGem;
			public static Item ascendedGem;
			public static Item gemcompoundItem;
			public static Block gemOre;
			public static Block Gemerator;
			public static Block GemeratorEmpty;
			public static Block blockElectricOooze;
			public static Fluid liquidElectricOoze = new Fluid("liquidelectricooze");
			public static Item bucketliquidElectricOoze;
			public static Block blockMuddyOooze;
			public static Fluid liquidMuddyOoze = new Fluid("liquidmuddyooze");
			public static Item bucketliquidMuddyOoze;
			public static Block blockFlamingOooze;
			public static Fluid liquidFlamingOoze = new Fluid("liquidflamingooze");
			public static Item bucketliquidAquoticOoze;
			public static Block blockAquoticOooze;
			public static Fluid liquidAquoticOoze = new Fluid("liquidaquoticooze");
			public static Item bucketliquidFlamingOoze;
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
	                return Item.getItemFromBlock(Gemerator);
	            }
	        };
	        
	        @EventHandler // used in 1.6.2
	        //@PreInit    // used in 1.5.2
	        public void preInit(FMLPreInitializationEvent event) {  
	        	
	        	
	        	FluidRegistry.registerFluid(liquidElectricOoze);
	        	blockElectricOooze = new BlockLiquidElectricOoze(liquidElectricOoze, Material.water).setBlockName("liquidelectricooze");
	        	GameRegistry.registerBlock(blockElectricOooze, "moleculargems" + "_" + blockElectricOooze.getUnlocalizedName().substring(5));
	        	liquidElectricOoze.setUnlocalizedName(blockElectricOooze.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidAquoticOoze);
	        	blockAquoticOooze = new BlockLiquidAquoticOoze(liquidAquoticOoze, Material.water).setBlockName("liquidaquoticoze");
	        	GameRegistry.registerBlock(blockAquoticOooze, "moleculargems" + "_" + blockAquoticOooze.getUnlocalizedName().substring(5));
	        	liquidAquoticOoze.setUnlocalizedName(blockAquoticOooze.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidMuddyOoze);
	        	blockMuddyOooze = new BlockLiquidMuddyOoze(liquidMuddyOoze, Material.water).setBlockName("liquidmuddyooze");
	        	GameRegistry.registerBlock(blockMuddyOooze, "moleculargems" + "_" + blockMuddyOooze.getUnlocalizedName().substring(5));
	        	liquidMuddyOoze.setUnlocalizedName(blockMuddyOooze.getUnlocalizedName());
	        	
	        	FluidRegistry.registerFluid(liquidFlamingOoze);
	        	blockFlamingOooze = new BlockLiquidFlamingOoze(liquidFlamingOoze, Material.lava).setBlockName("liquidflamingooze");
	        	GameRegistry.registerBlock(blockFlamingOooze, "moleculargems" + "_" + blockFlamingOooze.getUnlocalizedName().substring(5));
	        	liquidFlamingOoze.setUnlocalizedName(blockFlamingOooze.getUnlocalizedName());
	        	
	        	bucketliquidElectricOoze = new BucketLiquidElectricOoze(blockElectricOooze);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidelectricooze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidElectricOoze), new ItemStack(Items.bucket));
	        	
	        	bucketliquidAquoticOoze = new BucketLiquidAquoticOoze(blockAquoticOooze);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidaquoticooze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidAquoticOoze), new ItemStack(Items.bucket));
	        	
	        	bucketliquidMuddyOoze = new BucketLiquidMuddyOoze(blockMuddyOooze);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidmuddyooze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidMuddyOoze), new ItemStack(Items.bucket));
	        	
	        	bucketliquidFlamingOoze = new BucketLiquidFlamingOoze(blockFlamingOooze);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidflamingooze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidFlamingOoze), new ItemStack(Items.bucket));
	        	
	        	cleanGem = new CleanGem().setUnlocalizedName("CleanGem");
	        	gemcompoundItem = new GemCompoundItem();
	        	gemOre = new GemOre();
	        	Gemerator = new Gemerator();
	        	GemeratorEmpty = new GemeratorEmpty();
	        	ascendedGem = new AscendedGem();
	        	
	            GameRegistry.registerItem(cleanGem, cleanGem.getUnlocalizedName());
	            GameRegistry.registerItem(gemcompoundItem, gemcompoundItem.getUnlocalizedName());
	            GameRegistry.registerItem(ascendedGem, ascendedGem.getUnlocalizedName());
	            GameRegistry.registerBlock(gemOre, "gemOre");
	            GameRegistry.registerBlock(Gemerator, "Gemerator");
	            GameRegistry.registerBlock(GemeratorEmpty, "GemeratorEmpty");
	            GameRegistry.registerWorldGenerator(new WorldGenMoleculer(), 1);
	            
	            GameRegistry.registerItem(bucketliquidElectricOoze, bucketliquidElectricOoze.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidAquoticOoze, bucketliquidAquoticOoze.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidMuddyOoze, bucketliquidMuddyOoze.getUnlocalizedName());
	            GameRegistry.registerItem(bucketliquidFlamingOoze, bucketliquidFlamingOoze.getUnlocalizedName());
	            
	            GameRegistry.registerTileEntity(TileGemerator.class, "TileGemerator");
	            	            
	            MinecraftForge.EVENT_BUS.register(new BucketHandler());
	            FMLCommonHandler.instance().bus().register(new CraftingHandler());
	            FMLCommonHandler.instance().bus().register(new GemOnMineEvent());
	            		
	        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	        	
	        	minegem = new Achievement("achievement.minegem", "minegem", 0, 0, gemOre, (Achievement)null).initIndependentStat().registerStat();
	        	stickyooze  = new Achievement("achievement.stickyooze", "stickyooze", 2, 1, bucketliquidMuddyOoze, minegem).registerStat();
	        	agemerator  = new Achievement("achievement.agemerator", "agemerator", 2, 2, Gemerator, minegem).registerStat();
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
	                LanguageRegistry.addName(gemOre, "Gem Ore");
	                LanguageRegistry.addName(ascendedGem, "Ascended Gem");
	                LanguageRegistry.addName(GemeratorEmpty, "Empty Gemerator");
	                LanguageRegistry.addName(Gemerator, "Gemerator");
	                LanguageRegistry.addName(bucketliquidElectricOoze, "Electric Ooze Bucket");
	                LanguageRegistry.addName(blockElectricOooze, "Aquotic Ooze");
	                LanguageRegistry.addName(bucketliquidAquoticOoze, "Aquotic Ooze Bucket");
	                LanguageRegistry.addName(blockElectricOooze, "Electric Ooze");
	                LanguageRegistry.addName(bucketliquidMuddyOoze, "Muddy Ooze Bucket");
	                LanguageRegistry.addName(blockMuddyOooze, "Muddy Ooze");
	                LanguageRegistry.addName(blockFlamingOooze, "Flaming Ooze");
	                LanguageRegistry.addName(bucketliquidFlamingOoze, "Flaming Ooze Bucket");
	                LanguageRegistry.addName(gemcompoundItem, "Ascended Gem Compound");
	                LanguageRegistry.addName(new ItemStack(cleanGem, 1, 0), "Red Gem");
	                LanguageRegistry.addName(new ItemStack(cleanGem, 1, 1), "Blue Gem");
	                LanguageRegistry.addName(new ItemStack(cleanGem, 1, 2), "Green Gem");
	                
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
	                OreDictionary.registerOre("oreGem", gemOre);
	                OreDictionary.registerOre("gemRed", new ItemStack(cleanGem, 1, 0));
	                OreDictionary.registerOre("gemBlue", new ItemStack(cleanGem, 1, 1));
	                OreDictionary.registerOre("gemGreen", new ItemStack(cleanGem, 1, 2));
	                OreDictionary.registerOre("gemMolecular", new ItemStack(cleanGem, 1, 0));
	                OreDictionary.registerOre("gemMolecular", new ItemStack(cleanGem, 1, 1));
	                OreDictionary.registerOre("gemMolecular", new ItemStack(cleanGem, 1, 2));
	                OreDictionary.registerOre("gemAscended", ascendedGem);
	                OreDictionary.registerOre("bucketElectricOoze", bucketliquidElectricOoze);
	                OreDictionary.registerOre("bucketMuddyOoze", bucketliquidMuddyOoze);
	                OreDictionary.registerOre("bucketFlamingOoze", bucketliquidFlamingOoze);
	        }
	        public static void addOreRecipes()
	        {
	        	
	                GameRegistry.addRecipe(new ShapedOreRecipe(GemeratorEmpty, true, new Object[]{
	                		"DRD","BIG","DPD",
	                		Character.valueOf('D'), "gemDiamond",
	                		Character.valueOf('R'), "gemRed",
	                		Character.valueOf('B'), "gemBlue",
	                		Character.valueOf('G'), "gemGreen",
	                		Character.valueOf('P'), Blocks.piston,
	                		Character.valueOf('I'), "blockIron"
	                		}));
	                	                
	                GameRegistry.addRecipe(new ShapedOreRecipe(gemcompoundItem, true, new Object[]{
	                		"EEE","ECE","EEE",
	                		Character.valueOf('C'), "blockCoal",
	                		Character.valueOf('E'), "gemMolecular",
	                		}));
	                
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidElectricOoze, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.water_bucket.setContainerItem(null),
	                		Character.valueOf('E'), "gemAscended",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidFlamingOoze, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.water_bucket.setContainerItem(null),
	                		Character.valueOf('E'), "gemRed",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidMuddyOoze, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.water_bucket.setContainerItem(null),
	                		Character.valueOf('E'), "gemGreen",
	                		}));
	                GameRegistry.addRecipe(new ShapedOreRecipe(bucketliquidAquoticOoze, true, new Object[]{
	                		"EEE","EBE","EEE",
	                		Character.valueOf('B'), Items.water_bucket.setContainerItem(null),
	                		Character.valueOf('E'), "gemBlue",
	                		}));
	                
	                ItemStack itemascended = new ItemStack(ascendedGem);
					if(itemascended.stackTagCompound == null) itemascended.setTagCompound(new NBTTagCompound());
					itemascended.stackTagCompound.setInteger("Energy", gemeratorEnergyAmt * 4); 
	                
	               GameRegistry.addSmelting(gemcompoundItem, itemascended, 3.0f);
	        }
	        
	        @EventHandler // used in 1.6.2
	        //@PostInit   // used in 1.5.2
	        public void postInit(FMLPostInitializationEvent event) {
	                // Stub Method
	        	
	        }
	        
	}

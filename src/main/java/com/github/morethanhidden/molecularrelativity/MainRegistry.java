package com.github.morethanhidden.molecularrelativity;

	import com.github.morethanhidden.molecularrelativity.blocks.BlockLiquidEUze;
import com.github.morethanhidden.molecularrelativity.blocks.MolecularFurnace;
import com.github.morethanhidden.molecularrelativity.blocks.MolecularGenerator;
import com.github.morethanhidden.molecularrelativity.blocks.Moleculizer;
import com.github.morethanhidden.molecularrelativity.blocks.TelluriumOre;
import com.github.morethanhidden.molecularrelativity.client.ClientProxy;
import com.github.morethanhidden.molecularrelativity.handler.BucketHandler;
import com.github.morethanhidden.molecularrelativity.items.BucketLiquidEUzItem;
import com.github.morethanhidden.molecularrelativity.items.EuziteItem;
import com.github.morethanhidden.molecularrelativity.items.IradiantAlloyItem;
import com.github.morethanhidden.molecularrelativity.items.IradiantCompoundItem;
import com.github.morethanhidden.molecularrelativity.items.TelluriumIngot;
import com.github.morethanhidden.molecularrelativity.world.MolecularWorld;
import com.github.morethanhidden.molecularrelativity.world.WorldGenMoleculer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
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

	@Mod(modid="molecularrelativity", name="Molecular Relativity", version="0.0.1")
	//@NetworkMod(clientSideRequired=true) // not used in 1.7
	public class MainRegistry {
			//Items I have Added
			public static Item euziteItem;
			public static Item telluriumIngot;
			public static Item iradiantalloyItem;
			public static Item iradiantcompoundItem;
			public static Block telluriumOre;
			public static Block moleculizer;
			public static Block molecularGenerator;
			public static Block molecularFurnace;
			public static Block molecularFurnaceActive;
			public static Block blockLiquidEUze;
			public static Fluid liquidEUze = new Fluid("liquideuze");
			public static Item bucketliquidEUzItem;
			 
	        // The instance of your mod that Forge uses.
	        @Instance(value = "MolecularRelativity")
	        public static MainRegistry instance;
	        
	        // Says where the client and server 'proxy' code is loaded.
	        @SidedProxy(clientSide="com.github.morethanhidden.molecularrelativity.client.ClientProxy", serverSide="com.github.morethanhidden.molecularrelativity.CommonProxy")
	        public static ClientProxy proxy;
	        
	        public void preLoad(FMLPreInitializationEvent PreEvent) {
	        MolecularWorld.mainRegistry();
	        }
	        
	        //Creative tab for my mod
	        public static CreativeTabs tabMolecularRelativity = new CreativeTabs("Molecular Relativity") {
	            @Override
	            @SideOnly(Side.CLIENT)
	            public Item getTabIconItem() {
	                return Item.getItemFromBlock(molecularFurnace);
	            }
	        };
	        
	        @EventHandler // used in 1.6.2
	        //@PreInit    // used in 1.5.2
	        public void preInit(FMLPreInitializationEvent event) {  
	        	
	        	
	        	FluidRegistry.registerFluid(liquidEUze);
	        	blockLiquidEUze = new BlockLiquidEUze(liquidEUze, Material.water).setBlockName("liquidEUze");
	        	GameRegistry.registerBlock(blockLiquidEUze, "molecularrelativity" + "_" + blockLiquidEUze.getUnlocalizedName().substring(5));
	        	liquidEUze.setUnlocalizedName(blockLiquidEUze.getUnlocalizedName());
	        	
	        	bucketliquidEUzItem = new BucketLiquidEUzItem(blockLiquidEUze);
	        	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquideuze", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketliquidEUzItem), new ItemStack(Items.bucket));
	        	
	        	euziteItem = new EuziteItem();
	        	telluriumIngot = new TelluriumIngot();
	        	iradiantcompoundItem = new IradiantCompoundItem();
	        	iradiantalloyItem = new IradiantAlloyItem();
	        	telluriumOre = new TelluriumOre();
	        	moleculizer = new Moleculizer();
	        	molecularGenerator = new MolecularGenerator();
	        	molecularFurnace = new MolecularFurnace(false);
	        	molecularFurnaceActive = new MolecularFurnace(true);
	        	
	        	
	            GameRegistry.registerItem(euziteItem, euziteItem.getUnlocalizedName());
	            GameRegistry.registerItem(telluriumIngot, telluriumIngot.getUnlocalizedName());
	            GameRegistry.registerItem(iradiantcompoundItem, iradiantcompoundItem.getUnlocalizedName());
	            GameRegistry.registerItem(iradiantalloyItem, iradiantalloyItem.getUnlocalizedName());
	            GameRegistry.registerBlock(telluriumOre, "telluriumOre");
	            GameRegistry.registerBlock(moleculizer, "moleculizer");
	            GameRegistry.registerBlock(molecularGenerator, "MolecularGenerator");
	            GameRegistry.registerBlock(molecularFurnace, "MolecularFurnace");
	            GameRegistry.registerBlock(molecularFurnaceActive, "tutFurnaceActive");
	            GameRegistry.registerWorldGenerator(new WorldGenMoleculer(), 1);
	            
	            GameRegistry.registerItem(bucketliquidEUzItem, bucketliquidEUzItem.getUnlocalizedName());
	            
	            GameRegistry.registerTileEntity(TileMoleculizer.class, "TileMoleculizer");
	            GameRegistry.registerTileEntity(TileMolecularGenerator.class, "TileMolecularGenerator");
	            GameRegistry.registerTileEntity(TileMolecularFurnace.class, "TileMolecularFurnace");
	            MinecraftForge.EVENT_BUS.register(new BucketHandler());
	            
	        }
	        
	        @EventHandler // used in 1.6.2
	        //@Init       // used in 1.5.2
	        public void load(FMLInitializationEvent event) {
	        	liquidEUze.setIcons(blockLiquidEUze.getIcon(0, 0), blockLiquidEUze.getIcon(1, 0));
	        		addNames();
	                oreRegistration();
	                addOreRecipes();
	                
	        }
	        public static void addNames()
	        {
	                LanguageRegistry.addName(telluriumOre, "Tellurium Ore");
	                LanguageRegistry.addName(telluriumIngot, "Tellurium Ingot");
	        }
	        
	        public static void oreRegistration()
	        {
	                //1.3.2 OreDictionary.registerOre("ingotCopper", new ItemStack(ingotCopper));
	                //1.6.4
	                OreDictionary.registerOre("ingotTellurium", telluriumIngot);
	                OreDictionary.registerOre("oreTellurium", telluriumOre);
	        }
	        public static void addOreRecipes()
	        {
	                GameRegistry.addRecipe(new ShapedOreRecipe(Items.bucket, true, new Object[]{
	                                "FF", Character.valueOf('F'), telluriumIngot}));
	        }
	        
	        @EventHandler // used in 1.6.2
	        //@PostInit   // used in 1.5.2
	        public void postInit(FMLPostInitializationEvent event) {
	                // Stub Method
	        }
	}

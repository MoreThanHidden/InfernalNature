package morethanhidden.infernalnature.mob;

import morethanhidden.infernalnature.InfernalNature;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MolecularMobs {
	
	public static void mainRegistry(){
		registerEntity();
		
	}

	private static void registerEntity() {
		
		createEntity(EntityAncientMob.class, "Ghost of Ancients", 0xBEC9A5, 0x1851A1, true);
			
	}

	public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour, boolean worldspawn){
	EntityRegistry.registerModEntity(new ResourceLocation(powerofmagic.MODID, entityClass.getName()), entityClass, entityName, 1, powerofmagic.instance, 10, 1, true);
	if (worldspawn){EntityRegistry.addSpawn(entityClass, 40, 1, 2, EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.SWAMPLAND);}
	EntityRegistry.registerEgg(new ResourceLocation(powerofmagic.MODID, entityClass.getName()), solidColour, spotColour);
	}
	
}

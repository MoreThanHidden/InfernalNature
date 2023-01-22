package morethanhidden.infernalnature.mob;

import morethanhidden.infernalnature.Constants;
import net.minecraft.resources.ResourceLocation;

public class MolecularMobs {
	
	public static void mainRegistry(){
		registerEntity();
		
	}

	private static void registerEntity() {
		
		createEntity(EntityAncientMob.class, "Ghost of Ancients", 0xBEC9A5, 0x1851A1, true);
			
	}

	public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour, boolean worldspawn){
	EntityRegistry.registerModEntity(new ResourceLocation(Constants.MOD_ID, entityClass.getName()), entityClass, entityName, 1, infernalnature.instance, 10, 1, true);
	if (worldspawn){EntityRegistry.addSpawn(entityClass, 40, 1, 2, EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.SWAMPLAND);}
	EntityRegistry.registerEgg(new ResourceLocation(Constants.MOD_ID, entityClass.getName()), solidColour, spotColour);
	}
	
}

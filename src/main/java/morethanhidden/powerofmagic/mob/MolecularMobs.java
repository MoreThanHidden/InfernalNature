package morethanhidden.powerofmagic.mob;

import morethanhidden.powerofmagic.powerofmagic;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MolecularMobs {
	
	public static void mainRegistry(){
		registerEntity();
		
	}

	private static void registerEntity() {
		
		createEntity(EntityAncientMob.class, "Ghost of Ancients", 0xBEC9A5, 0x1851A1, true);
			
	}

	public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour, boolean worldspawn){
	EntityRegistry.registerModEntity(entityClass, entityName, 1, powerofmagic.instance, 10, 1, true);
	if (worldspawn){EntityRegistry.addSpawn(entityClass, 40, 1, 2, EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.SWAMPLAND);}
	EntityRegistry.registerEgg(entityClass, solidColour, spotColour);
	}
	
}

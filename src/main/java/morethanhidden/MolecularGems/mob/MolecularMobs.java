package morethanhidden.MolecularGems.mob;

import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class MolecularMobs {
	
	public static void mainRegistry(){
		registerEntity();
		
	}

	private static void registerEntity() {
		
		createEntity(EntityAncientMob.class, "Ghost of Ancients", 0xBEC9A5, 0x1851A1, true);
			
	}

	
	public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour, boolean worldspawn){
	int randomId = EntityRegistry.findGlobalUniqueEntityId();
	EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
	EntityRegistry.registerModEntity(entityClass, entityName, randomId, MainRegistry.instance, 10, 1, true);
	if (worldspawn){EntityRegistry.addSpawn(entityClass, 40, 1, 2, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland);}
	createEgg(randomId, solidColour, spotColour);
	}
	
	
	private static void createEgg(int randomId, int solidColour, int spotColour){
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColour, spotColour));
	}
	
}

package morethanhidden.infernalnature.world;

import java.util.Random;

import morethanhidden.infernalnature.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class WorldGenMoleculer implements IWorldGenerator {


	private void generateSurface(Level world, Random rand, int chunkX, int chunkZ) {
		for(int i = 0; i < powerofmagic.config_gemrate; i++){
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(10);
			int randPosZ = chunkZ + rand.nextInt(16);
			
			(new WorldGenMinable(BlockRegistry.gemOre.getDefaultState(), 3)).generate(world, rand, new BlockPos(randPosX, randPosY, randPosZ));
		}
		}
		

	private void generateNether(Level world, Random rand, int i, int j) {
		
		
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, Level world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
			case -1:
				generateNether(world, rand, chunkX * 16, chunkZ * 16);
			case 0:
				generateSurface(world, rand, chunkX * 16, chunkZ * 16);
		}
	}
}

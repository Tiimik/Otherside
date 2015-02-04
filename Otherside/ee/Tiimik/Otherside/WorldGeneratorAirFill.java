package ee.Tiimik.Otherside;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorAirFill implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
	        case 0: GenerateOverworld(random, chunkX * 16, chunkZ * 16, world); break;
	        case 1: GenerateEnd(random, chunkX * 16, chunkZ * 16, world); break;
	        case -1: GenerateNether(random, chunkX * 16, chunkZ * 16, world); break;
	    }
	}
	private void GenerateOverworld(Random random, int x, int z, World world) {
		addOres(Otherside.blockTest, world, random, x, z, 1, 20, 10, 50, 70, Blocks.dirt);
		
    }
 
    private void GenerateNether(Random random, int x, int z, World world) {
    }
 
    private void GenerateEnd(Random random, int x, int z, World world) {
    }
	    
public void addOres(Block block, World world, Random random, int blockXPos, int blockZPos, 
	int minVeinSize, int maxVeinSize, int chanceToSpawn, int minY, int maxY, Block generateIn){
	int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
	int heightRange = maxY - minY;
	WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
	for(int i=0; i< chanceToSpawn; i++){
		int xRand = blockXPos * 16 + random.nextInt(16);
		int yRand = random.nextInt(heightRange) + minY;
		int zRand = blockZPos * 16 + random.nextInt(16);
		gen.generate(world, random, xRand, yRand, zRand);
	}
}
		
	}



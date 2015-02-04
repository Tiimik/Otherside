package ee.Tiimik.Otherside;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.IWorldGenerator;

public class CreateSpawn implements IWorldGenerator {
	public static int newSpawnX;
	public static int newSpawnZ;
	public static int globalSpawnY;
	public final static String OTHERSIDE_DATA_SPAWN_EXISTS = "OthersideDataSpawnExists";

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		/*
		newSpawnX = 100;
		newSpawnZ = 100;
		globalSpawnY = 55;
		System.out.println("Creating spawn!");
		
		for (int x = newSpawnX-5; x <= newSpawnX+5; x++){
            for (int z = newSpawnZ-5; z <= newSpawnZ+5; z++){
            	for (int y = globalSpawnY; y <= globalSpawnY+6; y++){ //y+6
            		world.setBlockToAir(x,y,z);
            	}
            }
		}
		world.setBlock(newSpawnX-4, 60, newSpawnZ-4, Blocks.glowstone, 0, 2);
		
		// Make Floor
		for (int x = newSpawnX-5; x <= newSpawnX+5; x++){
            for (int z = newSpawnZ-5; z <= newSpawnZ+5; z++){
            	world.setBlock(x,globalSpawnY,z, Blocks.dirt, 0, 2);
            	
            }
		}
		// Make Ceiling
				for (int x = newSpawnX-5; x <= newSpawnX+5; x++){
		            for (int z = newSpawnZ-5; z <= newSpawnZ+5; z++){
		            	world.setBlock(x,globalSpawnY+6,z, Blocks.dirt, 0, 2);
		            }
				}
				
			*/	
	}
}

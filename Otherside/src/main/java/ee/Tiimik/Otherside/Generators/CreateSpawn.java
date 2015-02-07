package ee.Tiimik.Otherside.Generators;

import ee.Tiimik.Otherside.Entity.ExtPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class CreateSpawn {
	
	public static final void generate(World world, int newSpawnX, int globalSpawnY, int newSpawnZ, EntityPlayer player) {
		ExtPlayer props = ExtPlayer.get(player);
		
		System.out.println("Creating spawn!");
		//Load a 3x3 around spawn to make sure that it populates and calls our hooks.
		if (world.isRemote && world instanceof WorldServer)
		{
			WorldServer worlds = (WorldServer)world;
			int spawnX = (int) (newSpawnX / worlds.provider.getMovementFactor() / 16);
			int spawnZ = (int) (newSpawnZ / worlds.provider.getMovementFactor() / 16);
			for (int x = -1; x <= 1; x++)
				for (int z = -1; z <= 1; z++)
					worlds.theChunkProviderServer.loadChunk(spawnX + x, spawnZ + z);
		}
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
		
		props.SetSpawnData(true, newSpawnX, globalSpawnY, newSpawnZ);


	}
}

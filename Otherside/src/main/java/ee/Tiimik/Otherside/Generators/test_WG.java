package ee.Tiimik.Otherside.Generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import ee.Tiimik.Otherside.Configs.Configs;

public class test_WG implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0: GenerateOverworld(random, chunkX * 16, chunkZ * 16, world); break;
            case 1: GenerateEnd(random, chunkX * 16, chunkZ * 16, world); break;
            case -1: GenerateNether(random, chunkX * 16, chunkZ * 16, world); break;
        }
    }
    
    private void GenerateOverworld(Random random, int x, int z, World world) {
 
    	this.addOreSpawn2(Block.getBlockFromName(Configs.useBlock), world, random, x, z, Configs.genMinVeinSize, Configs.genMaxVeinSize, Configs.genChance, 60, 80);
    	//this.addOreSpawn(Blocks.dirt, world, random, x, z, 10, 50, 30, 60, 128);
    	//this.addOreSpawn(Blocks.dirt, world, random, x, z, 50, 80, 50, 60, 128);
        }
 
    private void GenerateNether(Random random, int x, int z, World world) {
    }
 
    private void GenerateEnd(Random random, int x, int z, World world) {
    }

    
    /**
    *
    * This method adds our block to the world.
    * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
    * Then it gives all the params to WorldGenMinable, which handles the replacing of the ores for us.
    *
    * @param block The block you want to spawn
    * @param world The world
    * @param random The Random
    * @param blockXPos the blockXpos of a chunk
    * @param blockZPos the blockZpos of a chunk
    * @param minVeinSize min vein
    * @param maxVeinSize max vein
    * @param chancesToSpawn the chance to spawn. Usually around 2
    * @param minY lowest point to spawn
    * @param maxY highest point to spawn
    */

   public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
   {
	   //System.out.println("Chunk gen at blockXPos: "+ blockXPos + " and blockZPos: "+ blockZPos);
       WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.air);
       for(int i = 0; i < chancesToSpawn; i++)
       {
           int posX = blockXPos + random.nextInt(16);
           int posY = minY + random.nextInt(maxY - minY);
           int posZ = blockZPos + random.nextInt(16);
           minable.generate(world, random, posX, posY, posZ);
       }
       
   }
   public void addOreSpawn2(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
   {
	 //  System.out.println("Chunk gen at blockXPos: "+ blockXPos + " and blockZPos: "+ blockZPos);
      // WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.air);
	          for(int y = 60; y < 90; y++)
       {
	        	  int posX = blockXPos*16;
	        	  int posZ = blockZPos*16;
	        	  for (int x = posX; x <= posX+14; x++){
	                  for (int z = posZ; z <= posZ+14; z++){
	                	  //if(world.get getBlockMaterial(x, y, z) == Material.air 
	                	//if(block.isAir(world, x, y, z)){
	                	  try{
//	                		  System.out.println("Should set block!");
	                		  world.setBlock(x,y,z, Blocks.dirt, 0, 2);
	                	  }
	                	  catch (Exception e){
	                		  System.out.println("error: " + e.toString());
	                	  }
	                		
	                		//	  }
	                  	
	                  }
	      		}
	        	  
	        	  
	        	  
                 //minable.generate(world, random, posX, posY, posZ);
       }
       
   }
    
    
    
    
}




package ee.Tiimik.Otherside.Configs;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

import java.io.File;
import java.io.IOException;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Configs {
	public static boolean useGeneration = true;
	public static String useBlock = "dirt";
	public static int genChance = 10;
	public static int genMinVeinSize = 4;
	public static int genMaxVeinSize = 10;
	
	
	public static final boolean initConfigs(FMLPreInitializationEvent event){
		Configuration config =  null;
	        File configFile = event.getSuggestedConfigurationFile();
	        try
	        {
	            config = new Configuration(configFile);
	        }
	        catch (Exception e)
	        {
	            if (configFile.exists())
	            	configFile.delete();
	            config = new Configuration(configFile);
	        }
	        Property prop;

	        prop = config.get(CATEGORY_GENERAL, "useGeneration", useGeneration);
	        prop.comment = "If special generation will be used.";
	        useGeneration = prop.getBoolean(useGeneration);
	        
	        prop = config.get(CATEGORY_GENERAL, "useBlock", useBlock);
	        prop.comment = "Block that will be used in additional generation. Always use \"Block.blockname\"";
	        useBlock = prop.getString();
	        
	        prop = config.get(CATEGORY_GENERAL, "genChance", genChance);
	        prop.comment = "Chance of vein to spawn";
	        genChance = prop.getInt(genChance);
	        
	        prop = config.get(CATEGORY_GENERAL, "genMinVeinSize", genMinVeinSize);
	        prop.comment = "Minimum size of generated vein";
	        genMinVeinSize = prop.getInt(genMinVeinSize);

	        prop = config.get(CATEGORY_GENERAL, "genMaxVeinSize", genMaxVeinSize);
	        prop.comment = "Maximum size of generated vein";
	        genMaxVeinSize = prop.getInt(genMaxVeinSize);
	        
	        
	       /* prop = config.get(CATEGORY_GENERAL, "platformType", platformType);
	        prop.comment = "Set the type of platform to create in the overworld, Possible values: \n" + 
	                       "  'grass' A single grass block\n" +
	                       "  'tree' a small oak tree on a grass block\n" +
	                       "  'skyblock21' For SkyBlock v2.1 platforms";
	        platformType = prop.getString();
	        
	        prop = config.get(CATEGORY_GENERAL, "generateSpikes", generateSpikes);
	        prop.comment = "Set to true to enable generation of the obsidian 'spikes' in the end.";
	        generateSpikes = prop.getBoolean(generateSpikes);
	        
	        prop = config.get(CATEGORY_GENERAL, "generateNetherFortress", generateNetherFortress);
	        prop.comment = "Set to true to enable generation of the nether fortresses.";
	        generateNetherFortress = prop.getBoolean(generateNetherFortress);
*/
	        if (config.hasChanged())
	        {
	            config.save();
	        }
		return true;
	}

	
}

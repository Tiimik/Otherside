package ee.Tiimik.Otherside.Proxy;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.GameRegistry;
import ee.Tiimik.Otherside.BlockTest;
import ee.Tiimik.Otherside.CreateSpawn;
import ee.Tiimik.Otherside.ItemTwigs;
import ee.Tiimik.Otherside.WGtest;
import ee.Tiimik.Otherside.Configs.Configs;
import ee.Tiimik.Otherside.EventsHandlers.miskievent;
import ee.Tiimik.Otherside.EventsHandlers.miskievent2;

public class CommonProxy {
	public static String spawnExists;
	public final static String OTHERSIDE_DATA_SPAWN_EXISTS = "OthersideDataSpawnExists";

	/**
	 * Returns a side-appropriate EntityPlayer for use during message handling
	 */
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
	
	public void preInit(FMLPreInitializationEvent e) {
		Configs.initConfigs(e);
		// WORLD GENERATION
		//GameRegistry.registerWorldGenerator(new WorldGeneratorAirFill(), 0);
		if(Configs.useGeneration){
			GameRegistry.registerWorldGenerator(new WGtest(), 20);
		}
		//Spawn Generation
		//-----------------------------

		System.out.println("Registreeritud!");

		//public void CreateSpawn = new CreateSpawn();
	}

	public void init(FMLInitializationEvent e) {
		FMLCommonHandler.instance().bus().register(new miskievent());
		//MinecraftForge.EVENT_BUS.register(new miskievent2());
	}

	public void postInit(FMLPostInitializationEvent e) {

	}


	//return playerRelocationInfo;

}
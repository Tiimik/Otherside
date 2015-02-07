package ee.Tiimik.Otherside.Proxy;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.GameRegistry;
import ee.Tiimik.Otherside.Configs.Configs;
import ee.Tiimik.Otherside.EventsHandlers.EventHandler_Spawning;
import ee.Tiimik.Otherside.Generators.test_WG;

public class CommonProxy {

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
			GameRegistry.registerWorldGenerator(new test_WG(), 20);
		}
		//System.out.println("Registreeritud!");
	}

	public void init(FMLInitializationEvent e) {
		FMLCommonHandler.instance().bus().register(new EventHandler_Spawning());
		//MinecraftForge.EVENT_BUS.register(new miskievent2());
	}

	public void postInit(FMLPostInitializationEvent e) {

	}

}
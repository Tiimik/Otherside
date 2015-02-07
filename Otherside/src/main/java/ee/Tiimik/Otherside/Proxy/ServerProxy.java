package ee.Tiimik.Otherside.Proxy;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ee.Tiimik.Otherside.EventsHandlers.EventHandler_Spawning;
import ee.Tiimik.Otherside.EventsHandlers.test_miskievent2;

public class ServerProxy extends CommonProxy {
	
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
      
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }


}

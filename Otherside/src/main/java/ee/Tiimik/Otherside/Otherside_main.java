package ee.Tiimik.Otherside;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ee.Tiimik.Otherside.EventsHandlers.EventHandler_Entity;
import ee.Tiimik.Otherside.Proxy.CommonProxy;
import ee.Tiimik.Otherside.lib.Constants;

@Mod(modid = Constants.MODID, name=Constants.MODNAME, version=Constants.MODVER)
public class Otherside_main {

	@SidedProxy(clientSide="ee.Tiimik.Otherside.Proxy.ClientProxy", serverSide="ee.Tiimik.Otherside.Proxy.ServerProxy")
    public static CommonProxy proxy;
	public static Otherside_main instance; 
	public static Item itemTwigs;
	public static Block blockTest;
	//public static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MODID);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		this.proxy.preInit(e);
		itemTwigs = new test_ItemTwigs().setUnlocalizedName("ItemTwigs");
		
		blockTest = new test_BlockTest(Material.rock).setBlockName("BlockTest").setBlockTextureName("otherside:BlockTest");
		
		GameRegistry.registerBlock(blockTest, blockTest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTwigs, itemTwigs.getUnlocalizedName().substring(5));
		// Remember to register your packets! This applies whether or not you used a
		// custom class or direct implementation of SimpleNetworkWrapper
	//	PacketDispatcher.registerPackets();
	}

	@EventHandler
	public void Init(FMLInitializationEvent e){
		this.proxy.init(e);
		
	}
	@EventHandler
	public void load(FMLInitializationEvent event) {
		//proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new EventHandler_Entity());
		//NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
		
	}
    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load e)
    {
    	
    	
    }
    @SubscribeEvent
    public void onWorldLoad(BlockEvent.PlaceEvent e)
    {
    	 	
    }
    
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		this.proxy.postInit(e);
		
	}
}

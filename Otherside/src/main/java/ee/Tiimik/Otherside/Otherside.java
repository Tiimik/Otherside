package ee.Tiimik.Otherside;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import ee.Tiimik.Otherside.Configs.Configs;
import ee.Tiimik.Otherside.EventsHandlers.EventHandlerTest;
import ee.Tiimik.Otherside.EventsHandlers.miskievent;
import ee.Tiimik.Otherside.EventsHandlers.miskievent2;
import ee.Tiimik.Otherside.Proxy.CommonProxy;
import ee.Tiimik.Otherside.lib.Constants;

@Mod(modid = Constants.MODID, name=Constants.MODNAME, version=Constants.MODVER)
public class Otherside {

	@SidedProxy(clientSide="ee.Tiimik.Otherside.Proxy.ClientProxy", serverSide="ee.Tiimik.Otherside.Proxy.ServerProxy")
    public static CommonProxy proxy;
	public static Otherside instance; 
	public static Item itemTwigs;
	public static Block blockTest;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		this.proxy.preInit(e);
		itemTwigs = new ItemTwigs().setUnlocalizedName("ItemTwigs");
		
		blockTest = new BlockTest(Material.rock).setBlockName("BlockTest").setBlockTextureName("otherside:BlockTest");
		
		GameRegistry.registerBlock(blockTest, blockTest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemTwigs, itemTwigs.getUnlocalizedName().substring(5));
	}

	@EventHandler
	public void Init(FMLInitializationEvent e){
		this.proxy.init(e);
		
	}
	@EventHandler
	public void load(FMLInitializationEvent event) {
	//	proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new EventHandlerTest());
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

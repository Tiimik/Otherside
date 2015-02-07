package ee.Tiimik.Otherside.EventsHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class test_miskievent2 {
/*	public final static String OTHERSIDE_DATA_SPAWNED = "OthersideDataSpawned";
	public EntityPlayer player = null;
	public static String playerRelocationInfo;
	*/
	@SubscribeEvent
    public void onEvent(LivingJumpEvent event)
    {

    	if (event.entity instanceof EntityPlayer) {
    		System.out.println("Player Jumps");
    		EntityPlayer p = (EntityPlayer)event.entity;
    		//System.out.println("Jumped at X:"+ p.chunkCoordX + " and Z:" + p.chunkCoordZ);

    			}
}
}	


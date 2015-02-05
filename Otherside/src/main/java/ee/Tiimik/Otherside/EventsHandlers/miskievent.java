package ee.Tiimik.Otherside.EventsHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import ee.Tiimik.Otherside.CreateSpawn;
import ee.Tiimik.Otherside.CreateSpawn2;
import ee.Tiimik.Otherside.ExtPlayer;
import ee.Tiimik.Otherside.network.client.SyncPlayerPropsMessage;

public class miskievent {
	public EntityPlayer player = null;

	@SubscribeEvent
	public void onEvent(PlayerLoggedInEvent event)
	{

		if (event.player instanceof EntityPlayer) {
			System.out.println("EVENT HAPPENING - PLAYER LOGGING IN!");
////ExtPlayer.loadNBTData(event.player.getEntityData());
			try{
				ExtPlayer.get(event.player).loadNBTData(event.player.getEntityData());
			}
			catch (Exception e){
				System.out.println("NBT data read error:"+e);
			}
	//		SyncPlayerPropsMessage.process(ExtPlayer.get(player), Side.SERVER); 
			if(ExtPlayer.playerSpawned() == false)
			{
				int PspawnX = 100;
				int PspawnY = 56;
				int PspawnZ = 100;
				CreateSpawn2.generate(event.player.getEntityWorld(), PspawnX, PspawnY-1, PspawnZ);
				EntityPlayer p = (EntityPlayer) event.player;
				p.setPositionAndUpdate(PspawnX, PspawnY, PspawnZ);
				p.worldObj.setSpawnLocation(PspawnX, PspawnY, PspawnZ);
				p.addChatMessage(new ChatComponentText("Spawn should be set now"));
				//ExtPlayer.
			//	ExtPlayer.get(player).saveNBTData(event.player.getEntityData());
				if(ExtPlayer.playerSpawned() == false)
				{}
				
			}

		}
	}
}



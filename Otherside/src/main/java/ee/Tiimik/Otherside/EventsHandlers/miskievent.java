package ee.Tiimik.Otherside.EventsHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ee.Tiimik.Otherside.CreateSpawn;
import ee.Tiimik.Otherside.CreateSpawn2;
import ee.Tiimik.Otherside.ExtPlayer;

public class miskievent {
	public EntityPlayer player = null;

	@SubscribeEvent
	public void onEvent(PlayerLoggedInEvent event)
	{

		if (event.player instanceof EntityPlayer) {
			System.out.println("EVENT HAPPENING - PLAYER LOGGING IN!");
////ExtPlayer.loadNBTData(event.player.getEntityData());
			//ExtPlayer.get(player).loadNBTData(event.player.getEntityData());
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
			//	ExtPlayer.get(player).saveNBTData(event.player.getEntityData());
				if(ExtPlayer.playerSpawned() == false)
				{}
				
			}

		}
	}
}



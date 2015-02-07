package ee.Tiimik.Otherside.EventsHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import ee.Tiimik.Otherside.Entity.ExtPlayer;
import ee.Tiimik.Otherside.Generators.CreateSpawn;
import ee.Tiimik.Otherside.Generators.temp_CreateSpawn;
import ee.Tiimik.Otherside.network.client.SyncPlayerPropsMessage;

public class EventHandler_Spawning {
	public EntityPlayer player = null;

	@SubscribeEvent
	public void onEvent(PlayerLoggedInEvent event)
	{
		if (event.player instanceof EntityPlayer) {
			
			//System.out.println("EVENT HAPPENING - PLAYER LOGGING IN!");

			ExtPlayer props = ExtPlayer.get(event.player);
			if(props.playerSpawned() == false)
			{
				int PspawnX = 100;
				int PspawnY = 56;
				int PspawnZ = 100;
				CreateSpawn.generate(event.player.getEntityWorld(), PspawnX, PspawnY-1, PspawnZ, event.player);
				EntityPlayer p = (EntityPlayer) event.player;
				p.setPositionAndUpdate(PspawnX, PspawnY, PspawnZ);
				p.worldObj.setSpawnLocation(PspawnX, PspawnY, PspawnZ);
				p.addChatMessage(new ChatComponentText("Spawn should be set now"));
				
			}

		}
	}
}



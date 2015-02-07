package ee.Tiimik.Otherside.EventsHandlers;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ee.Tiimik.Otherside.Entity.ExtPlayer;
import ee.Tiimik.Otherside.network.PacketDispatcher;
import ee.Tiimik.Otherside.network.client.SyncPlayerPropsMessage;

public class EventHandler_Entity {
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			if (ExtPlayer.get((EntityPlayer) event.entity) == null)
				ExtPlayer.register((EntityPlayer) event.entity);
		}
	}
	/*@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
			PacketDispatcher.sendTo(new SyncPlayerPropsMessage((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);
		}
	}*/
	@SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone event) {
		ExtPlayer.get(event.entityPlayer).copy(ExtPlayer.get(event.original));
	}
}

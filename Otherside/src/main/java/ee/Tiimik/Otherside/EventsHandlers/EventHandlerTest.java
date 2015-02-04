package ee.Tiimik.Otherside.EventsHandlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ee.Tiimik.Otherside.CreateSpawn2;
import ee.Tiimik.Otherside.ExtPlayer;

public class EventHandlerTest {
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			if (ExtPlayer.get((EntityPlayer) event.entity) == null)
				ExtPlayer.register((EntityPlayer) event.entity);
		}
	}
	@SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone event) {
		ExtPlayer.get(event.entityPlayer).copy(ExtPlayer.get(event.original));
	}
}

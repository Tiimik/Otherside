package ee.Tiimik.Otherside.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
//import tutorial.inventory.InventoryCustomPlayer;
//import tutorial.network.PacketDispatcher;
//import tutorial.network.client.SyncPlayerPropsMessage;

public class ExtPlayer implements IExtendedEntityProperties
{
	public final static String EXT_PROP_NAME = "ExtPlayer";

	private final EntityPlayer player;
	private boolean PlayerRelocated = false;
	private int PlayerSpawnX;
	private int PlayerSpawnY;
	private int PlayerSpawnZ;

	public ExtPlayer(EntityPlayer player) {
		this.player = player;
		this.PlayerRelocated = false;
		this.PlayerSpawnX = 0;
		this.PlayerSpawnY = 0;
		this.PlayerSpawnZ = 0;
		
	}

	/**
	 * Used to register these extended properties for the player during EntityConstructing event
	 */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtPlayer.EXT_PROP_NAME, new ExtPlayer(player));

	}

	/**
	 * Returns ExtendedPlayer properties for player
	 */
	public static final ExtPlayer get(EntityPlayer player) {
		return (ExtPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	/**
	 * Copies additional player data from the given ExtendedPlayer instance
	 * Avoids NBT disk I/O overhead when cloning a player after respawn
	 */
	public void copy(ExtPlayer props) {
		PlayerRelocated = props.PlayerRelocated;
		PlayerSpawnX = props.PlayerSpawnX;
		PlayerSpawnY = props.PlayerSpawnY;
		PlayerSpawnZ = props.PlayerSpawnZ;
	}
	@Override
	public final void saveNBTData(NBTTagCompound compound) {
		// We store all of our data nested in a single tag;
		// this way, we never have to worry about conflicting with other
		// mods that may also be writing to the player's tag compound
		NBTTagCompound properties = new NBTTagCompound();
		
		// Write everything to our new tag:
		//inventory.writeToNBT(properties);
		properties.setBoolean("PlayerRelocated", PlayerRelocated);
		properties.setInteger("PlayerSpawnX", PlayerSpawnX);
		properties.setInteger("PlayerSpawnY", PlayerSpawnY);
		properties.setInteger("PlayerSpawnZ", PlayerSpawnZ);
		
		// Finally, set the tag with our unique identifier:
		compound.setTag(EXT_PROP_NAME, properties);
		System.out.println("ExtPlayer data saved!" + PlayerRelocated + "; X:"+PlayerSpawnX + "; Y:"+PlayerSpawnY + "; Z:"+PlayerSpawnZ);
		
	}

	public final void loadNBTData(NBTTagCompound compound) {
		// Pretty much the reverse of saveNBTData - get our
		// unique tag and then load everything from it:
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
	//	inventory.readFromNBT(properties);
		//player.getDataWatcher().updateObject(MANA_WATCHER, properties.getInteger("CurrentMana"));
		PlayerRelocated = properties.getBoolean("PlayerRelocated");
		PlayerSpawnX = properties.getInteger("PlayerSpawnX");
		PlayerSpawnY = properties.getInteger("PlayerSpawnY");
		PlayerSpawnZ = properties.getInteger("PlayerSpawnZ");
		SetSpawnData(properties.getBoolean("PlayerRelocated"), properties.getInteger("PlayerSpawnX"), properties.getInteger("PlayerSpawnY"), properties.getInteger("PlayerSpawnZ"));
		System.out.println("ExtPlayer data LOADED: Player located: " + PlayerRelocated + "; X:"+PlayerSpawnX + "; Y:"+PlayerSpawnY + "; Z:"+PlayerSpawnZ);
		
	}
	public final boolean playerSpawned(){
		//ExtPlayer.loadNBTData(compound);
		//System.out.println("Plocated" + PlayerRelocated + "; X:"+PlayerSpawnX + "; Y:"+PlayerSpawnY + "; Z:"+PlayerSpawnZ);
		return PlayerRelocated;
	}
	public final void SetSpawnData(boolean relocTrue, int PSX, int PSY, int PSZ){
		PlayerRelocated = relocTrue;
		PlayerSpawnX = PSX;
		PlayerSpawnY = PSY;
		PlayerSpawnZ = PSZ;
	}

	@Override
	public void init(Entity entity, World world) {}
	
}
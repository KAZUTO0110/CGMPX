package net.fumyatan.cgmpx.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import net.fumyatan.cgmpx.Manager.BackManager;

public class PlayerTeleportEventListener implements Listener{

	@EventHandler
	public void onPlayerTeleportEvent(PlayerTeleportEvent e){
		BackManager.backpoint.put(e.getPlayer(), e.getFrom());
	}

}

package net.fumyatan.cgmpx.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.fumyatan.cgmpx.Manager.VanishManager;

public class PlayerJoinEventListener implements Listener {

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e){
		// Vanishの適用
		for (String p : VanishManager.vanisher){
			e.getPlayer().hidePlayer(Bukkit.getPlayer(p));
		}
	}

}

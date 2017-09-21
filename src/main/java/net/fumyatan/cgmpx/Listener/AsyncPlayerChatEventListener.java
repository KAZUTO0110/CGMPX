package net.fumyatan.cgmpx.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.fumyatan.cgmpx.Manager.AFKManager;

public class AsyncPlayerChatEventListener implements Listener {
	public static boolean waitLogin;
	public static Player waitPlayer;

	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		AFKManager.resetAFKTime(e.getPlayer());
	}

}

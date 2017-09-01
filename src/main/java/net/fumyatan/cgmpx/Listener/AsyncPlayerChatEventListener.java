package net.fumyatan.cgmpx.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.fumyatan.cgmpx.Manager.AFKManager;
import net.fumyatan.cgmpx.Manager.DebugConsole;

public class AsyncPlayerChatEventListener implements Listener {
	public static boolean waitLogin;
	public static Player waitPlayer;

	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();

		if (waitLogin && waitPlayer.equals(p)){
			if (DebugConsole.authePassword(e.getMessage(), p)){
				p.sendMessage(ChatColor.GREEN + "[CGMPX] Login Success!");
				waitLogin = false;
				waitPlayer = null;
			} else {
				p.sendMessage(ChatColor.RED + "[CGMPX] Missing Password!");
				waitLogin = false;
				waitPlayer = null;
			}
			e.setCancelled(true);
		}

		AFKManager.resetAFKTime(e.getPlayer());
	}

}

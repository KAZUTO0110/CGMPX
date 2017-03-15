package net.fumyatan.cgmpx.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.fumyatan.cgmpx.Manager.DebugConsole;
import net.fumyatan.cgmpx.Manager.VanishManager;

public class PlayerQuitEventListener implements Listener{

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent e){
		// VanishListから削除
		if (VanishManager.vanisher.contains(e.getPlayer().getName())){
			VanishManager.vanisher.remove(e.getPlayer().getName());
			e.setQuitMessage("");
		}

		// Debuggerから削除
		if (e.getPlayer().equals(DebugConsole.Debugger()))
			DebugConsole.debugLogout();
	}

}

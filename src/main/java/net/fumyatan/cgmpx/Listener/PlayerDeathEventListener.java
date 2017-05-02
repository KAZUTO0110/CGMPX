package net.fumyatan.cgmpx.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.fumyatan.cgmpx.Manager.BackManager;

public class PlayerDeathEventListener implements Listener{

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent e){
		BackManager.saveBackPoint(e.getEntity().getPlayer(), e.getEntity().getLocation());
	}
}

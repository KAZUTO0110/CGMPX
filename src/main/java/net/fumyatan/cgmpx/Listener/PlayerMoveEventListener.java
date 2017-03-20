package net.fumyatan.cgmpx.Listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.fumyatan.cgmpx.Manager.AFKManager;

public class PlayerMoveEventListener implements Listener {
	public static List<Player> freezeuser = new ArrayList<>();

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e){
		if (freezeuser.contains(e.getPlayer())){
			Location from = e.getFrom();
			Location to = e.getTo();

			from = new Location(from.getWorld(), from.getX(), from.getY(), from.getZ());
			to = new Location(to.getWorld(), to.getX(), to.getY(), to.getZ());
			if (!to.equals(from))
				e.setCancelled(true);
		}

		AFKManager.resetAFKTime(e.getPlayer());
	}
}

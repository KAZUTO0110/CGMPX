package net.fumyatan.cgmpx.Listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.fumyatan.cgmpx.Manager.AFKManager;

public class PlayerMoveEventListener implements Listener {
	public static List<Player> freezeuser = new ArrayList<>();

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e){

		if (e.getFrom().getBlockX() == e.getTo().getBlockX()
				&& e.getFrom().getBlockZ() == e.getTo().getBlockZ()
				&& e.getFrom().getBlockY() == e.getTo().getBlockY())
			return;

		if (freezeuser.contains(e.getPlayer()))
			e.setCancelled(true);

		//TODO 正常に判定が入らない
		if (AFKManager.antipush) {
			if (AFKManager.isAFK(e.getPlayer())) {
				if (!e.getPlayer().getNearbyEntities(4, 4, 4).isEmpty()) {
					e.setCancelled(true);
					return;
				}
			}
		}

		AFKManager.resetAFKTime(e.getPlayer());
	}
}

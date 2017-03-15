package net.fumyatan.cgmpx.Listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveEventListener implements Listener {
	public static List<Player> freezeuser = new ArrayList<>();

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e){
		if (freezeuser.contains(e.getPlayer())){
			e.setCancelled(true);
		}
	}
}

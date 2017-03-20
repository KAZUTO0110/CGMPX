package net.fumyatan.cgmpx.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import net.fumyatan.cgmpx.Manager.AFKManager;

public class AFKToggleEvent extends Event{

	// 固定
	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}

	// 独自実装部
	private static Player player;

	public AFKToggleEvent(Player p){
		player = p;
	}

	/**
	 * プレイヤーを取得します。
	 * @return Player
	 * @since 0.0.12-SNAPSHOT
	 */
	public Player getPlayer(){
		return player;
	}

	/**
	 * プレイヤーが離席中か取得します。
	 * @return boolean
	 * @since 0.0.12-SNAPSHOT
	 */
	public boolean isAFK(){
		return AFKManager.isAFK(player);
	}
}

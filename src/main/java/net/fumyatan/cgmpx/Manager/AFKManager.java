package net.fumyatan.cgmpx.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Event.AFKToggleEvent;

public class AFKManager {

	private static Map<Player, Long> users = new HashMap<>();
	private static List<Player> afks = new ArrayList<>();

	public static void updateAFKTime(){
		for (Player p : Bukkit.getOnlinePlayers()){
			if (users.get(p) != null){
				long sec = users.get(p);
				users.put(p, sec + 1);
				// DebugConsole.receiveInfoLog(ChatColor.YELLOW + "[AFKInfo] " + ChatColor.RESET + p.getDisplayName() + ChatColor.GOLD + " Time: " + sec);
			} else {
				users.put(p, 1L);
			}
		}
	}

	public static void checkAFK(){
		for (Player p : users.keySet()){
			if (60 <= users.get(p)){
				if (!afks.contains(p)){
					afks.add(p);
					AFKToggleEvent toggle = new AFKToggleEvent(p);
					Bukkit.getServer().getPluginManager().callEvent(toggle);
					Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.YELLOW + " は離席中です。");
				}
			}
		}
	}

	public static void resetAFKTime(Player p){
		users.put(p, 0L);
		if (afks.contains(p)){
			afks.remove(p);
			AFKToggleEvent toggle = new AFKToggleEvent(p);
			Bukkit.getServer().getPluginManager().callEvent(toggle);
			Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.YELLOW + " は離席から戻りました。");
		}
	}

	public static boolean isAFK(Player p){
		return afks.contains(p);
	}
}

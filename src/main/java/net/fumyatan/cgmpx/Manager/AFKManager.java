package net.fumyatan.cgmpx.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Event.AFKToggleEvent;
import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class AFKManager implements CommandExecutor {

	public static int time = 0;
	public static String afkmessage;
	public static String backmessage;
	public static boolean god;

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
			if (time <= users.get(p)){
				if (!VanishManager.vanisher.contains(p.getName())){
					if (!afks.contains(p)){
						afks.add(p);
						AFKToggleEvent toggle = new AFKToggleEvent(p);
						Bukkit.getServer().getPluginManager().callEvent(toggle);
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', afkmessage.replaceAll("%Player%", p.getDisplayName())));
						if (god)
							GodManager.setGod(p, true);
					}
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
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', backmessage.replaceAll("%Player%", p.getDisplayName())));
			if (god)
				GodManager.setGod(p, false);
		}
	}

	public static boolean isAFK(Player p){
		return afks.contains(p);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if (sender.hasPermission("cgmpx.afk")){
			if (afks.contains(p)){
				users.put(p, 0L);
				afks.remove(p);
				AFKToggleEvent toggle = new AFKToggleEvent(p);
				Bukkit.getServer().getPluginManager().callEvent(toggle);
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', backmessage.replaceAll("%Player%", p.getDisplayName())));
				if (god)
					GodManager.setGod(p, false);
			} else {
				if (!afks.contains(p)){
					afks.add(p);
					AFKToggleEvent toggle = new AFKToggleEvent(p);
					Bukkit.getServer().getPluginManager().callEvent(toggle);
					if (args.length == 0){
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', afkmessage.replaceAll("%Player%", p.getDisplayName())));
					} else {
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', afkmessage.replaceAll("%Player%", p.getDisplayName())) + ChatColor.GRAY + ": " + args[0]);
					}
					if (god)
						GodManager.setGod(p, true);
				}
			}
		} else {
			PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
		}
		return true;
	}
}

package net.fumyatan.cgmpx.Manager;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class BackManager implements CommandExecutor {
	public static Map<Player, Location> backpoint = new HashMap<>();

	public static void saveBackPoint(Player p, Location Loc){
		backpoint.put(p, Loc);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if (sender.hasPermission("cgmpx.back")){
			if (backpoint.containsKey(p)){
				p.teleport(backpoint.get(p));
				PrefixAdder.sendMessage(p, "Teleport to LastActionPoint.");
			}
		} else {
			PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
		}
		return true;
	}
}

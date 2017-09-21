package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("day")){
				if (sender.hasPermission("cgmpx.day")){
					p.getWorld().setTime(1000L);
				}
			} else if (command.getName().equalsIgnoreCase("night")){
				if (sender.hasPermission("cgmpx.night")){
					p.getWorld().setTime(18000L);
				}
			}
		} else {
			for (World world : Bukkit.getWorlds()) {
				if (command.getName().equalsIgnoreCase("day")) {
					world.setTime(1000L);
				} else if (command.getName().equalsIgnoreCase("night")) {
					world.setTime(18000L);
				}
			}
		}
		return true;
	}

}
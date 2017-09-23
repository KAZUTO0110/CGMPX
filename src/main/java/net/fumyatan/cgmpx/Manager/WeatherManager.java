package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("sun")){
				if (sender.hasPermission("cgmpx.sun")){
					p.getWorld().setStorm(false);
				}
			} else if (command.getName().equalsIgnoreCase("rain")){
				if (sender.hasPermission("cgmpx.rain")){
					p.getWorld().setStorm(true);
				}
			}
		} else {
			for (World world : Bukkit.getWorlds()) {
				if (command.getName().equalsIgnoreCase("sun")) {
					world.setStorm(false);
				} else if (command.getName().equalsIgnoreCase("rain")) {
					world.setStorm(true);
				}
			}
		}
		return false;
	}

}

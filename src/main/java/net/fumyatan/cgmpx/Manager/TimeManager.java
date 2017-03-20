package net.fumyatan.cgmpx.Manager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		sender.sendMessage(Long.toString(p.getWorld().getTime()));
		if (command.equals("day")){
			if (sender.hasPermission("cgmpx.day")){
				p.getWorld().setTime(1000L);
			}
		} else if (command.equals("night")){
			if (sender.hasPermission("cgmpx.night")){
				p.getWorld().setTime(18000L);
			}
		}
		return true;
	}

}

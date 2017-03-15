package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class HealManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0){
			if (sender.hasPermission("cgmpx.heal")){
				Player target = (Player) sender;
				target.setHealth(20.0);
				target.setFoodLevel(20);
				target.setSaturation((float) 20.0);
				PrefixAdder.sendMessage(sender, "Heal succeeded.");
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		} else {
			if (sender.hasPermission("cgmpx.heal.admin")){
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null){
					target.setHealth(20.0);
					target.setFoodLevel(20);
					target.setSaturation((float) 20.0);
					PrefixAdder.sendMessage(sender, "Heal succeeded.");
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
				}
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		}
		return true;
	}

}

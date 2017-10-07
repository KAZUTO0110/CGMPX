package net.fumyatan.cgmpx.Manager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class InventoryManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		switch (command.getName()) {
		case "workbench":
			if (sender instanceof Player && sender.hasPermission("cgmpx.wbc")){
				((Player) sender).openWorkbench(null, true);
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
			break;

		case "enderchest":
			if (sender instanceof Player && sender.hasPermission("cgmpx.ec")){
				((Player) sender).openInventory(((Player) sender).getEnderChest());
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
			break;

		default:
			break;
		}
		return false;
	}



}

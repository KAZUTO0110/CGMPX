package net.fumyatan.cgmpx.Manager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class InventoryManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		switch (command.getName()) {
		case "workbench":
			if (sender.hasPermission("cgmpx.wbc")){
				((HumanEntity) sender).openWorkbench(null, true);
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

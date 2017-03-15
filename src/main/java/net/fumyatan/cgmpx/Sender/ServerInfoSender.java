package net.fumyatan.cgmpx.Sender;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ServerInfoSender implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		MemoryUsage usage = mbean.getHeapMemoryUsage();

		if (sender.hasPermission("cgmpx.sinfo")){
			sender.sendMessage(ChatColor.AQUA + "============ CGMPX Server Info ============");
			sender.sendMessage(ChatColor.GOLD + "OS: " + ChatColor.RESET + System.getProperty("os.name") + ChatColor.GRAY + " (" + System.getProperty("os.arch") + ")");
			sender.sendMessage(ChatColor.GOLD + "RAM: " + ChatColor.RESET + usage.getUsed()/1024/1024 + "MB/" + usage.getInit()/1024/1024 + "MB");
			sender.sendMessage(ChatColor.GOLD + "Java: " + ChatColor.RESET + System.getProperty("java.version") + " " + System.getProperty("java vendor"));
		}
		return true;
	}
}

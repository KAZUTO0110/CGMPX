package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class NicknameManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equals("nick")){
			if (args.length == 1){
				if (sender.hasPermission("cgmpx.nick")){
					Player target = (Player) sender;
					target.setDisplayName("*" + ChatColor.translateAlternateColorCodes('&', args[0]));
					PrefixAdder.sendMessage(sender, "Successfully set Nickname.");
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
				}
			} else if (args.length == 2){
				if (sender.hasPermission("cgmpx.nick.admin")){
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null){
						target.setDisplayName("*" + ChatColor.translateAlternateColorCodes('&', args[1]));
						PrefixAdder.sendMessage(sender, "Successfully set Nickname.");
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
					}
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
				}
			}
		} else if (command.getName().equals("forcenick")) {
			if (args.length == 1){
				if (sender.hasPermission("cgmpx.nick.force")){
					Player target = (Player) sender;
					target.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]));
					PrefixAdder.sendMessage(sender, "Successfully set Nickname.");
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
				}
			} else if (args.length == 2){
				if (sender.hasPermission("cgmpx.nick.admin")){
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null){
						target.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[1]));
						PrefixAdder.sendMessage(sender, "Successfully set Nickname.");
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
					}
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
				}
			}
		} else {
			if (args.length == 1){
				if (sender.hasPermission("cgmpx.nick.admin")){
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null){
						target.setDisplayName(target.getName());
						PrefixAdder.sendMessage(sender, "Successfully Reset Nickname.");
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
					}
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
				}
			} else {
				if (sender.hasPermission("cgmpx.nick")){
					Player target = (Player) sender;
					target.setDisplayName(target.getName());
					PrefixAdder.sendMessage(sender, "Successfully Reset Nickname.");
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
				}
			}
		}
		return true;
	}
}

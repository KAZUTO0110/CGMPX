package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class FlyManager implements CommandExecutor {

	public static void setAllowFly(CommandSender sender, Player target){
		if (Bukkit.getPlayerExact(target.getName()) != null){
			if (sender.hasPermission("cgmpx.fly.toggle")){
				target.setAllowFlight(true);
				PrefixAdder.sendMessage(target, ChatColor.GOLD + "Enabled Fly");
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		} else {
			PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
		}
	}

	public static void setDenyFly(CommandSender sender, Player target){
		if (Bukkit.getPlayerExact(target.getName()) != null){
			if (sender.hasPermission("cgmpx.fly.toggle")){
				target.setAllowFlight(false);
				PrefixAdder.sendMessage(target, ChatColor.GOLD + "Disabled Fly");
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		} else {
			PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
		}
	}

	public static void setFlySpeed(CommandSender sender, Player target, String speed){
		if (Bukkit.getPlayerExact(target.getName()) != null){
			if (sender.hasPermission("cgmpx.fly.speed")){
				float realspeed = (float) 0.1;
				try {
					realspeed = Float.parseFloat(speed) / 10;
					if (!(realspeed >= 0) || realspeed > 1){
						PrefixAdder.sendMessage(sender, ChatColor.RED + "The value must be between 0 and 10.");
						return;
					}
				} catch (NumberFormatException e){
					PrefixAdder.sendMessage(sender, ChatColor.RED + "Please enter the correct value.");
				}
				target.setFlySpeed(realspeed);
				PrefixAdder.sendMessage(target, "Succeeded in changing the flight speed. Current speed: " + target.getFlySpeed()*10);
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		} else {
			PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0){
			sender.sendMessage(ChatColor.GOLD + "====== CGMPX FlyManager Help ======");
			sender.sendMessage("/fly on: Turn on Fly");
			sender.sendMessage("/fly off: Turn off Fly");
			sender.sendMessage("/fly speed [value]: Change flight speed");
			return true;
		}
		else if (sender instanceof Player){
			Player p = (Player) sender;
			if (args[0].equals("on")){
				if (args.length >= 2){
					if (sender.hasPermission("cgmpx.fly.admin.toggle")){
						if (Bukkit.getPlayerExact(args[1]) != null){
							setAllowFly(sender, Bukkit.getPlayer(args[1]));
						} else {
							PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
						}
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
					}
				} else {
					setAllowFly(p, p);
				}
				return true;
			}
			else if (args[0].equals("off")){
				if (args.length >= 2){
					if (sender.hasPermission("cgmpx.fly.admin.toggle")){
						if (Bukkit.getPlayerExact(args[1]) != null){
							setDenyFly(sender, Bukkit.getPlayer(args[1]));
						} else {
							PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
						}
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
					}
				} else {
					setDenyFly(sender, p);
				}
				return true;
			}
			else if (args[0].equals("speed")){
				if (args.length >= 2){
					if (args.length >= 3){
						if (sender.hasPermission("cgmpx.fly.admin.speed")){
							if (Bukkit.getPlayerExact(args[2]) != null){
								setFlySpeed(sender, Bukkit.getPlayer(args[2]), args[1]);
							} else {
								PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
							}
						} else {
							PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
						}
					}
					else if (args.length == 2) {
						setFlySpeed(sender, p, args[1]);
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED + "Please enter the correct value.");
					}
					return true;
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED + "Please enter the correct value.");
					return true;
				}
			}
		}
		return false;
	}
}

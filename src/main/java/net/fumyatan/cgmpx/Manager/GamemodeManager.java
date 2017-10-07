package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class GamemodeManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player){
			if (sender.hasPermission("cgmpx.cgm")){
				if (args.length == 0){
					if (((Player) sender).getGameMode().equals(GameMode.SURVIVAL)){
						((Player) sender).setGameMode(GameMode.CREATIVE);
						PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
					} else {
						((Player) sender).setGameMode(GameMode.SURVIVAL);
						PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
					}
				} else if (args.length == 2){
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null){
						switch (args[0].toLowerCase()){
						case "creative":
						case "1":
						case "c":
							target.setGameMode(GameMode.CREATIVE);
							PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
							break;
						case "survival":
						case "0":
						case "s":
							target.setGameMode(GameMode.SURVIVAL);
							PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
							break;
						case "spectator":
						case "3":
						case "sp":
							target.setGameMode(GameMode.SPECTATOR);
							PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
							break;
						case "adventure":
						case "2":
						case "a":
							target.setGameMode(GameMode.ADVENTURE);
							PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
							break;
						}
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
					}
				} else switch (args[0].toLowerCase()){
					case "creative":
					case "1":
					case "c":
						((Player) sender).setGameMode(GameMode.CREATIVE);
						PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
						break;
					case "survival":
					case "0":
					case "s":
						((Player) sender).setGameMode(GameMode.SURVIVAL);
						PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
						break;
					case "spectator":
					case "3":
					case "sp":
						((Player) sender).setGameMode(GameMode.SPECTATOR);
						PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
						break;
					case "adventure":
					case "2":
					case "a":
						((Player) sender).setGameMode(GameMode.ADVENTURE);
						PrefixAdder.sendMessage(sender, "Successfully changed game mode.");
						break;
				}
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		}
		return true;
	}
}

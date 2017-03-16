package net.fumyatan.cgmpx.Manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.dynmap.DynmapAPI;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class VanishManager implements CommandExecutor {

	public static List<String> vanisher = new ArrayList<String>();

	public void setVanish(Player target){
		for (Player p : Bukkit.getOnlinePlayers()){
			if (!p.hasPermission("cgmpx.vanish.bypass"))
				p.hidePlayer(target);
		}
		vanisher.add(target.getName());
		Bukkit.broadcastMessage(ChatColor.YELLOW + target.getName() + " left the game");
		PrefixAdder.sendMessage(target, "Vanish has been activated.");
	}

	public void setfullVanish(Player target){
		for (Player p : Bukkit.getOnlinePlayers()){
			p.hidePlayer(target);
			if (Bukkit.getServer().getPluginManager().getPlugin("dynmap") != null){
				DynmapAPI dynmap = (DynmapAPI) Bukkit.getServer().getPluginManager().getPlugin("dynmap");
				dynmap.setPlayerVisiblity(target, false);
			}
		}
		vanisher.add(target.getName());
		Bukkit.broadcastMessage(ChatColor.YELLOW + target.getName() + " left the game");
		PrefixAdder.sendMessage(target, "Vanish has been activated.");
	}

	public void unVanish(Player target){
		for (Player p : Bukkit.getOnlinePlayers()){
			p.showPlayer(target);
			if (Bukkit.getServer().getPluginManager().getPlugin("dynmap") != null){
				DynmapAPI dynmap = (DynmapAPI) Bukkit.getServer().getPluginManager().getPlugin("dynmap");
				dynmap.setPlayerVisiblity(target, true);
			}
		}
		vanisher.remove(target.getName());
		Bukkit.broadcastMessage(ChatColor.YELLOW + target.getName() + " joined the game");
		PrefixAdder.sendMessage(target, "Vanish has been disabled.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equals("fullvanish")){
			if (sender.hasPermission("cgmpx.fullvanish")){
				if (args.length == 0){
					if (vanisher.contains(sender.getName())){
						Player p = (Player) sender;
						unVanish(p);
					} else {
						Player p = (Player) sender;
						setfullVanish(p);
					}
				} else {
					Player p = Bukkit.getPlayer(args[0]);
					if (p != null){
						if (vanisher.contains(args[0])){
							unVanish(p);
						} else {
							setfullVanish(p);
						}
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
					}
				}
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		} else {
			if (sender.hasPermission("cgmpx.vanish")){
				if (args.length == 0){
					if (vanisher.contains(sender.getName())){
						Player p = (Player) sender;
						unVanish(p);
					} else {
						Player p = (Player) sender;
						setVanish(p);
					}
				} else {
					Player p = Bukkit.getPlayer(args[0]);
					if (p != null){
						if (vanisher.contains(args[0])){
							unVanish(p);
						} else {
							setVanish(p);
						}
					} else {
						PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
					}
				}
			} else {
				PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
			}
		}
		return true;
	}
}

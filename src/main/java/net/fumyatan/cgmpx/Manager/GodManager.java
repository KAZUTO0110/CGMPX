package net.fumyatan.cgmpx.Manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class GodManager implements CommandExecutor {
	private static List<Player> god = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0){
			if (sender.hasPermission("cgmpx.god")){
				Player p = (Player) sender;
				if (god.contains(p)){
					god.remove(p);
					resetNoDamageTicks(p);
					PrefixAdder.sendMessage(p, "You are no longer a god.");
				} else {
					god.add(p);
					PrefixAdder.sendMessage(p, "You became a god.");
				}
			}
		} else {
			if (sender.hasPermission("cgmpx.god.admin")){
			Player target = Bukkit.getPlayer(args[0]);
				if (target != null){
					if (god.contains(target)){
						god.remove(target);
						resetNoDamageTicks(target);
						PrefixAdder.sendMessage(target, "You are no longer a god.");
					} else {
						god.add(target);
						PrefixAdder.sendMessage(target, "You became a god.");
					}
				}
			}
		}
		return true;
	}

	public static boolean isGod(Player player){
		return god.contains(player);
	}

	public static void setNoDamageTicks(){
		for (Player p : god){
			p.setNoDamageTicks(1000);
		}
	}

	public static void resetNoDamageTicks(Player target){
		target.setNoDamageTicks(20);
	}

}

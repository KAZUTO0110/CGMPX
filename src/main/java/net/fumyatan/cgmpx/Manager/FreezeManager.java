package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Listener.PlayerMoveEventListener;
import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class FreezeManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.hasPermission("cgmpx.freeze")){
			if (args.length == 1){
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null){
					if (PlayerMoveEventListener.freezeuser.contains(target)){
						PlayerMoveEventListener.freezeuser.remove(target);
						target.setAllowFlight(false);
						PrefixAdder.sendMessage(target, "You were released from freeze.");
					} else {
						PlayerMoveEventListener.freezeuser.add(target);
						target.setAllowFlight(true);
						PrefixAdder.sendMessage(target, "You have been frozen!");
					}
				} else {
					PrefixAdder.sendMessage(sender, ChatColor.RED, "Player Not Found.");
				}
			}
		} else {
			PrefixAdder.sendMessage(sender, ChatColor.RED, "You don't have Permission.");
		}
		return true;
	}

	public static void setfreeze(Player target){
	   PlayerMoveEventListener.freezeuser.add(target);
	   PrefixAdder.sendMessage(target, "You have been frozen!");
    }

    public static void setunfreeze(Player target){
        PlayerMoveEventListener.freezeuser.remove(target);
        PrefixAdder.sendMessage(target, "You were released from freeze.");
    }

}

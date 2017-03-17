package net.fumyatan.cgmpx.Listener;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Manager.DebugConsole;

public class DebugCommandListener implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player){
			Player p = (Player) sender;
			if (args.length == 0){

			} else switch (args[0]) {
			// /questable debug だったときの処理
			case "debug":
				if (args.length == 1){
					AsyncPlayerChatEventListener.waitLogin = true;
					AsyncPlayerChatEventListener.waitPlayer = p;
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "[QTD] Please Type Password!");
				} else switch (args[1]) {
				case "test":
					try{
						DebugConsole.triggerTestthrow();
					} catch (IllegalArgumentException e){
						StringWriter sw = new StringWriter();
						PrintWriter pw = new PrintWriter(sw);
						e.printStackTrace(pw);
						pw.flush();
						String str = sw.toString();
						DebugConsole.receiveErrorLog(str);
					}
					break;

				case "serverinfo":
					DebugConsole.sendServerInfo();
					break;

				case "logout":
					DebugConsole.debugLogout();
					break;

				default:
					StringBuilder cmd = new StringBuilder();
					for (int i = 1; i<args.length; i++){
						cmd.append(args[i] + " ");
					}
					DebugConsole.sendCommand_bypass(cmd.toString(), p);
					break;
				}
				break;
			}
		}
		return true;
	}

}

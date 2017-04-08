package net.fumyatan.cgmpx.Manager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.fumyatan.cgmpx.Sender.WhoisInfoSender;
import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class WhoisManager implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		if (args.length == 0){
			sender.sendMessage("Unknown command. Type \"/whoisps help\" for help.");
		} else if (args[0].equals("help")) {
			PrefixAdder.sendMessage(sender, "/whoisps <playerID>: プレイヤーの情報を表示します");
			PrefixAdder.sendMessage(sender, "/whoisps checkver: プラグインに更新がないか確認します");
			PrefixAdder.sendMessage(sender, "/whoisps reload: Configをリロードします");
		} else {
			Player target = Bukkit.getPlayer(args[0]);
			WhoisInfoSender.sendWhoisInfo(sender, target, args[0]);
		}
		return true;
	}
}

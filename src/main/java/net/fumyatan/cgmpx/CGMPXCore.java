package net.fumyatan.cgmpx;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.fumyatan.cgmpx.Listener.AsyncPlayerChatEventListener;
import net.fumyatan.cgmpx.Listener.DebugCommandListener;
import net.fumyatan.cgmpx.Listener.PlayerJoinEventListener;
import net.fumyatan.cgmpx.Listener.PlayerMoveEventListener;
import net.fumyatan.cgmpx.Listener.PlayerQuitEventListener;
import net.fumyatan.cgmpx.Manager.FlyManager;
import net.fumyatan.cgmpx.Manager.FreezeManager;
import net.fumyatan.cgmpx.Manager.GamemodeManager;
import net.fumyatan.cgmpx.Manager.GodManager;
import net.fumyatan.cgmpx.Manager.HealManager;
import net.fumyatan.cgmpx.Manager.NicknameManager;
import net.fumyatan.cgmpx.Manager.TeleportManager;
import net.fumyatan.cgmpx.Manager.VanishManager;
import net.fumyatan.cgmpx.Sender.ServerInfoSender;
import net.fumyatan.cgmpx.Timer.Timer;

public class CGMPXCore extends JavaPlugin{

	public static Plugin plugin;

	@Override
	public void onEnable(){
		plugin = this;

		// コマンド登録
		getCommand("cgm").setExecutor(new GamemodeManager());
		//getCommand("day").setExecutor(new TimeManager());
		getCommand("fly").setExecutor(new FlyManager());
		getCommand("god").setExecutor(new GodManager());
		getCommand("heal").setExecutor(new HealManager());
		getCommand("forcenick").setExecutor(new NicknameManager());
		getCommand("nick").setExecutor(new NicknameManager());
		getCommand("nickreset").setExecutor(new NicknameManager());
		//getCommand("night").setExecutor(new TimeManager());
		getCommand("vanish").setExecutor(new VanishManager());
		getCommand("fullvanish").setExecutor(new VanishManager());
		getCommand("freeze").setExecutor(new FreezeManager());
		getCommand("tp").setExecutor(new TeleportManager());
		getCommand("tpa").setExecutor(new TeleportManager());
		getCommand("tphere").setExecutor(new TeleportManager());
		getCommand("serverinfo").setExecutor(new ServerInfoSender());
		getCommand("cgmpdebug").setExecutor(new DebugCommandListener());

		// イベントの登録
		getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), plugin);
		getServer().getPluginManager().registerEvents(new PlayerQuitEventListener(), plugin);
		getServer().getPluginManager().registerEvents(new PlayerMoveEventListener(), plugin);
		getServer().getPluginManager().registerEvents(new AsyncPlayerChatEventListener(), plugin);

		// Runnableの実行
		getServer().getScheduler().runTaskTimer(this, new Timer(), 0L, 20L);
	}

	@Override
	public void onDisable(){
		getServer().getScheduler().cancelTasks(plugin);
	}
}

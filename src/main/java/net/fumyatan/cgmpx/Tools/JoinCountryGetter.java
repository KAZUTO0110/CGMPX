package net.fumyatan.cgmpx.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import net.fumyatan.cgmpx.Manager.DebugManager;

public class JoinCountryGetter {

	private static String Countryinfo(String adr_s){
		// Ipから接続国を取得
		URLConnection conn;
		StringBuilder entirePage = new StringBuilder();
		try {
			conn = new URL("http://freegeoip.net/json/" + adr_s).openConnection();
			conn.setReadTimeout(1000);
			conn.setConnectTimeout(1000);
			conn.connect();
			BufferedReader stream = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String inputLine;
			while ((inputLine = stream.readLine()) != null)
				entirePage.append(inputLine);
			stream.close();
			return new String(entirePage);
		} catch (IOException | NullPointerException e) {
			// TODO 自動生成された catch ブロック
			DebugManager.receiveDebug(e, 2);
			PrefixAdder.setLoggerWarn("Failed to connect to API.");

		}
		return null;

	}

	public static String JoinCountry(String adr_s){

		//接続国の抜き取り
		try{
		String[] cinfo_s = Countryinfo(adr_s).split(",", -1);
		String[] cinfo_name = cinfo_s[2].split("\"", -1);
		return cinfo_name[3];
		} catch (StringIndexOutOfBoundsException se){
			DebugManager.receiveDebug(se, 2);
			PrefixAdder.setLoggerWarn("Failed to get the connection country information.");
		}
		return null;

	}

	public static String JoinCountryCode(String adr_s){
		try {
			String[] cinfo_s = Countryinfo(adr_s).split(",", -1);
			String cinfo_code = cinfo_s[1].substring(16,18);
			return cinfo_code;
		} catch (StringIndexOutOfBoundsException se){
			DebugManager.receiveDebug(se, 2);
			PrefixAdder.setLoggerWarn("Failed to get the connection country information.");
		}
		return null;

	}

}

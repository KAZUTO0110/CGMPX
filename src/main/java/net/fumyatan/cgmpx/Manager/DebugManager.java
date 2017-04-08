package net.fumyatan.cgmpx.Manager;

import java.io.PrintWriter;
import java.io.StringWriter;

import net.fumyatan.cgmpx.Tools.PrefixAdder;

public class DebugManager {
	private static boolean debug = true;;

	/**
	 * デバッグ情報を受け取ります。
	 * @param s エラー文
	 * @param type 0:Info 1:Warn 2:Error
	 */
	public static void receiveDebug(String s, int type){
		switch (type) {
		case 0:
			if (debug)
				PrefixAdder.setLoggerInfo(s);
			DebugConsole.receiveInfoLog(s);
			break;

		case 1:
			if (debug)
				PrefixAdder.setLoggerWarn(s);
			DebugConsole.receiveWarnLog(s);
			break;

		case 2:
			if (debug)
				PrefixAdder.setLoggerWarn(s);
			DebugConsole.receiveErrorLog(s);
			break;

		default:
			if (debug)
				PrefixAdder.setLoggerWarn(s);
			DebugConsole.receiveWarnLog(s);
			break;
		}
	}

	/**
	 * デバッグ情報を受け取ります。
	 * @param e 例外
	 * @param type type 0:Info 1:Warn 2:Error
	 */
	public static void receiveDebug(Throwable e, int type){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		pw.flush();
		String str = sw.toString();

		switch (type) {
		case 0:
			if (debug)
				e.printStackTrace();
			DebugConsole.receiveInfoLog(str);
			break;

		case 1:
			if (debug)
				e.printStackTrace();
			DebugConsole.receiveWarnLog(str);
			break;

		case 2:
			if (debug)
				e.printStackTrace();
			DebugConsole.receiveErrorLog(str);
			break;

		default:
			if (debug)
				e.printStackTrace();
			DebugConsole.receiveWarnLog(str);
			break;
		}
	}

}

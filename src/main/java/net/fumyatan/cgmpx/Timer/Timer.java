package net.fumyatan.cgmpx.Timer;

import net.fumyatan.cgmpx.Manager.AFKManager;
import net.fumyatan.cgmpx.Manager.GodManager;

public class Timer implements Runnable {

	@Override
	public void run() {
		// AKF処理用
		AFKManager.updateAFKTime();
		AFKManager.checkAFK();

		// GOD処理用
		GodManager.setNoDamageTicks();
	}

}

package net.sigma.utils;

import net.minecraft.client.Minecraft;

public class TimerUtils {
	public static Minecraft mc = Minecraft.getMinecraft();
	public long lastMS = System.currentTimeMillis();

	public boolean check(float milliseconds) {
		return (float) this.getCurrentTime() >= milliseconds;
	}

	public long getCurrentTime() {
		return System.currentTimeMillis();
	}

	public void reset() {
		lastMS = System.currentTimeMillis();
	}

	public boolean hasTimeElapsed(long time, boolean reset) {
		if (System.currentTimeMillis() - lastMS > time) {
			if (reset)
				reset();
			return true;
		}
		return false;
	}

	public long getDifference() {
		return System.nanoTime() / 1000000L - lastMS;
	}

}

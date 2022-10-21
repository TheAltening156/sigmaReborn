package net.sigma.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class MoveUtils {
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean isMoving() {
		return mc.thePlayer.moveForward != 0.0 || mc.thePlayer.moveStrafing != 0.0;
	}
	
	public static void strafe(double strafe) {
		if (!isMoving()) 
			return;
		float yaw = getDirection();
		mc.thePlayer.motionX = -Math.sin(yaw) * strafe;
		mc.thePlayer.motionZ = Math.cos(yaw) * strafe;
	}

	public static float getDirection() {
		EntityPlayerSP thePlayer = mc.thePlayer;
		Float rotationYaw = thePlayer.rotationYaw;
		if (thePlayer.moveForward < 0.0f) {
			rotationYaw += 180.0f;
		}
		Float forward = 1.0f;
		if (thePlayer.moveForward < 0.0f) {
			forward = -0.5f;
		} else if (thePlayer.moveForward > 0.0f) {
			forward = 0.5f;
		}
		if (thePlayer.moveStrafing > 0.0f) {
			rotationYaw -= 90.0f * forward;
		}
		if (thePlayer.moveStrafing < 0.0f) {
			rotationYaw += 90.0f * forward;
		}
		return (float) Math.toRadians(rotationYaw);
	}
}

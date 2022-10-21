package net.sigma.module.modules;

import java.util.Base64;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.sigma.event.events.EventUpdate;
import net.sigma.module.Cat;
import net.sigma.module.Module;
import net.sigma.settings.BooleanSettings;
import net.sigma.settings.ModeSettings;
import net.sigma.settings.NumberSettings;
import net.sigma.utils.MoveUtils;

public class Fly extends Module{
	public ModeSettings mode = new ModeSettings("Type", "Fly mode", "Vanilla", this, "Vanilla", "MinelandPrisonSemiInf");
	public NumberSettings speed = new NumberSettings("Speed", "Fly Speed", 0.5, 0.1, 9.5, this);
	public BooleanSettings updown = new BooleanSettings("Up Down", "Let you go up or down", true, this);
	
	public Fly() {
		super("Fly", "Allows you to fly like a bird", Keyboard.KEY_F, Cat.MOVEMENT);
		this.addSettings(speed, mode, updown);
	}
	
	@Override
	public void onUpdate(EventUpdate e) {
		if (mode.is("Vanilla")) {
			mc.thePlayer.motionX = 0;
			mc.thePlayer.motionY = 0;
			mc.thePlayer.motionZ = 0;

			MoveUtils.strafe(speed.getFloatValue());
			if (updown.isToggled()) {
				if (mc.gameSettings.keyBindJump.isKeyDown()) {
					mc.thePlayer.motionY += speed.getFloatValue();
				}
			
				if (mc.gameSettings.keyBindSneak.isKeyDown()) {
					mc.thePlayer.motionY -= speed.getFloatValue();
				}
			}
		}
		if (mode.is("MinelandPrisonSemiInf")) {
			if (!((mc.thePlayer.ticksExisted % 15) == 0)) {
				/*mc.thePlayer.motionX=0;
				mc.thePlayer.motionZ = 0;
				MoveUtils.strafe(0);
				mc.thePlayer.jumpMovementFactor = 0;//0.02f;*/
				double val = 1.2E-7D;
				if (mc.thePlayer.ticksExisted % 2 == 0) {
					val = -val;
					
					mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + -val, mc.thePlayer.posZ);

					MoveUtils.strafe(0.20);

				}
				mc.thePlayer.motionY = 0;
			}
		}
		if (mode.is("TEST")) {
			if (!((mc.thePlayer.ticksExisted % 35) == 0)) {
				mc.thePlayer.motionX=0;
				mc.thePlayer.motionZ = 0;
				MoveUtils.strafe(0);
				mc.thePlayer.jumpMovementFactor = 0;//0.02f;
				double val = 1.2E-7D;
				if (mc.thePlayer.ticksExisted % 2 == 0) {
					val = -val;
				}
				if (mc.thePlayer.ticksExisted % 2 == 0) {
					mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + val, mc.thePlayer.posZ);
	
					MoveUtils.strafe(0.30);
	
				}
				mc.thePlayer.motionY = 0;
			} else {
				mc.thePlayer.motionX = 0;
				mc.thePlayer.posY = -1.2E-7D;
				mc.thePlayer.motionZ = 0;
			}
		}
	}
	
	
	
}

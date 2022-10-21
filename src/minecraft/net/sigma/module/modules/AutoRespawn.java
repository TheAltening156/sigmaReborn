package net.sigma.module.modules;

import net.sigma.event.events.EventUpdate;
import net.sigma.module.Cat;
import net.sigma.module.Module;
import net.sigma.utils.TimerUtils;

public class AutoRespawn extends Module{
	public TimerUtils timer = new TimerUtils();
	
	public AutoRespawn() {
		super("AutoRespawn", "Respawn Player Automatically", Cat.EXPLOIT);
	}
	
	@Override
	public void onUpdate(EventUpdate e) {
		mc.thePlayer.respawnPlayer();
		
	}
	
}

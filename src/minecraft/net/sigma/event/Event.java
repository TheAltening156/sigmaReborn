package net.sigma.event;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.sigma.Sigma;
import net.sigma.event.events.EventGetChat;
import net.sigma.event.events.EventIngameGui;
import net.sigma.event.events.EventUpdate;
import net.sigma.module.Module;
import net.sigma.module.ModuleManager;
import net.sigma.settings.Settings;

public class Event<T>{
	public boolean cancelled;
	public EventType type;
	
	public void onEvent(T e) {
		if (e instanceof EventUpdate) {
			Minecraft.getMinecraft().gameSettings.gammaSetting = 10;
		}
		if (e instanceof EventGetChat) {
			Sigma.c.onChat((EventGetChat) e);
		}
		
		for (Module m : ModuleManager.mods) {
			if (m.isToggled()) {
				if (e instanceof EventUpdate) {
					m.onUpdate((EventUpdate) e);
				}
				if (e instanceof EventIngameGui) {
					m.onIngameGui((EventIngameGui) e);
				}
				if (e instanceof EventGetChat) {
					m.onGetChat((EventGetChat) e);
				}
			}
		}
	}
	
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	
	public boolean isPre() {
		return type == EventType.PRE;
	}
	
	public boolean isPost() {
		return type == EventType.POST;
	}
	
	public void cancelEvent() {
		setCancelled(true);
	}
	
}

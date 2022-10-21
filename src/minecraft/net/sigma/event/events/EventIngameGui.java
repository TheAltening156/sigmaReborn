package net.sigma.event.events;

import net.sigma.event.Event;

public class EventIngameGui extends Event<EventIngameGui>{
	public float partialTicks;

	public EventIngameGui(float partialTicks) {
		this.partialTicks = partialTicks;
	}

	public float getPartialTicks() {
		return partialTicks;
	}

	public void setPartialTicks(float partialTicks) {
		this.partialTicks = partialTicks;
	}
	
	
}

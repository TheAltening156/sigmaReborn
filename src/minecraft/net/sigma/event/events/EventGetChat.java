package net.sigma.event.events;

import net.sigma.event.Event;

public class EventGetChat extends Event<EventGetChat>{
	public String message;
	
	public EventGetChat(String msg) {
		this.message = msg;
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return message;
	}
}

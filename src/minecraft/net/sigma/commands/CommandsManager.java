package net.sigma.commands;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

import net.sigma.commands.cmds.Bind;
import net.sigma.event.events.EventGetChat;

public class CommandsManager {
	public CopyOnWriteArrayList<Command> c = new CopyOnWriteArrayList<Command>();
	public String prefix = ".";
	
	public CommandsManager() {
		c.add(new Bind());
	}

	public void onChat(EventGetChat e) {
		String msg = e.getMessage();
		
		if (!msg.startsWith(prefix))
			return;
		e.cancelEvent();
		
		msg = msg.substring(prefix.length());
		
		if (msg.split(" ").length > 0) {
			String cmd = msg.split(" ")[0];
			for (Command c : this.c) {
				if (c.syntax.contains(cmd)) {
					c.onCommand(Arrays.copyOfRange(msg.split(" "), 1, msg.split(" ").length), msg);
				}
			}
		}
	}
	
}

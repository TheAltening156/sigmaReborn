package net.sigma.commands.cmds;

import net.sigma.commands.*;
import net.sigma.ui.GuiBindScreen;

public class Bind extends Command{

	public Bind() {
		super("Bind", "Bind a module to a key", "bind", "Bind", "b");
	}

	@Override
	public void onCommand(String[] args, String Command) {
		mc.displayGuiScreen(new GuiBindScreen());
		
	}

	
	
}

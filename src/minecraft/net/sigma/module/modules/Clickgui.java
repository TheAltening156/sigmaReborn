package net.sigma.module.modules;

import org.lwjgl.input.Keyboard;

import net.sigma.module.Cat;
import net.sigma.module.Module;
import net.sigma.ui.clickgui.ClickGUI;

public class Clickgui extends Module{

	public Clickgui() {
		super("ClickGui", "Show a gui with clickables modules", Keyboard.KEY_RSHIFT, Cat.RENDER);
	}
	
	@Override
	public void onEnable() {
		if (mc.currentScreen == null)
		mc.displayGuiScreen(new ClickGUI());
		
	}
	
}

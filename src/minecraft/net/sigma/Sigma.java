package net.sigma;

import org.lwjgl.opengl.Display;

import net.minecraft.client.Minecraft;
import net.sigma.commands.CommandsManager;
import net.sigma.event.Event;
import net.sigma.module.ModuleManager;
import net.sigma.module.modules.*;
import net.sigma.ui.*;
import viamcp.ViaMCP;

public class Sigma {
	public static String name = "Sigma - Remake";
	public static String version = "B0.4";
	public static Minecraft mc = Minecraft.getMinecraft();
	public static Event e = new Event();
	public static ModuleManager mod;
	public static CommandsManager c;
	public static boolean back = true;
	public static boolean back1 = true;
	public static Animations anims;
	public static Clickgui clickgui;
	public static HUD hud;
	public static boolean initialized;
	
	public static void start() {
		mc.gameSettings.showInventoryAchievementHint = false;
		mc.displayGuiScreen(new Switcher());
		Display.setTitle("Sigma - Remake Version Switcher");
		
		try {
			ViaMCP.getInstance().start();
			ViaMCP.getInstance().initAsyncSlider();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		initialized = false;
		
	}
	
	public static void initNormal() {
		Display.setTitle("Classic Sigma - Remake " + version + " | Minecraft 1.8.8");
		c = new CommandsManager();
		mod = new ModuleManager();
		mc.displayGuiScreen(new ClassicMainMenu());
		
		initialized = true;
	}
	
	public static void initJello() {
		Display.setTitle("Sigma Jello - Remake " + version + " | Minecraft 1.8.8");
		c = new CommandsManager();
		mod = new ModuleManager();
		mc.displayGuiScreen(new JelloMainMenu());
		
		initialized = true;
	}

	public static Event getEvent() {
		return e;
	}
	
}

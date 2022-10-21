package net.sigma.module;

import java.util.ArrayList;
import java.util.List;

import net.sigma.Sigma;
import net.sigma.module.modules.*;

public class ModuleManager {
	public static ArrayList<Module> mods = new ArrayList<Module>();
	
	public ModuleManager() {
		//to add module to game, use -> register(new moduleName());
		register(new Fly());
		register(Sigma.anims = new Animations());
		register(Sigma.clickgui = new Clickgui());
		register(Sigma.hud = new HUD());
		register(new AutoRespawn());
		
		
	}
	
	public boolean register(Module m) {
		return mods.add(m);
	}
	
	public static List<Module> getToggledModules() {
		List<Module> mod = new ArrayList<Module>();
		for(Module m : mods) {
			if (m.isToggled()) {
				mod.add(m);
			}
		}
		return mod;
	}
	
	
}

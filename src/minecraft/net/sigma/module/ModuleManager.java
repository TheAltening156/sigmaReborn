package net.sigma.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sigma.Sigma;
import net.sigma.module.modules.*;

public class ModuleManager {
	public static ArrayList<Module> mods = new ArrayList<Module>();
	
	public ModuleManager() {
		/*to add module to game, use -> register(new module1(),
												 new module2());*/
		register(new Fly(),
				 Sigma.anims = new Animations(),
				 Sigma.clickgui = new Clickgui(),
				 Sigma.hud = new HUD(),
				 new AutoRespawn());
		
		
	}
	
	public boolean register(Module... m) {
		return mods.addAll(Arrays.asList(m));
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

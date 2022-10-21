package net.sigma.settings;

import net.sigma.module.Module;

public abstract class Settings {
	public String name;
	public String desc;
	public Object var1;
	public Module parent;

	public abstract Object getVar();
	
	public abstract void setVar(Object var1);
}

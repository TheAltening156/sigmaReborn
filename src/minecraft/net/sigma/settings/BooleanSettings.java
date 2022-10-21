package net.sigma.settings;

import net.sigma.module.Module;

public class BooleanSettings extends Settings{
	public boolean toggled;

	public BooleanSettings(String name, String desc, boolean toggled, Module parent) {
		this.name = name;
		this.desc = desc;
		this.toggled = toggled;
		this.parent = parent;
	}
	
	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	
	public void toggle() {
		this.toggled = !this.toggled;
	}
	
	@Override
	public Boolean getVar() {
		return toggled;
	}
	
	@Override
	public void setVar(Object value) {
		if (value instanceof String) {
			if (((String) value).equalsIgnoreCase("true")) {
				this.toggled = true;
			} else if (((String) value).equalsIgnoreCase("false")) {
				this.toggled = false;
			}
		}
		if (value instanceof Boolean) {
			this.toggled = (boolean) value;
		}
	}
	
}

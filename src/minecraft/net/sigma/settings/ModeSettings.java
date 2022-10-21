package net.sigma.settings;

import java.util.Arrays;
import java.util.List;

import net.sigma.module.Module;

public class ModeSettings extends Settings{
	public List<String> modes;
	public int index;
	public boolean isShown;
	public String[] modess;
	
	public ModeSettings(String name,String desc, String def, Module parent, String... modes) {
		this.name = name;
		this.desc = desc;
		this.parent = parent;
		this.modes = Arrays.asList(modes);
		this.modess = modes;
		this.index = this.modes.indexOf(def);

	}
	
	public String[] getModess() {
		return modess;
	}
	
	public List<String> getMods() {
		return modes;
	}
	
	public String getMode() {
		return modes.get(index);
	}
	public void setModes(List<String> modes) {
		this.modes = modes;
	}
	public boolean is(String mode) {
		return index == modes.indexOf(mode);
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void cycle(boolean forward) {
		if (forward) {
			if (this.index > 0) {
				this.index--;
			} else {
				this.index = this.modes.size() - 1;
			}
		} else {
			if (index < modes.size() - 1) {
				index++;
			} else {
				index = 0;
			}
		}
	}
	
	@Override
	public void setVar(Object value) {
		if (value instanceof String) {
			for (String v : this.modes) {
				if (v.equalsIgnoreCase((String) value)) {
					this.index = modes.indexOf(v);
					return;
				}
			}
		}
	}

	@Override
	public String getVar() {
		return modes.get(index);
	}
	
}

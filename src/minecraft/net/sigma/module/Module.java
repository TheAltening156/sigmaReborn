package net.sigma.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.sigma.event.events.*;
import net.sigma.settings.*;

public class Module {
	private String name;
	private String desc;
	private int key = 0;
	private Cat cat;
	private boolean toggled;
	public boolean showSettings;
	public Minecraft mc = Minecraft.getMinecraft();
	public List<Settings> settings = new ArrayList<Settings>();
	
	public Module(String name, String desc, int key, Cat cat) {
		this.name = name;
		this.desc = desc;
		this.key = key;
		this.cat = cat;
	}
	
	public Module(String name, String desc, Cat cat) {
		this.name = name;
		this.desc = desc;
		this.key = 0;
		this.cat = cat;
	}
	
	public void addSettings(Settings... s) {
		settings.addAll(Arrays.asList(s));
		settings.sort(Comparator.comparingInt(se -> se instanceof ModeSettings ? 3 : 0));
		settings.sort(Comparator.comparingInt(se -> se instanceof NumberSettings ? 2 : 0));
		settings.sort(Comparator.comparingInt(se -> se instanceof BooleanSettings ? 1 : 0));
	}
	
	public boolean isToggled() {
		return toggled;
	}
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	public void toggle() {
		this.toggled = !this.toggled;
		if (this.toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate(EventUpdate e) {}
	public void onIngameGui(EventIngameGui e) {}
	public void onGetChat(EventGetChat e) {}
	
}

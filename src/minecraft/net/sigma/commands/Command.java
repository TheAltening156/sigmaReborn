package net.sigma.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;

public abstract class Command {
	public String name, desc;
	public List<String> syntax = new ArrayList<String>();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public Command(String name, String desc, String... syntax) {
		this.name = name;
		this.desc = desc;
		this.syntax = Arrays.asList(syntax);
	}
	
	public abstract void onCommand(String[] args, String Command);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String description) {
		this.desc = description;
	}
	
	public List<String> getSyntax() {
		return syntax;
	}

	public void setSyntax(List<String> syntax) {
		this.syntax = syntax;
	}
}

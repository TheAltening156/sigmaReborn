package net.sigma.module;

public enum Cat {
	COMBAT("Combat", 15, 15, false, true),
	MOVEMENT("Movement", 120, 15, false, true),
	PLAYER("Player", 225, 15, false, true),
	EXPLOIT("Exploit", 330, 15, false, true),
	RENDER("Render", 15, 180, false, true);
	
	public String name;
	public int posX;
	public int posY;
	public boolean clicked;
	public boolean showMods;
	
	Cat(String name, int posX, int posY, boolean clicked, boolean showMods) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.clicked = clicked;
		this.showMods = showMods;
	}
}

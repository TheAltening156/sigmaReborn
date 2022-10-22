package net.sigma.ui;

import java.awt.Font;
import java.io.InputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class FontManager {
	/*
	* jelloLight
	*/
	public static TTFFontRenderer jelloLight = getSizedFont("jellolight", 18);
	public static TTFFontRenderer jelloMedium = getSizedFont("jellomedium", 18);
	public static TTFFontRenderer jelloRegular = getSizedFont("jelloregular", 18);
	public static TTFFontRenderer jellofr = getSizedFont("Jello", 18);
	public static TTFFontRenderer sigmaJello = getFont("jellolight2");
	public static TTFFontRenderer sfUi = getSizedFont("sfui", 18);
	
	public static TTFFontRenderer getFont(String name) {
		return new TTFFontRenderer(name, 0, 18, 0, 1);
	}
	
	public static TTFFontRenderer getSizedFont(String name, int size) {
		return new TTFFontRenderer(name, 0, size, 0, 1);
	}
	
	public static TTFFontRenderer getFontQuality(String name, float quality) {
		return new TTFFontRenderer(name, 0, 18, 0, quality);

	} 
	
}

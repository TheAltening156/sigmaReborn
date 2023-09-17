package net.sigma.ui.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class FontManager {
	/*public static TTFFontRenderer jelloLight = getSizedFont("jellolight", 18);
	public static TTFFontRenderer jelloMedium = getSizedFont("jellomedium", 18);
	public static TTFFontRenderer jelloRegular = getSizedFont("jelloregular", 18);
	public static TTFFontRenderer jellofr = getSizedFont("Jello", 18);
	public static TTFFontRenderer sigmaJello = getFont("jellolight2");
	public static TTFFontRenderer sfUi = getSizedFont("sfui", 18);
	public static TTFFontRenderer sfm = getFontQuality("SFM", 0.5f);*/
	public static TTFFontRenderer jelloLight;
	public static TTFFontRenderer jelloMedium;
	public static TTFFontRenderer jelloRegular;
	public static TTFFontRenderer jellofr;
	public static TTFFontRenderer sigmaJello;
	public static TTFFontRenderer sfUi;
	public static TTFFontRenderer sfm;
	public static TTFFontRenderer sigma;

	
	public static void init() throws Exception{
		jelloLight = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/jellolight.ttf")).deriveFont(0, 18), true);
		jelloMedium = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/jellomedium.ttf")).deriveFont(0, 18), true);
		jelloRegular = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/jelloregular.ttf")).deriveFont(0, 18), true);
		jellofr = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/Jello.ttf")).deriveFont(0, 18), true);
		sigmaJello = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/jellolight2.ttf")).deriveFont(0, 18), true);
		sfUi = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/sfui.ttf")).deriveFont(0, 18), true);
		sfm = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/SFM.ttf")).deriveFont(0, 18), true);
		sigma = new TTFFontRenderer(Font.createFont(0, Font.class.getResourceAsStream("/assets/minecraft/Sigma/sigma.ttf")).deriveFont(0, 18), true);
	}


	public static TTFFontRenderer getFontQuality(String fontName, float size) {
		try {
			return new TTFFontRenderer(Font.createFont(0, FontManager.class.getResourceAsStream("/assets/minecraft/Sigma/" + fontName + ".ttf")).deriveFont(0, 18 * size), true);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		return jelloLight;
	}
	
}

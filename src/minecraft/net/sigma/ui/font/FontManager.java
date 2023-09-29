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
		jelloLight = createFont("jellolight");
		jelloMedium = createFont("jellomedium");
        jelloRegular = createFont("jelloregular");
        jellofr = createFont("Jello");
        sigmaJello = createFont("jellolight2");
        sfUi = createFont("sfui");
        sfm = createFont("SFM");
        sigma = createFont("sigma");	
	}

	public static TTFFontRenderer getFontQuality(String fontName, float size) {
		TTFFontRenderer font = null;
		try {
			return font = new TTFFontRenderer(Font.createFont(0, FontManager.class.getResourceAsStream("/assets/minecraft/Sigma/" + fontName + ".ttf")).deriveFont(0, 18 * size), true);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		return jelloLight;
	}

	public static TTFFontRenderer createFont(String fontName) {
		return getFontQuality(fontName, 1);
	}
	
}

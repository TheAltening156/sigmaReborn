package net.sigma.module.modules;

import java.awt.Color;
import java.util.Comparator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiOverlayDebug;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.sigma.Sigma;
import net.sigma.event.events.EventIngameGui;
import net.sigma.module.Cat;
import net.sigma.module.Module;
import net.sigma.module.ModuleManager;
import net.sigma.ui.FontManager;
import net.sigma.ui.TTFFontRenderer;
import net.sigma.utils.DrawUtils;

public class HUD extends Module{
	public TTFFontRenderer fr = FontManager.jelloLight;
	public TTFFontRenderer fr1 = FontManager.getFontQuality("jellolight", 1.1f);
	public static TTFFontRenderer bigfr = FontManager.getFontQuality("jellolight2", 3.3f);
	public static GuiOverlayDebug xddd = new GuiOverlayDebug(Minecraft.getMinecraft());
	
	public HUD() {
		super("ActiveMods", "Show Activated Modules", Cat.RENDER);
		
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
	}
	
	@Override
	public void onIngameGui(EventIngameGui e) {
		ScaledResolution sr = new ScaledResolution(mc);
		List list = xddd.getDebugInfoRight();
		List list1 = xddd.call();
		float sigmaY = 4;
		float sigmaX = 8;
		
		float modY = 2;
		if (mc.gameSettings.showDebugInfo) {
			sigmaX = sr.getScaledWidth() / 2;
			for (float i = 0; i < list.size(); ++i)
	        {
				float j = fr.getHeight();
				float i1 = 2 + j * i;
				modY = i1 + 10;
	        }
		}
		
		if (!mc.gameSettings.showDebugInfo) 
		DrawUtils.drawShadowImage((float) (sigmaX - 12 - fr.getWidth("Sigma") / 2) - 8, sigmaY - 8, 123, 50, new ResourceLocation("Sigma/arraylistshadow.png"));
		else
		DrawUtils.drawShadowImage((float) (sigmaX - 12 - fr.getWidth("Sigma") / 2) - 35, sigmaY - 8, 123, 50, new ResourceLocation("Sigma/arraylistshadow.png"));

		for (Module m : ModuleManager.getToggledModules()) {
			DrawUtils.drawShadowImage((float) (sr.getScaledWidth() - fr1.getWidth(m.getName()) - 14), modY - 5, 67, (float) fr1.getHeight(m.getName()) + 14, new ResourceLocation("Sigma/arraylistshadow.png"));
			modY+=13;
		}
		if (!mc.gameSettings.showDebugInfo) {
			bigfr.drawStringScaled("Sigma", sigmaX, sigmaY - 1, new Color(255, 255, 255, 130).getRGB(), 3.3f);
			FontManager.jelloMedium.drawCenteredString("Jello", sigmaX + 10, sigmaY + 28, new Color(255, 255, 255, 170).getRGB());

		} else { 
			bigfr.drawCenteredStringScaled("Sigma", sigmaX, sigmaY + 3, new Color(255, 255, 255, 130).getRGB(), 3.3f);
			FontManager.jelloMedium.drawString("Jello", sigmaX - 35, sigmaY + 28, new Color(255, 255, 255, 170).getRGB());
		}

		modY = 2;
		if (mc.gameSettings.showDebugInfo) {
			 for (float i = 0; i < list1.size(); ++i)
		        {
				 float j = fr.getHeight();
				 float l = 2 + j * i;
	                sigmaY = l + 10;
	            }
		        
			for (float i = 0; i < list.size(); ++i)
	        {
			float j = fr.getHeight();
			float i1 = 2 + j * i;
				modY = i1 + 10;
	        }
		}
		for (Module m : ModuleManager.getToggledModules()) {
			fr1.drawStringScaled(m.getName(), sr.getScaledWidth() - fr1.getWidth(m.getName()) - 8, modY, -1, 1.1f);
			modY += 13;
		}
		
	}
	
}

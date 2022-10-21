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
	public TTFFontRenderer bigfr;
	public static GuiOverlayDebug xddd = new GuiOverlayDebug(Minecraft.getMinecraft());
	
	public HUD() {
		super("ActiveMods", "Show Activated Modules", Cat.RENDER);
		
	}
	
	@Override
	public void onEnable() {
		bigfr = FontManager.getFontQuality("jellolight2", 3.3f);
		super.onEnable();
	}
	
	@Override
	public void onIngameGui(EventIngameGui e) {
		ScaledResolution sr = new ScaledResolution(mc);
		List list = xddd.getDebugInfoRight();
		List list1 = xddd.call();
		int sigmaY = 4;
		int sigmaX = 8;
		
		int modY = 2;
		if (mc.gameSettings.showDebugInfo) {
			sigmaX = sr.getScaledWidth() / 2;
			for (int i = 0; i < list.size(); ++i)
	        {
			int j = fr.FONT_HEIGHT;
            int i1 = 2 + j * i;
				modY = i1 + 10;
	        }
		}
		
		if (!mc.gameSettings.showDebugInfo) 
		DrawUtils.drawShadowImage((int) (sigmaX - 12 - fr.getWidth("Sigma") / 2) - 8, sigmaY - 8, 125, 50, new ResourceLocation("Sigma/arraylistshadow.png"));
		else
		DrawUtils.drawShadowImage((int) (sigmaX - 12 - fr.getWidth("Sigma") / 2) - 35, sigmaY - 8, 125, 50, new ResourceLocation("Sigma/arraylistshadow.png"));

		for (Module m : ModuleManager.getToggledModules()) {
			DrawUtils.drawShadowImage((int) (sr.getScaledWidth() - fr.getWidth(m.getName()) - 5), modY - 5, 60, (int) fr.getHeight(m.getName()) + 14, new ResourceLocation("Sigma/arraylistshadow.png"));
			
			//DrawUtils.drawShadowImage((int) (sr.getScaledWidth() - fr.getWidth(m.getName()) - 7), modY - 6, (int)(fr.getWidth(m.getName()) + 6), (int) fr.getHeight(m.getName()) + 12, new ResourceLocation("Sigma/arraylistshadow.png"));

			
			modY+=11;
		}
		if (!mc.gameSettings.showDebugInfo) {
			bigfr.drawStringScaled("Sigma", sigmaX, sigmaY - 2, new Color(255, 255, 255, 130).getRGB(), 3.3f);
			FontManager.jelloMedium.drawCenteredString("Jello", sigmaX + 10, sigmaY + 28, new Color(255, 255, 255, 170).getRGB());

		} else { 
			bigfr.drawCenteredStringScaled("Sigma", sigmaX, sigmaY , new Color(255, 255, 255, 130).getRGB(), 3.3f);
			FontManager.jelloMedium.drawString("Jello", sigmaX - 35, sigmaY + 26, new Color(255, 255, 255, 170).getRGB());
		}

		modY = 2;
		if (mc.gameSettings.showDebugInfo) {
			 for (int i = 0; i < list1.size(); ++i)
		        {
	                int j = fr.FONT_HEIGHT;
	                int l = 2 + j * i;
	                sigmaY = l + 10;
	            }
		        
			for (int i = 0; i < list.size(); ++i)
	        {
			int j = fr.FONT_HEIGHT;
           int i1 = 2 + j * i;
				modY = i1 + 10;
	        }
		}
		for (Module m : ModuleManager.getToggledModules()) {
			fr.drawString(m.getName(), (int) (sr.getScaledWidth() - fr.getWidth(m.getName()) - 5), modY, -1);
			modY += 11;
		}
		
	}

	public static class Sort implements Comparator<Module>{
		Minecraft mc = Minecraft.getMinecraft();
		@Override
		public int compare(Module first, Module second) {
			if (Sigma.hud.fr.getWidth(first.getName()) < Sigma.hud.fr.getWidth(second.getName())) {
				return 1;
			}
			if (Sigma.hud.fr.getWidth(first.getName()) > Sigma.hud.fr.getWidth(second.getName())) {
				return -1;
			}
			return 0;
		}
	}
	
	
	
}

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
import net.sigma.ui.font.FontManager;
import net.sigma.ui.font.TTFFontRenderer;
import net.sigma.utils.DrawUtils;

public class HUD extends Module{
	public TTFFontRenderer fr;
	public TTFFontRenderer fr1;
	public static TTFFontRenderer bigfr;
	public static GuiOverlayDebug xddd = new GuiOverlayDebug(Minecraft.getMinecraft());
	
	public HUD() {
		super("ActiveMods", "Show Activated Modules", Cat.RENDER);
		fr = FontManager.jelloLight;
		fr1 = FontManager.getFontQuality("jellolight", 1.1f);
		bigfr = FontManager.getFontQuality("jellolight2", 3.3f);
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
		float sigmaX;
		float sigmaY = 5;
		float modY = 2;
		sigmaX =mc.gameSettings.showDebugInfo ? sr.getScaledWidth() / 2 : 45;
		
		for (float i = 0; i < list.size(); ++i) {
			float i1 = 2 + fr.getHeight() * i;
			modY = mc.gameSettings.showDebugInfo ? i1 + 13 : 5;
        }
		DrawUtils.drawShadowImage((float) (sigmaX - 12 - fr.getWidth("Sigma") / 2) - (!mc.gameSettings.showDebugInfo ? 35 : 28), sigmaY - 10, 123, 50, new ResourceLocation("Sigma/arraylistshadow.png"));

		bigfr.drawCenteredString("Sigma", sigmaX + (!mc.gameSettings.showDebugInfo ? 4 : 0), sigmaY + 10, new Color(255, 255, 255, 130).getRGB());
		FontManager.jelloMedium.drawCenteredString("Jello", sigmaX - (!mc.gameSettings.showDebugInfo ? 28 : 31), sigmaY + 28, new Color(255, 255, 255, 170).getRGB());
		
		for (Module m : ModuleManager.getToggledModules()) {
			DrawUtils.drawShadowImage((float) (sr.getScaledWidth() - fr1.getWidth(m.getName()) - 14), modY - 5, 67, (float) fr1.getHeight(m.getName()) + 14, new ResourceLocation("Sigma/arraylistshadow.png"));
			fr1.drawString(m.getName(), sr.getScaledWidth() - fr1.getWidth(m.getName()) - 8, modY, -1);
			modY += 13;
		}
		
	}
	
}

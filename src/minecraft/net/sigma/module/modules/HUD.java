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
	public ScaledResolution sr;
	public static TTFFontRenderer bigfr;
	public static GuiOverlayDebug xddd = new GuiOverlayDebug(Minecraft.getMinecraft());
	
	public HUD() {
		super("ActiveMods", "Show Activated Modules", Cat.RENDER);
		sr = new ScaledResolution(mc);
		fr = FontManager.jelloLight;
		fr1 = FontManager.getFontQuality("jellolight", 1.15f);
		bigfr = FontManager.getFontQuality("jellolight2", 3.3f);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
	}
	
	@Override
	public void onIngameGui(EventIngameGui e) {
		sr = new ScaledResolution(mc);
		float modY = 2;
		for (float i = 0; i < xddd.getDebugInfoRight().size(); ++i) {
			float i1 = 2 + fr.getHeight() * i;
			modY = mc.gameSettings.showDebugInfo ? i1 + 13 : 5;
        }
		for (Module m : ModuleManager.getToggledModules()) {
			DrawUtils.drawShadowImage((float) (sr.getScaledWidth() - fr1.getWidth(m.getName()) - 16), modY - 12, fr1.getWidth(m.getName())*2, (float) fr1.getHeight(m.getName()) + 20, new ResourceLocation("Sigma/arraylistshadow.png"));
			fr1.drawString(m.getName(), sr.getScaledWidth() - fr1.getWidth(m.getName()) - 8, modY, -1);
			modY += 13;
		}
		
	}
	
}

package net.sigma.ui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.sigma.Sigma;
import net.sigma.ui.components.JelloButtons;
import net.sigma.ui.font.FontManager;
import net.sigma.ui.font.TTFFontRenderer;
import net.sigma.utils.DrawUtils;
import viamcp.ViaMCP;

public class JelloMainMenu extends GuiScreen {
	private TTFFontRenderer bigfr;
	public static TTFFontRenderer sigmaJello;
	private float animatedMouseX;
	private float animatedMouseY;
	private boolean hovered;	
	@Override
	public void initGui() {
		animatedMouseX = 0;
		animatedMouseY = 0;
		int x = this.width / 2 - 152;
		int y = this.height / 2 + 5;
		buttonList.add(new JelloButtons(0, x, y, "Singleplayer"));
		buttonList.add(new JelloButtons(1, x + 61, y, "Multiplayer"));
		buttonList.add(new JelloButtons(2, x + 122, y, "Connect"));
		buttonList.add(new JelloButtons(3, x + 183, y, "Settings"));
		buttonList.add(new JelloButtons(4, x + 244, y, "AltManager"));
		if (sigmaJello == null || bigfr == null) {
			bigfr = FontManager.getFontQuality("JelloLight1", 10);
			sigmaJello = FontManager.getFontQuality("jellolight2", 1.1f);
		}
		super.initGui();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("Sigma/jellomenu.png"));
		this.drawModalRectWithCustomSizedTexture(-animatedMouseX / 1.43f,  -animatedMouseY / 10.15f, 0.0f, 0.0f, this.width * 1.7, this.height * 1.1, this.width * 1.7, this.height* 1.1);
		
		DrawUtils.drawShadowImage(this.width / 2 - 115, this.height / 2 - 90, 235, 90, new ResourceLocation("Sigma/shadow.png"));
		
		bigfr.drawCenteredString("Jello", this.width / 2 + 5, this.height / 2 - 55, -1);
				
		DrawUtils.drawShadowImage(1, this.height - 14, sigmaJello.getWidth("\u00a9 Sigma Reborn") + 25, 9, new ResourceLocation("Sigma/arraylistshadow.png"));
		sigmaJello.drawString("\u00a9 Sigma Reborn", 4, this.height - 16, -1);
		String namem = "Jello for Sigma " + Sigma.version + " - 1.7.x - 1.19.x";
		sigmaJello.drawString(namem, width - sigmaJello.getWidth(namem) + 69, this.height - 16, -1);
		
		for (GuiButton b : this.buttonList) {
			if (b instanceof JelloButtons) {
				((JelloButtons) b).drawButton(mc, mouseX, mouseY);
				((JelloButtons) b).drawName();
			}
		}
		animatedMouseX = mouseX;
		animatedMouseY = mouseY;
		super.drawScreen(mouseX, mouseY, partialTicks);

	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 0) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if (button.id == 1) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if (button.id == 2) {
			
		}
		if (button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if (button.id == 4) {
			
		}
	}
}

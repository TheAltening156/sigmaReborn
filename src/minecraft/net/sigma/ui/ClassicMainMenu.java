package net.sigma.ui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.sigma.ui.components.ClassicButtons;
import net.sigma.utils.DrawUtils;

public class ClassicMainMenu extends GuiScreen {
	private TTFFontRenderer fr = FontManager.getFontQuality("SFM", 0.57f);
	private int animatedMouseX;
	private int animatedMouseY;

	@Override
	public void initGui() {
		animatedMouseX = 0;
		animatedMouseY = 0;
		int wIdth = width / 2 - 50;
		int hEight = height / 2 - 50;
		buttonList.add(new ClassicButtons(0, wIdth - 90, hEight, "Singleplayer"));
		buttonList.add(new ClassicButtons(1, wIdth - 30, hEight, "Multiplayer"));
		buttonList.add(new ClassicButtons(2, wIdth + 30, hEight, "Options"));
		buttonList.add(new ClassicButtons(3, wIdth + 90, hEight, "Language"));
		
		buttonList.add(new ClassicButtons(4, wIdth - 65, hEight + 75, "Accounts"));
		buttonList.add(new ClassicButtons(5, wIdth + 65, hEight + 75, "Exit"));
		buttonList.add(new ClassicButtons(6, wIdth, hEight + 75, "Agora"));
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("Sigma/classicblur.png"));
		GlStateManager.color(1, 1, 1, 1.0f);
		this.drawModalRectWithCustomSizedTexture(-10 + animatedMouseX / 125f, -4 + animatedMouseY / 90f, 0.0f, 0.0f, this.width * 1.008f + 10, this.height * 1.009f + 4, this.width * 1.008f + 10, this.height * 1.009 + 4);
		GlStateManager.bindTexture(0);
		GlStateManager.pushMatrix();
		GlStateManager.translate(-10 + animatedMouseX / 40f, -4 + animatedMouseY / 50f, 0);
		double x = this.width / 2 - 113.5;
		double y = this.height / 2 - 47;
		DrawUtils.drawImage(this.width / 2 - 68, this.height / 2 - 110, 150, 48.75, new ResourceLocation("Sigma/mainmenu/classic/big.png"));
		for (Object o : this.buttonList) {
			GuiButton b = (GuiButton) o;
			if (b instanceof ClassicButtons) {
				b.drawButton(mc, mouseX, mouseY);
			}
		}
		GlStateManager.popMatrix();
		GL11.glPushMatrix();
		GL11.glTranslated(2, height - fr.getHeight() - 13, 0.0);
		GL11.glScaled(0.57f, 0.57f, 0.57f);
		fr.drawStringWithShadow("Hello " + EnumChatFormatting.GREEN + mc.getSession().getUsername() + "\247f!", 0, 0, -1);
		fr.drawStringWithShadow("You are using the last version!", 0, 18, -1);
		GL11.glPopMatrix();
		animatedMouseX = mouseX;
		animatedMouseY = mouseY;
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		GlStateManager.pushMatrix();
		GlStateManager.translate(-10 + animatedMouseX / 40f, -4 + animatedMouseY / 50f, 0);
		double x = this.width / 2 - 123.5;
		double y = this.height / 2 - 47;
		for (int i : new int[] {0, 1, 2, 3, 4, 5, 6}) {
			boolean b = i == 4 || i == 5 || i == 6;
			if (isHovered(b ? x - 212 : x, b ? y + 73 : y, b ? x - 161 : x + 47, b ? y + 119.5 :y + 46.5, mouseX, mouseY)) {
				switch(i) {
					case 0:
						mc.displayGuiScreen(new GuiSelectWorld(this));
						break;
					case 1: 
						mc.displayGuiScreen(new GuiMultiplayer(this));
						break;
					case 2:
						mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
						break;
					case 3:
						 mc.displayGuiScreen(new GuiLanguage(this, mc.gameSettings, mc.getLanguageManager()));
						break;
					case 4:
						break;
					case 5:
						
						break;
					case 6:
						mc.shutdown();
						break;
				}
			}
			x += 63;
		}
		GlStateManager.popMatrix();
		animatedMouseX = mouseX;
		animatedMouseY = mouseY;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		/*if (button.id == 0) {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        } else if (button.id == 1) {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        } else if (button.id == 2) {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        } else if (button.id == 3) {
            mc.displayGuiScreen(new GuiLanguage(this, mc.gameSettings, mc.getLanguageManager()));
        } else if (button.id == 4) {
            //mc.displayGuiScreen(new GuiAltManager());
        } else if (button.id == 5) {
            mc.shutdown();
        } else if (button.id == 6) {
        	//mc.displayGuiScreen(new GuiAltManager());
        }*/
	}
	
	
}

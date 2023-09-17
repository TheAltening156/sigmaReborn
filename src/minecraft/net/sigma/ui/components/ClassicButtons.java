package net.sigma.ui.components;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.sigma.ui.font.FontManager;
import net.sigma.ui.font.TTFFontRenderer;

public class ClassicButtons extends GuiButton {
	private ResourceLocation icon;
	private int index = 0;
	private boolean movingUp;

	public ClassicButtons(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, 50, 50, buttonText);
		icon = new ResourceLocation("Sigma/mainmenu/classic/" + buttonText + ".png");
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (this.visible) {
			hovered = visible && isHovered(xPosition + width / 2 - 4, yPosition + height / 2 - 24, xPosition + width / 2 + 43, yPosition + height / 2 + 35, mouseX, mouseY);
			mouseDragged(mc, mouseX, mouseY);
			int text = hovered ? new Color(255, 255, 255, 255).getRGB() : new Color(232, 232, 232, 255).getRGB();
			if (hovered && index < 1) {
				movingUp = true;
			} else if (index == 14 && movingUp && !hovered) {
				movingUp = false;
			}

			if (movingUp && index < 14) {
				index++;
			} else if (index > 0 && !movingUp) {
				index--;
			}
			GlStateManager.pushMatrix();
			float offset = (xPosition + width / 2);
			GlStateManager.translate(offset, (yPosition + getPosition(index)), 1);
			GlStateManager.enableAlpha();
			TTFFontRenderer font = FontManager.sfm;
			GL11.glPushMatrix();
			GL11.glTranslated(50/2, 55, 0.0);
			GL11.glScaled(0.5, 0.5, 0.5);
			font.drawCenteredStringWithShadow(displayString, 0, 0, text);
			GL11.glPopMatrix();
			GlStateManager.enableBlend();
			mc.getTextureManager().bindTexture(icon);
			drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 50, 50, 50, 50);
			GlStateManager.bindTexture(0);
			GlStateManager.disableAlpha();
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
	}

	public float getPosition(int index) {
		if (movingUp) {
			return new float[] {0, -48.839F, -107.135F, -147.163F, -159.884F, -148.736F, -128.329F, -112.506F,
					-107.611F, -117.462F, -123.848F, -118.805F, -120.371F, -119.885F, -120}[index] / 10;
		} else {
			return new float[] { 0, -0.115F, 0.371F, -1.195F, 3.848F, -2.538F, -12.389F, -7.494F, 8.329F, 28.736F,
					39.884F, 27.163F, -12.865F, -71.161F, -120 }[index] / 10;
		}
	}
}

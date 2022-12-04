package net.sigma.ui.components;

import java.awt.Color;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.sigma.ui.FontManager;
import net.sigma.ui.TTFFontRenderer;

public class JelloButtons extends GuiButton{
	private boolean movingUp;
	private int index;
	private ResourceLocation icon;
	
	public JelloButtons(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, 64, 64, buttonText);
		icon = new ResourceLocation("Sigma/mainmenu/" + buttonText + ".png");
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (this.visible) {
			hovered = isHovered(xPosition + width / 2 - 33, yPosition, xPosition + width / 2 + 31, yPosition + 64, mouseX, mouseY);
			boolean xd = hovered && Mouse.isButtonDown(0);
			mouseDragged(mc, mouseX, mouseY);
			GlStateManager.pushMatrix();
			float offset = (xPosition + width / 2 - 33);
			GlStateManager.translate(offset, yPosition, 1);
			GlStateManager.enableBlend();
			GlStateManager.disableAlpha();
			GlStateManager.color(xd ? 0.9f : 1.0f, xd ? 0.9f : 1.0f, xd ? 0.9f : 1.0f, 1.0f);
			Minecraft.getMinecraft().getTextureManager().bindTexture(icon);
		    GL11.glTexParameteri(3553, 10240, 9729);
		    GL11.glTexParameteri(3553, 10241, 9729);
		    drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 64, 64, 64, 64);
			GlStateManager.bindTexture(0);
			GlStateManager.disableAlpha();
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
	}
}

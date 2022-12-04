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
import net.sigma.utils.DrawUtils;

public class JelloButtons extends GuiButton{
	public String name;
	private boolean movingUp;
	private int index;
	private ResourceLocation icon;
	private TTFFontRenderer fr = FontManager.getFontQuality("jellolight", 1.4f);
	public float val = 1;
	
	public JelloButtons(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, 64, 64, buttonText);
		icon = new ResourceLocation("Sigma/mainmenu/" + buttonText + ".png");
		this.name = buttonText;
		val = 1;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (this.visible) {
			hovered = isHovered(xPosition + width / 2 - 26, yPosition + 6, xPosition + width / 2 + 23, yPosition + 55, mouseX, mouseY);
			if (val < 1 || val < 180 && hovered) {
				val+=18;
			} else if (!hovered && val > 1 || val != 1) {
				val-=18;
			}
			boolean xd = hovered && Mouse.isButtonDown(0);
			mouseDragged(mc, mouseX, mouseY);
			GlStateManager.pushMatrix();
			float offset = (xPosition + width / 2 - 33);
			GlStateManager.translate(offset, yPosition, 1);
			GlStateManager.enableBlend();
			GlStateManager.disableAlpha();
			GlStateManager.color(xd ? 0.9f : 1.0f, xd ? 0.9f : 1.0f, xd ? 0.9f : 1.0f, 1.0f);
			Minecraft.getMinecraft().getTextureManager().bindTexture(icon);
		    //GL11.glTexParameteri(3553, 10240, 9729);
		    GL11.glTexParameteri(3553, 10241, 9729);
		    double vall = val/13;
		    double xx = -vall /2;
		    double yy = -vall;
		    double ww = 64 + vall;
		    double hh = 64 + vall;
		    drawModalRectWithCustomSizedTexture(xx,yy, 0, 0, ww,hh,ww,hh);
			GlStateManager.bindTexture(0);
			GlStateManager.disableAlpha();
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
	}
	public void drawName() {
		if (hovered)
		DrawUtils.drawShadowImage(xPosition - 22, yPosition + 60, fr.getWidth(name) + 75, 17, new ResourceLocation("Sigma/shadow.png"));
		fr.drawCenteredStringScaled(name, xPosition + 31, yPosition + 60, new Color(255, 255, 255, (int)val).getRGB(),0.5f + val/180);

	}
}

package net.sigma.ui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.google.gson.JsonSyntaxException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.sigma.Sigma;
import net.sigma.ui.font.FontManager;
import net.sigma.ui.font.TTFFontRenderer;
import net.sigma.utils.DrawUtils;

public class Switcher extends GuiScreen{
	private static boolean x;
	private static boolean x1;
	private static boolean x2;
	private static float animatedMouseX;
	private static float animatedMouseY;
	private static ResourceLocation blur = new ResourceLocation("shader/post/blur.json");
	/*TTFFontRenderer sigmaFr = FontManager.getFontQuality("sigma", 4.5f);
	TTFFontRenderer prodFr = FontManager.getFontQuality("sigma", 2f);
	TTFFontRenderer jell = FontManager.getFontQuality("jelloregular", 1.2f);
	TTFFontRenderer sigma = FontManager.getFontQuality("jellolight2", 1.3f);
	TTFFontRenderer jello = FontManager.getFontQuality("jellolight2", 0.62f);*/
	
	TTFFontRenderer sigmaFr;
	TTFFontRenderer prodFr;
	TTFFontRenderer jell;
	TTFFontRenderer sigma;
	public Switcher() {
		animatedMouseX = 0;
		animatedMouseY = 0;
	}
	
	@Override
	public void initGui() {
		if (sigmaFr == null) {
			sigmaFr = FontManager.getFontQuality("Sigma", 5.5f);
			prodFr = FontManager.getFontQuality("Sigma", 2.5f);
			jell = FontManager.getFontQuality("jelloregular", 1.2f);
			sigma = FontManager.getFontQuality("jellolight2", 1.3f);
		}
	}
	
	@Override
	public void onGuiClosed() {

	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == Keyboard.KEY_ESCAPE) {
			mc.displayGuiScreen(this);
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Sigma/bg.png"));
        GlStateManager.color(0.6f, 0.6f, 0.6f, 1.0f);
		this.drawModalRectWithCustomSizedTexture(-animatedMouseX / 28f, -animatedMouseY / 27f, 0.0f, 0.0f, this.width * 1.04f, this.height * 1.04f, this.width * 1.04f, this.height * 1.04);
		
		GlStateManager.color(1, 1, 1, 1);
		sigmaFr.drawCenteredString("SIGMA", this.width / 2 - 28, this.height / 2 - 70, -1);
		prodFr.drawCenteredString("PROD", this.width / 2 + 75, this.height / 2 - 80, -1);
		{
			this.drawRect(this.width / 2 - 170, this.height / 2 - 32, this.width / 2 + 170, this.height / 2 + 20, new Color(255, 255, 255, 50).getRGB());		
			if (x) this.drawRect(this.width / 2 - 170, this.height / 2 - 32, this.width / 2 + 170, this.height / 2 + 20, new Color(145, 0, 145, 80).getRGB());		
			
			jell.drawString("No Addons", this.width / 2 + 166 - jell.getWidth("No Addons"), (float) (this.height / 2 - 18), -1);
			FontManager.jelloLight.drawString("1.7.x - 1.19.x", this.width / 2 + 177 - jell.getWidth("1.7.x - 1.19.x"), (float) (this.height / 2  - 5), -1);
			{
				GlStateManager.disableAlpha();
				GlStateManager.enableBlend();
				GL11.glDepthMask(false);
				Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Sigma/switcher/normal.png"));
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8f);
				drawModalRectWithCustomSizedTexture(this.width / 2 - 170, this.height / 2 - 32, 0.0f, 0.0f, 141, 52, 141, 52);
				GL11.glDepthMask(true);
				GlStateManager.disableBlend();
				GlStateManager.enableAlpha();	
			}
		}
		
		{
			this.drawRect(this.width / 2 - 170, this.height / 2 + 28, this.width / 2 - 5, this.height / 2 + 70, new Color(255, 255, 255, 50).getRGB());
			if (x1) this.drawRect(this.width / 2 - 170, this.height / 2 + 28, this.width / 2 - 5, this.height / 2 + 70, new Color(145, 0, 145, 80).getRGB());

			jell.drawString("Classic", this.width / 2 - 10 - jell.getWidth("Classic"), (float) (this.height / 2 + 44), -1);
			FontManager.jelloLight.drawString("1.7.x - 1.19.x", this.width / 2 - 20 - FontManager.jelloRegular.getWidth("1.7.x - 1.19.x Classic"), (float) (this.height / 2 + 45), -1);
			
			{
				float x1 = 27f;
				float y1 = 42f;
				GlStateManager.disableAlpha();
				GlStateManager.enableBlend();
				GL11.glDepthMask(false);
		        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Sigma/switcher/old.png"));
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8f);
		        drawModalRectWithCustomSizedTexture(this.width / 2 - 170, this.height / 2 + 28, 0.0f, 0.0f, x1, y1, x1, y1);
		        GL11.glDepthMask(true);
		        GlStateManager.disableBlend();
				GlStateManager.enableAlpha();
			}
		}
		
		{
			
			this.drawRect(this.width / 2 + 5, this.height / 2 + 28, this.width / 2 + 170, this.height / 2 + 70, new Color(255, 255, 255, 50).getRGB());
			if (x2) this.drawRect(this.width / 2 + 5, this.height / 2 + 28, this.width / 2 + 170, this.height / 2 + 70, new Color(145, 0, 145, 80).getRGB());
			
			jell.drawString("Jello", this.width / 2 + 166 - jell.getWidth("Jello"), (float) (this.height / 2 + 44), -1);
			FontManager.jelloLight.drawString("1.7.x - 1.19.x", this.width / 2 + 160 - FontManager.jelloRegular.getWidth("1.7.x - 1.19.x Jello"), (float) (this.height / 2 + 45), -1);
			{
				float x1 = 165f;
				float y1 = 42;
				GlStateManager.disableAlpha();
				GlStateManager.enableBlend();
				GL11.glDepthMask(false);
		        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Sigma/switcher/new.png"));
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8f);
		        drawModalRectWithCustomSizedTexture(this.width / 2 + 5, this.height / 2 + 28, 0.0f, 0.0f, x1, y1, x1, y1);
		        GL11.glDepthMask(true);
		        GlStateManager.disableBlend();
				GlStateManager.enableAlpha();
			}
		}
		x  = isHovered(this.width / 2 - 170, this.height / 2 - 32, this.width / 2 + 170, this.height / 2 + 20, mouseX, mouseY);
		x1 = isHovered(this.width / 2 - 170, this.height / 2 + 28, this.width / 2 - 5,   this.height / 2 + 70, mouseX, mouseY);
		x2 = isHovered(this.width / 2 + 5,   this.height / 2 + 28, this.width / 2 + 170, this.height / 2 + 70, mouseX, mouseY);
        animatedMouseX = mouseX;
        animatedMouseY = mouseY;
	}
	
	@Override
	public void updateScreen() {

		super.updateScreen();
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (mouseButton != 0) return;
		if (!Sigma.initialized) {
			if (x) {
				mc.displayGuiScreen(new GuiMainMenu());
				Display.setTitle("Sigma - Remake | Minecraft 1.8.8");
			}
			if (x1) {
				Sigma.initNormal();
			}
			if (x2) {
				Sigma.initJello();
			}
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
}

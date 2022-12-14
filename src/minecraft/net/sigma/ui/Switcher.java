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
import net.sigma.utils.DrawUtils;

public class Switcher extends GuiScreen{
	private static double posYHovered1;
	private static double posYHovered2;
	private static double posYHovered3;
	private static boolean x;
	private static boolean x1;
	private static boolean x2;
	private static float animatedMouseX;
	private static float animatedMouseY;
	double val;
	double val1;
	double val2;
	private static ResourceLocation blur = new ResourceLocation("shader/post/blur.json");
	TTFFontRenderer sigmaFr = FontManager.getFontQuality("sigma", 4.5f);
	TTFFontRenderer prodFr = FontManager.getFontQuality("sigma", 2f);
	TTFFontRenderer jell = FontManager.getFontQuality("jelloregular", 1.2f);
	TTFFontRenderer sigma = FontManager.getFontQuality("jellolight2", 1.3f);
	TTFFontRenderer jello = FontManager.getFontQuality("jellolight2", 0.62f);

	public Switcher() {
		animatedMouseX = 0;
		animatedMouseY = 0;
		posYHovered1 = -0.7999999999999998;
		posYHovered2 = -0.7999999999999998;
		posYHovered3 = -0.7999999999999998;
		val = -0.7999999999999998;
		val1 = -0.7999999999999998;
		val2 = -0.7999999999999998;
	}
	
	@Override
	public void initGui() {
	}
	
	@Override
	public void onGuiClosed() {

	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Sigma/bg.png"));
        GlStateManager.color(0.6f, 0.6f, 0.6f, 1.0f);
		this.drawModalRectWithCustomSizedTexture(-animatedMouseX / 28f, -animatedMouseY / 27f, 0.0f, 0.0f, this.width * 1.04f, this.height * 1.04f, this.width * 1.04f, this.height * 1.04);
		
		GlStateManager.color(1, 1, 1, 1);
		sigmaFr.drawStringScaled("Sigma", this.width / 2 - 83, this.height / 2 - 100, -1, 4.5f);
		prodFr.drawStringScaled("PROD", this.width / 2 + 65, this.height / 2 - 95, -1, 2f);

		{
			this.drawRect(this.width / 2 - 170, this.height / 2 - 32 - posYHovered1, this.width / 2 + 170, this.height / 2 + 20 - posYHovered1, new Color(0, 0, 0, 150).getRGB());		
			if (x) this.drawRect(this.width / 2 - 170, this.height / 2 - 32 - posYHovered1, this.width / 2 + 170, this.height / 2 + 20 - posYHovered1, new Color(145, 0, 145, 100).getRGB());		
			jell.drawStringScaled("No Addons", this.width / 2 + 155 - jell.getWidth("No Addons"), (float) (this.height / 2 - 21 - posYHovered1), -1, 1.2f);
			FontManager.jelloLight.drawString("1.7.x - 1.19.x", this.width / 2 + 185 - jell.getWidth("1.7.x - 1.19.x Jello"), (float) (this.height / 2  - 8.5 - posYHovered1), -1);
		
			{
				
				GlStateManager.disableAlpha();
				GlStateManager.enableBlend();
				GL11.glDepthMask(false);
		        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Sigma/switcher/normal.png"));
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8f);
		        drawModalRectWithCustomSizedTexture(this.width / 2 - 170, this.height / 2 - 32 - posYHovered1, 0.0f, 0.0f, 141, 52, 141, 52);
		        GL11.glDepthMask(true);
		        GlStateManager.disableBlend();
				GlStateManager.enableAlpha();
			}
		}
		
		{
			this.drawRect(this.width / 2 - 170, this.height / 2 + 28 - posYHovered2, this.width / 2 - 5, this.height / 2 + 70 - posYHovered2, new Color(0, 0, 0, 150).getRGB());
			if (x1) this.drawRect(this.width / 2 - 170, this.height / 2 + 28 - posYHovered2, this.width / 2 - 5, this.height / 2 + 70 - posYHovered2, new Color(145, 0, 145, 100).getRGB());

			jell.drawStringScaled("Classic", this.width / 2 - 16 - jell.getWidth("Classic"), (float) (this.height / 2 + 41 - posYHovered2), -1, 1.21f);
			FontManager.jelloLight.drawString("1.7.x - 1.19.x", this.width / 2 - 26 - FontManager.jelloRegular.getWidth("1.7.x - 1.19.x Jello"), (float) (this.height / 2 + 42.5 - posYHovered2), -1);
			
			{
				float x1 = 27f;
				float y1 = 42f;
				GlStateManager.disableAlpha();
				GlStateManager.enableBlend();
				GL11.glDepthMask(false);
		        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Sigma/switcher/old.png"));
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8f);
		        drawModalRectWithCustomSizedTexture(this.width / 2 - 170, this.height / 2 + 28 - posYHovered2, 0.0f, 0.0f, x1, y1, x1, y1);
		        GL11.glDepthMask(true);
		        GlStateManager.disableBlend();
				GlStateManager.enableAlpha();
			}
		}
		
		{
			
			this.drawRect(this.width / 2 + 5, this.height / 2 + 28 - posYHovered3, this.width / 2 + 170, this.height / 2 + 70 - posYHovered3, new Color(0, 0, 0, 150).getRGB());
			if (x2) this.drawRect(this.width / 2 + 5, this.height / 2 + 28 - posYHovered3, this.width / 2 + 170, this.height / 2 + 70 - posYHovered3, new Color(145, 0, 145, 100).getRGB());
			
			//Fake 
			/*sigma.drawStringScaled("Sigma", this.width / 2 + 9, this.height / 2 + 29 - posYHovered3, new Color(255, 255, 255, 130).getRGB(), 1.3f);
			jello.drawStringScaled("Jello", this.width / 2 + 9, this.height / 2 + 40.7 - posYHovered3, new Color(255, 255, 255, 130).getRGB(), 0.62f);
			
			drawRect(this.width / 2 + 9, this.height / 2 + 48 - posYHovered3, this.width / 2 + 32, this.height / 2 + 67 - posYHovered3, new Color(255, 255, 255, 60).getRGB());
			jello.drawStringScaled("Move", this.width / 2 + 13, this.height / 2 + 48 - posYHovered3, new Color(255, 255, 255, 180).getRGB(), 0.62f);
			jello.drawStringScaled("Player", this.width / 2 + 11, this.height / 2 + (48 + 6) - posYHovered3, new Color(255, 255, 255, 180).getRGB(), 0.62f);
			jello.drawStringScaled("Combat", this.width / 2 + 11, this.height / 2 + (48 + 12) - posYHovered3, new Color(255, 255, 255, 180).getRGB(), 0.62f);
*/
			jell.drawStringScaled("Jello", this.width / 2 + 161 - jell.getWidth("Jello"), (float) (this.height / 2 + 41 - posYHovered3), -1, 1.2f);
			FontManager.jelloLight.drawString("1.7.x - 1.19.x", this.width / 2 + 162 - FontManager.jelloRegular.getWidth("1.7.x - 1.19.x Jello"), (float) (this.height / 2 + 42.5 - posYHovered3), -1);
			{
				float x1 = 165f;//165 //125
				float y1 = 42;
				GlStateManager.disableAlpha();
				GlStateManager.enableBlend();
				GL11.glDepthMask(false);
		        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Sigma/switcher/new.png"));
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8f);
		        drawModalRectWithCustomSizedTexture(this.width / 2 + 5, this.height / 2 + 28 - posYHovered3, 0.0f, 0.0f, x1, y1, x1, y1);
		        GL11.glDepthMask(true);
		        GlStateManager.disableBlend();
				GlStateManager.enableAlpha();
			}
		}
		
		
		if (isHovered(this.width / 2 - 170, this.height / 2 - 32, this.width / 2 + 170, this.height / 2 + 20, mouseX, mouseY) ) {
			x = true;
		} else {
			x = false;
		}
		if (isHovered(this.width / 2 - 170, this.height / 2 + 28, this.width / 2 - 5, this.height / 2 + 70, mouseX, mouseY) ) {
			x1 = true;
		} else {
			x1 = false;
		}
		if (isHovered(this.width / 2 + 5, this.height / 2 + 28, this.width / 2 + 170, this.height / 2 + 70, mouseX, mouseY) ) {
			x2 = true;
		} else {
			x2 = false;
		}
		
        animatedMouseX = mouseX;
        animatedMouseY = mouseY;
	}
	
	@Override
	public void updateScreen() {
		double max = 0.5d;	
		posYHovered1 = val;
		posYHovered2 = val1;
		posYHovered3 = val2;
		
		if (x && val < max) {
			val += 1.9d;
		} else if (!x && val > 0){
			val -= 1.9d;
		} 
		if (x1 && val1 < max) {
			val1 += 1.9d;
		} else if (!x1 && val1 > 0){
			val1 -= 1.9d;
		} 
		if (x2 && val2 < max) {
			val2 += 1.9d;
		} else if (!x2 && val2 > 0){
			val2 -= 1.9d;
		} 
		super.updateScreen();
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
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

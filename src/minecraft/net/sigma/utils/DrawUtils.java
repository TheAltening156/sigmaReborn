package net.sigma.utils;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

public class DrawUtils extends GuiScreen{
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static void setColor(int color) {
		float alpha = (float)(color >> 24 & 255) / 255.0F;
        float red = (float)(color >> 16 & 255) / 255.0F;
        float green = (float)(color >> 8 & 255) / 255.0F;
        float blue = (float)(color & 255) / 255.0F;
		GL11.glColor4f(red, green, blue, alpha);
	}
	
	public static void drawImage(final int x, final int y, final int width, final int height, final ResourceLocation image, Color color) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        setColor(color.getRGB());
        Minecraft.getMinecraft().getTextureManager().bindTexture(image);
        drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
	
	public static void drawImage(final int x, final int y, int width, int height, final ResourceLocation image) {
        GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Minecraft.getMinecraft().getTextureManager().bindTexture(image);
        drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
        GL11.glDepthMask(true);
        GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
    }
	
	public static void drawShadowImage(final int x, final int y, final int width, final int height, final ResourceLocation image) {
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(image);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.7F);
		drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
	}
	
	public static void drawShadowImage1(final int x, final int y, final int width, final int height, final ResourceLocation image) {
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(image);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.7F);
		drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, x - width, y - height, (float) x - width, (float) y - height);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
	}
	
	public static void drawImage(final double x, final double y, final double width, final double height, final ResourceLocation image) {
        GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Minecraft.getMinecraft().getTextureManager().bindTexture(image);
        drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
        GL11.glDepthMask(true);
        GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
    }

	public static void drawImageDiv2(float x, float y, float width, float height, final ResourceLocation image) {
		width /= 2.0f;
		height /= 2.0f;
        GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Minecraft.getMinecraft().getTextureManager().bindTexture(image);
        drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
        GL11.glDepthMask(true);
        GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
	}
}

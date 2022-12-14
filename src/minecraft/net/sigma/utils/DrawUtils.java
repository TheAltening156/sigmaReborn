package net.sigma.utils;

import java.awt.Color;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

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
	
	public static void drawShadowImage(final double x, final double y, final double width, final double height, final ResourceLocation image) {
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
	
	public static void drawBorderedRoundedRect(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
		drawRoundedRect((double)var0, (double)var1, (double)var2, (double)var3, (double)var4, var5);
		drawRoundedRect((double)(var0 + 0.5F), (double)(var1 + 0.5F), (double)(var2 - 0.5F), (double)(var3 - 0.5F), (double)var4, var6);
	}

	public static void drawBorderedRoundedRect(float var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
		drawRoundedRect((double)var0, (double)var1, (double)var2, (double)var3, (double)var4, var6);
		drawRoundedRect((double)(var0 + var5), (double)(var1 + var5), (double)(var2 - var5), (double)(var3 - var5), (double)var4, var7);
	}

	
	public static void drawRoundedRect(double x, double y, double x1, double y1, double round, int color) {
		GL11.glPushAttrib(0);
		GL11.glScaled(0.5D, 0.5D, 0.5D);
		x *= 2.0D;
		y *= 2.0D;
		x1 *= 2.0D;
		y1 *= 2.0D;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		setColor(color);
		GL11.glEnable(2848);
		GL11.glBegin(9);

		int var11;
		for(var11 = 0; var11 <= 90; var11 += 3) {
			GL11.glVertex2d(x + round + Math.sin((double)var11 * Math.PI / 180.0D) * round * -1.0D, y + round + Math.cos((double)var11 * Math.PI / 180.0D) * round * -1.0D);
		}

		for(var11 = 90; var11 <= 180; var11 += 3) {
			GL11.glVertex2d(x + round + Math.sin((double)var11 * Math.PI / 180.0D) * round * -1.0D, y1 - round + Math.cos((double)var11 * Math.PI / 180.0D) * round * -1.0D);
		}

		for(var11 = 0; var11 <= 90; var11 += 3) {
			GL11.glVertex2d(x1 - round + Math.sin((double)var11 * Math.PI / 180.0D) * round, y1 - round + Math.cos((double)var11 * Math.PI / 180.0D) * round);
		}

		for(var11 = 90; var11 <= 180; var11 += 3) {
			GL11.glVertex2d(x1 - round + Math.sin((double)var11 * Math.PI / 180.0D) * round, y + round + Math.cos((double)var11 * Math.PI / 180.0D) * round);
		}

		GL11.glEnd();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
		GL11.glDisable(3042);
		GL11.glEnable(3553);
		GL11.glScaled(2.0D, 2.0D, 2.0D);
		GL11.glPopAttrib();
	}

	public static void drawCircle(double x, double y, double offset, int color) {
		GL11.glEnable(GL13.GL_MULTISAMPLE);
    	GL11.glEnable(GL11.GL_POLYGON_SMOOTH);
        boolean blend = GL11.glIsEnabled((int) 3042);
        boolean line = GL11.glIsEnabled((int) 2848);
        boolean texture = GL11.glIsEnabled((int) 3553);
        if (!blend) {
            GL11.glEnable((int) 3042);
        }
        if (!line) {
            GL11.glEnable((int) 2848);
        }
        if (texture) {
            GL11.glDisable((int) 3553);
        }
        GL11.glBlendFunc((int) 770, (int) 771);
        setColor(color);

        GL11.glBegin((int) 9);
        int i = 0;
        while (i <= 360) {
            GL11.glVertex2d(
                    (double) ((double) x + Math.sin((double) ((double) i * 3.141526 / 180.0)) * (double) offset),
                    (double) ((double) y + Math.cos((double) ((double) i * 3.141526 / 180.0)) * (double) offset));
            ++i;
        }
        GL11.glEnd();
        if (texture) {
            GL11.glEnable((int) 3553);
        }
        if (!line) {
            GL11.glDisable((int) 2848);
        }
        if (!blend) {
            GL11.glDisable((int) 3042);
        }
        GL11.glDisable(GL11.GL_POLYGON_SMOOTH);
        GL11.glClear(0);
	}
}

package net.sigma.ui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.sigma.utils.DrawUtils;

public class JelloMainMenu extends GuiScreen {
	private TTFFontRenderer bigfr = FontManager.getFontQuality("JelloLight1", 10);
	private TTFFontRenderer namefr = FontManager.getFontQuality("jellolight", 1.4f);
	private float animatedMouseX;
	private float animatedMouseY;
	private boolean hovered;
	private double val1;
	private double val2;
	private double val3;
	private double val4;
	private double val5;
	private double max;
	
	
	@Override
	public void initGui() {
		animatedMouseX = 0;
		animatedMouseY = 0;
		val1 = 1d;
		val2 = 0d;
		val3 = 0d;
		val4 = 0d;
		val5 = 0d;
		
		max = 8d;
		super.initGui();
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		mc.getTextureManager().bindTexture(new ResourceLocation("Sigma/jellomenu.png"));
		this.drawModalRectWithCustomSizedTexture(-animatedMouseX / 1.43f,  -animatedMouseY / 10.15f, 0.0f, 0.0f, this.width * 1.7, this.height * 1.1, this.width * 1.7, this.height* 1.1);
		
		DrawUtils.drawShadowImage(this.width / 2 - 75, this.height / 2 - 90, 190, 90, new ResourceLocation("Sigma/shadow.png"));
		
		bigfr.drawCenteredStringScaled("Jello", this.width / 2 - 5, this.height / 2 - 93, -1, 10f);
				
		double posX = this.width / 2 - 153;
		int idk = 64;
		/*DrawUtils.drawImage(posX, this.height / 2 + 5, idk, idk, new ResourceLocation("Sigma/mainmenu/Singleplayer.png"));
		DrawUtils.drawImage(posX + 61, this.height / 2 + 5, idk, idk, new ResourceLocation("Sigma/mainmenu/Multiplayer.png"));
		DrawUtils.drawImage(posX + 122, this.height / 2 + 5, idk, idk, new ResourceLocation("Sigma/mainmenu/Connect.png"));
		DrawUtils.drawImage(posX + 183, this.height / 2 + 5, idk, idk, new ResourceLocation("Sigma/mainmenu/Settings.png"));
		DrawUtils.drawImage(posX + 244, this.height / 2 + 5, idk, idk, new ResourceLocation("Sigma/mainmenu/AltManager.png"));
*/
		for (String name : new String[] {"Singleplayer", "Multiplayer", "Connect", "Settings", "AltManager"}) {
			if (val1 > 1) {
				GlStateManager.translate(posX + 32.0F, height + 64.0F, 0.0F);
			    GlStateManager.scale(Math.min(1.2D, val1), Math.min(1.2D, val1), 1.0D);
			    GlStateManager.translate(-(posX + 32.0F), -(height + 64.0F), 0.0F);
			    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			}
			DrawUtils.drawImage(posX, this.height / 2 + 5, idk, idk, new ResourceLocation("Sigma/mainmenu/" + name + ".png"));
			GlStateManager.pushMatrix();
			if (isHovered(posX + 8, this.height / 2 + 8, posX + 56, this.height / 2 + 56, mouseX, mouseY)) {
				//if (val1 < 1.2F) {
					//this.val1 = val1 + 0.0500001D;
				//}
				//if (val1 > 1) {
					namefr.drawCenteredStringScaled(name, (float) (posX + 32), this.height / 2 + 75, new Color(255, 255, 255, (int) Math.max(0.0F, Math.min(1.0F, 0.5F + (this.val1 - 1.0F) * 2.5F))).getRGB(), 1.4f); // 180
				//}
			} else
			/*if (this.val1 > 1 && !isHovered(posX + 8, this.height / 2 + 8, posX + 56, this.height / 2 + 56, mouseX, mouseY)) {
				val1 = val1 - 0.06666666666666667D;
			}*/
		    if (val1 > 1) {
				//GlStateManager.translate(posX + 32.0F, height + 64.0F, 0.0F);
				//GlStateManager.scale(Math.min(1.0D, this.val1 - 0.2D), Math.min(1.0D, this.val1 - 0.2D), 1.0D);
				//GlStateManager.translate(-(posX + 32.0F), -(height + 64.0F), 0.0F);

				//namefr.drawCenteredStringScaled(name, (float) (posX + 32), this.height / 2 + 75, new Color(255, 255, 255, (int) Math.max(0.0F, Math.min(1.0F, 0.5F + (this.val1 - 1.0F) * 2.5F))).getRGB(), 1.4f); // 180
		    }
			GlStateManager.popMatrix();
			posX += 61;
		}
		animatedMouseX = mouseX;
		animatedMouseY = mouseY;
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		double posX = this.width / 2 - 152.5;
		for (String name : new String[] {"Singleplayer", "Multiplayer", "Connect", "Settings", "AltManager"}) {
			if (isHovered(posX + 8, this.height / 2 + 13, posX + 56, this.height / 2 + 61, mouseX, mouseY)) {
				switch(name) {
					case "Singleplayer": 
						mc.displayGuiScreen(new GuiSelectWorld(this));
						break;
					case "Multiplayer": 
						mc.displayGuiScreen(new GuiMultiplayer(this));
						break;
					/*case "singleplayer": 
						mc.displayGuiScreen(new GuiSelectWorld(this));
						break;*/
					case "Settings": 
						mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
						break;
					/*case "singleplayer": 
						mc.displayGuiScreen(new GuiSelectWorld(this));
						break;*/
					
				}
			}
			
			posX += 58;
		}
	}
	
	
}

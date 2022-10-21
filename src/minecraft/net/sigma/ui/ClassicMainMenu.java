package net.sigma.ui;

import java.io.IOException;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ClassicMainMenu extends GuiScreen {
	
	private int animatedMouseX;
	private int animatedMouseY;

	@Override
	public void initGui() {
		animatedMouseX = 0;
		animatedMouseY = 0;
		super.initGui();
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return super.doesGuiPauseGame();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		float color = 0.55f;
		super.drawScreen(mouseX, mouseY, partialTicks);
		mc.getTextureManager().bindTexture(new ResourceLocation("Sigma/jelloblur.jpeg"));
		GlStateManager.color(color, color, color, 1.0f);
		this.drawModalRectWithCustomSizedTexture(-4 + animatedMouseX / 125f, animatedMouseY / 90f, 0.0f, 0.0f, this.width * 1.008f, this.height * 1.009f, this.width * 1.008f, this.height * 1.009);

		drawRect(0, 0, 1, 1, -1);
		
		animatedMouseX = mouseX;
		animatedMouseY = mouseY;
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		mc.displayGuiScreen(new GuiSelectWorld(this));
	}
	
	
}

package net.sigma.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.ibm.icu.text.Normalizer.Mode;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.sigma.Sigma;
import net.sigma.event.events.EventUpdate;
import net.sigma.module.Cat;
import net.sigma.module.Module;
import net.sigma.module.ModuleManager;
import net.sigma.settings.BooleanSettings;
import net.sigma.settings.ModeSettings;
import net.sigma.settings.NumberSettings;
import net.sigma.settings.Settings;
import net.sigma.ui.FontManager;
import net.sigma.ui.TTFFontRenderer;
import net.sigma.utils.DrawUtils;

public class ClickGUI extends GuiScreen {
	private static int oldX;
	private static int oldY;
	private int start,
				stop;
	private static float outro;
	private static float lastOutro;
	private static boolean showSettings;
	private static TTFFontRenderer fr = FontManager.jelloLight;
	private static TTFFontRenderer settsfr = FontManager.getFontQuality("jelloregular", 1.29f);
	private static TTFFontRenderer catfr = FontManager.getFontQuality("jellolight2", 1.25f);
	public static TTFFontRenderer bigfr = FontManager.getFontQuality("jellomedium", 2.1f);
	
	public ClickGUI() {
	}
	
	@Override
	public void initGui() {
		this.outro = 1.0F;
	    this.lastOutro = 1.0F;
	    /*if (OpenGlHelper.shadersSupported && mc.getRenderViewEntity() instanceof EntityPlayer) {
			if (mc.entityRenderer.theShaderGroup != null) {
				mc.entityRenderer.theShaderGroup.deleteShaderGroup();
			}
			mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
		}*/
	    super.initGui();
	}
	
	@Override
	public void onGuiClosed() {
		/*if (mc.entityRenderer.theShaderGroup != null) {
			mc.entityRenderer.theShaderGroup.deleteShaderGroup();
			mc.entityRenderer.theShaderGroup = null;
		}*/
		super.onGuiClosed();
	}
	
	public void onTick() {
		
		super.updateScreen();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		
		for (Cat c : Cat.values()) {
			if (c.clicked) {
				c.posX += mouseX - oldX;
				c.posY += mouseY - oldY;
			}			
			int posX = c.posX;
			int posY = c.posY;
			
			drawRect(posX, posY, posX + 100, posY + 30, new Color(240, 240, 240, 248).getRGB());
			catfr.drawStringScaled(c.name, posX + 10, posY + 8, new Color(99, 99, 99, 178).getRGB(), 1.25f);
			
			if (c.showMods) {
				
				drawRect(posX, posY + 30, posX + 100, posY + 160, -1);
				
				int modX = posX + 12;
				int modY = posY + 32;
				for (Module m : ModuleManager.mods) {				
					if (c == m.getCat()) {
						if (!this.showSettings) {
							if (isHovered(modX - 12, modY - 2, modX + 88, modY + 12.8, mouseX, mouseY)) {
								drawRect(modX - 12, modY - 2, modX + 88, modY + 12.8, m.isToggled() ? new Color(28, 158, 255).getRGB() : new Color(229, 229, 229).getRGB());
								
							} else {
								drawRect(modX - 12, modY - 2, modX + 88, modY + 12.8, m.isToggled() ? new Color(28, 158, 255).getRGB() : -1 );							
							}
						} else {
							drawRect(modX - 12, modY - 2, modX + 88, modY + 12.8, m.isToggled() ? new Color(28, 158, 255).getRGB() : -1 );							
						}
						
						fr.drawString(m.getName(), m.isToggled() ? modX + 5 : modX, modY, m.isToggled() ? -1 : 1);
						modY += 15;	
					}
				}
			}
			
		}
		
		if (this.showSettings) {
			Gui.drawRect(0, 0, sr.getScaledWidth(), sr.getScaledHeight(), new Color(0,0,0,120).getRGB());
			Gui.drawRect(this.width / 2 - 125, this.height / 2 - 150, this.width / 2 + 125, this.height / 2 + 150, -1);
			
		}
			
		int settsX = sr.getScaledWidth() / 2 - 110;
		int settsY = sr.getScaledHeight() / 2 - 110;
		int settsWidth = this.width / 2 + 100;
		//int settsHeight = this.height / 2 + 150;
		for (Module m : ModuleManager.mods) {
			if (m.showSettings) {
				fr.drawString(m.getDesc(), settsX, settsY - 27, new Color(125, 125, 125).getRGB());
				bigfr.drawStringScaled(m.getName(), this.width / 2 - 125, this.height / 2 - 180, -1, 2.1f);

			}
			for (Settings s : m.settings) {
				if (m.showSettings) {
					if (isHovered(settsX, settsY, settsX + fr.getWidth(s.name) + 11, settsY + 14, mouseX, mouseY)) {
						FontManager.jelloMedium.drawString(s.name, settsX - 11, this.height / 2 + 150, -1);
						fr.drawString(s.desc, settsX - 8 + FontManager.jelloMedium.getWidth(s.name), this.height / 2 + 150, -1);
					}
					if (s instanceof ModeSettings) {
						ModeSettings lmfao = (ModeSettings) s;
						settsfr.drawStringScaled(s.name, settsX, settsY, 1, 1.29f);
						fr.drawString(lmfao.isShown ? "<" : ">", settsWidth - fr.getWidth(">"), settsY, isHovered(settsWidth - 60, settsY, settsWidth, settsY + 13, mouseX, mouseY) || lmfao.isShown ? new Color(55, 55, 55).getRGB() : new Color(145, 145, 145).getRGB());
						fr.drawString(s.getVar().toString(), settsWidth - 60, settsY, new Color(55, 55, 55).getRGB());
						if (lmfao.isShown) {
							byte b;
							int i;
							String[] string11;
							for (i = (string11 = lmfao.modess).length, b = 0; b < i;) {
								String string1 = string11[b];
								if (isHovered(settsWidth - 63, settsY + 13.5, settsWidth - 5, settsY + 27.5, mouseX, mouseY)) {
									drawRect(settsWidth - 63, settsY + 13.5, settsWidth - 5, settsY + 27.5, new Color(0, 0, 0, 35).getRGB());
								}
								fr.drawString(string1, settsWidth - 60, settsY + 15, 1);
								settsY += 14;
								b++;
							}
							/*for (String test : lmfao.modes) {
								if (isHovered(settsWidth - 63, settsY + 13.5, settsWidth - 5, settsY + 27.5, mouseX, mouseY)) {
									drawRect(settsWidth - 63, settsY + 13.5, settsWidth - 5, settsY + 27.5, new Color(0, 0, 0, 35).getRGB());
									lmfao.setVar(string1);
								}
								fr.drawString(test, settsWidth - 60, settsY + 15, 1);
								
								settsY += 14;
							}*/
						}
					}
					if (s instanceof NumberSettings) {
						NumberSettings num = (NumberSettings) s;
						double min = num.getMin();
						double max = num.getMax();
						double diff = (max - min);
						double rdrWidth = 61 * ((num.getVar() - min) / diff);
						drawRect(settsWidth - 60, settsY + 2, settsWidth, settsY + 6, new Color(213, 229, 248).getRGB());
						drawRect(settsWidth - 60, settsY + 2, settsWidth - 60 + rdrWidth, settsY + 6, new Color(37, 146, 237).getRGB());
						
						double mouseSnap = mouseX;
                        mouseSnap = Math.max((settsWidth - 60), mouseSnap);
                        mouseSnap = Math.min(settsWidth, mouseSnap);
                        double test = (mouseSnap - (settsWidth - 60))/(settsWidth-(settsWidth - 60));
                        double val = min + test * diff;	       
                        drawRect((settsWidth - 60) + rdrWidth - 3.5, settsY, (settsWidth - 60) + rdrWidth + 3.5, settsY + 8, 1);
                        drawRect((settsWidth - 60) + rdrWidth - 3.5, settsY, (settsWidth - 60) + rdrWidth + 3.5, settsY + 8, 1);
                        drawRect((settsWidth - 60) + rdrWidth - 3.5, settsY, (settsWidth - 60) + rdrWidth + 3.5, settsY + 8, 1);
              
                        if (isHovered((settsWidth - 60) + rdrWidth - 3.5, settsY, (settsWidth - 60) + rdrWidth + 3.5, settsY + 8, mouseX, mouseY) && Mouse.isButtonDown(0)) {
                       		num.setValue(val);
                       	}
						settsfr.drawStringScaled(s.name, settsX, settsY, 1, 1.29f);
						if (isHovered(settsWidth - 60, settsY + 2, settsWidth, settsY + 6, mouseX, mouseY)) {
							fr.drawString(s.getVar().toString(), settsWidth - fr.getWidth(s.getVar().toString()) - 65, settsY - 2, new Color(125, 125, 125).getRGB());
						}
					}
					if (s instanceof BooleanSettings) {
						BooleanSettings b = (BooleanSettings) s;
						settsfr.drawStringScaled(s.name, settsX, settsY, 1, 1.29f);	
						//Gui.drawRect(settsWidth - 14, settsY - 1, settsWidth, settsY + 13, b.isToggled() ? new Color(37, 146, 237).getRGB() : new Color(200, 200, 200).getRGB());
						if (b.toggled ) DrawUtils.drawImage(settsWidth - 12, settsY, 24 / 2, 24 / 2, new ResourceLocation("Sigma/bool.png")); else Gui.drawRect(settsWidth - 12, settsY, settsWidth, settsY + 12, new Color(200, 200, 200).getRGB());


					}

					settsY += 18;
				}
			}	
		}
		oldX = mouseX;
		oldY = mouseY;
		super.drawScreen(mouseX, mouseY, partialTicks);

	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		for (Cat c : Cat.values()) {
			c.clicked = false;
		}
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		ScaledResolution sr = new ScaledResolution(mc);
		for (Cat c : Cat.values()) {
			if (!this.showSettings) {
				int posX = c.posX;
				int posY = c.posY;
				
				if (isHovered(posX, posY, posX + 100, posY + 30, mouseX, mouseY)) {
					if (mouseButton == 1) { 
						c.showMods = !c.showMods;
					}
					if (mouseButton == 0) {
						c.clicked = true;
					}
				}
				
				int modX = posX + 12;
				int modY = posY + 32;
				for (Module m : ModuleManager.mods) {
					if (c.showMods) {
						if (c == m.getCat()) {
							if (isHovered(modX - 12, modY - 2, modX + 88, modY + 12.8, mouseX, mouseY)) {
								if (mouseButton == 0) {
									m.toggle();
								} 
								if (mouseButton == 1) {
									this.showSettings = !this.showSettings;
									m.showSettings = this.showSettings;
								}
							}
							modY += 15;	
						}
					}
				}
			} else {
				
				for (Module m : ModuleManager.mods) if (m.showSettings)
				if (!isHovered(this.width / 2 - 125, this.height / 2 - 150, this.width / 2 + 125, this.height / 2 + 150, mouseX, mouseY) && mouseButton == 0) {
					this.showSettings = false;
					m.showSettings = false;
				}
				int settsX = sr.getScaledWidth() / 2 - 110;
				int settsY = sr.getScaledHeight() / 2 - 110;
				int settsWidth = this.width / 2 + 100;
				for (Module m : ModuleManager.mods) {
					for (Settings s : m.settings) {
						if (m.showSettings) {
							if (isHovered(settsX, settsY, settsX + fr.getWidth(s.name) + 11, settsY + 14, mouseX, mouseY)) {
							}
							if (s instanceof ModeSettings) {
								ModeSettings lmfao = (ModeSettings) s;
								if (isHovered(settsWidth - 60, settsY, settsWidth, settsY + 13, mouseX, mouseY) && mouseButton == 0) {
									lmfao.isShown = !lmfao.isShown;
								}
								if (lmfao.isShown) {
									byte b;
									int i;
									String[] string11;
									for (i = (string11 = lmfao.modess).length, b = 0; b < i;) {
										String string1 = string11[b];
										if (isHovered(settsWidth - 63, settsY + 13.5, settsWidth - 5, settsY + 27.5, mouseX, mouseY)) {
											lmfao.setVar(string1);
											lmfao.isShown = false;
										}
										settsY += 14;
										b++;
									}
								}
							}
							if (s instanceof NumberSettings) {
								NumberSettings num = (NumberSettings) s;
							}
							if (s instanceof BooleanSettings) {
								BooleanSettings b = (BooleanSettings) s;
								if (isHovered(settsWidth - 15, settsY - 2, settsWidth, settsY + 13, mouseX, mouseY)) {
									b.toggle();
								}
							}

							settsY += 18;
						}
					}
				}
			}
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == Keyboard.KEY_ESCAPE) {
			Sigma.clickgui.setToggled(false);
			mc.displayGuiScreen((GuiScreen)null);
			for (Module m : ModuleManager.mods) {
					m.showSettings = false;
					for (Settings s : m.settings) {
						if (s instanceof ModeSettings) {
							ModeSettings ss = (ModeSettings) s;
							ss.isShown = false;
						}
					}
				}
				this.showSettings = false;
			
			/*if (!this.showSettings) {
				Sigma.clickgui.setToggled(false);
				mc.displayGuiScreen((GuiScreen)null);
			} else {
				for (Module m : ModuleManager.mods) {
					m.showSettings = false;
				}
				this.showSettings = false;
			}*/
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public boolean isHovered(double x, double y, double x1, double y1, int mouseX, int mouseY) {
		return mouseX >= x && mouseY >= y && mouseX <= x1 && mouseY <= y1;
	}
	
	public static float smoothTransition(double current, double last) {
	    return (float)(current * (Minecraft.getMinecraft()).timer.renderPartialTicks + last * (1.0F - (Minecraft.getMinecraft()).timer.renderPartialTicks));
	  }
	
}

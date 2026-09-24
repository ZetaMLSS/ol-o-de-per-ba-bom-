package net.mcreator.minerp.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minerp.world.inventory.GuiDoGeradorv1Menu;
import net.mcreator.minerp.procedures.RetornarEnergiaDoGuiGeradorProcedure;
import net.mcreator.minerp.procedures.RetornarEnergiaDaBateriaDentroDoGeradorProcedure;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuiDoGeradorv1Screen extends AbstractContainerScreen<GuiDoGeradorv1Menu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public GuiDoGeradorv1Screen(GuiDoGeradorv1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/gui_do_geradorv_1.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		net.spidrone.uiapi.UIProgressBarRenderer.drawProgressBar(guiGraphics, this.leftPos + 145, this.topPos + 14, 12, 52, 1, -16777216, -14145496, net.spidrone.uiapi.UIColorEffects.solid(-11163051),
				RetornarEnergiaDaBateriaDentroDoGeradorProcedure.execute(world, x, y, z), 50000, net.spidrone.uiapi.UIProgressBarRenderer.FillDirection.BOTTOM_TO_TOP);
		net.spidrone.uiapi.UIProgressBarRenderer.drawProgressBarFromImage(guiGraphics, this.leftPos + 25, this.topPos + 43, net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/fogoapagado.png"),
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/fogoacesso.png"), 18, 18, RetornarEnergiaDoGuiGeradorProcedure.execute(world, x, y, z), 1600,
				net.spidrone.uiapi.UIProgressBarRenderer.FillDirection.BOTTOM_TO_TOP);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
	}
}
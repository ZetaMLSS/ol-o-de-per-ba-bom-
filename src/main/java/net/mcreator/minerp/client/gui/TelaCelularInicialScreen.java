package net.mcreator.minerp.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minerp.world.inventory.TelaCelularInicialMenu;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TelaCelularInicialScreen extends AbstractContainerScreen<TelaCelularInicialMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private Button button_5;
	private Button button_6;
	private Button button_7;

	public TelaCelularInicialScreen(TelaCelularInicialMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 96;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/tela_celular_inicial.png");

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
		button_1 = Button.builder(Component.translatable("gui.minerp.tela_celular_inicial.button_1"), e -> {
		}).bounds(this.leftPos + 13, this.topPos + 17, 30, 20).build();
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.minerp.tela_celular_inicial.button_2"), e -> {
		}).bounds(this.leftPos + 54, this.topPos + 17, 30, 20).build();
		this.addRenderableWidget(button_2);
		button_3 = Button.builder(Component.translatable("gui.minerp.tela_celular_inicial.button_3"), e -> {
		}).bounds(this.leftPos + 13, this.topPos + 48, 30, 20).build();
		this.addRenderableWidget(button_3);
		button_4 = Button.builder(Component.translatable("gui.minerp.tela_celular_inicial.button_4"), e -> {
		}).bounds(this.leftPos + 54, this.topPos + 48, 30, 20).build();
		this.addRenderableWidget(button_4);
		button_5 = Button.builder(Component.translatable("gui.minerp.tela_celular_inicial.button_5"), e -> {
		}).bounds(this.leftPos + 13, this.topPos + 78, 30, 20).build();
		this.addRenderableWidget(button_5);
		button_6 = Button.builder(Component.translatable("gui.minerp.tela_celular_inicial.button_6"), e -> {
		}).bounds(this.leftPos + 54, this.topPos + 78, 30, 20).build();
		this.addRenderableWidget(button_6);
		button_7 = Button.builder(Component.translatable("gui.minerp.tela_celular_inicial.button_7"), e -> {
		}).bounds(this.leftPos + 33, this.topPos + 108, 30, 20).build();
		this.addRenderableWidget(button_7);
	}
}
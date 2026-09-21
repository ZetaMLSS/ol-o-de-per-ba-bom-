package net.mcreator.minerp.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.minerp.world.inventory.ConfigurarSenhaComputadorBancarioMenu;
import net.mcreator.minerp.network.ConfigurarSenhaComputadorBancarioButtonMessage;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ConfigurarSenhaComputadorBancarioScreen extends AbstractContainerScreen<ConfigurarSenhaComputadorBancarioMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox ColocarSenha;
	private Button button_avancar;

	public ConfigurarSenhaComputadorBancarioScreen(ConfigurarSenhaComputadorBancarioMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 90;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("ColocarSenha"))
				ColocarSenha.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/configurar_senha_computador_bancario.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		ColocarSenha.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (ColocarSenha.isFocused())
			return ColocarSenha.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String ColocarSenhaValue = ColocarSenha.getValue();
		super.resize(minecraft, width, height);
		ColocarSenha.setValue(ColocarSenhaValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		ColocarSenha = new EditBox(this.font, this.leftPos + 29, this.topPos + 13, 118, 18, Component.translatable("gui.minerp.configurar_senha_computador_bancario.ColocarSenha"));
		ColocarSenha.setMaxLength(8192);
		ColocarSenha.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "ColocarSenha", content, false);
		});
		ColocarSenha.setHint(Component.translatable("gui.minerp.configurar_senha_computador_bancario.ColocarSenha"));
		this.addWidget(this.ColocarSenha);
		button_avancar = Button.builder(Component.translatable("gui.minerp.configurar_senha_computador_bancario.button_avancar"), e -> {
			int x = ConfigurarSenhaComputadorBancarioScreen.this.x;
			int y = ConfigurarSenhaComputadorBancarioScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ConfigurarSenhaComputadorBancarioButtonMessage(0, x, y, z));
				ConfigurarSenhaComputadorBancarioButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 58, this.topPos + 45, 60, 20).build();
		this.addRenderableWidget(button_avancar);
	}
}
package net.mcreator.minerp.client.gui;

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

import net.mcreator.minerp.world.inventory.TelaDePesquisaComputadorBancoMenu;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TelaDePesquisaComputadorBancoScreen extends AbstractContainerScreen<TelaDePesquisaComputadorBancoMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox Pesquisar;
	private Button button_pesquisar;

	public TelaDePesquisaComputadorBancoScreen(TelaDePesquisaComputadorBancoMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 124;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("Pesquisar"))
				Pesquisar.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/tela_de_pesquisa_computador_banco.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Pesquisar.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (Pesquisar.isFocused())
			return Pesquisar.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String PesquisarValue = Pesquisar.getValue();
		super.resize(minecraft, width, height);
		Pesquisar.setValue(PesquisarValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		Pesquisar = new EditBox(this.font, this.leftPos + 29, this.topPos + 28, 118, 18, Component.translatable("gui.minerp.tela_de_pesquisa_computador_banco.Pesquisar"));
		Pesquisar.setMaxLength(8192);
		Pesquisar.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "Pesquisar", content, false);
		});
		Pesquisar.setHint(Component.translatable("gui.minerp.tela_de_pesquisa_computador_banco.Pesquisar"));
		this.addWidget(this.Pesquisar);
		button_pesquisar = Button.builder(Component.translatable("gui.minerp.tela_de_pesquisa_computador_banco.button_pesquisar"), e -> {
		}).bounds(this.leftPos + 53, this.topPos + 72, 70, 20).build();
		this.addRenderableWidget(button_pesquisar);
	}
}
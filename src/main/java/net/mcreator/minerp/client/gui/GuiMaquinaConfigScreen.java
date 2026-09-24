package net.mcreator.minerp.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.minerp.world.inventory.GuiMaquinaConfigMenu;
import net.mcreator.minerp.network.GuiMaquinaConfigButtonMessage;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuiMaquinaConfigScreen extends AbstractContainerScreen<GuiMaquinaConfigMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox ValorAPagar;
	private Checkbox Debito;
	private Checkbox Credito;
	private Button button_confirmar;

	public GuiMaquinaConfigScreen(GuiMaquinaConfigMenu container, Inventory inventory, Component text) {
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
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("ValorAPagar"))
				ValorAPagar.setValue(stringState);
		}
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("Debito")) {
				if (Debito.selected() != logicState)
					Debito.onPress();
			} else if (name.equals("Credito")) {
				if (Credito.selected() != logicState)
					Credito.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/gui_maquina_config.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		ValorAPagar.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (ValorAPagar.isFocused())
			return ValorAPagar.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String ValorAPagarValue = ValorAPagar.getValue();
		super.resize(minecraft, width, height);
		ValorAPagar.setValue(ValorAPagarValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		{
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.gui_maquina_config.label_debito"), 23, 83, -12829636, false);
		}
		{
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.gui_maquina_config.label_credito"), 119, 83, -12829636, false);
		}
	}

	@Override
	public void init() {
		super.init();
		ValorAPagar = new EditBox(this.font, this.leftPos + 29, this.topPos + 15, 118, 18, Component.translatable("gui.minerp.gui_maquina_config.ValorAPagar"));
		ValorAPagar.setMaxLength(8192);
		ValorAPagar.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "ValorAPagar", content, false);
		});
		ValorAPagar.setHint(Component.translatable("gui.minerp.gui_maquina_config.ValorAPagar"));
		this.addWidget(this.ValorAPagar);
		button_confirmar = Button.builder(Component.translatable("gui.minerp.gui_maquina_config.button_confirmar"), e -> {
			int x = GuiMaquinaConfigScreen.this.x;
			int y = GuiMaquinaConfigScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new GuiMaquinaConfigButtonMessage(0, x, y, z));
				GuiMaquinaConfigButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 52, this.topPos + 117, 70, 20).build();
		this.addRenderableWidget(button_confirmar);
		Debito = Checkbox.builder(Component.translatable("gui.minerp.gui_maquina_config.Debito"), this.font).pos(this.leftPos + 28, this.topPos + 58).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "Debito", value, false);
		}).build();
		this.addRenderableWidget(Debito);
		Credito = Checkbox.builder(Component.translatable("gui.minerp.gui_maquina_config.Credito"), this.font).pos(this.leftPos + 128, this.topPos + 58).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "Credito", value, false);
		}).build();
		this.addRenderableWidget(Credito);
	}
}
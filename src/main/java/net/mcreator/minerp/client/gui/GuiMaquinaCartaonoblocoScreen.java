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

import net.mcreator.minerp.world.inventory.GuiMaquinaCartaonoblocoMenu;
import net.mcreator.minerp.procedures.VerValorDaGuiMaquinaCartaoProcedure;
import net.mcreator.minerp.procedures.VerMetodoDaGuiMaquinaCartaoProcedure;
import net.mcreator.minerp.network.GuiMaquinaCartaonoblocoButtonMessage;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuiMaquinaCartaonoblocoScreen extends AbstractContainerScreen<GuiMaquinaCartaonoblocoMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox senha;
	private Button button_confirmar;

	public GuiMaquinaCartaonoblocoScreen(GuiMaquinaCartaonoblocoMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 212;
		this.imageHeight = 179;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("senha"))
				senha.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/gui_maquina_cartaonobloco.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		senha.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (senha.isFocused())
			return senha.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String senhaValue = senha.getValue();
		super.resize(minecraft, width, height);
		senha.setValue(senhaValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		{
			guiGraphics.drawString(this.font, VerValorDaGuiMaquinaCartaoProcedure.execute(world, x, y, z), 93, 8, -12829636, false);
		}
		{
			guiGraphics.drawString(this.font, VerMetodoDaGuiMaquinaCartaoProcedure.execute(world, x, y, z), 101, 24, -12829636, false);
		}
		this.guiTools$renderMultilineLabel(guiGraphics, "Valor:", 49, 7, 40, 16, -16777216, false, 1.25F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Valor:", 48, 7, 40, 16, -16751104, false, 1.25F);
		this.guiTools$renderMultilineLabel(guiGraphics, "M\u00E9todo:", 49, 23, 56, 15, -16777216, false, 1.25F);
		this.guiTools$renderMultilineLabel(guiGraphics, "M\u00E9todo:", 48, 23, 56, 15, -16750951, false, 1.25F);
	}

	@Override
	public void init() {
		super.init();
		senha = new EditBox(this.font, this.leftPos + 8, this.topPos + 47, 118, 18, Component.translatable("gui.minerp.gui_maquina_cartaonobloco.senha"));
		senha.setMaxLength(8192);
		senha.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "senha", content, false);
		});
		senha.setHint(Component.translatable("gui.minerp.gui_maquina_cartaonobloco.senha"));
		this.addWidget(this.senha);
		button_confirmar = Button.builder(Component.translatable("gui.minerp.gui_maquina_cartaonobloco.button_confirmar"), e -> {
			int x = GuiMaquinaCartaonoblocoScreen.this.x;
			int y = GuiMaquinaCartaonoblocoScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new GuiMaquinaCartaonoblocoButtonMessage(0, x, y, z));
				GuiMaquinaCartaonoblocoButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 134, this.topPos + 46, 70, 20).build();
		this.addRenderableWidget(button_confirmar);
	}

	private final java.util.Map<String, java.util.List<String>> guiTools$multilineCache = new java.util.HashMap<>();

	private void guiTools$renderMultilineLabel(GuiGraphics guiGraphics, String text, int x, int y, int boxWidth, int boxHeight, int color, boolean shadow, float scale) {
		if (text == null || scale <= 0.0F || boxWidth <= 0 || boxHeight <= 0)
			return;
		int wrapWidth = Math.max(1, (int) Math.floor(boxWidth / scale));
		int lineStep = this.font.lineHeight + 1;
		int currentY = 0;
		java.util.List<String> lines = this.guiTools$multilineCache.computeIfAbsent(text + "\u0000" + wrapWidth, key -> this.guiTools$wrapMultilineText(text, wrapWidth));
		if (this.guiTools$multilineCache.size() > 64)
			this.guiTools$multilineCache.clear();
		guiGraphics.pose().pushPose();
		try {
			guiGraphics.pose().translate(x, y, 0.0F);
			guiGraphics.pose().scale(scale, scale, 1.0F);
			for (String line : lines) {
				guiGraphics.drawString(this.font, line, 0, currentY, color, shadow);
				currentY += lineStep;
			}
		} finally {
			guiGraphics.pose().popPose();
		}
	}

	private java.util.List<String> guiTools$wrapMultilineText(String text, int wrapWidth) {
		java.util.List<String> lines = new java.util.ArrayList<>();
		for (String paragraph : text.replace("\r", "").split("\n", -1)) {
			if (paragraph.isEmpty()) {
				lines.add("");
				continue;
			}
			StringBuilder line = new StringBuilder();
			for (String word : paragraph.split("\s+")) {
				String candidate = line.isEmpty() ? word : line + " " + word;
				if (!line.isEmpty() && this.font.width(candidate) > wrapWidth) {
					lines.add(line.toString());
					line.setLength(0);
					line.append(word);
				} else {
					line.setLength(0);
					line.append(candidate);
				}
			}
			lines.add(line.toString());
		}
		return java.util.List.copyOf(lines);
	}
}
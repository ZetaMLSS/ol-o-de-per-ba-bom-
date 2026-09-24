package net.mcreator.minerp.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minerp.world.inventory.GuiAprovadoMaquinaCartaoMenu;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuiAprovadoMaquinaCartaoScreen extends AbstractContainerScreen<GuiAprovadoMaquinaCartaoMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public GuiAprovadoMaquinaCartaoScreen(GuiAprovadoMaquinaCartaoMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/gui_aprovado_maquina_cartao.png");

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
		this.guiTools$renderMultilineLabel(guiGraphics, "Aprovado.", 52, 12, 120, 40, -12829636, false, 1.50F);
	}

	@Override
	public void init() {
		super.init();
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
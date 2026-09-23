package net.mcreator.minerp.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minerp.world.inventory.ATMTELA2Menu;
import net.mcreator.minerp.procedures.MostraValorBancoAtmDoCartao2Procedure;
import net.mcreator.minerp.network.ATMTELA2ButtonMessage;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ATMTELA2Screen extends AbstractContainerScreen<ATMTELA2Menu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_1;
	private Button button_5;
	private Button button_10;
	private Button button_20;
	private Button button_50;
	private Button button_100;
	private Button button_05;
	private Button button_200;

	public ATMTELA2Screen(ATMTELA2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 188;
		this.imageHeight = 187;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/atmtela_2.png");

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
		{
			guiGraphics.drawString(this.font, MostraValorBancoAtmDoCartao2Procedure.execute(world, x, y, z), 63, 9, -16777216, false);
		}
		{
			guiGraphics.drawString(this.font, MostraValorBancoAtmDoCartao2Procedure.execute(world, x, y, z), 62, 9, -16751104, false);
		}
		{
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.atmtela_2.label_depositar"), 12, 44, -16777216, false);
		}
		{
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.atmtela_2.label_depositar_copy"), 11, 44, -16751104, false);
		}
		{
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.atmtela_2.label_retirar"), 129, 13, -16777216, false);
		}
		{
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.atmtela_2.label_retirar_copy"), 128, 13, -16751104, false);
		}
		this.guiTools$renderMultilineLabel(guiGraphics, "Saldo:", 32, 9, 30, 12, -16777216, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Saldo:", 31, 9, 30, 12, -16751104, false, 1.00F);
	}

	@Override
	public void init() {
		super.init();
		button_1 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_1"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(0, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 136, this.topPos + 31, 20, 20).build();
		this.addRenderableWidget(button_1);
		button_5 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_5"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(1, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 156, this.topPos + 31, 20, 20).build();
		this.addRenderableWidget(button_5);
		button_10 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_10"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(2, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 116, this.topPos + 51, 20, 20).build();
		this.addRenderableWidget(button_10);
		button_20 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_20"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(3, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 136, this.topPos + 51, 20, 20).build();
		this.addRenderableWidget(button_20);
		button_50 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_50"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(4, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 156, this.topPos + 51, 20, 20).build();
		this.addRenderableWidget(button_50);
		button_100 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_100"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(5, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 116, this.topPos + 70, 20, 20).build();
		this.addRenderableWidget(button_100);
		button_05 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_05"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(6, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 116, this.topPos + 31, 20, 20).build();
		this.addRenderableWidget(button_05);
		button_200 = Button.builder(Component.translatable("gui.minerp.atmtela_2.button_200"), e -> {
			int x = ATMTELA2Screen.this.x;
			int y = ATMTELA2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ATMTELA2ButtonMessage(7, x, y, z));
				ATMTELA2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 136, this.topPos + 70, 20, 20).build();
		this.addRenderableWidget(button_200);
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
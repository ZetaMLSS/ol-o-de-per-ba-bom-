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

import net.mcreator.minerp.world.inventory.TelaChats4Menu;
import net.mcreator.minerp.procedures.BateriaVisorProcedure;
import net.mcreator.minerp.network.TelaChats4ButtonMessage;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TelaChats4Screen extends AbstractContainerScreen<TelaChats4Menu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox escrevermensagem;
	private Button button_enviar;

	public TelaChats4Screen(TelaChats4Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 21;
		this.imageHeight = 0;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("escrevermensagem"))
				escrevermensagem.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/tela_chats_4.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		escrevermensagem.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiTools$alphaBlit(guiGraphics, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		net.spidrone.uiapi.UIProgressBarRenderer.drawProgressBar(guiGraphics, this.leftPos + 24, this.topPos + -95, 16, 7, 1, -16777216, -14145496, net.spidrone.uiapi.UIColorEffects.multiGradient(-6750208, -256, -16724992, -16751104),
				BateriaVisorProcedure.execute(entity), 10000, net.spidrone.uiapi.UIProgressBarRenderer.FillDirection.LEFT_TO_RIGHT);
		RenderSystem.disableBlend();
		guiTools$orderedImages : {
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 120;
				int guiTools$visibleHeight = 229;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/gemini_generated_image_luqojiluqojiluqo-removebg-preview.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -49 + guiTools$xOffset, this.topPos + -120 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 120, 229);
			}
		}
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (escrevermensagem.isFocused())
			return escrevermensagem.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String escrevermensagemValue = escrevermensagem.getValue();
		super.resize(minecraft, width, height);
		escrevermensagem.setValue(escrevermensagemValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.HoracelularvisorProcedure.execute(world), ""), -26, -96, 48, 40, -1, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.Texto5Procedure.execute(entity), ""), -28, -66, 79, 24, -12829636, false, 0.50F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.Texto4Procedure.execute(entity), ""), -28, -48, 79, 24, -12829636, false, 0.50F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.Texto3Procedure.execute(entity), ""), -28, -29, 79, 24, -12829636, false, 0.50F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.Texto2Procedure.execute(entity), ""), -28, -12, 79, 24, -12829636, false, 0.50F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.Texto1Procedure.execute(entity), ""), -28, 5, 79, 24, -12829636, false, 0.50F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.NumeroNotificacoesProcedure.execute(entity), ""), -26, -86, 120, 40, -12829636, false, 1.00F);
	}

	@Override
	public void init() {
		super.init();
		escrevermensagem = new EditBox(this.font, this.leftPos + -28, this.topPos + 30, 78, 18, Component.translatable("gui.minerp.tela_chats_4.escrevermensagem"));
		escrevermensagem.setMaxLength(8192);
		escrevermensagem.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "escrevermensagem", content, false);
		});
		this.addWidget(this.escrevermensagem);
		button_enviar = Button.builder(Component.translatable("gui.minerp.tela_chats_4.button_enviar"), e -> {
			int x = TelaChats4Screen.this.x;
			int y = TelaChats4Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TelaChats4ButtonMessage(0, x, y, z));
				TelaChats4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -16, this.topPos + 55, 55, 20).build();
		this.addRenderableWidget(button_enviar);
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

	private static net.minecraft.resources.ResourceLocation guiTools$dynamicTexture(String value, net.minecraft.resources.ResourceLocation fallback) {
		if (value == null || value.isBlank())
			return fallback;
		try {
			String texture = value.trim().replace('\\', '/');
			if (texture.indexOf(':') >= 0)
				return net.minecraft.resources.ResourceLocation.parse(texture);
			while (texture.startsWith("/"))
				texture = texture.substring(1);
			if (texture.startsWith("textures/screens/"))
				texture = texture.substring("textures/screens/".length());
			if (!texture.endsWith(".png"))
				texture += ".png";
			return net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("minerp", "textures/screens/" + texture);
		} catch (RuntimeException ignored) {
			return fallback;
		}
	}

	private static void guiTools$alphaBlit(net.minecraft.client.gui.GuiGraphics graphics, net.minecraft.resources.ResourceLocation texture, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight) {
		boolean wasBlending = org.lwjgl.opengl.GL11.glIsEnabled(org.lwjgl.opengl.GL11.GL_BLEND);
		com.mojang.blaze3d.systems.RenderSystem.enableBlend();
		com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
		try {
			graphics.blit(texture, x, y, u, v, width, height, textureWidth, textureHeight);
		} finally {
			if (!wasBlending)
				com.mojang.blaze3d.systems.RenderSystem.disableBlend();
		}
	}
}
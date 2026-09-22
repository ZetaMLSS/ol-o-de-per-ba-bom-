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

import net.mcreator.minerp.world.inventory.TelaAdionarContatoMenu;
import net.mcreator.minerp.procedures.BateriaVisorProcedure;
import net.mcreator.minerp.network.TelaAdionarContatoButtonMessage;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TelaAdionarContatoScreen extends AbstractContainerScreen<TelaAdionarContatoMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox input_nome;
	private EditBox input_numero;
	private Button button_chamar;

	public TelaAdionarContatoScreen(TelaAdionarContatoMenu container, Inventory inventory, Component text) {
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
			if (name.equals("input_nome"))
				input_nome.setValue(stringState);
			else if (name.equals("input_numero"))
				input_numero.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/tela_adionar_contato.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		input_nome.render(guiGraphics, mouseX, mouseY, partialTicks);
		input_numero.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (input_nome.isFocused())
			return input_nome.keyPressed(key, b, c);
		if (input_numero.isFocused())
			return input_numero.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String input_nomeValue = input_nome.getValue();
		String input_numeroValue = input_numero.getValue();
		super.resize(minecraft, width, height);
		input_nome.setValue(input_nomeValue);
		input_numero.setValue(input_numeroValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.HoracelularvisorProcedure.execute(world), ""), -26, -96, 48, 40, -1, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Novo-Contato\n", -29, -86, 81, 31, -16777216, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Apelido:\n", -29, -42, 81, 31, -16777216, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "N\u00FAmero:\n", -29, 1, 81, 31, -16777216, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.ExcessocontatosProcedure.execute(entity), ""), -28, 32, 120, 40, -65536, false, 0.50F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.TelefoneNaoExisteProcedure.execute(entity), ""), -28, 33, 120, 40, -65536, false, 0.50F);
	}

	@Override
	public void init() {
		super.init();
		input_nome = new EditBox(this.font, this.leftPos + -28, this.topPos + -30, 78, 18, Component.translatable("gui.minerp.tela_adionar_contato.input_nome"));
		input_nome.setMaxLength(8192);
		input_nome.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "input_nome", content, false);
		});
		this.addWidget(this.input_nome);
		input_numero = new EditBox(this.font, this.leftPos + -28, this.topPos + 13, 78, 18, Component.translatable("gui.minerp.tela_adionar_contato.input_numero"));
		input_numero.setMaxLength(8192);
		input_numero.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "input_numero", content, false);
		});
		this.addWidget(this.input_numero);
		button_chamar = Button.builder(Component.translatable("gui.minerp.tela_adionar_contato.button_chamar"), e -> {
			int x = TelaAdionarContatoScreen.this.x;
			int y = TelaAdionarContatoScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TelaAdionarContatoButtonMessage(0, x, y, z));
				TelaAdionarContatoButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -17, this.topPos + 55, 55, 20).build();
		this.addRenderableWidget(button_chamar);
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
package net.mcreator.minerp.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minerp.world.inventory.GuiDaMineradoraMenu;
import net.mcreator.minerp.procedures.MostrarLuanaCoinProcedureProcedure;
import net.mcreator.minerp.procedures.MostrarEtCoinProcedureProcedure;
import net.mcreator.minerp.procedures.MostrarCatCoinProcedureProcedure;
import net.mcreator.minerp.procedures.MostrarBatCoinProcedureProcedure;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuiDaMineradoraScreen extends AbstractContainerScreen<GuiDaMineradoraMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public GuiDaMineradoraScreen(GuiDaMineradoraMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/gui_da_mineradora.png");

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
		guiTools$alphaBlit(guiGraphics, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		net.spidrone.uiapi.UIProgressBarRenderer.drawProgressBar(guiGraphics, this.leftPos + 88, this.topPos + -74, 37, 8, 1, -16777216, -14145496, net.spidrone.uiapi.UIColorEffects.solid(-11163051), 0, 100,
				net.spidrone.uiapi.UIProgressBarRenderer.FillDirection.LEFT_TO_RIGHT);
		RenderSystem.disableBlend();
		guiTools$orderedImages : {
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 280;
				int guiTools$visibleHeight = 240;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/guiminer1.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -140 + guiTools$xOffset, this.topPos + -120 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 280, 240);
			}
			if (this.enhanced_image_button_invisivel != null && this.enhanced_image_button_invisivel.visible) {
				this.enhanced_image_button_invisivel.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_invisivel1 != null && this.enhanced_image_button_invisivel1.visible) {
				this.enhanced_image_button_invisivel1.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_invisivel2 != null && this.enhanced_image_button_invisivel2.visible) {
				this.enhanced_image_button_invisivel2.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_invisivel2_copy != null && this.enhanced_image_button_invisivel2_copy.visible) {
				this.enhanced_image_button_invisivel2_copy.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_invisivel2_copy_copy != null && this.enhanced_image_button_invisivel2_copy_copy.visible) {
				this.enhanced_image_button_invisivel2_copy_copy.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_invisivel2_copy_copy_copy != null && this.enhanced_image_button_invisivel2_copy_copy_copy.visible) {
				this.enhanced_image_button_invisivel2_copy_copy_copy.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
		}
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
		if (MostrarCatCoinProcedureProcedure.execute(world)) {
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.gui_da_mineradora.label_catcoin"), 51, 57, -16711936, false);
		}
		if (MostrarBatCoinProcedureProcedure.execute(world)) {
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.gui_da_mineradora.label_catcoin_copy"), 51, 68, -16711936, false);
		}
		if (MostrarEtCoinProcedureProcedure.execute(world)) {
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.gui_da_mineradora.label_catcoin_copy_copy"), 51, 81, -16711936, false);
		}
		if (MostrarLuanaCoinProcedureProcedure.execute(world)) {
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.gui_da_mineradora.label_catcoin_copy_copy_copy"), 51, 93, -16711936, false);
		}
		{
			guiGraphics.drawString(this.font, Component.translatable("gui.minerp.gui_da_mineradora.label_informacoes"), -111, 55, -16711936, false);
		}
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.RetornarStatusOnMineradorav1Procedure.execute(world, x, y, z), ""), 8, 37, 20, 12, -16711936, false, 0.75F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Escolher Moeda:", 0, 68, 40, 20, -16711936, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Envio:", -111, 96, 36, 12, -16711936, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Moeda:", -111, 86, 36, 12, -16711936, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Hash Da Moeda:", -111, 65, 43, 22, -16711936, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.RetornarMoedaDaMineradoraProcedure.execute(world, x, y, z), ""), -78, 86, 30, 12, -16711936, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.RetornarPlayerDaMineradoraProcedure.execute(world, x, y, z), ""), -78, 96, 30, 12, -16711936, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Hash", -78, 75, 30, 12, -16711936, false, 1.00F);
	}

	@Override
	public void init() {
		super.init();
		enhanced_image_button_invisivel = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 122, this.topPos + -117, 14, 14,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = GuiDaMineradoraScreen.this.x;
					int y = GuiDaMineradoraScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.GuiDaMineradoraButtonMessage(0, x, y, z));
						net.mcreator.minerp.network.GuiDaMineradoraButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_invisivel);
		enhanced_image_button_invisivel1 = new net.minecraft.client.gui.components.ImageButton(this.leftPos + -27, this.topPos + 6, 23, 22,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = GuiDaMineradoraScreen.this.x;
					int y = GuiDaMineradoraScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.GuiDaMineradoraButtonMessage(1, x, y, z));
						net.mcreator.minerp.network.GuiDaMineradoraButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_invisivel1);
		enhanced_image_button_invisivel2 = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 52, this.topPos + 58, 42, 10,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = GuiDaMineradoraScreen.this.x;
					int y = GuiDaMineradoraScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.GuiDaMineradoraButtonMessage(2, x, y, z));
						net.mcreator.minerp.network.GuiDaMineradoraButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_invisivel2);
		enhanced_image_button_invisivel2_copy = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 52, this.topPos + 69, 42, 10,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = GuiDaMineradoraScreen.this.x;
					int y = GuiDaMineradoraScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.GuiDaMineradoraButtonMessage(3, x, y, z));
						net.mcreator.minerp.network.GuiDaMineradoraButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_invisivel2_copy);
		enhanced_image_button_invisivel2_copy_copy = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 51, this.topPos + 82, 42, 10,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = GuiDaMineradoraScreen.this.x;
					int y = GuiDaMineradoraScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.GuiDaMineradoraButtonMessage(4, x, y, z));
						net.mcreator.minerp.network.GuiDaMineradoraButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_invisivel2_copy_copy);
		enhanced_image_button_invisivel2_copy_copy_copy = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 52, this.topPos + 94, 42, 10,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = GuiDaMineradoraScreen.this.x;
					int y = GuiDaMineradoraScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.GuiDaMineradoraButtonMessage(5, x, y, z));
						net.mcreator.minerp.network.GuiDaMineradoraButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_invisivel2_copy_copy_copy);
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

	private static final boolean guiTools$enhancedImageButton = true;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel1;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel2;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel2_copy;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel2_copy_copy;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel2_copy_copy_copy;

	private static net.minecraft.resources.ResourceLocation guiTools$buttonTexture(String value, net.minecraft.resources.ResourceLocation fallback) {
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
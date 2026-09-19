package net.mcreator.minerp.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minerp.world.inventory.TelaCelularBancoMenu;
import net.mcreator.minerp.procedures.BateriaVisorProcedure;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TelaCelularBancoScreen extends AbstractContainerScreen<TelaCelularBancoMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public TelaCelularBancoScreen(TelaCelularBancoMenu container, Inventory inventory, Component text) {
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
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/tela_celular_banco.png");

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
		net.spidrone.uiapi.UIProgressBarRenderer.drawProgressBar(guiGraphics, this.leftPos + 24, this.topPos + -95, 16, 7, 1, -16777216, -14145496, net.spidrone.uiapi.UIColorEffects.multiGradient(-6750208, -256, -16724992, -65281),
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
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 28;
				int guiTools$visibleHeight = 28;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + 18 + guiTools$xOffset, this.topPos + -9 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 28, 28);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 28;
				int guiTools$visibleHeight = 28;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + 18 + guiTools$xOffset, this.topPos + -39 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 28, 28);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 28;
				int guiTools$visibleHeight = 28;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + 18 + guiTools$xOffset, this.topPos + -70 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 28, 28);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 28;
				int guiTools$visibleHeight = 28;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -23 + guiTools$xOffset, this.topPos + -70 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 28, 28);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 28;
				int guiTools$visibleHeight = 28;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -23 + guiTools$xOffset, this.topPos + -39 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 28, 28);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 28;
				int guiTools$visibleHeight = 28;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -23 + guiTools$xOffset, this.topPos + -9 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 28, 28);
			}
			if (this.enhanced_image_button_app_config != null && this.enhanced_image_button_app_config.visible) {
				this.enhanced_image_button_app_config.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_app_banco != null && this.enhanced_image_button_app_banco.visible) {
				this.enhanced_image_button_app_banco.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_app_policia != null && this.enhanced_image_button_app_policia.visible) {
				this.enhanced_image_button_app_policia.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_app_ambulancia != null && this.enhanced_image_button_app_ambulancia.visible) {
				this.enhanced_image_button_app_ambulancia.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_app_chamada != null && this.enhanced_image_button_app_chamada.visible) {
				this.enhanced_image_button_app_chamada.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_vaunt_wallet != null && this.enhanced_image_button_vaunt_wallet.visible) {
				this.enhanced_image_button_vaunt_wallet.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_app_urbr != null && this.enhanced_image_button_app_urbr.visible) {
				this.enhanced_image_button_app_urbr.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.HoracelularvisorProcedure.execute(world), ""), -26, -96, 48, 40, -1, false, 1.00F);
	}

	@Override
	public void init() {
		super.init();
		enhanced_image_button_app_config = new net.minecraft.client.gui.components.ImageButton(this.leftPos + -22, this.topPos + -69, 26, 26,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_config.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_config.png")),
				e -> {
					int x = TelaCelularBancoScreen.this.x;
					int y = TelaCelularBancoScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularBancoButtonMessage(0, x, y, z));
						net.mcreator.minerp.network.TelaCelularBancoButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			private boolean guiTools$pressedToggled;

			@Override
			public void onPress() {
				guiTools$pressedToggled = !guiTools$pressedToggled;
				super.onPress();
			}

			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_config.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = (guiTools$pressedToggled || mousePressed) ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_app_config);
		enhanced_image_button_app_banco = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 19, this.topPos + -69, 26, 26,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_banco.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_banco.png")),
				e -> {
					int x = TelaCelularBancoScreen.this.x;
					int y = TelaCelularBancoScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularBancoButtonMessage(1, x, y, z));
						net.mcreator.minerp.network.TelaCelularBancoButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			private boolean guiTools$pressedToggled;

			@Override
			public void onPress() {
				guiTools$pressedToggled = !guiTools$pressedToggled;
				super.onPress();
			}

			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_banco.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = (guiTools$pressedToggled || mousePressed) ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_app_banco);
		enhanced_image_button_app_policia = new net.minecraft.client.gui.components.ImageButton(this.leftPos + -22, this.topPos + -38, 26, 26, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_policia.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_policia.png")), e -> {
					int x = TelaCelularBancoScreen.this.x;
					int y = TelaCelularBancoScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularBancoButtonMessage(2, x, y, z));
						net.mcreator.minerp.network.TelaCelularBancoButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			private boolean guiTools$pressedToggled;

			@Override
			public void onPress() {
				guiTools$pressedToggled = !guiTools$pressedToggled;
				super.onPress();
			}

			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_policia.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = (guiTools$pressedToggled || mousePressed) ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_app_policia);
		enhanced_image_button_app_ambulancia = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 19, this.topPos + -38, 26, 26, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_ambulancia.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_ambulancia.png")), e -> {
					int x = TelaCelularBancoScreen.this.x;
					int y = TelaCelularBancoScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularBancoButtonMessage(3, x, y, z));
						net.mcreator.minerp.network.TelaCelularBancoButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			private boolean guiTools$pressedToggled;

			@Override
			public void onPress() {
				guiTools$pressedToggled = !guiTools$pressedToggled;
				super.onPress();
			}

			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_ambulancia.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = (guiTools$pressedToggled || mousePressed) ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_app_ambulancia);
		enhanced_image_button_app_chamada = new net.minecraft.client.gui.components.ImageButton(this.leftPos + -22, this.topPos + -8, 26, 26, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_chamada.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_chamada.png")), e -> {
				}) {
			private boolean guiTools$pressedToggled;

			@Override
			public void onPress() {
				guiTools$pressedToggled = !guiTools$pressedToggled;
				super.onPress();
			}

			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_chamada.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = (guiTools$pressedToggled || mousePressed) ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_app_chamada);
		enhanced_image_button_vaunt_wallet = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 19, this.topPos + -8, 26, 26, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/vaunt_wallet.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/vaunt_wallet.png")), e -> {
				}) {
			private boolean guiTools$pressedToggled;

			@Override
			public void onPress() {
				guiTools$pressedToggled = !guiTools$pressedToggled;
				super.onPress();
			}

			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/vaunt_wallet.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = (guiTools$pressedToggled || mousePressed) ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_vaunt_wallet);
		enhanced_image_button_app_urbr = new net.minecraft.client.gui.components.ImageButton(this.leftPos + -2, this.topPos + 27, 26, 26,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_urbr.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_urbr.png")),
				e -> {
					int x = TelaCelularBancoScreen.this.x;
					int y = TelaCelularBancoScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularBancoButtonMessage(6, x, y, z));
						net.mcreator.minerp.network.TelaCelularBancoButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			private boolean guiTools$pressedToggled;

			@Override
			public void onPress() {
				guiTools$pressedToggled = !guiTools$pressedToggled;
				super.onPress();
			}

			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/app_urbr.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = (guiTools$pressedToggled || mousePressed) ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_app_urbr);
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
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_app_config;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_app_banco;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_app_policia;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_app_ambulancia;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_app_chamada;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_vaunt_wallet;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_app_urbr;

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
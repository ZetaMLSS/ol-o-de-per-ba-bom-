package net.mcreator.minerp.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minerp.world.inventory.TelaCelularCriptoCatCoinAbaMenu;
import net.mcreator.minerp.procedures.MostrarquantidadeCatCoinAtualProcedure;
import net.mcreator.minerp.procedures.MostrarValorCatCoinAtualProcedure;
import net.mcreator.minerp.procedures.BateriaVisorProcedure;
import net.mcreator.minerp.init.MinerpModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TelaCelularCriptoCatCoinAbaScreen extends AbstractContainerScreen<TelaCelularCriptoCatCoinAbaMenu> implements MinerpModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public TelaCelularCriptoCatCoinAbaScreen(TelaCelularCriptoCatCoinAbaMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("minerp:textures/screens/tela_celular_cripto_cat_coin_aba.png");

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
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 82;
				int guiTools$visibleHeight = 166;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/tradetela.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -30 + guiTools$xOffset, this.topPos + -88 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 82, 166);
			}
			if (this.enhanced_image_button_invisivel_copy != null && this.enhanced_image_button_invisivel_copy.visible) {
				this.enhanced_image_button_invisivel_copy.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_invisivel != null && this.enhanced_image_button_invisivel.visible) {
				this.enhanced_image_button_invisivel.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 21;
				int guiTools$visibleHeight = 21;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -21 + guiTools$xOffset, this.topPos + 11 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 21, 21);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 21;
				int guiTools$visibleHeight = 21;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + -21 + guiTools$xOffset, this.topPos + 33 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 21, 21);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 21;
				int guiTools$visibleHeight = 21;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + 23 + guiTools$xOffset, this.topPos + 33 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 21, 21);
			}
			if (true) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 21;
				int guiTools$visibleHeight = 21;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + 23 + guiTools$xOffset, this.topPos + 11 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 21, 21);
			}
			if (this.enhanced_image_button_configurar_senha_computador_banc != null && this.enhanced_image_button_configurar_senha_computador_banc.visible) {
				this.enhanced_image_button_configurar_senha_computador_banc.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_configurar_senha_computador_banc_copy != null && this.enhanced_image_button_configurar_senha_computador_banc_copy.visible) {
				this.enhanced_image_button_configurar_senha_computador_banc_copy.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_configurar_senha_computador_banc_copy_2 != null && this.enhanced_image_button_configurar_senha_computador_banc_copy_2.visible) {
				this.enhanced_image_button_configurar_senha_computador_banc_copy_2.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_configurar_senha_computador_banc_copy_copy != null && this.enhanced_image_button_configurar_senha_computador_banc_copy_copy.visible) {
				this.enhanced_image_button_configurar_senha_computador_banc_copy_copy.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		{
			guiGraphics.drawString(this.font, MostrarValorCatCoinAtualProcedure.execute(world), 1, -33, -16777216, false);
		}
		{
			guiGraphics.drawString(this.font, MostrarValorCatCoinAtualProcedure.execute(world), 1, -34, -16738048, false);
		}
		{
			guiGraphics.drawString(this.font, MostrarquantidadeCatCoinAtualProcedure.execute(world), 2, -4, -16777216, false);
		}
		{
			guiGraphics.drawString(this.font, MostrarquantidadeCatCoinAtualProcedure.execute(world), 2, -5, -16750951, false);
		}
		this.guiTools$renderMultilineLabel(guiGraphics, "Quantidade no mercado:", -15, -24, 60, 22, -16777216, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Valor:", -3, -44, 30, 12, -16777216, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, java.util.Objects.toString(net.mcreator.minerp.procedures.HoracelularvisorProcedure.execute(world), ""), -26, -96, 48, 21, -1, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Valor:", -4, -44, 30, 12, -1, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "Quantidade no mercado:", -16, -24, 60, 22, -1, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "ResultadoCripto", -26, 57, 74, 12, -1, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "__________", -16, -3, 80, 12, -1, false, 1.00F);
		this.guiTools$renderMultilineLabel(guiGraphics, "__________", -16, -33, 80, 12, -1, false, 1.00F);
	}

	@Override
	public void init() {
		super.init();
		enhanced_image_button_invisivel_copy = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 1, this.topPos + 88, 20, 18,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = TelaCelularCriptoCatCoinAbaScreen.this.x;
					int y = TelaCelularCriptoCatCoinAbaScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage(0, x, y, z));
						net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
		this.addWidget(enhanced_image_button_invisivel_copy);
		enhanced_image_button_invisivel = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 14, this.topPos + -64, 32, 16,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/invisivel.png")),
				e -> {
					int x = TelaCelularCriptoCatCoinAbaScreen.this.x;
					int y = TelaCelularCriptoCatCoinAbaScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage(1, x, y, z));
						net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
		enhanced_image_button_configurar_senha_computador_banc = new net.minecraft.client.gui.components.ImageButton(this.leftPos + -23, this.topPos + 9, 22, 22, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png")), e -> {
					int x = TelaCelularCriptoCatCoinAbaScreen.this.x;
					int y = TelaCelularCriptoCatCoinAbaScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage(2, x, y, z));
						net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png");
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
				String guiTools$buttonText = "-1";
				if (!guiTools$buttonText.isEmpty()) {
					guiGraphics.pose().pushPose();
					guiGraphics.pose().translate(getX() + width / 2.0, getY() + height / 2.0, 0);
					guiGraphics.pose().scale(1.25f, 1.25f, 1.0f);
					guiGraphics.drawString(net.minecraft.client.Minecraft.getInstance().font, guiTools$buttonText, -net.minecraft.client.Minecraft.getInstance().font.width(guiTools$buttonText) / 2,
							-net.minecraft.client.Minecraft.getInstance().font.lineHeight / 2, -1, false);
					guiGraphics.pose().popPose();
				}
			}
		};
		this.addWidget(enhanced_image_button_configurar_senha_computador_banc);
		enhanced_image_button_configurar_senha_computador_banc_copy = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 21, this.topPos + 9, 22, 22, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png")), e -> {
					int x = TelaCelularCriptoCatCoinAbaScreen.this.x;
					int y = TelaCelularCriptoCatCoinAbaScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage(3, x, y, z));
						net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png");
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
				String guiTools$buttonText = "+1";
				if (!guiTools$buttonText.isEmpty()) {
					guiGraphics.pose().pushPose();
					guiGraphics.pose().translate(getX() + width / 2.0, getY() + height / 2.0, 0);
					guiGraphics.pose().scale(1.25f, 1.25f, 1.0f);
					guiGraphics.drawString(net.minecraft.client.Minecraft.getInstance().font, guiTools$buttonText, -net.minecraft.client.Minecraft.getInstance().font.width(guiTools$buttonText) / 2,
							-net.minecraft.client.Minecraft.getInstance().font.lineHeight / 2, -1, false);
					guiGraphics.pose().popPose();
				}
			}
		};
		this.addWidget(enhanced_image_button_configurar_senha_computador_banc_copy);
		enhanced_image_button_configurar_senha_computador_banc_copy_2 = new net.minecraft.client.gui.components.ImageButton(this.leftPos + -23, this.topPos + 31, 22, 22, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png")), e -> {
					int x = TelaCelularCriptoCatCoinAbaScreen.this.x;
					int y = TelaCelularCriptoCatCoinAbaScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage(4, x, y, z));
						net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png");
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
				String guiTools$buttonText = "-5";
				if (!guiTools$buttonText.isEmpty()) {
					guiGraphics.pose().pushPose();
					guiGraphics.pose().translate(getX() + width / 2.0, getY() + height / 2.0, 0);
					guiGraphics.pose().scale(1.25f, 1.25f, 1.0f);
					guiGraphics.drawString(net.minecraft.client.Minecraft.getInstance().font, guiTools$buttonText, -net.minecraft.client.Minecraft.getInstance().font.width(guiTools$buttonText) / 2,
							-net.minecraft.client.Minecraft.getInstance().font.lineHeight / 2, -1, false);
					guiGraphics.pose().popPose();
				}
			}
		};
		this.addWidget(enhanced_image_button_configurar_senha_computador_banc_copy_2);
		enhanced_image_button_configurar_senha_computador_banc_copy_copy = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 21, this.topPos + 31, 22, 22, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png"), net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png")), e -> {
					int x = TelaCelularCriptoCatCoinAbaScreen.this.x;
					int y = TelaCelularCriptoCatCoinAbaScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage(5, x, y, z));
						net.mcreator.minerp.network.TelaCelularCriptoCatCoinAbaButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/resultado_banco_computador.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = guiTools$normalTexture;
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = net.minecraft.resources.ResourceLocation.parse("minerp:textures/screens/negrom.png");
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
				String guiTools$buttonText = "+5";
				if (!guiTools$buttonText.isEmpty()) {
					guiGraphics.pose().pushPose();
					guiGraphics.pose().translate(getX() + width / 2.0, getY() + height / 2.0, 0);
					guiGraphics.pose().scale(1.25f, 1.25f, 1.0f);
					guiGraphics.drawString(net.minecraft.client.Minecraft.getInstance().font, guiTools$buttonText, -net.minecraft.client.Minecraft.getInstance().font.width(guiTools$buttonText) / 2,
							-net.minecraft.client.Minecraft.getInstance().font.lineHeight / 2, -1, false);
					guiGraphics.pose().popPose();
				}
			}
		};
		this.addWidget(enhanced_image_button_configurar_senha_computador_banc_copy_copy);
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
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel_copy;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_invisivel;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_configurar_senha_computador_banc;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_configurar_senha_computador_banc_copy;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_configurar_senha_computador_banc_copy_2;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_configurar_senha_computador_banc_copy_copy;

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
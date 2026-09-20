/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.minerp.world.inventory.*;
import net.mcreator.minerp.network.MenuStateUpdateMessage;
import net.mcreator.minerp.MinerpMod;

import java.util.Map;

public class MinerpModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MinerpMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<TelaCelularInicialMenu>> TELA_CELULAR_INICIAL = REGISTRY.register("tela_celular_inicial", () -> IMenuTypeExtension.create(TelaCelularInicialMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InventarioCarteiraMenu>> INVENTARIO_CARTEIRA = REGISTRY.register("inventario_carteira", () -> IMenuTypeExtension.create(InventarioCarteiraMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TelaCelularPoliciaMenu>> TELA_CELULAR_POLICIA = REGISTRY.register("tela_celular_policia", () -> IMenuTypeExtension.create(TelaCelularPoliciaMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TelaCelularParamedicoMenu>> TELA_CELULAR_PARAMEDICO = REGISTRY.register("tela_celular_paramedico", () -> IMenuTypeExtension.create(TelaCelularParamedicoMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TelaCelularUrbMenu>> TELA_CELULAR_URB = REGISTRY.register("tela_celular_urb", () -> IMenuTypeExtension.create(TelaCelularUrbMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GuiDoCarregadorCelularMenu>> GUI_DO_CARREGADOR_CELULAR = REGISTRY.register("gui_do_carregador_celular", () -> IMenuTypeExtension.create(GuiDoCarregadorCelularMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TelaCelularBancoMenu>> TELA_CELULAR_BANCO = REGISTRY.register("tela_celular_banco", () -> IMenuTypeExtension.create(TelaCelularBancoMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TelaCelularConfigMenu>> TELA_CELULAR_CONFIG = REGISTRY.register("tela_celular_config", () -> IMenuTypeExtension.create(TelaCelularConfigMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TelaCelularCriptoMenu>> TELA_CELULAR_CRIPTO = REGISTRY.register("tela_celular_cripto", () -> IMenuTypeExtension.create(TelaCelularCriptoMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof MinerpModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}
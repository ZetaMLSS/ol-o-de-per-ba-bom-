/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.minerp.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
public class MinerpModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MinerpModMenus.TELA_CELULAR_INICIAL.get(), TelaCelularInicialScreen::new);
		event.register(MinerpModMenus.INVENTARIO_CARTEIRA.get(), InventarioCarteiraScreen::new);
		event.register(MinerpModMenus.TELA_CELULAR_POLICIA.get(), TelaCelularPoliciaScreen::new);
		event.register(MinerpModMenus.TELA_CELULAR_PARAMEDICO.get(), TelaCelularParamedicoScreen::new);
		event.register(MinerpModMenus.TELA_CELULAR_URB.get(), TelaCelularUrbScreen::new);
		event.register(MinerpModMenus.GUI_DO_CARREGADOR_CELULAR.get(), GuiDoCarregadorCelularScreen::new);
		event.register(MinerpModMenus.TELA_CELULAR_BANCO.get(), TelaCelularBancoScreen::new);
		event.register(MinerpModMenus.TELA_CELULAR_CONFIG.get(), TelaCelularConfigScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}
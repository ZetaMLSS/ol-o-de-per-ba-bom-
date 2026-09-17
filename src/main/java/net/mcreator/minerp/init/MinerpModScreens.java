/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.minerp.client.gui.TelaCelularInicialScreen;
import net.mcreator.minerp.client.gui.CarteiraGuiScreen;

@EventBusSubscriber(Dist.CLIENT)
public class MinerpModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MinerpModMenus.TELA_CELULAR_INICIAL.get(), TelaCelularInicialScreen::new);
		event.register(MinerpModMenus.CARTEIRA_GUI.get(), CarteiraGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}
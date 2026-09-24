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
		event.register(MinerpModMenus.TELA_CELULAR_CRIPTO.get(), TelaCelularCriptoScreen::new);
		event.register(MinerpModMenus.CONFIGURAR_SENHA_COMPUTADOR_BANCARIO.get(), ConfigurarSenhaComputadorBancarioScreen::new);
		event.register(MinerpModMenus.INSIRA_SUA_SENHA_COMPUTADOR_BANQUEIRO.get(), InsiraSuaSenhaComputadorBanqueiroScreen::new);
		event.register(MinerpModMenus.TELA_DE_PESQUISA_COMPUTADOR_BANCO.get(), TelaDePesquisaComputadorBancoScreen::new);
		event.register(MinerpModMenus.RESULTADO_BANCO_COMPUTADOR.get(), ResultadoBancoComputadorScreen::new);
		event.register(MinerpModMenus.TELA_CELULAR_MENSSAGENS.get(), TelaCelularMenssagensScreen::new);
		event.register(MinerpModMenus.TELA_ADIONAR_CONTATO.get(), TelaAdionarContatoScreen::new);
		event.register(MinerpModMenus.TELA_CHAT1.get(), TelaChatsScreen::new);
		event.register(MinerpModMenus.ATMTELA_1.get(), ATMTELA1Screen::new);
		event.register(MinerpModMenus.ATMTELA_2.get(), ATMTELA2Screen::new);
		event.register(MinerpModMenus.GUI_MAQUINA_CONFIG.get(), GuiMaquinaConfigScreen::new);
		event.register(MinerpModMenus.GUI_MAQUINA_CARTAONOBLOCO.get(), GuiMaquinaCartaonoblocoScreen::new);
		event.register(MinerpModMenus.GUI_APROVADO_MAQUINA_CARTAO.get(), GuiAprovadoMaquinaCartaoScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}
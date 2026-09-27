package net.mcreator.minerp.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minerp.network.MinerpModVariables;

public class AtivarNotificacaoCriptoMineradasProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MinerpModVariables.PLAYER_VARIABLES).NotificacaoCriptoMoedasMineradas == false) {
			{
				MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
				_vars.NotificacaoCriptoMoedasMineradas = true;
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Notifica\u00E7\u00F5es de cripto moedas Ligada!"), false);
		} else {
			{
				MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
				_vars.NotificacaoCriptoMoedasMineradas = false;
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Notifica\u00E7\u00F5es de cripto moedas Desligada!"), false);
		}
	}
}
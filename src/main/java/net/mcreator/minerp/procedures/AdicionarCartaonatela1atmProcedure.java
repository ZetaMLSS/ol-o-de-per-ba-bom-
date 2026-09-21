package net.mcreator.minerp.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.init.MinerpModMenus;

public class AdicionarCartaonatela1atmProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "Senha", "", true);
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.network.MinerpModVariables;

public class TelefoneNaoExisteProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(MinerpModVariables.PLAYER_VARIABLES).NumeroInesistente;
	}
}
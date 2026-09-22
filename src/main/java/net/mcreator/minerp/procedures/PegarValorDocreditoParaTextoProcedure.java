package net.mcreator.minerp.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.network.MinerpModVariables;

public class PegarValorDocreditoParaTextoProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##.##").format(entity.getData(MinerpModVariables.PLAYER_VARIABLES).LimiteDoCredito - entity.getData(MinerpModVariables.PLAYER_VARIABLES).CreditoBanco);
	}
}
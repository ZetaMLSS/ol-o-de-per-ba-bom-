package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.network.MinerpModVariables;

public class MostrarValorBatCoinCriptoCelularProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if (MinerpModVariables.MapVariables.get(world).BatCoinAtivada == true) {
			return new java.text.DecimalFormat("##.##").format(entity.getData(MinerpModVariables.PLAYER_VARIABLES).BatCoinSaldo);
		} else if (MinerpModVariables.MapVariables.get(world).BatCoinAtivada == false) {
			return "";
		}
		return "";
	}
}
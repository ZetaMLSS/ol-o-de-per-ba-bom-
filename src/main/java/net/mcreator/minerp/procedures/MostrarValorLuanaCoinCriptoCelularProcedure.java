package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.network.MinerpModVariables;

public class MostrarValorLuanaCoinCriptoCelularProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if (MinerpModVariables.MapVariables.get(world).LuanaCoinAtivada == true) {
			return new java.text.DecimalFormat("##.##").format(entity.getData(MinerpModVariables.PLAYER_VARIABLES).LuanaCoinSaldo);
		} else if (MinerpModVariables.MapVariables.get(world).LuanaCoinAtivada == false) {
			return "";
		}
		return "";
	}
}
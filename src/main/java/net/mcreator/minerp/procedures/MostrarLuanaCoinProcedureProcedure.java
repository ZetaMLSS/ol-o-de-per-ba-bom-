package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.minerp.network.MinerpModVariables;

public class MostrarLuanaCoinProcedureProcedure {
	public static boolean execute(LevelAccessor world) {
		return MinerpModVariables.MapVariables.get(world).LuanaCoinAtivada;
	}
}
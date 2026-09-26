package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.minerp.network.MinerpModVariables;

public class MostrarValorCatCoinAtualProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("##.##").format(MinerpModVariables.MapVariables.get(world).CatCoinValor);
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.network.MinerpModVariables;

public class Comprar1catcoinProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (MinerpModVariables.MapVariables.get(world).CatCoinQuantidade > 0 && entity.getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco >= MinerpModVariables.MapVariables.get(world).CatCoinValor) {
			{
				MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
				_vars.DinheiroBanco = entity.getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco - MinerpModVariables.MapVariables.get(world).CatCoinValor;
				_vars.CatCoinSaldo = entity.getData(MinerpModVariables.PLAYER_VARIABLES).CatCoinSaldo + 1;
				_vars.markSyncDirty();
			}
			MinerpModVariables.MapVariables.get(world).CatCoinQuantidade = MinerpModVariables.MapVariables.get(world).CatCoinQuantidade - 1;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}
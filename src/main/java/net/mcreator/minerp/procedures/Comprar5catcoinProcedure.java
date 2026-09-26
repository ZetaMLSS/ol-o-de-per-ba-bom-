package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.network.MinerpModVariables;

public class Comprar5catcoinProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (MinerpModVariables.MapVariables.get(world).CatCoinQuantidade > 4 && entity.getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco >= MinerpModVariables.MapVariables.get(world).CatCoinValor * 5) {
			{
				MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
				_vars.DinheiroBanco = entity.getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco - MinerpModVariables.MapVariables.get(world).CatCoinValor * 5;
				_vars.CatCoinSaldo = entity.getData(MinerpModVariables.PLAYER_VARIABLES).CatCoinSaldo + 5;
				_vars.markSyncDirty();
			}
			MinerpModVariables.MapVariables.get(world).CatCoinQuantidade = MinerpModVariables.MapVariables.get(world).CatCoinQuantidade - 5;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}
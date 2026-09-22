package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.minerp.network.MinerpModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class PagarCreditoProcedureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		MinerpModVariables.MapVariables.get(world).DinheiroDoProprioBanco = MinerpModVariables.MapVariables.get(world).DinheiroDoProprioBanco
				+ (commandParameterEntity(arguments, "player")).getData(MinerpModVariables.PLAYER_VARIABLES).CreditoBanco * 1.15;
		MinerpModVariables.MapVariables.get(world).markSyncDirty();
		{
			MinerpModVariables.PlayerVariables _vars = (commandParameterEntity(arguments, "player")).getData(MinerpModVariables.PLAYER_VARIABLES);
			_vars.DinheiroBanco = (commandParameterEntity(arguments, "player")).getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco
					- (commandParameterEntity(arguments, "player")).getData(MinerpModVariables.PLAYER_VARIABLES).CreditoBanco * 1.15;
			_vars.CreditoBanco = 0;
			_vars.markSyncDirty();
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}
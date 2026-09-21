package net.mcreator.minerp.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.minerp.network.MinerpModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class MudarcodigoUnicoProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		{
			MinerpModVariables.PlayerVariables _vars = (commandParameterEntity(arguments, "player")).getData(MinerpModVariables.PLAYER_VARIABLES);
			_vars.CartaoVinculado = DoubleArgumentType.getDouble(arguments, "numero");
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
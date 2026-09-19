package net.mcreator.minerp.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SaberONbtProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		String Resultado = "";
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(
							("" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble((commandParameterMessage(arguments, "nome")))))),
					false);
	}

	private static String commandParameterMessage(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return MessageArgument.getMessage(arguments, parameter).getString();
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return "";
		}
	}
}
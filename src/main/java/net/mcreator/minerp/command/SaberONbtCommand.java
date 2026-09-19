package net.mcreator.minerp.command;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.Commands;

@EventBusSubscriber
public class SaberONbtCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("Nbt")

				.then(Commands.argument("nome", MessageArgument.message())));
	}

}
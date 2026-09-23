package net.mcreator.minerp.command;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

@EventBusSubscriber
public class ENVIARMENSAGEMCELULARCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("enviarmensagemcelular").requires(source -> source.hasPermission(4)).then(Commands.argument("player", EntityArgument.player())
				.then(Commands.argument("celular", ItemArgument.item(event.getBuildContext())).then(Commands.argument("numero", MessageArgument.message()).then(Commands.argument("mensagem", MessageArgument.message()))))));
	}

}
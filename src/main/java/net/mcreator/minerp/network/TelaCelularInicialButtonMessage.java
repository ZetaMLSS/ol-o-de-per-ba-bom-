package net.mcreator.minerp.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.minerp.MinerpMod;

@EventBusSubscriber
public record TelaCelularInicialButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TelaCelularInicialButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinerpMod.MODID, "tela_celular_inicial_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TelaCelularInicialButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TelaCelularInicialButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TelaCelularInicialButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TelaCelularInicialButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TelaCelularInicialButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;

		guiTools$enhancedImageButton : {
			if (buttonID == 0) {
				net.mcreator.minerp.procedures.AppConfiguracoesCelularProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 1) {
				net.mcreator.minerp.procedures.AbrirAppBancoProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 2) {
				net.mcreator.minerp.procedures.BotaoCelularPoliciaProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 3) {
				net.mcreator.minerp.procedures.BotaoCelularParamedicoProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 4) {
				net.mcreator.minerp.procedures.BotaoCelularMenssagensProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 5) {
				net.mcreator.minerp.procedures.AbrirAppCriptoProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 6) {
				net.mcreator.minerp.procedures.BotaoCelularURBProcedure.execute(world, x, y, z, entity);
			}
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinerpMod.addNetworkMessage(TelaCelularInicialButtonMessage.TYPE, TelaCelularInicialButtonMessage.STREAM_CODEC, TelaCelularInicialButtonMessage::handleData);
	}
}
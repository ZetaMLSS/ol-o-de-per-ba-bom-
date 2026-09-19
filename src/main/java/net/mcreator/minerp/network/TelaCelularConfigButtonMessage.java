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
public record TelaCelularConfigButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TelaCelularConfigButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinerpMod.MODID, "tela_celular_config_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TelaCelularConfigButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TelaCelularConfigButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TelaCelularConfigButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TelaCelularConfigButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TelaCelularConfigButtonMessage message, final IPayloadContext context) {
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
				net.mcreator.minerp.procedures.AppConfiguracoesCelularProcedure.execute();
			}
			if (buttonID == 1) {
				net.mcreator.minerp.procedures.AbrirAppBancoProcedure.execute();
			}
			if (buttonID == 2) {
				net.mcreator.minerp.procedures.BotaoCelularPoliciaProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 3) {
				net.mcreator.minerp.procedures.BotaoCelularParamedicoProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 6) {
				net.mcreator.minerp.procedures.BotaoCelularURBProcedure.execute(world, x, y, z, entity);
			}
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinerpMod.addNetworkMessage(TelaCelularConfigButtonMessage.TYPE, TelaCelularConfigButtonMessage.STREAM_CODEC, TelaCelularConfigButtonMessage::handleData);
	}
}
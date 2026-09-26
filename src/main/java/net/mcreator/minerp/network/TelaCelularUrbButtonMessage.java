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

import net.mcreator.minerp.procedures.ChamarUrbProcedure;
import net.mcreator.minerp.MinerpMod;

@EventBusSubscriber
public record TelaCelularUrbButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TelaCelularUrbButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinerpMod.MODID, "tela_celular_urb_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TelaCelularUrbButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TelaCelularUrbButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TelaCelularUrbButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TelaCelularUrbButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TelaCelularUrbButtonMessage message, final IPayloadContext context) {
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
		if (buttonID == 0) {

			ChamarUrbProcedure.execute(world, x, y, z, entity);
		}

		guiTools$enhancedImageButton : {
			if (buttonID == 1) {
				net.mcreator.minerp.procedures.BotaoInvisivelcelularvoltaraoinicioProcedure.execute(world, x, y, z, entity);
			}
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinerpMod.addNetworkMessage(TelaCelularUrbButtonMessage.TYPE, TelaCelularUrbButtonMessage.STREAM_CODEC, TelaCelularUrbButtonMessage::handleData);
	}
}
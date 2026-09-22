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

import net.mcreator.minerp.procedures.*;
import net.mcreator.minerp.MinerpMod;

@EventBusSubscriber
public record ATMTELA2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<ATMTELA2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinerpMod.MODID, "atmtela_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ATMTELA2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ATMTELA2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ATMTELA2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<ATMTELA2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ATMTELA2ButtonMessage message, final IPayloadContext context) {
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

			RetirarAtm1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			RetirarAtm5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			RetirarAtm10Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			RetirarAtm20Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			RetirarAtm50Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			RetirarAtm100Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			RetirarAtm05Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			RetirarAtm200Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinerpMod.addNetworkMessage(ATMTELA2ButtonMessage.TYPE, ATMTELA2ButtonMessage.STREAM_CODEC, ATMTELA2ButtonMessage::handleData);
	}
}
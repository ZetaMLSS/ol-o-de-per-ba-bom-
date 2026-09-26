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
public record GuiDaMineradoraButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<GuiDaMineradoraButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinerpMod.MODID, "gui_da_mineradora_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GuiDaMineradoraButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GuiDaMineradoraButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new GuiDaMineradoraButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<GuiDaMineradoraButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final GuiDaMineradoraButtonMessage message, final IPayloadContext context) {
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
				net.mcreator.minerp.procedures.FecharGuiProcedure.execute(entity);
			}
			if (buttonID == 1) {
				net.mcreator.minerp.procedures.BotaoLigarMineradorav1procedureProcedure.execute(world, x, y, z);
			}
			if (buttonID == 2) {
				net.mcreator.minerp.procedures.SelecionarMoedaMineiradoraCatCoinProcedure.execute(world, x, y, z);
			}
			if (buttonID == 3) {
				net.mcreator.minerp.procedures.SelecionarMoedaMineiradoraBatCoinProcedure.execute(world, x, y, z);
			}
			if (buttonID == 4) {
				net.mcreator.minerp.procedures.SelecionarMoedaMineiradoraEtCoinProcedure.execute(world, x, y, z);
			}
			if (buttonID == 5) {
				net.mcreator.minerp.procedures.SelecionarMoedaMineiradoraLuanaCoinProcedure.execute(world, x, y, z);
			}
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinerpMod.addNetworkMessage(GuiDaMineradoraButtonMessage.TYPE, GuiDaMineradoraButtonMessage.STREAM_CODEC, GuiDaMineradoraButtonMessage::handleData);
	}
}
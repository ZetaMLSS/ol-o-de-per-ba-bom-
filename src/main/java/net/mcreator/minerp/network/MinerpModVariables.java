package net.mcreator.minerp.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.minerp.MinerpMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class MinerpModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MinerpMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(PlayerVariables::new).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MinerpMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		MinerpMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.DinheiroBanco = original.DinheiroBanco;
		clone.CatCoinSaldo = original.CatCoinSaldo;
		clone.CreditoBanco = original.CreditoBanco;
		clone.LimiteDoCredito = original.LimiteDoCredito;
		clone.CartaoVinculado = original.CartaoVinculado;
		clone.NumeroInesistente = original.NumeroInesistente;
		clone.BatCoinSaldo = original.BatCoinSaldo;
		clone.EtCoinSaldo = original.EtCoinSaldo;
		clone.LuanaCoinSaldo = original.LuanaCoinSaldo;
		if (!event.isWasDeath()) {
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData mapdata = MapVariables.get(player.level());
			SavedData worlddata = WorldVariables.get(player.level());
			if (mapdata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData worlddata = WorldVariables.get(player.level());
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "minerp_worldvars";
		boolean _syncDirty = false;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "minerp_mapvars";
		boolean _syncDirty = false;
		public double CatCoinValor = 0;
		public double CatCoinQuantidade = 0;
		public boolean urb_ativo = false;
		public double urb_x = 0;
		public double urb_y = 0;
		public double urb_z = 0;
		public double CatCoinLimite = 0;
		public double DinheiroDoProprioBanco = 0;
		public String numeros_registrados = "\"\"";
		public String canal1_alvo = "livre";
		public String canal2_alvo = "livre";
		public String canal3_alvo = "livre";
		public String canal1_remetente = "\"\"";
		public String canal2_remetente = "\"\"";
		public String canal3_remetente = "\"\"";
		public String canal1_texto = "\"\"";
		public String canal2_texto = "\"\"";
		public String canal3_texto = "\"\"";
		public boolean CatCoinAtivada = true;
		public boolean BatCoinAtivada = false;
		public boolean LuanaCoinAtivada = false;
		public boolean EtCoinAtivada = false;
		public double BatCoinValor = 0;
		public double BatCoinQuantidade = 0;
		public double BatCoinLimite = 0;
		public double EtCoinValor = 0;
		public double EtCoinQuantidade = 0;
		public double EtCoinLimite = 0;
		public double LuanaCoinValor = 0;
		public double LuanaCoinQuantidade = 0;
		public double LuanaCoinLimite = 0;
		public double DinheiroPrefeitura = 0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			CatCoinValor = nbt.getDouble("CatCoinValor");
			CatCoinQuantidade = nbt.getDouble("CatCoinQuantidade");
			urb_ativo = nbt.getBoolean("urb_ativo");
			urb_x = nbt.getDouble("urb_x");
			urb_y = nbt.getDouble("urb_y");
			urb_z = nbt.getDouble("urb_z");
			CatCoinLimite = nbt.getDouble("CatCoinLimite");
			DinheiroDoProprioBanco = nbt.getDouble("DinheiroDoProprioBanco");
			numeros_registrados = nbt.getString("numeros_registrados");
			canal1_alvo = nbt.getString("canal1_alvo");
			canal2_alvo = nbt.getString("canal2_alvo");
			canal3_alvo = nbt.getString("canal3_alvo");
			canal1_remetente = nbt.getString("canal1_remetente");
			canal2_remetente = nbt.getString("canal2_remetente");
			canal3_remetente = nbt.getString("canal3_remetente");
			canal1_texto = nbt.getString("canal1_texto");
			canal2_texto = nbt.getString("canal2_texto");
			canal3_texto = nbt.getString("canal3_texto");
			CatCoinAtivada = nbt.getBoolean("CatCoinAtivada");
			BatCoinAtivada = nbt.getBoolean("BatCoinAtivada");
			LuanaCoinAtivada = nbt.getBoolean("LuanaCoinAtivada");
			EtCoinAtivada = nbt.getBoolean("EtCoinAtivada");
			BatCoinValor = nbt.getDouble("BatCoinValor");
			BatCoinQuantidade = nbt.getDouble("BatCoinQuantidade");
			BatCoinLimite = nbt.getDouble("BatCoinLimite");
			EtCoinValor = nbt.getDouble("EtCoinValor");
			EtCoinQuantidade = nbt.getDouble("EtCoinQuantidade");
			EtCoinLimite = nbt.getDouble("EtCoinLimite");
			LuanaCoinValor = nbt.getDouble("LuanaCoinValor");
			LuanaCoinQuantidade = nbt.getDouble("LuanaCoinQuantidade");
			LuanaCoinLimite = nbt.getDouble("LuanaCoinLimite");
			DinheiroPrefeitura = nbt.getDouble("DinheiroPrefeitura");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("CatCoinValor", CatCoinValor);
			nbt.putDouble("CatCoinQuantidade", CatCoinQuantidade);
			nbt.putBoolean("urb_ativo", urb_ativo);
			nbt.putDouble("urb_x", urb_x);
			nbt.putDouble("urb_y", urb_y);
			nbt.putDouble("urb_z", urb_z);
			nbt.putDouble("CatCoinLimite", CatCoinLimite);
			nbt.putDouble("DinheiroDoProprioBanco", DinheiroDoProprioBanco);
			nbt.putString("numeros_registrados", numeros_registrados);
			nbt.putString("canal1_alvo", canal1_alvo);
			nbt.putString("canal2_alvo", canal2_alvo);
			nbt.putString("canal3_alvo", canal3_alvo);
			nbt.putString("canal1_remetente", canal1_remetente);
			nbt.putString("canal2_remetente", canal2_remetente);
			nbt.putString("canal3_remetente", canal3_remetente);
			nbt.putString("canal1_texto", canal1_texto);
			nbt.putString("canal2_texto", canal2_texto);
			nbt.putString("canal3_texto", canal3_texto);
			nbt.putBoolean("CatCoinAtivada", CatCoinAtivada);
			nbt.putBoolean("BatCoinAtivada", BatCoinAtivada);
			nbt.putBoolean("LuanaCoinAtivada", LuanaCoinAtivada);
			nbt.putBoolean("EtCoinAtivada", EtCoinAtivada);
			nbt.putDouble("BatCoinValor", BatCoinValor);
			nbt.putDouble("BatCoinQuantidade", BatCoinQuantidade);
			nbt.putDouble("BatCoinLimite", BatCoinLimite);
			nbt.putDouble("EtCoinValor", EtCoinValor);
			nbt.putDouble("EtCoinQuantidade", EtCoinQuantidade);
			nbt.putDouble("EtCoinLimite", EtCoinLimite);
			nbt.putDouble("LuanaCoinValor", LuanaCoinValor);
			nbt.putDouble("LuanaCoinQuantidade", LuanaCoinQuantidade);
			nbt.putDouble("LuanaCoinLimite", LuanaCoinLimite);
			nbt.putDouble("DinheiroPrefeitura", DinheiroPrefeitura);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			_syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinerpMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		boolean _syncDirty = false;
		public double DinheiroBanco = 0;
		public double CatCoinSaldo = 0;
		public double CreditoBanco = 0;
		public double LimiteDoCredito = 0;
		public double CartaoVinculado = 0;
		public String NumeroInesistente = "\"\"";
		public double BatCoinSaldo = 0;
		public double EtCoinSaldo = 0;
		public double LuanaCoinSaldo = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("DinheiroBanco", DinheiroBanco);
			nbt.putDouble("CatCoinSaldo", CatCoinSaldo);
			nbt.putDouble("CreditoBanco", CreditoBanco);
			nbt.putDouble("LimiteDoCredito", LimiteDoCredito);
			nbt.putDouble("CartaoVinculado", CartaoVinculado);
			nbt.putString("NumeroInesistente", NumeroInesistente);
			nbt.putDouble("BatCoinSaldo", BatCoinSaldo);
			nbt.putDouble("EtCoinSaldo", EtCoinSaldo);
			nbt.putDouble("LuanaCoinSaldo", LuanaCoinSaldo);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			DinheiroBanco = nbt.getDouble("DinheiroBanco");
			CatCoinSaldo = nbt.getDouble("CatCoinSaldo");
			CreditoBanco = nbt.getDouble("CreditoBanco");
			LimiteDoCredito = nbt.getDouble("LimiteDoCredito");
			CartaoVinculado = nbt.getDouble("CartaoVinculado");
			NumeroInesistente = nbt.getString("NumeroInesistente");
			BatCoinSaldo = nbt.getDouble("BatCoinSaldo");
			EtCoinSaldo = nbt.getDouble("EtCoinSaldo");
			LuanaCoinSaldo = nbt.getDouble("LuanaCoinSaldo");
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinerpMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
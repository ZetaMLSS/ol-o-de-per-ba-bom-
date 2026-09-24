package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.world.inventory.GuiAprovadoMaquinaCartaoMenu;
import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;
import net.mcreator.minerp.init.MinerpModItems;

import java.util.ArrayList;

import io.netty.buffer.Unpooled;

public class LerCartaoEDarResultadoNaMaquinaCartaoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack recibo = ItemStack.EMPTY;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.CARTAO_DE_CREDITO.get()) {
			if (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity2 && _entity2.containerMenu instanceof MinerpModMenus.MenuAccessor _menu2)
					? _menu2.getMenuState(0, "senha", "")
					: "") == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("senha")) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("codigo") == entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).CartaoVinculado) {
						if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("debito") == true
								&& entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco >= (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
										.copyTag().getDouble("valor")) {
							{
								MinerpModVariables.PlayerVariables _vars = entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES);
								_vars.DinheiroBanco = entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco
										- (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("valor");
								_vars.markSyncDirty();
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null) {
									_blockEntity.getPersistentData().putString("status", "aprovado");
								}
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							recibo = new ItemStack(MinerpModItems.RECIBO_DE_VENDA.get()).copy();
							{
								final String _tagName = "valor";
								final double _tagValue = ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("valor"));
								CustomData.update(DataComponents.CUSTOM_DATA, recibo, tag -> tag.putDouble(_tagName, _tagValue));
							}
							{
								final String _tagName = "nickvendedor";
								final String _tagValue = ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nickvendedor"));
								CustomData.update(DataComponents.CUSTOM_DATA, recibo, tag -> tag.putString(_tagName, _tagValue));
							}
							{
								final String _tagName = "metodo";
								final String _tagValue = "Debito";
								CustomData.update(DataComponents.CUSTOM_DATA, recibo, tag -> tag.putString(_tagName, _tagValue));
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = recibo.copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(9, _setstack);
							}
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(x, y, z);
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("GuiAprovadoMaquinaCartao");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new GuiAprovadoMaquinaCartaoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
							break;
						} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("credito") == true
								&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
										.getDouble("valor") <= entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).LimiteDoCredito - entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).CreditoBanco) {
							MinerpModVariables.MapVariables.get(world).DinheiroDoProprioBanco = MinerpModVariables.MapVariables.get(world).DinheiroDoProprioBanco
									- (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("valor");
							MinerpModVariables.MapVariables.get(world).markSyncDirty();
							{
								MinerpModVariables.PlayerVariables _vars = entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES);
								_vars.CreditoBanco = entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).CreditoBanco
										+ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("valor") * 1.15;
								_vars.markSyncDirty();
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null) {
									_blockEntity.getPersistentData().putString("status", "aprovado");
								}
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							recibo = new ItemStack(MinerpModItems.RECIBO_DE_VENDA.get()).copy();
							{
								final String _tagName = "valor";
								final double _tagValue = ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("valor"));
								CustomData.update(DataComponents.CUSTOM_DATA, recibo, tag -> tag.putDouble(_tagName, _tagValue));
							}
							{
								final String _tagName = "nickvendedor";
								final String _tagValue = ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nickvendedor"));
								CustomData.update(DataComponents.CUSTOM_DATA, recibo, tag -> tag.putString(_tagName, _tagValue));
							}
							{
								final String _tagName = "metodo";
								final String _tagValue = "Credito";
								CustomData.update(DataComponents.CUSTOM_DATA, recibo, tag -> tag.putString(_tagName, _tagValue));
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = recibo.copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot(9, _setstack);
							}
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(x, y, z);
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("GuiAprovadoMaquinaCartao");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new GuiAprovadoMaquinaCartaoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
							break;
						} else {
							if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
								_menu.sendMenuStateUpdate(_player, 0, "senha", "Cart\u00E3o Recusado.", true);
						}
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
							_menu.sendMenuStateUpdate(_player, 0, "senha", "Cart\u00E3o invalido.", true);
					}
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
					_menu.sendMenuStateUpdate(_player, 0, "senha", "Senha incorreta.", true);
			}
		} else {
			if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "senha", "Insira o cart\u00E3o.", true);
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}
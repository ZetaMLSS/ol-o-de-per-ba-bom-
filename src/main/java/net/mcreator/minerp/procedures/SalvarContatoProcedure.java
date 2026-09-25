package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.world.inventory.TelaCelularMenssagensMenu;
import net.mcreator.minerp.world.inventory.TelaAdionarContatoMenu;
import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;

import io.netty.buffer.Unpooled;

public class SalvarContatoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double slots = 0;
		ItemStack contato = ItemStack.EMPTY;
		slots = 1;
		if (MinerpModVariables.MapVariables.get(world).numeros_registrados
				.contains(((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "input_numero", "") : "") + ",")) {
			for (int _i1 = 0; _i1 < 9; _i1++) {
				if ((getItemStackFromItemStackSlot((int) slots, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem()) {
					contato = new ItemStack(Items.PAPER).copy();
					{
						final String _tagName = "numero";
						final double _tagValue = new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert((entity instanceof Player _entity4 && _entity4.containerMenu instanceof MinerpModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "input_numero", "") : "");
						CustomData.update(DataComponents.CUSTOM_DATA, contato, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "nome";
						final String _tagValue = ((entity instanceof Player _entity6 && _entity6.containerMenu instanceof MinerpModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(0, "input_nome", "") : "");
						CustomData.update(DataComponents.CUSTOM_DATA, contato, tag -> tag.putString(_tagName, _tagValue));
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
						ItemStack _setstack = contato.copy();
						_setstack.setCount(1);
						_modHandlerItemSetSlot.setStackInSlot((int) slots, _setstack);
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("TelaCelularMenssagens");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
					break;
				}
				slots = slots + 1;
			}
		} else {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TelaAdionarContato");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TelaAdionarContatoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			{
				MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
				_vars.NumeroInesistente = "Erro: Este n\u00FAmero n\u00E3o existe!";
				_vars.markSyncDirty();
			}
		}
	}

	private static ItemStack getItemStackFromItemStackSlot(int slotID, ItemStack itemStack) {
		IItemHandler itemHandler = itemStack.getCapability(Capabilities.ItemHandler.ITEM, null);
		if (itemHandler != null)
			return itemHandler.getStackInSlot(slotID).copy();
		return ItemStack.EMPTY;
	}
}
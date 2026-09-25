package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModMenus;

import java.util.ArrayList;

public class EnviarmensagemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double numero_slot = 0;
		double ValorSlotRepeat = 0;
		boolean alvo_encontrado = false;
		ItemStack mensagem = ItemStack.EMPTY;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Enviado: " + ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "escrevermensagem", "") : ""))), false);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (((getItemStackFromItemStackSlot(
							(int) Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero_chat_ativo")),
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero"))
							.equals(new java.text.DecimalFormat("##").format(itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")))) {
						ValorSlotRepeat = 1;
						for (int _i1 = 0; _i1 < 10; _i1++) {
							if (((getItemStackFromItemStackSlot((int) ValorSlotRepeat, itemstackiterator)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")).equals(new java.text.DecimalFormat("##")
									.format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")))) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(((getItemStackFromItemStackSlot((int) ValorSlotRepeat, itemstackiterator)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")
											+ ": " + ((entity instanceof Player _entity17 && _entity17.containerMenu instanceof MinerpModMenus.MenuAccessor _menu17) ? _menu17.getMenuState(0, "escrevermensagem", "") : ""))), false);
								break;
							}
							if (ValorSlotRepeat >= 10) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(((new java.text.DecimalFormat("##")
											.format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"))) + ": "
											+ ((entity instanceof Player _entity21 && _entity21.containerMenu instanceof MinerpModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(0, "escrevermensagem", "") : ""))), false);
								break;
							}
							ValorSlotRepeat = ValorSlotRepeat + 1;
						}
					}
				}
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
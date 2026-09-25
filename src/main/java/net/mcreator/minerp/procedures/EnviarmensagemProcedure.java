package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
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
			_player.displayClientMessage(Component.literal(("Tentando enviar para: " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString((new java.text.DecimalFormat("##").format((getItemStackFromItemStackSlot(
							(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero_chat_ativo")),
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"))))))),
					false);
		{
			final String _tagName = "mensagem1";
			final String _tagValue = ("Voc\u00EA: " + ((entity instanceof Player _entity8 && _entity8.containerMenu instanceof MinerpModMenus.MenuAccessor _menu8) ? _menu8.getMenuState(0, "escrevermensagem", "") : ""));
			CustomData.update(DataComponents.CUSTOM_DATA,
					(getItemStackFromItemStackSlot((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero_chat_ativo")),
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
					tag -> tag.putString(_tagName, _tagValue));
		}
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
							.getDouble("numero") == (getItemStackFromItemStackSlot(
									(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero_chat_ativo")),
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")) {
						ValorSlotRepeat = 1;
						mensagem = new ItemStack(Items.PAPER).copy();
						{
							final String _tagName = "mensagem";
							final String _tagValue = ((entity instanceof Player _entity21 && _entity21.containerMenu instanceof MinerpModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(0, "escrevermensagem", "") : "");
							CustomData.update(DataComponents.CUSTOM_DATA, mensagem, tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "numero";
							final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"));
							CustomData.update(DataComponents.CUSTOM_DATA, mensagem, tag -> tag.putDouble(_tagName, _tagValue));
						}
						for (int _i1 = 0; _i1 < 10; _i1++) {
							if ((getItemStackFromItemStackSlot((int) ValorSlotRepeat, itemstackiterator)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
									.getDouble("numero") == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")) {
								if (itemstackiterator.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
									ItemStack _setstack = mensagem.copy();
									_setstack.setCount(1);
									_modHandlerItemSetSlot.setStackInSlot((int) ValorSlotRepeat, _setstack);
								}
								break;
							}
							if (ValorSlotRepeat == 11) {
								if (itemstackiterator.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
									ItemStack _setstack = mensagem.copy();
									_setstack.setCount(1);
									_modHandlerItemSetSlot.setStackInSlot(11, _setstack);
								}
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
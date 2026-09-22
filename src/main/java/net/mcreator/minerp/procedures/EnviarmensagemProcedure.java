package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;

import java.util.ArrayList;

public class EnviarmensagemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double numero_slot = 0;
		boolean alvo_encontrado = false;
		alvo_encontrado = false;
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L5");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L4")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L4");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L3")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L3");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L2")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L2");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L1")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")) + "_L1");
			final String _tagValue = ("Voc\u00EA: " + ((entity instanceof Player _entity34 && _entity34.containerMenu instanceof MinerpModMenus.MenuAccessor _menu34) ? _menu34.getMenuState(0, "escrevermensagem", "") : ""));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(
							("Tentando enviar para: " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo")))),
					false);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero") == new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo"))) {
						alvo_encontrado = true;
						break;
					}
				}
			}
		}
		if (alvo_encontrado == true) {
			if ((MinerpModVariables.MapVariables.get(world).canal1_alvo).equals("livre")) {
				MinerpModVariables.MapVariables.get(world).canal1_alvo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
						.getString("numero_chat_ativo");
				MinerpModVariables.MapVariables.get(world).canal1_remetente = ""
						+ ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"));
				MinerpModVariables.MapVariables.get(world).canal1_texto = (entity instanceof Player _entity50 && _entity50.containerMenu instanceof MinerpModMenus.MenuAccessor _menu50) ? _menu50.getMenuState(0, "escrevermensagem", "") : "";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((MinerpModVariables.MapVariables.get(world).canal2_alvo).equals("livre")) {
				MinerpModVariables.MapVariables.get(world).canal2_alvo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
						.getString("numero_chat_ativo");
				MinerpModVariables.MapVariables.get(world).canal2_remetente = ""
						+ ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"));
				MinerpModVariables.MapVariables.get(world).canal2_texto = (entity instanceof Player _entity55 && _entity55.containerMenu instanceof MinerpModMenus.MenuAccessor _menu55) ? _menu55.getMenuState(0, "escrevermensagem", "") : "";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((MinerpModVariables.MapVariables.get(world).canal3_alvo).equals("livre")) {
				MinerpModVariables.MapVariables.get(world).canal3_alvo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
						.getString("numero_chat_ativo");
				MinerpModVariables.MapVariables.get(world).canal3_remetente = ""
						+ ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"));
				MinerpModVariables.MapVariables.get(world).canal3_texto = (entity instanceof Player _entity60 && _entity60.containerMenu instanceof MinerpModMenus.MenuAccessor _menu60) ? _menu60.getMenuState(0, "escrevermensagem", "") : "";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Rede ocupada, tente novamente em breve."), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("N\u00FAmero desligado ou fora de \u00E1rea."), false);
		}
	}
}
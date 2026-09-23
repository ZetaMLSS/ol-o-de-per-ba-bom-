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

import net.mcreator.minerp.world.inventory.*;
import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;

import java.util.ArrayList;

public class EnviarmensagemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double numero_slot = 0;
		boolean alvo_encontrado = false;
		String qualchatestaaberto = "";
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof TelaChatsMenu) {
			qualchatestaaberto = "contato_numero_1";
		} else {
			if (entity instanceof Player _plr1 && _plr1.containerMenu instanceof TelaChats2Menu) {
				qualchatestaaberto = "contato_numero_2";
			} else {
				if (entity instanceof Player _plr2 && _plr2.containerMenu instanceof TelaChats3Menu) {
					qualchatestaaberto = "contato_numero_3";
				} else {
					if (entity instanceof Player _plr3 && _plr3.containerMenu instanceof TelaChats4Menu) {
						qualchatestaaberto = "contato_numero_4";
					} else {
						if (entity instanceof Player _plr4 && _plr4.containerMenu instanceof TelaChats5Menu) {
							qualchatestaaberto = "contato_numero_5";
						} else {
							if (entity instanceof Player _plr5 && _plr5.containerMenu instanceof TelaChats6Menu) {
								qualchatestaaberto = "contato_numero_6";
							} else {
								if (entity instanceof Player _plr6 && _plr6.containerMenu instanceof TelaChats7Menu) {
									qualchatestaaberto = "contato_numero_7";
								} else {
									if (entity instanceof Player _plr7 && _plr7.containerMenu instanceof TelaChats8Menu) {
										qualchatestaaberto = "contato_numero_8";
									} else {
										if (entity instanceof Player _plr8 && _plr8.containerMenu instanceof TelaChats9Menu) {
											qualchatestaaberto = "contato_numero_9";
										} else {
											if (entity instanceof Player _plr9 && _plr9.containerMenu instanceof TelaChats10Menu) {
												qualchatestaaberto = "contato_numero_10";
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		alvo_encontrado = false;
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L5");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L4")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L4");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L3")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L3");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L2")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L2");
			final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
					.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L1")));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)) + "_L1");
			final String _tagValue = ("Voc\u00EA: " + ((entity instanceof Player _entity44 && _entity44.containerMenu instanceof MinerpModMenus.MenuAccessor _menu44) ? _menu44.getMenuState(0, "escrevermensagem", "") : ""));
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(
							("Tentando enviar para: " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(qualchatestaaberto)))),
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
				MinerpModVariables.MapVariables.get(world).canal1_texto = (entity instanceof Player _entity60 && _entity60.containerMenu instanceof MinerpModMenus.MenuAccessor _menu60) ? _menu60.getMenuState(0, "escrevermensagem", "") : "";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((MinerpModVariables.MapVariables.get(world).canal2_alvo).equals("livre")) {
				MinerpModVariables.MapVariables.get(world).canal2_alvo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
						.getString("numero_chat_ativo");
				MinerpModVariables.MapVariables.get(world).canal2_remetente = ""
						+ ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"));
				MinerpModVariables.MapVariables.get(world).canal2_texto = (entity instanceof Player _entity65 && _entity65.containerMenu instanceof MinerpModMenus.MenuAccessor _menu65) ? _menu65.getMenuState(0, "escrevermensagem", "") : "";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((MinerpModVariables.MapVariables.get(world).canal3_alvo).equals("livre")) {
				MinerpModVariables.MapVariables.get(world).canal3_alvo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
						.getString("numero_chat_ativo");
				MinerpModVariables.MapVariables.get(world).canal3_remetente = ""
						+ ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero"));
				MinerpModVariables.MapVariables.get(world).canal3_texto = (entity instanceof Player _entity70 && _entity70.containerMenu instanceof MinerpModMenus.MenuAccessor _menu70) ? _menu70.getMenuState(0, "escrevermensagem", "") : "";
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
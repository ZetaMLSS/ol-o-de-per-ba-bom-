package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModMenus;
import net.mcreator.minerp.init.MinerpModItems;

import java.util.ArrayList;

public class EnviarmensagemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
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
			final String _tagValue = ((entity instanceof Player _entity34 && _entity34.containerMenu instanceof MinerpModMenus.MenuAccessor _menu34) ? _menu34.getMenuState(0, "escrevermensagem", "") : "");
			CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
		}
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.getItem() == MinerpModItems.CELULAR.get() && (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero"))
							.equals((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero_chat_ativo"))) {
						{
							final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L5");
							final String _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
									.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L4")));
							CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L4");
							final String _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
									.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L3")));
							CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L3");
							final String _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
									.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L2")));
							CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L2");
							final String _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
									.getString(("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L1")));
							CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = ("Chat_" + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + "_L1");
							final String _tagValue = ((entity instanceof Player _entity77 && _entity77.containerMenu instanceof MinerpModMenus.MenuAccessor _menu77) ? _menu77.getMenuState(0, "escrevermensagem", "") : "");
							CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "Ultima_Mensagem_Numero";
							final String _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero"));
							CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putString(_tagName, _tagValue));
						}
					}
				}
			}
		}
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class ExcessocontatosProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_10")).equals("")) {
			return "";
		}
		return "Lista de Contatos Cheia!";
	}
}
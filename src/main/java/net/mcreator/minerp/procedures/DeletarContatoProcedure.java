package net.mcreator.minerp.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModMenus;

public class DeletarContatoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 1) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_1")).equals(""))) {
				{
					final String _tagName = "contato_nome_1";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_1";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity7 && _entity7.containerMenu instanceof MinerpModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 2) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_2")).equals(""))) {
				{
					final String _tagName = "contato_nome_2";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_2";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity14 && _entity14.containerMenu instanceof MinerpModMenus.MenuAccessor _menu14) ? _menu14.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 3) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_3")).equals(""))) {
				{
					final String _tagName = "contato_nome_3";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_3";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity21 && _entity21.containerMenu instanceof MinerpModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 4) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_4")).equals(""))) {
				{
					final String _tagName = "contato_nome_4";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_4";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity28 && _entity28.containerMenu instanceof MinerpModMenus.MenuAccessor _menu28) ? _menu28.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 5) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_5")).equals(""))) {
				{
					final String _tagName = "contato_nome_5";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_5";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity35 && _entity35.containerMenu instanceof MinerpModMenus.MenuAccessor _menu35) ? _menu35.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 6) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_6")).equals(""))) {
				{
					final String _tagName = "contato_nome_6";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_6";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity42 && _entity42.containerMenu instanceof MinerpModMenus.MenuAccessor _menu42) ? _menu42.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 7) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_7")).equals(""))) {
				{
					final String _tagName = "contato_nome_7";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_7";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity49 && _entity49.containerMenu instanceof MinerpModMenus.MenuAccessor _menu49) ? _menu49.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 8) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_8")).equals(""))) {
				{
					final String _tagName = "contato_nome_8";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_8";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity56 && _entity56.containerMenu instanceof MinerpModMenus.MenuAccessor _menu56) ? _menu56.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 9) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_9")).equals(""))) {
				{
					final String _tagName = "contato_nome_9";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_9";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		} else if (((entity instanceof Player _entity63 && _entity63.containerMenu instanceof MinerpModMenus.MenuAccessor _menu63) ? _menu63.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 10) {
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_10")).equals(""))) {
				{
					final String _tagName = "contato_nome_10";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_10";
					final String _tagValue = "";
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
			}
		}
	}
}
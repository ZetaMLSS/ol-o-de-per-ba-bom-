package net.mcreator.minerp.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModMenus;

public class ProcedureDaConfigDaMaquinaDeCartaoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) && _menu0.getMenuState(1, "Credito", false)
				&& (entity instanceof Player _entity1 && _entity1.containerMenu instanceof MinerpModMenus.MenuAccessor _menu1) && _menu1.getMenuState(1, "Debito", false)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "ValorAPagar", "Error", true);
		} else if (!((entity instanceof Player _entity3 && _entity3.containerMenu instanceof MinerpModMenus.MenuAccessor _menu3) && _menu3.getMenuState(1, "Credito", false))
				&& !((entity instanceof Player _entity4 && _entity4.containerMenu instanceof MinerpModMenus.MenuAccessor _menu4) && _menu4.getMenuState(1, "Debito", false))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "ValorAPagar", "Error", true);
		} else {
			if ((entity instanceof Player _entity6 && _entity6.containerMenu instanceof MinerpModMenus.MenuAccessor _menu6) && _menu6.getMenuState(1, "Credito", false)) {
				{
					final String _tagName = "credito";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "valor";
					final double _tagValue = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((entity instanceof Player _entity9 && _entity9.containerMenu instanceof MinerpModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(0, "ValorAPagar", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "nickvendedor";
					final String _tagValue = (entity.getDisplayName().getString());
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "pronto";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
			if ((entity instanceof Player _entity18 && _entity18.containerMenu instanceof MinerpModMenus.MenuAccessor _menu18) && _menu18.getMenuState(1, "Debito", false)) {
				{
					final String _tagName = "debito";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
				}
				{
					final String _tagName = "valor";
					final double _tagValue = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((entity instanceof Player _entity21 && _entity21.containerMenu instanceof MinerpModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(0, "ValorAPagar", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "nickvendedor";
					final String _tagValue = (entity.getDisplayName().getString());
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "pronto";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		}
	}
}
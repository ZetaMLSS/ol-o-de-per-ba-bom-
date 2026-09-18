package net.mcreator.minerp.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.init.MinerpModMenus;
import net.mcreator.minerp.init.MinerpModItems;

public class CalculadoradaguicarteiraProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double Valor = 0;
		double slot = 0;
		Valor = 0;
		slot = 1;
		for (int _i1 = 0; _i1 < 18; _i1++) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_050.get()) {
				Valor = Valor + 0.5;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_1.get()) {
				Valor = Valor + 1;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_5.get()) {
				Valor = Valor + 5;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_10.get()) {
				Valor = Valor + 10;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_20.get()) {
				Valor = Valor + 20;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_50.get()) {
				Valor = Valor + 50;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_100.get()) {
				Valor = Valor + 100;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_200.get()) {
				Valor = Valor + 200;
			}
			slot = slot + 1;
		}
		return "" + Valor;
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.minerp.init.MinerpModItems;

public class QuaisItensVaiNaCarteiraProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getItem() == MinerpModItems.VD_1.get() || itemstack.getItem() == MinerpModItems.VD_050.get() || itemstack.getItem() == MinerpModItems.VD_5.get() || itemstack.getItem() == MinerpModItems.VD_20.get()
				|| itemstack.getItem() == MinerpModItems.VD_50.get() || itemstack.getItem() == MinerpModItems.VD_100.get() || itemstack.getItem() == MinerpModItems.VD_200.get() || itemstack.getItem() == MinerpModItems.VD_10.get()) {
			return false;
		}
		return true;
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.init.MinerpModMenus;
import net.mcreator.minerp.init.MinerpModItems;

public class ATMTELA1ProceudretodotempoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.CARTAO_DE_CREDITO.get())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "Senha", "Insira o cart\u00E3o", true);
		}
	}
}
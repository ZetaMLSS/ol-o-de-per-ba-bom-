package net.mcreator.minerp.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.world.inventory.CarteiraGuiMenu;
import net.mcreator.minerp.init.MinerpModItems;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class CarteiraInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == MinerpModItems.CARTEIRA.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof CarteiraGuiMenu)
				player.closeContainer();
		}
	}

	public CarteiraInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 9);
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != MinerpModItems.CARTEIRA.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}
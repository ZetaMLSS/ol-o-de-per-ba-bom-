package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.init.MinerpModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BloquearQuebraAlgemadoProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MinerpModItems.ALGEMA.get()) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
	}
}
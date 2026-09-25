package net.mcreator.minerp.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.minerp.init.MinerpModItems;

public class PrenderAlgemaProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MinerpModItems.ALGEMA.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack3 = new ItemStack(MinerpModItems.ALGEMA.get()).copy();
				_setstack3.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack3);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack4 = new ItemStack(Blocks.SMOOTH_STONE).copy();
				_setstack4.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack4);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}
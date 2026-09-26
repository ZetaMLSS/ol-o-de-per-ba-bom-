package net.mcreator.minerp.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModItems;

public class PrenderAlgemaProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MinerpModItems.ALGEMA.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack4 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
				_setstack4.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack4);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "ativada";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack7 = new ItemStack(Blocks.AIR).copy();
				_setstack7.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack7);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModItems;

public class VincularComCodigoAlgemaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double slot = 0;
		ItemStack itemresultado = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MinerpModItems.CHAVE_ALGEMA_SEM_CODIGO.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MinerpModItems.ALGEMA.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack4 = new ItemStack(MinerpModItems.CHAVE_ALGEMA.get()).copy();
				_setstack4.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack4);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "codigoalgema";
				final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("codigoalgema"));
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModItems;

public class CaixaQuandoClicadoComOBotaoDireitoProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MinerpModItems.CAIXA.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack2 = new ItemStack(MinerpModItems.CELULAR.get()).copy();
				_setstack2.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack2);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "numero";
				final double _tagValue = (Mth.nextInt(RandomSource.create(), 100000, 999999));
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "bateria";
				final double _tagValue = 5000;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			MinerpModVariables.MapVariables.get(world).numeros_registrados = MinerpModVariables.MapVariables.get(world).numeros_registrados + ""
					+ Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")) + ",";
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}
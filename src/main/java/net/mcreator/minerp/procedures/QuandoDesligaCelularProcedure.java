package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.world.inventory.*;
import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.MinerpMod;

public class QuandoDesligaCelularProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		MinerpMod.queueServerWork(2, () -> {
			if (!(entity instanceof Player _plr0 && _plr0.containerMenu instanceof TelaCelularInicialMenu || entity instanceof Player _plr1 && _plr1.containerMenu instanceof TelaCelularPoliciaMenu
					|| entity instanceof Player _plr2 && _plr2.containerMenu instanceof TelaCelularUrbMenu || entity instanceof Player _plr3 && _plr3.containerMenu instanceof TelaCelularParamedicoMenu
					|| entity instanceof Player _plr4 && _plr4.containerMenu instanceof TelaCelularCriptoMenu || entity instanceof Player _plr5 && _plr5.containerMenu instanceof TelaCelularMenssagensMenu
					|| entity instanceof Player _plr6 && _plr6.containerMenu instanceof TelaAdionarContatoMenu || entity instanceof Player _plr7 && _plr7.containerMenu instanceof TelaCelularConfigMenu
					|| entity instanceof Player _plr8 && _plr8.containerMenu instanceof TelaCelularBancoMenu || entity instanceof Player _plr9 && _plr9.containerMenu instanceof TelaCelularMenssagensMenu
					|| entity instanceof Player _plr10 && _plr10.containerMenu instanceof TelaAdionarContatoMenu || entity instanceof Player _plr11 && _plr11.containerMenu instanceof TelaChatsMenu)) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue(0);
			}
		});
		{
			MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
			_vars.NumeroInesistente = "";
			_vars.markSyncDirty();
		}
	}
}
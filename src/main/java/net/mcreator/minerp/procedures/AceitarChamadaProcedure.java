package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minerp.network.MinerpModVariables;

public class AceitarChamadaProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (MinerpModVariables.MapVariables.get(world).urb_ativo == true) {
			MinerpModVariables.MapVariables.get(world).urb_ativo = false;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Corrida Adquirida! O cliente est\u00E1 em X: " + new java.text.DecimalFormat("##").format(MinerpModVariables.MapVariables.get(world).urb_x) + " Y: "
						+ new java.text.DecimalFormat("##").format(MinerpModVariables.MapVariables.get(world).urb_y) + " Z: " + new java.text.DecimalFormat("##").format(MinerpModVariables.MapVariables.get(world).urb_z))), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Desculpa, outro motorista UrB j\u00E1 aceitou esta corrida ou ela expirou."), false);
		}
	}
}
package net.mcreator.minerp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;

public class ChamarUrbProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) && _menu0.getMenuState(1, "Curta", false)) {
			MinerpModVariables.MapVariables.get(world).urb_ativo = true;
			MinerpModVariables.MapVariables.get(world).urb_x = entity.getX();
			MinerpModVariables.MapVariables.get(world).urb_y = entity.getY();
			MinerpModVariables.MapVariables.get(world).urb_z = entity.getZ();
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @a[team=Urb] [\"\",{\"text\":\"[UrB] Nova Viagem Curta! \"},{\"text\":\"[ACEITAR]\",\"color\":\"green\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/aceitarurb\"}}]");
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Um Urber foi solicitado aguarde no local."), true);
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
		if ((entity instanceof Player _entity7 && _entity7.containerMenu instanceof MinerpModMenus.MenuAccessor _menu7) && _menu7.getMenuState(1, "Longa", false)) {
			MinerpModVariables.MapVariables.get(world).urb_x = entity.getX();
			MinerpModVariables.MapVariables.get(world).urb_y = entity.getY();
			MinerpModVariables.MapVariables.get(world).urb_z = entity.getZ();
			MinerpModVariables.MapVariables.get(world).urb_ativo = true;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @a[team=Urb] [\"\",{\"text\":\"[UrB] Nova Viagem Longa! \"},{\"text\":\"[ACEITAR]\",\"color\":\"green\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/aceitarurb\"}}]");
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Um Urber foi solicitado aguarde no local."), true);
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
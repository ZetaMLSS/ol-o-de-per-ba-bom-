package net.mcreator.minerp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.minerp.init.MinerpModMenus;

public class SetarPelaGuiDoComputadorBancoLimiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "SetarLimiteCredito", "") : "").equals(""))) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("adicionarlimitecredito " + getBlockNBTString(world, BlockPos.containing(x, y, z), "nick") + " "
								+ ((entity instanceof Player _entity2 && _entity2.containerMenu instanceof MinerpModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "SetarLimiteCredito", "") : "")));
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}